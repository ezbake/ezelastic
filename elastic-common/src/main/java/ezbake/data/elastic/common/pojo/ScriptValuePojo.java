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

import ezbake.data.elastic.thrift.ScriptValue;

// Union
public final class ScriptValuePojo {
    private String textValue;
    private Integer intValue;
    private Double doubleValue;
    private Long longValue;
    private Boolean booleanValue;

    public static ScriptValuePojo fromThrift(ScriptValue thrift) {
        if (thrift == null) {
            return null;
        }

        final ScriptValuePojo pojo = new ScriptValuePojo();

        switch (thrift.getSetField()) {
            case TEXT_VALUE:
                pojo.textValue = thrift.getTextValue();
                break;
            case INT_VALUE:
                pojo.intValue = thrift.getIntValue();
                break;
            case DOUBLE_VALUE:
                pojo.doubleValue = thrift.getDoubleValue();
                break;
            case LONG_VALUE:
                pojo.longValue = thrift.getLongValue();
                break;
            case BOOLEAN_VALUE:
                pojo.booleanValue = thrift.getBooleanValue();
                break;
            default:
                throw new IllegalArgumentException("Unknown field set in union");
        }

        return pojo;
    }

    public static ScriptValue toThrift(ScriptValuePojo pojo) {
        if (pojo == null) {
            return null;
        }

        final ScriptValue thrift = new ScriptValue();

        if (pojo.textValue != null) {
            thrift.setTextValue(pojo.textValue);
        } else if (pojo.intValue != null) {
            thrift.setIntValue(pojo.intValue);
        } else if (pojo.doubleValue != null) {
            thrift.setDoubleValue(pojo.doubleValue);
        } else if (pojo.longValue != null) {
            thrift.setLongValue(pojo.longValue);
        } else if (pojo.booleanValue != null) {
            thrift.setBooleanValue(pojo.booleanValue);
        } else {
            throw new IllegalArgumentException("No field set in POJO for Thrift union");
        }

        return thrift;
    }
}