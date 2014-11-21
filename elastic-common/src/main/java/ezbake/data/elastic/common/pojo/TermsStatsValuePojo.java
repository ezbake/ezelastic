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

import ezbake.data.elastic.thrift.TermsStatsValue;

// Union
public final class TermsStatsValuePojo {
    private String valueField;
    private ValueScriptPojo valueScript;

    public static TermsStatsValuePojo fromThrift(TermsStatsValue thrift) {
        if (thrift == null) {
            return null;
        }

        final TermsStatsValuePojo pojo = new TermsStatsValuePojo();

        switch (thrift.getSetField()) {
            case VALUE_FIELD:
                pojo.valueField = thrift.getValueField();
                break;
            case VALUE_SCRIPT:
                pojo.valueScript = ValueScriptPojo.fromThrift(thrift.getValueScript());
                break;
            default:
                throw new IllegalArgumentException("Unknown field set in union");
        }

        return pojo;
    }

    public static TermsStatsValue toThrift(TermsStatsValuePojo pojo) throws TException {
        if (pojo == null) {
            return null;
        }

        final TermsStatsValue thrift = new TermsStatsValue();

        if (pojo.valueField != null) {
            thrift.setValueField(pojo.valueField);
        } else if (pojo.valueScript != null) {
            thrift.setValueScript(ValueScriptPojo.toThrift(pojo.valueScript));
        } else {
            throw new IllegalArgumentException("No field set in POJO for Thrift union");
        }

        return thrift;
    }
}