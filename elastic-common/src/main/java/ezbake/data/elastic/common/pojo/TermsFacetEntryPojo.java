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

import ezbake.data.elastic.thrift.TermsFacetEntry;

public final class TermsFacetEntryPojo {
    private String term;
    private long count;

    public static List<TermsFacetEntryPojo> fromThrift(List<TermsFacetEntry> thrifts) {
        if (thrifts == null) {
            return null;
        }

        final List<TermsFacetEntryPojo> pojos = new ArrayList<>(thrifts.size());
        for (final TermsFacetEntry thrift : thrifts) {
            final TermsFacetEntryPojo pojo = new TermsFacetEntryPojo();
            pojo.term = thrift.getTerm();
            pojo.count = thrift.getCount();

            pojos.add(pojo);
        }

        return pojos;
    }

    public static List<TermsFacetEntry> toThrift(List<TermsFacetEntryPojo> pojos) throws TException {
        if (pojos == null) {
            return null;
        }

        final List<TermsFacetEntry> thrifts = new ArrayList<>(pojos.size());
        for (final TermsFacetEntryPojo pojo : pojos) {
            final TermsFacetEntry thrift = new TermsFacetEntry(pojo.term, pojo.count);
            thrift.validate();
            thrifts.add(thrift);
        }

        return thrifts;
    }
}
