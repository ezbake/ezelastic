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

import ezbake.data.elastic.thrift.DateHistogramFacetEntry;

public final class DateHistogramFacetEntryPojo {
    private long time;
    private long count;
    private double mean;
    private double min;
    private double max;
    private double total;
    private long totalCount;

    public static List<DateHistogramFacetEntryPojo> fromThrift(List<DateHistogramFacetEntry> thrifts) {
        if (thrifts == null) {
            return null;
        }

        final List<DateHistogramFacetEntryPojo> pojos = new ArrayList<>(thrifts.size());

        for (final DateHistogramFacetEntry thrift : thrifts) {
            final DateHistogramFacetEntryPojo pojo = new DateHistogramFacetEntryPojo();
            pojo.time = thrift.getTime();
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

    public static List<DateHistogramFacetEntry> toThrift(List<DateHistogramFacetEntryPojo> pojos) throws TException {
        if (pojos == null) {
            return null;
        }

        final List<DateHistogramFacetEntry> thrifts = new ArrayList<>(pojos.size());
        for (final DateHistogramFacetEntryPojo pojo : pojos) {
            final DateHistogramFacetEntry thrift = new DateHistogramFacetEntry(
                    pojo.time, pojo.count, pojo.mean, pojo.min, pojo.max, pojo.total, pojo.totalCount);

            thrift.validate();

            thrifts.add(thrift);
        }

        return thrifts;
    }
}
