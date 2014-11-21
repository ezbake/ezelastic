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

import ezbake.data.elastic.thrift.TermsFacetResult;

public final class TermsFacetResultPojo {
    private long totalCount;
    private long otherCount;
    private long missingCount;
    private List<TermsFacetEntryPojo> entries;

    public static TermsFacetResultPojo fromThrift(TermsFacetResult thrift) {
        if (thrift == null) {
            return null;
        }

        final TermsFacetResultPojo pojo = new TermsFacetResultPojo();
        pojo.totalCount = thrift.getTotalCount();
        pojo.otherCount = thrift.getOtherCount();
        pojo.missingCount = thrift.getMissingCount();
        pojo.entries = TermsFacetEntryPojo.fromThrift(thrift.getEntries());

        return pojo;
    }

    public static TermsFacetResult toThrift(TermsFacetResultPojo pojo) throws TException {
        if (pojo == null) {
            return null;
        }

        final TermsFacetResult thrift = new TermsFacetResult(
                pojo.totalCount, pojo.otherCount, pojo.missingCount, TermsFacetEntryPojo.toThrift(pojo.entries));

        thrift.validate();

        return thrift;
    }
}