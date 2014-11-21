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

import ezbake.data.elastic.thrift.TermStatOrder;
import ezbake.data.elastic.thrift.TermsStatsFacet;

public final class TermsStatsFacetPojo {
    private String keyField;
    private TermsStatsValuePojo valueField;
    private TermStatOrder order;
    private int size;
    private boolean allTerms;

    public static TermsStatsFacetPojo fromThrift(TermsStatsFacet thrift) {
        if (thrift == null) {
            return null;
        }

        final TermsStatsFacetPojo pojo = new TermsStatsFacetPojo();
        pojo.keyField = thrift.getKeyField();
        pojo.valueField = TermsStatsValuePojo.fromThrift(thrift.getValueField());
        pojo.order = thrift.getOrder();
        pojo.size = thrift.getSize();
        pojo.allTerms = thrift.isAllTerms();

        return pojo;
    }

    public static TermsStatsFacet toThrift(TermsStatsFacetPojo pojo) throws TException {
        if (pojo == null) {
            return null;
        }

        final TermsStatsFacet thrift = new TermsStatsFacet();
        thrift.setKeyField(pojo.keyField);
        thrift.setValueField(TermsStatsValuePojo.toThrift(pojo.valueField));
        thrift.setOrder(pojo.order);
        thrift.setSize(pojo.size);
        thrift.setAllTerms(pojo.allTerms);

        thrift.validate();

        return thrift;
    }
}