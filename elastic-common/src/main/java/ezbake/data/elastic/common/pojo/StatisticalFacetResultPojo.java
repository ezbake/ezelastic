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

import ezbake.data.elastic.thrift.StatisticalFacetResult;

public final class StatisticalFacetResultPojo {
    private long count;
    private double max;
    private double mean;
    private double min;
    private double stdDeviation;
    private double sumOfSquares;
    private double total;
    private double variance;

    public static StatisticalFacetResultPojo fromThrift(StatisticalFacetResult thrift) {
        if (thrift == null) {
            return null;
        }

        final StatisticalFacetResultPojo pojo = new StatisticalFacetResultPojo();
        pojo.count = thrift.getCount();
        pojo.max = thrift.getMax();
        pojo.mean = thrift.getMean();
        pojo.min = thrift.getMin();
        pojo.stdDeviation = thrift.getStdDeviation();
        pojo.sumOfSquares = thrift.getSumOfSquares();
        pojo.total = thrift.getTotal();
        pojo.variance = thrift.getVariance();

        return pojo;
    }

    public static StatisticalFacetResult toThrift(StatisticalFacetResultPojo pojo) throws TException {
        if (pojo == null) {
            return null;
        }

        final StatisticalFacetResult thrift = new StatisticalFacetResult(
                pojo.count, pojo.max, pojo.mean, pojo.min, pojo.stdDeviation, pojo.sumOfSquares, pojo.total,
                pojo.variance);

        thrift.validate();

        return thrift;
    }
}