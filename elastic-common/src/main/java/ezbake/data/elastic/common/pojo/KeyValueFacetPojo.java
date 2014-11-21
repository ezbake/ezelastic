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

import ezbake.data.elastic.thrift.KeyValueFacet;

public final class KeyValueFacetPojo {
    private String key_field_name;
    private String value_field;

    public static KeyValueFacetPojo fromThrift(KeyValueFacet thrift) {
        if (thrift == null) {
            return null;
        }

        final KeyValueFacetPojo pojo = new KeyValueFacetPojo();
        pojo.key_field_name = thrift.getKey_field_name();
        pojo.value_field = thrift.getValue_field();

        return pojo;
    }

    public static KeyValueFacet toThrift(KeyValueFacetPojo pojo) throws TException {
        if (pojo == null) {
            return null;
        }

        final KeyValueFacet thrift = new KeyValueFacet(pojo.key_field_name, pojo.value_field);
        thrift.validate();
        return thrift;
    }
}