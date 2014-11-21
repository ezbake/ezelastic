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

import ezbake.data.elastic.thrift.FacetOrder;
import ezbake.data.elastic.thrift.TermsScriptFacet;

public final class TermsScriptFacetPojo {
    // All optional
    private ValueScriptPojo script;
    private String scriptField;
    private List<String> fields;
    private FacetOrder order;
    private List<String> exclude;
    private String regex;
    private Integer size;
    private Boolean allTerms;

    public static TermsScriptFacetPojo fromThrift(TermsScriptFacet thrift) {
        if (thrift == null) {
            return null;
        }

        final TermsScriptFacetPojo pojo = new TermsScriptFacetPojo();
        pojo.script = ValueScriptPojo.fromThrift(thrift.getScript());
        pojo.scriptField = thrift.getScriptField();
        pojo.fields = thrift.getFields();
        pojo.order = thrift.getOrder();
        pojo.exclude = thrift.getExclude();
        pojo.regex = thrift.getRegex();

        if (thrift.isSetSize()) {
            pojo.size = thrift.getSize();
        }

        if (thrift.isSetAllTerms()) {
            pojo.allTerms = thrift.isAllTerms();
        }

        return pojo;
    }

    public static TermsScriptFacet toThrift(TermsScriptFacetPojo pojo) throws TException {
        if (pojo == null) {
            return null;
        }

        final TermsScriptFacet thrift = new TermsScriptFacet();
        thrift.setScript(ValueScriptPojo.toThrift(pojo.script));
        thrift.setScriptField(pojo.scriptField);
        thrift.setFields(pojo.fields);
        thrift.setOrder(pojo.order);
        thrift.setExclude(pojo.exclude);
        thrift.setRegex(pojo.regex);

        if (pojo.size != null) {
            thrift.setSize(pojo.size);
        }

        if (pojo.allTerms != null) {
            thrift.setAllTerms(pojo.allTerms);
        }

        thrift.validate();

        return thrift;
    }
}