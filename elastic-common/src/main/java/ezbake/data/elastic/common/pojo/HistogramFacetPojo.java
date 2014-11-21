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

import ezbake.data.elastic.thrift.HistogramFacet;

public final class HistogramFacetPojo {
    private int interval;
    private BaseFacetValuePojo facetValue;

    public static HistogramFacetPojo fromThrift(HistogramFacet thrift) {
        if (thrift == null) {
            return null;
        }

        final HistogramFacetPojo pojo = new HistogramFacetPojo();
        pojo.interval = thrift.getInterval();
        pojo.facetValue = BaseFacetValuePojo.fromThrift(thrift.getFacetValue());

        return pojo;
    }

    public static HistogramFacet toThrift(HistogramFacetPojo pojo) throws TException {
        if (pojo == null) {
            return null;
        }

        final HistogramFacet thrift = new HistogramFacet(pojo.interval, BaseFacetValuePojo.toThrift(pojo.facetValue));
        thrift.validate();
        return thrift;
    }
}