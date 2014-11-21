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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.elasticsearch.search.facet.Facet;
import org.elasticsearch.search.facet.datehistogram.DateHistogramFacet;
import org.elasticsearch.search.facet.filter.FilterFacet;
import org.elasticsearch.search.facet.histogram.HistogramFacet;
import org.elasticsearch.search.facet.range.RangeFacet;
import org.elasticsearch.search.facet.statistical.StatisticalFacet;
import org.elasticsearch.search.facet.terms.TermsFacet;
import org.elasticsearch.search.facet.termsstats.TermsStatsFacet;
import org.elasticsearch.search.facet.termsstats.doubles.InternalTermsStatsDoubleFacet;
import org.elasticsearch.search.facet.termsstats.longs.InternalTermsStatsLongFacet;

import ezbake.data.elastic.thrift.DateHistogramFacetEntry;
import ezbake.data.elastic.thrift.DateHistogramFacetResult;
import ezbake.data.elastic.thrift.FacetRequest;
import ezbake.data.elastic.thrift.FacetResult;
import ezbake.data.elastic.thrift.FilterFacetResult;
import ezbake.data.elastic.thrift.HistogramFacetEntry;
import ezbake.data.elastic.thrift.HistogramFacetResult;
import ezbake.data.elastic.thrift.RangeFacetEntry;
import ezbake.data.elastic.thrift.RangeFacetResult;
import ezbake.data.elastic.thrift.StatisticalFacetResult;
import ezbake.data.elastic.thrift.TermsFacetEntry;
import ezbake.data.elastic.thrift.TermsFacetResult;
import ezbake.data.elastic.thrift.TermsStatsFacetResult;
import ezbake.data.elastic.thrift.TermsStatsFacetResultEntry;

final class FacetResultsToThriftConversions {
    private FacetResultsToThriftConversions() {
    }

    static Map<String, FacetResult> getFacetsFromResult(
            Map<String, FacetRequest._Fields> facetMap,
            Map<String, Facet> elasticFacets) {
        // Parse out facets
        final Map<String, FacetResult> facetResults = new HashMap<>();

        for (final Map.Entry<String, FacetRequest._Fields> entry : facetMap.entrySet()) {
            final FacetResult result = new FacetResult();
            final Facet response = elasticFacets.get(entry.getKey());
            switch (entry.getValue()) {
                case DATE_HISTOGRAM_FACET:
                    result.setDateFacetResult(convertDateHistogramFacetResults((DateHistogramFacet) response));
                    break;
                case FILTER_FACET:
                    result.setFilterFacetResult(convertFilterFacetResults((FilterFacet) response));
                    break;
                case HISTOGRAM_FACET:
                    result.setHistogramFacetResult(convertHistogramFacetResults((HistogramFacet) response));
                    break;
                case RANGE_FACET:
                    result.setRangeFacetResult(convertRangeFacetResults((RangeFacet) response));
                    break;
                case TERMS_FACET:
                    result.setTermsFacetResult(convertTermsFacetResults((TermsFacet) response));
                    break;
                case STATISTICAL_FACET:
                    result.setStatisticalFacetResult(convertStatisticalFacetResults((StatisticalFacet) response));
                    break;
                case TERMS_STATS_FACET:
                    result.setTermsStatsFacetResult(convertTermsStatsFacetResults((TermsStatsFacet) response));
                    break;
                default:
                    throw new IllegalArgumentException("Facet result has unknown type " + entry.getValue());
            }

            facetResults.put(entry.getKey(), result);
        }
        return facetResults;
    }

    private static TermsFacetResult convertTermsFacetResults(TermsFacet facet) {
        final List<TermsFacetEntry> entries = new ArrayList<>();
        for (final TermsFacet.Entry entry : facet.getEntries()) {
            final TermsFacetEntry resultEntry = new TermsFacetEntry();
            resultEntry.setTerm(entry.getTerm().toString());
            resultEntry.setCount(entry.getCount());
            entries.add(resultEntry);
        }

        final TermsFacetResult result = new TermsFacetResult();
        result.setMissingCount(facet.getMissingCount());
        result.setOtherCount(facet.getOtherCount());
        result.setTotalCount(facet.getTotalCount());
        result.setEntries(entries);
        return result;
    }

    private static RangeFacetResult convertRangeFacetResults(RangeFacet facet) {
        final List<RangeFacetEntry> entries = new ArrayList<>();
        for (final RangeFacet.Entry entry : facet.getEntries()) {
            final RangeFacetEntry resultEntry = new RangeFacetEntry();
            resultEntry.setFrom(entry.getFromAsString());
            resultEntry.setTo(entry.getToAsString());
            resultEntry.setCount(entry.getCount());
            resultEntry.setMin(entry.getMin());
            resultEntry.setMax(entry.getMax());
            resultEntry.setMean(entry.getMean());
            entries.add(resultEntry);
        }

        final RangeFacetResult result = new RangeFacetResult();
        result.setEntries(entries);
        return result;
    }

    private static HistogramFacetResult convertHistogramFacetResults(HistogramFacet facet) {
        final List<HistogramFacetEntry> entries = new ArrayList<>();
        for (final HistogramFacet.Entry entry : facet) {
            final HistogramFacetEntry resultEntry = new HistogramFacetEntry();
            resultEntry.setKey(entry.getKey());
            resultEntry.setCount(entry.getCount());
            resultEntry.setMin(entry.getMin());
            resultEntry.setMean(entry.getMean());
            resultEntry.setMax(entry.getMax());
            resultEntry.setTotalCount(entry.getTotalCount());
            resultEntry.setTotal(entry.getTotal());
            entries.add(resultEntry);
        }
        final HistogramFacetResult result = new HistogramFacetResult();
        result.setEntries(entries);
        return result;
    }

    private static FilterFacetResult convertFilterFacetResults(FilterFacet facet) {
        final FilterFacetResult result = new FilterFacetResult();
        result.setCount(facet.getCount());
        return result;
    }

    private static DateHistogramFacetResult convertDateHistogramFacetResults(DateHistogramFacet facet) {
        final List<DateHistogramFacetEntry> resultEntries = new ArrayList<>();
        for (final DateHistogramFacet.Entry entry : facet) {
            final DateHistogramFacetEntry resultEntry = new DateHistogramFacetEntry();
            resultEntry.setCount(entry.getCount());
            resultEntry.setTime(entry.getTime());
            resultEntry.setMin(entry.getMin());
            resultEntry.setMean(entry.getMean());
            resultEntry.setMax(entry.getMax());
            resultEntry.setTotalCount(entry.getTotalCount());
            resultEntry.setTotal(entry.getTotal());
            resultEntries.add(resultEntry);
        }

        final DateHistogramFacetResult result = new DateHistogramFacetResult();
        result.setEntries(resultEntries);
        return result;
    }

    private static StatisticalFacetResult convertStatisticalFacetResults(StatisticalFacet facet) {
        final StatisticalFacetResult result = new StatisticalFacetResult();
        result.setCount(facet.getCount());
        result.setMax(facet.getMax());
        result.setMean(facet.getMean());
        result.setMin(facet.getMin());
        result.setStdDeviation(facet.getStdDeviation());
        result.setSumOfSquares(facet.getSumOfSquares());
        result.setTotal(facet.getTotal());
        result.setVariance(facet.getVariance());
        return result;
    }

    private static TermsStatsFacetResult convertTermsStatsFacetResults(TermsStatsFacet facet) {
        final TermsStatsFacetResult result = new TermsStatsFacetResult();
        final List<TermsStatsFacetResultEntry> entries = new ArrayList<>();

        for (final TermsStatsFacet.Entry entry : facet.getEntries()) {
            final TermsStatsFacetResultEntry resultEntry = new TermsStatsFacetResultEntry();
            resultEntry.setCount(entry.getCount());
            resultEntry.setTotal(entry.getTotal());
            resultEntry.setMean(entry.getMean());
            resultEntry.setMax(entry.getMax());
            resultEntry.setMin(entry.getMin());
            resultEntry.setTerm(entry.getTerm().toString());
            if (entry instanceof InternalTermsStatsDoubleFacet.DoubleEntry
                    || entry instanceof InternalTermsStatsLongFacet.LongEntry) {
                resultEntry.setTermAsNumber(entry.getTermAsNumber().doubleValue());
            }
            resultEntry.setTotalCount(entry.getTotalCount());
            entries.add(resultEntry);
        }
        result.setEntries(entries);
        return result;
    }
}
