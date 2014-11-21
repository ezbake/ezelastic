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

import ezbake.data.elastic.thrift.FacetRange;
import ezbake.data.elastic.thrift.RangeType;

public final class FacetRangePojo {
    private RangeType rangeType;
    private String from; // optional
    private String to; // optional

    public static List<FacetRangePojo> fromThrift(List<FacetRange> thrifts) {
        if (thrifts == null) {
            return null;
        }

        final List<FacetRangePojo> pojos = new ArrayList<>(thrifts.size());
        for (final FacetRange thrift : thrifts) {
            final FacetRangePojo pojo = new FacetRangePojo();
            pojo.rangeType = thrift.getRangeType();
            pojo.from = thrift.getFrom();
            pojo.to = thrift.getTo();

            pojos.add(pojo);
        }

        return pojos;
    }

    public static List<FacetRange> toThrift(List<FacetRangePojo> pojos) throws TException {
        if (pojos == null) {
            return null;
        }

        final List<FacetRange> thrifts = new ArrayList<>(pojos.size());
        for (final FacetRangePojo pojo : pojos) {
            final FacetRange thrift = new FacetRange();
            thrift.setRangeType(pojo.rangeType);
            thrift.setFrom(pojo.from);
            thrift.setTo(pojo.to);

            thrift.validate();

            thrifts.add(thrift);
        }

        return thrifts;
    }
}
