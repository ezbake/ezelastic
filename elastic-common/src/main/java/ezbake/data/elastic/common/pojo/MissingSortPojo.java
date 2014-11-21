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

import ezbake.data.elastic.thrift.MissingOrder;
import ezbake.data.elastic.thrift.MissingSort;

// Union
public final class MissingSortPojo {
    private MissingOrder basic;
    private String custom;

    public static MissingSortPojo fromThrift(MissingSort thrift) {
        if (thrift == null) {
            return null;
        }

        final MissingSortPojo pojo = new MissingSortPojo();

        switch (thrift.getSetField()) {
            case BASIC:
                pojo.basic = thrift.getBasic();
                break;
            case CUSTOM:
                pojo.custom = thrift.getCustom();
                break;
            default:
                throw new IllegalArgumentException("Unknown field set in union");
        }

        return pojo;
    }

    public static MissingSort toThrift(MissingSortPojo pojo) {
        if (pojo == null) {
            return null;
        }

        final MissingSort thrift = new MissingSort();

        if (pojo.basic != null) {
            thrift.setBasic(pojo.basic);
        } else if (pojo.custom != null) {
            thrift.setCustom(pojo.custom);
        } else {
            throw new IllegalArgumentException("No field set in POJO for Thrift union");
        }

        return thrift;
    }
}
