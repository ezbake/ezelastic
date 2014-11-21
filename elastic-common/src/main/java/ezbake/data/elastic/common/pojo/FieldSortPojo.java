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

import ezbake.data.elastic.thrift.FieldSort;
import ezbake.data.elastic.thrift.SortMode;
import ezbake.data.elastic.thrift.SortOrder;

public final class FieldSortPojo {
    private String field;
    private SortOrder order;
    private SortMode mode; // optional
    private MissingSortPojo missing; // optional
    private Boolean ignoreUnmapped; // optional

    public static FieldSortPojo fromThrift(FieldSort thrift) {
        if (thrift == null) {
            return null;
        }

        final FieldSortPojo pojo = new FieldSortPojo();
        pojo.field = thrift.getField();
        pojo.order = thrift.getOrder();
        pojo.mode = thrift.getMode();
        pojo.missing = MissingSortPojo.fromThrift(thrift.getMissing());

        if (thrift.isIgnoreUnmapped()) {
            pojo.ignoreUnmapped = thrift.isIgnoreUnmapped();
        }

        return pojo;
    }

    public static FieldSort toThrift(FieldSortPojo pojo) {
        if (pojo == null) {
            return null;
        }

        final FieldSort thrift = new FieldSort();
        thrift.setField(pojo.field);
        thrift.setOrder(pojo.order);
        thrift.setMode(pojo.mode);
        thrift.setMissing(MissingSortPojo.toThrift(pojo.missing));

        if (pojo.ignoreUnmapped != null) {
            thrift.setIgnoreUnmapped(pojo.ignoreUnmapped);
        }

        return thrift;
    }
}
