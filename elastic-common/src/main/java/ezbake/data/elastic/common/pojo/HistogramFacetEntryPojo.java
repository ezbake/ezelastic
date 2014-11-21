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

import java.util.ArrayList;
import java.util.List;

import org.apache.thrift.TException;

import ezbake.data.elastic.thrift.HistogramFacetEntry;

public final class HistogramFacetEntryPojo {
    private long key;
    private long count;
    private double mean;
    private double min;
    private double max;
    private double total;
    private long totalCount;

    public static List<HistogramFacetEntryPojo> fromThrift(List<HistogramFacetEntry> thrifts) {
        if (thrifts == null) {
            return null;
        }

        final List<HistogramFacetEntryPojo> pojos = new ArrayList<>(thrifts.size());

        for (final HistogramFacetEntry thrift : thrifts) {
            final HistogramFacetEntryPojo pojo = new HistogramFacetEntryPojo();
            pojo.key = thrift.getKey();
            pojo.count = thrift.getCount();
            pojo.mean = thrift.getMean();
            pojo.min = thrift.getMin();
            pojo.max = thrift.getMax();
            pojo.total = thrift.getTotalCount();
            pojo.totalCount = thrift.getTotalCount();

            pojos.add(pojo);
        }

        return pojos;
    }

    public static List<HistogramFacetEntry> toThrift(List<HistogramFacetEntryPojo> pojos) throws TException {
        if (pojos == null) {
            return null;
        }

        final List<HistogramFacetEntry> thrifts = new ArrayList<>(pojos.size());
        for (final HistogramFacetEntryPojo pojo : pojos) {
            final HistogramFacetEntry thrift = new HistogramFacetEntry(
                    pojo.key, pojo.count, pojo.mean, pojo.min, pojo.max, pojo.total, pojo.totalCount);

            thrift.validate();

            thrifts.add(thrift);
        }

        return thrifts;
    }
}
