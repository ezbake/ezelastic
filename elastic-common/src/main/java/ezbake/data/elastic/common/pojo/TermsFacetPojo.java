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
import ezbake.data.elastic.thrift.TermsFacet;

public final class TermsFacetPojo {
    private List<String> fields;
    private List<String> exclude; // optional
    private String regex; // optional
    private Integer size; // optional
    private Boolean isScriptField; // optional
    private Boolean allTerms; // optional
    private FacetOrder order; // optional

    public static TermsFacetPojo fromThrift(TermsFacet thrift) {
        if (thrift == null) {
            return null;
        }

        final TermsFacetPojo pojo = new TermsFacetPojo();
        pojo.fields = thrift.getFields();
        pojo.order = thrift.getOrder();
        pojo.exclude = thrift.getExclude();
        pojo.regex = thrift.getRegex();

        if (thrift.isSetSize()) {
            pojo.size = thrift.getSize();
        }

        if (thrift.isSetIsScriptField()) {
            pojo.isScriptField = thrift.isIsScriptField();
        }

        if (thrift.isSetAllTerms()) {
            pojo.allTerms = thrift.isAllTerms();
        }

        return pojo;
    }

    public static TermsFacet toThrift(TermsFacetPojo pojo) throws TException {
        if (pojo == null) {
            return null;
        }

        final TermsFacet thrift = new TermsFacet();
        thrift.setFields(pojo.fields);
        thrift.setOrder(pojo.order);
        thrift.setExclude(pojo.exclude);
        thrift.setRegex(pojo.regex);

        if (pojo.size != null) {
            thrift.setSize(pojo.size);
        }

        if (pojo.isScriptField != null) {
            thrift.setIsScriptField(pojo.isScriptField);
        }

        if (pojo.allTerms != null) {
            thrift.setAllTerms(pojo.allTerms);
        }

        thrift.validate();

        return thrift;
    }
}