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

import ezbake.data.elastic.thrift.KeyValueDateScript;

public final class KeyValueDateScriptPojo {
    private String key_field;
    private String value_script;
    private List<ScriptParamPojo> scriptParams; // optional

    public static KeyValueDateScriptPojo fromThrift(KeyValueDateScript thrift) {
        if (thrift == null) {
            return null;
        }

        final KeyValueDateScriptPojo pojo = new KeyValueDateScriptPojo();
        pojo.key_field = thrift.getKey_field();
        pojo.value_script = thrift.value_script;
        pojo.scriptParams = ScriptParamPojo.fromThrift(thrift.getScriptParams());

        return pojo;
    }

    public static KeyValueDateScript toThrift(KeyValueDateScriptPojo pojo) throws TException {
        if (pojo == null) {
            return null;
        }

        final KeyValueDateScript thrift = new KeyValueDateScript();
        thrift.setKey_field(pojo.key_field);
        thrift.setValue_script(pojo.value_script);
        thrift.setScriptParams(ScriptParamPojo.toThrift(pojo.scriptParams));

        thrift.validate();

        return thrift;
    }
}