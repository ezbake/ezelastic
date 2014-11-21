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

import java.util.ArrayList;
import java.util.List;

import org.apache.thrift.TException;

import ezbake.data.elastic.thrift.ScriptParam;

public final class ScriptParamPojo {
    private String paramName;
    private ScriptValuePojo paramValue;

    public static List<ScriptParamPojo> fromThrift(List<ScriptParam> thrifts) {
        if (thrifts == null) {
            return null;
        }

        final List<ScriptParamPojo> pojos = new ArrayList<>(thrifts.size());
        for (final ScriptParam thrift : thrifts) {
            final ScriptParamPojo pojo = new ScriptParamPojo();
            pojo.paramName = thrift.getParamName();
            pojo.paramValue = ScriptValuePojo.fromThrift(thrift.getParamValue());

            pojos.add(pojo);
        }

        return pojos;
    }

    public static List<ScriptParam> toThrift(List<ScriptParamPojo> pojos) throws TException {
        if (pojos == null) {
            return null;
        }

        final List<ScriptParam> thrifts = new ArrayList<>(pojos.size());
        for (final ScriptParamPojo pojo : pojos) {
            final ScriptParam thrift = new ScriptParam(pojo.paramName, ScriptValuePojo.toThrift(pojo.paramValue));
            thrift.validate();
            thrifts.add(thrift);
        }

        return thrifts;
    }
}
