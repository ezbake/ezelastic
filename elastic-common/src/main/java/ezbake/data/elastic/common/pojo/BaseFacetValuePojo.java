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

import ezbake.data.elastic.thrift.BaseFacetValue;

// Union
public final class BaseFacetValuePojo {
    private String facetField;
    private KeyValueFacetPojo keyValueFacet;
    private KeyValueScriptPojo keyValueScript;

    public static BaseFacetValuePojo fromThrift(BaseFacetValue thrift) {
        if (thrift == null) {
            return null;
        }

        final BaseFacetValuePojo pojo = new BaseFacetValuePojo();

        switch (thrift.getSetField()) {
            case FACET_FIELD:
                pojo.facetField = thrift.getFacetField();
                break;
            case KEY_VALUE_FACET:
                pojo.keyValueFacet = KeyValueFacetPojo.fromThrift(thrift.getKeyValueFacet());
                break;
            case KEY_VALUE_SCRIPT:
                pojo.keyValueScript = KeyValueScriptPojo.fromThrift(thrift.getKeyValueScript());
                break;
            default:
                throw new IllegalArgumentException("Unknown field set in union");
        }

        return pojo;
    }

    public static BaseFacetValue toThrift(BaseFacetValuePojo pojo) throws TException {
        if (pojo == null) {
            return null;
        }

        final BaseFacetValue thrift = new BaseFacetValue();

        if (pojo.facetField != null) {
            thrift.setFacetField(pojo.facetField);
        } else if (pojo.keyValueFacet != null) {
            thrift.setKeyValueFacet(KeyValueFacetPojo.toThrift(pojo.keyValueFacet));
        } else if (pojo.keyValueScript != null) {
            thrift.setKeyValueScript(KeyValueScriptPojo.toThrift(pojo.keyValueScript));
        } else {
            throw new IllegalArgumentException("No field set in POJO for Thrift union");
        }

        return thrift;
    }
}