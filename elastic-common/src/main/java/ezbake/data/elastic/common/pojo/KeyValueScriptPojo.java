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

import ezbake.data.elastic.thrift.KeyValueScript;

public final class KeyValueScriptPojo {
    private String keyScript;
    private String valueScript;
    private List<ScriptParamPojo> scriptParams; // optional

    public static KeyValueScriptPojo fromThrift(KeyValueScript thrift) {
        if (thrift == null) {
            return null;
        }

        final KeyValueScriptPojo pojo = new KeyValueScriptPojo();
        pojo.keyScript = thrift.getKeyScript();
        pojo.valueScript = thrift.getValueScript();
        pojo.scriptParams = ScriptParamPojo.fromThrift(thrift.getScriptParams());

        return pojo;
    }

    public static KeyValueScript toThrift(KeyValueScriptPojo pojo) throws TException {
        if (pojo == null) {
            return null;
        }

        final KeyValueScript thrift = new KeyValueScript();
        thrift.setKeyScript(pojo.keyScript);
        thrift.setValueScript(pojo.valueScript);
        thrift.setScriptParams(ScriptParamPojo.toThrift(pojo.scriptParams));

        thrift.validate();
        return thrift;
    }
}