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

import ezbake.data.elastic.thrift.RangeFacetEntry;

public final class RangeFacetEntryPojo {
    private String from;
    private String to;
    private double min;
    private double max;
    private double mean;
    private long count;

    public static List<RangeFacetEntryPojo> fromThrift(List<RangeFacetEntry> thrifts) {
        if (thrifts == null) {
            return null;
        }

        final List<RangeFacetEntryPojo> pojos = new ArrayList<>(thrifts.size());
        for (final RangeFacetEntry thrift : thrifts) {
            final RangeFacetEntryPojo pojo = new RangeFacetEntryPojo();
            pojo.from = thrift.getFrom();
            pojo.to = thrift.getTo();
            pojo.min = thrift.getMin();
            pojo.max = thrift.getMax();
            pojo.mean = thrift.getMean();
            pojo.count = thrift.getCount();

            pojos.add(pojo);
        }

        return pojos;
    }

    public static List<RangeFacetEntry> toThrift(List<RangeFacetEntryPojo> pojos) throws TException {
        if (pojos == null) {
            return null;
        }

        final List<RangeFacetEntry> thrifts = new ArrayList<>(pojos.size());
        for (final RangeFacetEntryPojo pojo : pojos) {
            final RangeFacetEntry thrift =
                    new RangeFacetEntry(pojo.from, pojo.to, pojo.min, pojo.max, pojo.mean, pojo.count);

            thrift.validate();

            thrifts.add(thrift);
        }

        return thrifts;
    }
}
