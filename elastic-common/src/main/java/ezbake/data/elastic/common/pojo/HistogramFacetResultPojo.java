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

import java.util.List;

import org.apache.thrift.TException;

import ezbake.data.elastic.thrift.HistogramFacetResult;

public final class HistogramFacetResultPojo {
    private List<HistogramFacetEntryPojo> entries;

    public static HistogramFacetResultPojo fromThrift(HistogramFacetResult thrift) {
        if (thrift == null) {
            return null;
        }

        final HistogramFacetResultPojo pojo = new HistogramFacetResultPojo();
        pojo.entries = HistogramFacetEntryPojo.fromThrift(thrift.getEntries());

        return pojo;
    }

    public static HistogramFacetResult toThrift(HistogramFacetResultPojo pojo) throws TException {
        if (pojo == null) {
            return null;
        }

        final HistogramFacetResult thrift = new HistogramFacetResult(HistogramFacetEntryPojo.toThrift(pojo.entries));

        thrift.validate();

        return thrift;
    }
}