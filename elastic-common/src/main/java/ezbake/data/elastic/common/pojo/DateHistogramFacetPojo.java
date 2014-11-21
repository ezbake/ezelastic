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

import ezbake.data.elastic.thrift.DateHistogramFacet;

public final class DateHistogramFacetPojo {
    private DateFieldPojo field;
    private DateIntervalPojo interval;
    private Integer factor; // optional
    private Short post_zone_hours; // optional
    private Short pre_zone_hours; // optional

    public static DateHistogramFacetPojo fromThrift(DateHistogramFacet thrift) {
        if (thrift == null) {
            return null;
        }

        final DateHistogramFacetPojo pojo = new DateHistogramFacetPojo();
        pojo.field = DateFieldPojo.fromThrift(thrift.getField());
        pojo.interval = DateIntervalPojo.fromThrift(thrift.getInterval());

        if (thrift.isSetFactor()) {
            pojo.factor = thrift.getFactor();
        }

        if (thrift.isSetPost_zone_hours()) {
            pojo.post_zone_hours = thrift.getPost_zone_hours();
        }

        if (thrift.isSetPre_zone_hours()) {
            pojo.pre_zone_hours = thrift.getPre_zone_hours();
        }

        return pojo;
    }

    public static DateHistogramFacet toThrift(DateHistogramFacetPojo pojo) throws TException {
        if (pojo == null) {
            return null;
        }

        final DateHistogramFacet thrift = new DateHistogramFacet();
        thrift.setField(DateFieldPojo.toThrift(pojo.field));
        thrift.setInterval(DateIntervalPojo.toThrift(pojo.interval));

        if (pojo.factor != null) {
            thrift.setFactor(pojo.factor);
        }

        if (pojo.post_zone_hours != null) {
            thrift.setPost_zone_hours(pojo.post_zone_hours);
        }

        if (pojo.pre_zone_hours != null) {
            thrift.setPre_zone_hours(pojo.pre_zone_hours);
        }

        thrift.validate();

        return thrift;
    }
}