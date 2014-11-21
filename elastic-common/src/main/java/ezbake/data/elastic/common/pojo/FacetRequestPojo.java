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

import ezbake.data.elastic.thrift.FacetRequest;

// Union
public final class FacetRequestPojo {
    private HistogramFacetPojo histogramFacet;
    private RangeFacetPojo rangeFacet;
    private FilterFacetPojo filterFacet;
    private TermsFacetPojo termsFacet;
    private DateHistogramFacetPojo dateHistogramFacet;
    private TermsStatsFacetPojo termsStatsFacet;
    private StatisticalFacetPojo statisticalFacet;
    private TermsScriptFacetPojo termsScriptFacet;

    public static FacetRequestPojo fromThrift(FacetRequest thrift) {
        if (thrift == null) {
            return null;
        }

        final FacetRequestPojo pojo = new FacetRequestPojo();

        switch (thrift.getSetField()) {
            case HISTOGRAM_FACET:
                pojo.histogramFacet = HistogramFacetPojo.fromThrift(thrift.getHistogramFacet());
                break;
            case RANGE_FACET:
                pojo.rangeFacet = RangeFacetPojo.fromThrift(thrift.getRangeFacet());
                break;
            case FILTER_FACET:
                pojo.filterFacet = FilterFacetPojo.fromThrift(thrift.getFilterFacet());
                break;
            case TERMS_FACET:
                pojo.termsFacet = TermsFacetPojo.fromThrift(thrift.getTermsFacet());
                break;
            case DATE_HISTOGRAM_FACET:
                pojo.dateHistogramFacet = DateHistogramFacetPojo.fromThrift(thrift.getDateHistogramFacet());
                break;
            case TERMS_STATS_FACET:
                pojo.termsStatsFacet = TermsStatsFacetPojo.fromThrift(thrift.getTermsStatsFacet());
                break;
            case STATISTICAL_FACET:
                pojo.statisticalFacet = StatisticalFacetPojo.fromThrift(thrift.getStatisticalFacet());
                break;
            case TERMS_SCRIPT_FACET:
                pojo.termsScriptFacet = TermsScriptFacetPojo.fromThrift(thrift.getTermsScriptFacet());
                break;
            default:
                throw new IllegalArgumentException("Unknown field set in union");
        }

        return pojo;
    }

    public static FacetRequest toThrift(FacetRequestPojo pojo) throws TException {
        if (pojo == null) {
            return null;
        }

        final FacetRequest thrift = new FacetRequest();

        if (pojo.histogramFacet != null) {
            thrift.setHistogramFacet(HistogramFacetPojo.toThrift(pojo.histogramFacet));
        } else if (pojo.rangeFacet != null) {
            thrift.setRangeFacet(RangeFacetPojo.toThrift(pojo.rangeFacet));
        } else if (pojo.filterFacet != null) {
            thrift.setFilterFacet(FilterFacetPojo.toThrift(pojo.filterFacet));
        } else if (pojo.termsFacet != null) {
            thrift.setTermsFacet(TermsFacetPojo.toThrift(pojo.termsFacet));
        } else if (pojo.dateHistogramFacet != null) {
            thrift.setDateHistogramFacet(DateHistogramFacetPojo.toThrift(pojo.dateHistogramFacet));
        } else if (pojo.termsStatsFacet != null) {
            thrift.setTermsStatsFacet(TermsStatsFacetPojo.toThrift(pojo.termsStatsFacet));
        } else if (pojo.statisticalFacet != null) {
            thrift.setStatisticalFacet(StatisticalFacetPojo.toThrift(pojo.statisticalFacet));
        } else if (pojo.termsScriptFacet != null) {
            thrift.setTermsScriptFacet(TermsScriptFacetPojo.toThrift(pojo.termsScriptFacet));
        } else {
            throw new IllegalArgumentException("No field set in POJO for Thrift union");
        }

        return thrift;
    }
}