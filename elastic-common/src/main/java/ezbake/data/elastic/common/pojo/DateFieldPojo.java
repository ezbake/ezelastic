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

import ezbake.data.elastic.thrift.DateField;

// Union
public final class DateFieldPojo {
    private String _field;
    private KeyValueFacetPojo keyValueDateField;
    private KeyValueDateScriptPojo keyValueDateScript;

    public static DateFieldPojo fromThrift(DateField thrift) {
        if (thrift == null) {
            return null;
        }

        final DateFieldPojo pojo = new DateFieldPojo();

        switch (thrift.getSetField()) {
            case _FIELD:
                pojo._field = thrift.get_field();
                break;
            case KEY_VALUE_DATE_FIELD:
                pojo.keyValueDateField = KeyValueFacetPojo.fromThrift(thrift.getKeyValueDateField());
                break;
            case KEY_VALUE_DATE_SCRIPT:
                pojo.keyValueDateScript = KeyValueDateScriptPojo.fromThrift(thrift.getKeyValueDateScript());
                break;
            default:
                throw new IllegalArgumentException("Unknown field set in union");
        }

        return pojo;
    }

    public static DateField toThrift(DateFieldPojo pojo) throws TException {
        if (pojo == null) {
            return null;
        }

        final DateField thrift = new DateField();

        if (pojo._field != null) {
            thrift.set_field(pojo._field);
        } else if (pojo.keyValueDateField != null) {
            thrift.setKeyValueDateField(KeyValueFacetPojo.toThrift(pojo.keyValueDateField));
        } else if (pojo.keyValueDateScript != null) {
            thrift.setKeyValueDateScript(KeyValueDateScriptPojo.toThrift(pojo.keyValueDateScript));
        } else {
            throw new IllegalArgumentException("No field set in POJO for Thrift union");
        }

        return thrift;
    }
}