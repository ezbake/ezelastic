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

package ezbake.data.elastic.common.pojo;

import org.apache.thrift.TException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import ezbake.data.elastic.thrift.FacetResult;

// Union
public final class FacetResultPojo {
    private TermsFacetResultPojo termsFacetResult;
    private RangeFacetResultPojo rangeFacetResult;
    private DateHistogramFacetResultPojo dateFacetResult;
    private HistogramFacetResultPojo histogramFacetResult;
    private FilterFacetResultPojo filterFacetResult;
    private TermsStatsFacetResultPojo termsStatsFacetResult;
    private StatisticalFacetResultPojo statisticalFacetResult;

    public static FacetResultPojo fromThrift(FacetResult thrift) {
        if (thrift == null) {
            return null;
        }

        final FacetResultPojo pojo = new FacetResultPojo();

        switch (thrift.getSetField()) {
            case TERMS_FACET_RESULT:
                pojo.termsFacetResult = TermsFacetResultPojo.fromThrift(thrift.getTermsFacetResult());
                break;
            case RANGE_FACET_RESULT:
                pojo.rangeFacetResult = RangeFacetResultPojo.fromThrift(thrift.getRangeFacetResult());
                break;
            case DATE_FACET_RESULT:
                pojo.dateFacetResult = DateHistogramFacetResultPojo.fromThrift(thrift.getDateFacetResult());
                break;
            case HISTOGRAM_FACET_RESULT:
                pojo.histogramFacetResult = HistogramFacetResultPojo.fromThrift(thrift.getHistogramFacetResult());
                break;
            case FILTER_FACET_RESULT:
                pojo.filterFacetResult = FilterFacetResultPojo.fromThrift(thrift.getFilterFacetResult());
                break;
            case TERMS_STATS_FACET_RESULT:
                pojo.termsStatsFacetResult = TermsStatsFacetResultPojo.fromThrift(thrift.getTermsStatsFacetResult());
                break;
            case STATISTICAL_FACET_RESULT:
                pojo.statisticalFacetResult = StatisticalFacetResultPojo.fromThrift(thrift.getStatisticalFacetResult());
                break;
            default:
                throw new IllegalArgumentException("Unknown field set in union");
        }

        return pojo;
    }

    public static FacetResult toThrift(FacetResultPojo pojo) throws TException {
        if (pojo == null) {
            return null;
        }

        final FacetResult thrift = new FacetResult();

        if (pojo.termsFacetResult != null) {
            thrift.setTermsFacetResult(TermsFacetResultPojo.toThrift(pojo.termsFacetResult));
        } else if (pojo.rangeFacetResult != null) {
            thrift.setRangeFacetResult(RangeFacetResultPojo.toThrift(pojo.rangeFacetResult));
        } else if (pojo.dateFacetResult != null) {
            thrift.setDateFacetResult(DateHistogramFacetResultPojo.toThrift(pojo.dateFacetResult));
        } else if (pojo.histogramFacetResult != null) {
            thrift.setHistogramFacetResult(HistogramFacetResultPojo.toThrift(pojo.histogramFacetResult));
        } else if (pojo.filterFacetResult != null) {
            thrift.setFilterFacetResult(FilterFacetResultPojo.toThrift(pojo.filterFacetResult));
        } else if (pojo.termsStatsFacetResult != null) {
            thrift.setTermsStatsFacetResult(TermsStatsFacetResultPojo.toThrift(pojo.termsStatsFacetResult));
        } else if (pojo.statisticalFacetResult != null) {
            thrift.setStatisticalFacetResult(StatisticalFacetResultPojo.toThrift(pojo.statisticalFacetResult));
        } else {
            throw new IllegalArgumentException("No field set in POJO for Thrift union");
        }

        return thrift;
    }

    public static FacetResultPojo fromJson(String json) {
        try {
            final Gson gson = new GsonBuilder().create();
            return gson.fromJson(json, FacetResultPojo.class);
        } catch (final JsonSyntaxException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public FacetResult toThrift() throws TException {
        return toThrift(this);
    }

    public String toJson() {
        final Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this, FacetResultPojo.class);
    }
}
