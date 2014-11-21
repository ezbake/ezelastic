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

import ezbake.data.elastic.thrift.TermsStatsFacetResult;

public final class TermsStatsFacetResultPojo {
    private List<TermsStatsFacetResultEntryPojo> entries;

    public static TermsStatsFacetResultPojo fromThrift(TermsStatsFacetResult thrift) {
        if (thrift == null) {
            return null;
        }

        final TermsStatsFacetResultPojo pojo = new TermsStatsFacetResultPojo();
        pojo.entries = TermsStatsFacetResultEntryPojo.fromThrift(thrift.getEntries());

        return pojo;
    }

    public static TermsStatsFacetResult toThrift(TermsStatsFacetResultPojo pojo) throws TException {
        if (pojo == null) {
            return null;
        }

        final TermsStatsFacetResult thrift =
                new TermsStatsFacetResult(TermsStatsFacetResultEntryPojo.toThrift(pojo.entries));

        thrift.validate();

        return thrift;
    }
}