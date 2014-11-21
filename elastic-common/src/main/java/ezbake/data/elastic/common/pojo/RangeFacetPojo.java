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

import ezbake.data.elastic.thrift.RangeFacet;

public final class RangeFacetPojo {
    private List<FacetRangePojo> ranges;
    private BaseFacetValuePojo field;

    public static RangeFacetPojo fromThrift(RangeFacet thrift) {
        if (thrift == null) {
            return null;
        }

        final RangeFacetPojo pojo = new RangeFacetPojo();
        pojo.ranges = FacetRangePojo.fromThrift(thrift.getRanges());
        pojo.field = BaseFacetValuePojo.fromThrift(thrift.getField());

        return pojo;
    }

    public static RangeFacet toThrift(RangeFacetPojo pojo) throws TException {
        if (pojo == null) {
            return null;
        }

        final RangeFacet thrift =
                new RangeFacet(FacetRangePojo.toThrift(pojo.ranges), BaseFacetValuePojo.toThrift(pojo.field));

        thrift.validate();

        return thrift;
    }
}