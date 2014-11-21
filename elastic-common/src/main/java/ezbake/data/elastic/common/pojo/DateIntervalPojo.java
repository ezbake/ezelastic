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

import ezbake.data.elastic.thrift.DateInterval;
import ezbake.data.elastic.thrift.DateIntervalType;

// Union
public final class DateIntervalPojo {
    private String customInterval;
    private DateIntervalType staticInterval;

    public static DateIntervalPojo fromThrift(DateInterval thrift) {
        if (thrift == null) {
            return null;
        }

        final DateIntervalPojo pojo = new DateIntervalPojo();

        switch (thrift.getSetField()) {
            case CUSTOM_INTERVAL:
                pojo.customInterval = thrift.getCustomInterval();
                break;
            case STATIC_INTERVAL:
                pojo.staticInterval = thrift.getStaticInterval();
                break;
            default:
                throw new IllegalArgumentException("Unknown field set in union");
        }

        return pojo;
    }

    public static DateInterval toThrift(DateIntervalPojo pojo) {
        if (pojo == null) {
            return null;
        }

        final DateInterval thrift = new DateInterval();

        if (pojo.customInterval != null) {
            thrift.setCustomInterval(pojo.customInterval);
        } else if (pojo.staticInterval != null) {
            thrift.setStaticInterval(pojo.staticInterval);
        } else {
            throw new IllegalArgumentException("No field set in POJO for Thrift union");
        }

        return thrift;
    }
}