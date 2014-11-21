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

import ezbake.data.elastic.thrift.ValueScript;

public final class ValueScriptPojo {
    private String script;
    private List<ScriptParamPojo> params;

    public static ValueScriptPojo fromThrift(ValueScript thrift) {
        if (thrift == null) {
            return null;
        }

        final ValueScriptPojo pojo = new ValueScriptPojo();
        pojo.script = thrift.getScript();
        pojo.params = ScriptParamPojo.fromThrift(thrift.getParams());

        return pojo;
    }

    public static ValueScript toThrift(ValueScriptPojo pojo) throws TException {
        if (pojo == null) {
            return null;
        }

        final ValueScript thrift = new ValueScript(pojo.script, ScriptParamPojo.toThrift(pojo.params));
        thrift.validate();
        return thrift;
    }
}