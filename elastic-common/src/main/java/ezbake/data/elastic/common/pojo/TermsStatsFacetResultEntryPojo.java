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

import ezbake.data.elastic.thrift.TermsStatsFacetResultEntry;

public final class TermsStatsFacetResultEntryPojo {
    private long count;
    private long totalCount;
    private double total;
    private double mean;
    private double max;
    private double min;
    private double termAsNumber;
    private String term;

    public static List<TermsStatsFacetResultEntryPojo> fromThrift(List<TermsStatsFacetResultEntry> thrifts) {
        if (thrifts == null) {
            return null;
        }

        final List<TermsStatsFacetResultEntryPojo> pojos = new ArrayList<>(thrifts.size());
        for (final TermsStatsFacetResultEntry thrift : thrifts) {
            final TermsStatsFacetResultEntryPojo pojo = new TermsStatsFacetResultEntryPojo();
            pojo.count = thrift.getCount();
            pojo.totalCount = thrift.getTotalCount();
            pojo.total = thrift.getTotalCount();
            pojo.mean = thrift.getMean();
            pojo.max = thrift.getMax();
            pojo.min = thrift.getMin();
            pojo.termAsNumber = thrift.getTermAsNumber();
            pojo.term = thrift.getTerm();

            pojos.add(pojo);
        }

        return pojos;
    }

    public static List<TermsStatsFacetResultEntry> toThrift(List<TermsStatsFacetResultEntryPojo> pojos)
            throws TException {
        if (pojos == null) {
            return null;
        }

        final List<TermsStatsFacetResultEntry> thrifts = new ArrayList<>(pojos.size());
        for (final TermsStatsFacetResultEntryPojo pojo : pojos) {
            final TermsStatsFacetResultEntry thrift = new TermsStatsFacetResultEntry(
                    pojo.count, pojo.totalCount, pojo.total, pojo.mean, pojo.max, pojo.min, pojo.termAsNumber,
                    pojo.term);

            thrift.validate();

            thrifts.add(thrift);
        }

        return thrifts;
    }
}
