/*   Copyright (C) 2013-2014 Computer Sciences Corporation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. */

package ezbake.data.elastic.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.FilterBuilder;
import org.elasticsearch.index.query.FilterBuilders;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.facet.FacetBuilder;
import org.elasticsearch.search.facet.FacetBuilders;
import org.elasticsearch.search.facet.datehistogram.DateHistogramFacetBuilder;
import org.elasticsearch.search.facet.filter.FilterFacetBuilder;
import org.elasticsearch.search.facet.histogram.HistogramFacetBuilder;
import org.elasticsearch.search.facet.histogram.HistogramScriptFacetBuilder;
import org.elasticsearch.search.facet.range.RangeFacetBuilder;
import org.elasticsearch.search.facet.range.RangeScriptFacetBuilder;
import org.elasticsearch.search.facet.statistical.StatisticalFacetBuilder;
import org.elasticsearch.search.facet.statistical.StatisticalScriptFacetBuilder;
import org.elasticsearch.search.facet.terms.TermsFacetBuilder;
import org.elasticsearch.search.facet.termsstats.TermsStatsFacetBuilder;

import ezbake.data.elastic.thrift.BaseFacetValue;
import ezbake.data.elastic.thrift.DateField;
import ezbake.data.elastic.thrift.DateHistogramFacet;
import ezbake.data.elastic.thrift.DateInterval;
import ezbake.data.elastic.thrift.Facet;
import ezbake.data.elastic.thrift.FacetRange;
import ezbake.data.elastic.thrift.FacetRequest;
import ezbake.data.elastic.thrift.FilterFacet;
import ezbake.data.elastic.thrift.HistogramFacet;
import ezbake.data.elastic.thrift.RangeFacet;
import ezbake.data.elastic.thrift.RangeType;
import ezbake.data.elastic.thrift.ScriptParam;
import ezbake.data.elastic.thrift.ScriptValue;
import ezbake.data.elastic.thrift.StatisticalFacet;
import ezbake.data.elastic.thrift.TermsFacet;
import ezbake.data.elastic.thrift.TermsScriptFacet;
import ezbake.data.elastic.thrift.TermsStatsFacet;
import ezbake.data.elastic.thrift.TermsStatsValue;

@SuppressWarnings("NestedSwitchStatement")
final class ThriftToFacetConversions {
    private ThriftToFacetConversions() {
    }

    static Map<String, FacetRequest._Fields> addFacetsToSearch(
            List<Facet> facets, SearchRequestBuilder builder, FilterBuilder visibilityFilter) {
        final Map<String, FacetRequest._Fields> facetMap = new HashMap<>();
        if (facets != null) {
            for (final Facet facet : facets) {
                final String label = facet.getLabel();
                final String filterJson = facet.getFilterJSON();
                final FacetRequest request = facet.getFacet();
                FacetRequest._Fields facetFieldSet = request.getSetField();

                switch (facetFieldSet) {
                    case DATE_HISTOGRAM_FACET:
                        builder.addFacet(
                                convertDateHistorgramFacet(
                                        label, request.getDateHistogramFacet(), filterJson, visibilityFilter));
                        break;
                    case FILTER_FACET:
                        builder.addFacet(
                                convertFilterFacet(
                                        label, request.getFilterFacet(), filterJson, visibilityFilter));
                        break;
                    case HISTOGRAM_FACET:
                        final HistogramFacet hf = facet.getFacet().getHistogramFacet();
                        switch (hf.getFacetValue().getSetField()) {
                            case FACET_FIELD:
                                builder.addFacet(convertHistogramFacet(label, hf, filterJson, visibilityFilter));
                                break;
                            case KEY_VALUE_FACET:
                                builder.addFacet(convertHistogramFacet(label, hf, filterJson, visibilityFilter));
                                break;
                            case KEY_VALUE_SCRIPT:
                                builder.addFacet(convertHistogramScriptFacet(label, hf, filterJson, visibilityFilter));
                                break;
                            default:
                                throw new IllegalArgumentException(
                                        "Histogram facet has invalid type " + hf.getFacetValue().getSetField());
                        }
                        break;
                    case RANGE_FACET:
                        final RangeFacet rf = facet.getFacet().getRangeFacet();
                        switch (rf.getField().getSetField()) {
                            case FACET_FIELD:
                                builder.addFacet(convertRangeFacet(label, rf, filterJson, visibilityFilter));
                                break;
                            case KEY_VALUE_FACET:
                                builder.addFacet(convertRangeFacet(label, rf, filterJson, visibilityFilter));
                                break;
                            case KEY_VALUE_SCRIPT:
                                builder.addFacet(convertRangeScriptFacet(label, rf, filterJson, visibilityFilter));
                                break;
                            default:
                                throw new IllegalArgumentException(
                                        "Range facet has invalid type " + rf.getField().getSetField());
                        }
                        break;
                    case STATISTICAL_FACET:
                        builder.addFacet(
                                convertStatisticalFacet(
                                        label, request.getStatisticalFacet(), filterJson, visibilityFilter));
                        break;
                    case TERMS_FACET:
                        builder.addFacet(
                                convertTermFacet(
                                        label, request.getTermsFacet(), filterJson, visibilityFilter));
                        break;
                    case TERMS_SCRIPT_FACET:
                        builder.addFacet(
                                convertTermScriptFacet(
                                        label, request.getTermsScriptFacet(), filterJson, visibilityFilter));
                        facetFieldSet = FacetRequest._Fields.TERMS_FACET; // Override type
                        break;
                    case TERMS_STATS_FACET:
                        builder.addFacet(
                                convertTermsStatsFacet(
                                        label, request.getTermsStatsFacet(), filterJson, visibilityFilter));
                        break;
                    default:
                        throw new IllegalArgumentException("Facet has unknown type " + facetFieldSet);
                }

                facetMap.put(label, facetFieldSet);
            }
        }

        return facetMap;
    }

    private static TermsFacetBuilder convertTermFacet(
            String label, TermsFacet facet, String filterJson, FilterBuilder visibilityFilter) {
        final TermsFacetBuilder tf =
                FacetBuilders.termsFacet(label).fields(facet.getFields().toArray(new String[facet.getFieldsSize()]));

        // Order
        if (facet.isSetOrder()) {
            tf.order(
                    org.elasticsearch.search.facet.terms.TermsFacet.ComparatorType.valueOf(
                            facet.getOrder().toString()));
        }

        // Exclusions
        if (facet.isSetExclude()) {
            tf.exclude(facet.getExclude().toArray());
        }

        // Regex
        if (facet.isSetRegex()) {
            tf.regex(facet.getRegex());
        }

        // Size
        if (facet.isSetSize()) {
            tf.size(facet.getSize());
        }

        // All terms
        if (facet.isSetAllTerms()) {
            tf.allTerms(facet.isAllTerms());
        }

        addFacetFilter(tf, filterJson, visibilityFilter);

        return tf;
    }

    private static RangeFacetBuilder convertRangeFacet(
            String label, RangeFacet facet, String filterJson, FilterBuilder visibilityFilter) {
        final RangeFacetBuilder rf = FacetBuilders.rangeFacet(label);

        if (facet.getField().isSet(BaseFacetValue._Fields.FACET_FIELD)) {
            rf.field(facet.getField().getFacetField());
        } else {
            rf.keyField(facet.getField().getKeyValueFacet().getKey_field_name()).valueField(
                    facet.getField().getKeyValueFacet().getValue_field());
        }

        for (final FacetRange range : facet.getRanges()) {
            if (range.getRangeType() == RangeType.INTEGER || range.getRangeType() == RangeType.DOUBLE) {
                if (range.isSetFrom() && range.isSetTo()) {
                    rf.addRange(Double.parseDouble(range.getFrom()), Double.parseDouble(range.getTo()));
                } else if (range.isSetFrom()) {
                    rf.addUnboundedTo(Double.parseDouble(range.getFrom()));
                } else if (range.isSetTo()) {
                    rf.addUnboundedFrom(Double.parseDouble(range.getTo()));
                }
            } else {
                if (range.isSetFrom() && range.isSetTo()) {
                    try {
                        rf.addRange(Long.valueOf(range.getFrom()), Long.valueOf(range.getTo()));
                    } catch (final NumberFormatException nfe) {
                        rf.addRange(range.getFrom(), range.getTo());
                    }
                } else if (range.isSetFrom()) {
                    try {
                        rf.addUnboundedTo(Long.valueOf(range.getFrom()));
                    } catch (final NumberFormatException nfe) {
                        rf.addUnboundedTo(range.getFrom());
                    }
                } else if (range.isSetTo()) {
                    try {
                        rf.addUnboundedFrom(Long.valueOf(range.getTo()));
                    } catch (final NumberFormatException nfe) {
                        rf.addUnboundedFrom(range.getTo());
                    }
                }
            }
        }

        addFacetFilter(rf, filterJson, visibilityFilter);

        return rf;
    }

    private static RangeScriptFacetBuilder convertRangeScriptFacet(
            String label, RangeFacet facet, String filterJson, FilterBuilder visibilityFilter) {
        final RangeScriptFacetBuilder rsf = FacetBuilders.rangeScriptFacet(label);

        rsf.keyScript(facet.getField().getKeyValueScript().getKeyScript());
        rsf.valueScript(facet.getField().getKeyValueScript().getValueScript());

        if (facet.getField().getKeyValueScript().isSetScriptParams()) {
            for (final Map.Entry<String, Object> entry : convertParamsList(
                    facet.getField().getKeyValueScript().getScriptParams()).entrySet()) {
                rsf.param(entry.getKey(), entry.getValue());
            }
        }

        for (final FacetRange range : facet.getRanges()) {
            if (range.getRangeType() == RangeType.INTEGER || range.getRangeType() == RangeType.DOUBLE) {
                if (range.isSetFrom() && range.isSetTo()) {
                    rsf.addRange(Double.parseDouble(range.getFrom()), Double.parseDouble(range.getTo()));
                } else if (range.isSetFrom()) {
                    rsf.addUnboundedTo(Double.parseDouble(range.getFrom()));
                } else if (range.isSetTo()) {
                    rsf.addUnboundedFrom(Double.parseDouble(range.getTo()));
                }
            } else {
                if (range.isSetFrom() && range.isSetTo()) {
                    try {
                        rsf.addRange(Long.valueOf(range.getFrom()), Long.valueOf(range.getTo()));
                    } catch (final NumberFormatException nfe) {
                        rsf.addRange(Double.parseDouble(range.getFrom()), Double.parseDouble(range.getTo()));
                    }
                } else if (range.isSetFrom()) {
                    try {
                        rsf.addUnboundedTo(Long.valueOf(range.getFrom()));
                    } catch (final NumberFormatException nfe) {
                        rsf.addUnboundedTo(Double.parseDouble(range.getFrom()));
                    }
                } else if (range.isSetTo()) {
                    try {
                        rsf.addUnboundedFrom(Long.valueOf(range.getTo()));
                    } catch (final NumberFormatException nfe) {
                        rsf.addUnboundedFrom(Double.parseDouble(range.getTo()));
                    }
                }
            }
        }

        addFacetFilter(rsf, filterJson, visibilityFilter);

        return rsf;
    }

    private static HistogramFacetBuilder convertHistogramFacet(
            String label, HistogramFacet facet, String filterJson, FilterBuilder visibilityFilter) {
        final HistogramFacetBuilder hf = FacetBuilders.histogramFacet(label).interval(facet.getInterval());

        if (facet.getFacetValue().isSet(BaseFacetValue._Fields.FACET_FIELD)) {
            hf.field(facet.getFacetValue().getFacetField());
        } else {
            hf.keyField(facet.getFacetValue().getKeyValueFacet().getKey_field_name()).valueField(
                    facet.getFacetValue().getKeyValueFacet().getValue_field());
        }

        addFacetFilter(hf, filterJson, visibilityFilter);

        return hf;
    }

    private static HistogramScriptFacetBuilder convertHistogramScriptFacet(
            String label, HistogramFacet facet, String filterJson, FilterBuilder visibilityFilter) {
        final HistogramScriptFacetBuilder hsf = FacetBuilders.histogramScriptFacet(label);

        hsf.keyScript(facet.getFacetValue().getKeyValueScript().getKeyScript());
        hsf.valueScript(facet.getFacetValue().getKeyValueScript().getValueScript());

        if (facet.getFacetValue().getKeyValueScript().isSetScriptParams()) {
            for (final Map.Entry<String, Object> entry : convertParamsList(
                    facet.getFacetValue().getKeyValueScript().getScriptParams()).entrySet()) {
                hsf.param(entry.getKey(), entry.getValue());
            }
        }

        addFacetFilter(hsf, filterJson, visibilityFilter);

        return hsf;
    }

    private static FilterFacetBuilder convertFilterFacet(
            String label, FilterFacet facet, String filterJson, FilterBuilder visibilityFilter) {
        final FilterFacetBuilder ff = FacetBuilders.filterFacet(label);
        ff.filter(FilterBuilders.queryFilter(QueryBuilders.queryString(facet.getLuceneQuery())));

        addFacetFilter(ff, filterJson, visibilityFilter);

        return ff;
    }

    private static DateHistogramFacetBuilder convertDateHistorgramFacet(
            String label, DateHistogramFacet facet, String filterJson, FilterBuilder visibilityFilter) {
        final DateHistogramFacetBuilder dhg = FacetBuilders.dateHistogramFacet(label);

        // Required interval
        if (facet.getInterval().isSet(DateInterval._Fields.CUSTOM_INTERVAL)) {
            dhg.interval(facet.getInterval().getCustomInterval());
        } else {
            switch (facet.getInterval().getStaticInterval()) {
                case YEAR:
                    dhg.interval("year");
                    break;
                case QUARTER:
                    dhg.interval("quarter");
                    break;
                case MONTH:
                    dhg.interval("month");
                    break;
                case WEEK:
                    dhg.interval("week");
                    break;
                case DAY:
                    dhg.interval("day");
                    break;
                case HOUR:
                    dhg.interval("hour");
                    break;
                case MINUTE:
                    dhg.interval("minute");
                    break;
            }
        }

        // Optional Pre and Post zone offsets
        if (facet.isSet(DateHistogramFacet._Fields.POST_ZONE_HOURS)) {
            dhg.postOffset(TimeValue.timeValueHours(facet.getPost_zone_hours()));
        }

        if (facet.isSet(DateHistogramFacet._Fields.PRE_ZONE_HOURS)) {
            dhg.preOffset(TimeValue.timeValueHours(facet.getPre_zone_hours()));
        }

        // Optional factor
        if (facet.isSet(DateHistogramFacet._Fields.FACTOR)) {
            dhg.factor(facet.getFactor());
        }

        addFacetFilter(dhg, filterJson, visibilityFilter);

        // Field settings
        if (facet.getField().isSet(DateField._Fields.KEY_VALUE_DATE_SCRIPT)) {
            dhg.valueScript(facet.getField().getKeyValueDateScript().getValue_script()).keyField(
                    facet.getField().getKeyValueDateScript().getKey_field());
        } else if (facet.getField().isSet(DateField._Fields.KEY_VALUE_DATE_FIELD)) {
            dhg.keyField(facet.getField().getKeyValueDateField().getKey_field_name()).valueField(
                    facet.getField().getKeyValueDateField().getValue_field());
        } else {
            dhg.field(facet.getField().get_field());
        }

        return dhg;
    }

    private static FacetBuilder convertStatisticalFacet(
            String label, StatisticalFacet facet, String filterJson, FilterBuilder visibilityFilter) {
        if (facet.isSet(StatisticalFacet._Fields.SCRIPT)) {
            // Script based
            final StatisticalScriptFacetBuilder ssf = FacetBuilders.statisticalScriptFacet(label);
            ssf.script(facet.getScript().getScript());

            if (facet.getScript().isSetParams()) {
                for (final Map.Entry<String, Object> entry : convertParamsList(facet.getScript().getParams())
                        .entrySet()) {
                    ssf.param(entry.getKey(), entry.getValue());
                }
            }

            addFacetFilter(ssf, filterJson, visibilityFilter);

            return ssf;
        } else if (facet.isSet(StatisticalFacet._Fields.FIELDS)) {
            // Traditional
            final StatisticalFacetBuilder sf = FacetBuilders.statisticalFacet(label);
            if (facet.getFields().size() > 1) {
                sf.fields(facet.getFields().toArray(new String[facet.getFields().size()]));
            } else {
                sf.field(facet.getFields().get(0));
            }

            addFacetFilter(sf, filterJson, visibilityFilter);

            return sf;
        }

        return null;
    }

    private static TermsStatsFacetBuilder convertTermsStatsFacet(
            String label, TermsStatsFacet facet, String filterJson, FilterBuilder visibilityFilter) {
        final TermsStatsFacetBuilder tsf = FacetBuilders.termsStatsFacet(label);

        // Order
        if (facet.isSetOrder()) {
            tsf.order(
                    org.elasticsearch.search.facet.termsstats.TermsStatsFacet.ComparatorType.valueOf(
                            facet.getOrder().toString()));
        }

        // Key
        if (facet.isSetKeyField()) {
            tsf.keyField(facet.getKeyField());
        }

        // Value/Value Script
        if (facet.isSetValueField()) {
            if (facet.getValueField().isSet(TermsStatsValue._Fields.VALUE_SCRIPT)) {
                tsf.valueScript(facet.getValueField().getValueScript().getScript());
            } else {
                tsf.valueField(facet.getValueField().getValueField());
            }
        }

        // Size
        if (facet.isSetSize()) {
            tsf.size(facet.getSize());
        }

        // All terms
        if (facet.isSetAllTerms() && facet.isAllTerms()) {
            tsf.allTerms();
        }

        addFacetFilter(tsf, filterJson, visibilityFilter);

        return tsf;
    }

    private static TermsFacetBuilder convertTermScriptFacet(
            String label, TermsScriptFacet facet, String filterJson, FilterBuilder visibilityFilter) {
        final TermsFacetBuilder tf = FacetBuilders.termsFacet(label);

        // Script field
        if (facet.isSetScriptField()) {
            tf.scriptField(facet.getScriptField());
        }

        // Regular fields
        if (facet.isSetFields() && facet.getFieldsSize() > 0) {
            tf.fields(facet.getFields().toArray(new String[facet.getFieldsSize()]));
        }

        // Value script
        if (facet.isSetScript()) {
            tf.script(facet.getScript().getScript());

            if (facet.getScript().isSetParams()) {
                for (final Map.Entry<String, Object> entry : convertParamsList(facet.getScript().getParams())
                        .entrySet()) {
                    tf.param(entry.getKey(), entry.getValue());
                }
            }
        }

        // Order
        if (facet.isSetOrder()) {
            tf.order(
                    org.elasticsearch.search.facet.terms.TermsFacet.ComparatorType.valueOf(
                            facet.getOrder().toString()));
        }

        // Exclusions
        if (facet.isSetExclude()) {
            tf.exclude(facet.getExclude().toArray());
        }

        // Regex
        if (facet.isSetRegex()) {
            tf.regex(facet.getRegex());
        }

        // Size
        if (facet.isSetSize()) {
            tf.size(facet.getSize());
        }

        // All terms
        if (facet.isSetAllTerms()) {
            tf.allTerms(facet.isAllTerms());
        }

        addFacetFilter(tf, filterJson, visibilityFilter);

        return tf;
    }

    private static Map<String, Object> convertParamsList(List<ScriptParam> params) {
        final Map<String, Object> result = new HashMap<>();

        for (final ScriptParam param : params) {
            final String paramName = param.getParamName();
            final ScriptValue paramVal = param.getParamValue();
            switch (paramVal.getSetField()) {
                case BOOLEAN_VALUE:
                    result.put(paramName, paramVal.getBooleanValue());
                    break;
                case DOUBLE_VALUE:
                    result.put(paramName, paramVal.getDoubleValue());
                    break;
                case INT_VALUE:
                    result.put(paramName, paramVal.getIntValue());
                    break;
                case LONG_VALUE:
                    result.put(paramName, paramVal.getLongValue());
                    break;
                case TEXT_VALUE:
                    result.put(paramName, paramVal.getTextValue());
                    break;
                default:
                    throw new IllegalArgumentException(
                            "Facet script parameter has unknown type " + paramVal.getSetField());
            }
        }

        return result;
    }

    private static void addFacetFilter(FacetBuilder facet, String filterJson, FilterBuilder visibilityFilter) {
        // If filterJson is set add it along with visibility filter
        final FilterBuilder facetFilter;
        if (StringUtils.isBlank(filterJson)) {
            facetFilter = visibilityFilter;
        } else {
            facetFilter = FilterBuilders.andFilter(FilterBuilders.wrapperFilter(filterJson), visibilityFilter);
            facet.facetFilter(FilterBuilders.wrapperFilter(filterJson));
        }

        facet.facetFilter(facetFilter);
    }
}
