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

import ezbake.data.elastic.thrift.StatisticalFacet;

// Union
public final class StatisticalFacetPojo {
    private List<String> fields;
    private ValueScriptPojo script;

    public static StatisticalFacetPojo fromThrift(StatisticalFacet thrift) {
        if (thrift == null) {
            return null;
        }

        final StatisticalFacetPojo pojo = new StatisticalFacetPojo();

        switch (thrift.getSetField()) {
            case FIELDS:
                pojo.fields = thrift.getFields();
                break;
            case SCRIPT:
                pojo.script = ValueScriptPojo.fromThrift(thrift.getScript());
                break;
            default:
                throw new IllegalArgumentException("Unknown field set in union");
        }

        return pojo;
    }

    public static StatisticalFacet toThrift(StatisticalFacetPojo pojo) throws TException {
        if (pojo == null) {
            return null;
        }

        final StatisticalFacet thrift = new StatisticalFacet();

        if (pojo.fields != null) {
            thrift.setFields(pojo.fields);
        } else if (pojo.script != null) {
            thrift.setScript(ValueScriptPojo.toThrift(pojo.script));
        } else {
            throw new IllegalArgumentException("No field set in POJO for Thrift union");
        }

        return thrift;
    }
}