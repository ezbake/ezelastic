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

namespace java ezbake.data.elastic.thrift

union ScriptValue
{
    1: string textValue;
    2: i32 intValue;
    3: double doubleValue;
    4: i64 longValue;
    5: bool booleanValue;
}

struct ScriptParam
{
    1: string paramName;
    2: ScriptValue paramValue;
}

struct ValueScript
{
    1: string script;
    2: list<ScriptParam> params;
}

struct KeyValueFacet
{
    1: required string key_field_name;
    2: required string value_field;
}

struct KeyValueScript
{
    1: required string keyScript;
    2: required string valueScript;
    3: optional list<ScriptParam> scriptParams;
}

union BaseFacetValue
{
    1: string facetField;
    2: KeyValueFacet keyValueFacet;
    3: KeyValueScript keyValueScript;
}

// Histogram Facet
struct HistogramFacet
{
    1: required i32 interval;
    2: required BaseFacetValue facetValue;
}

struct HistogramFacetEntry
{
    1: i64 key;
    2: i64 count;
    3: double mean;
    4: double min;
    5: double max;
    6: double total;
    7: i64 totalCount;
}

struct HistogramFacetResult
{
    1: list<HistogramFacetEntry> entries;
}

// Date Histogram Facet

enum DateIntervalType
{
    YEAR = 1,
    QUARTER,
    MONTH,
    WEEK,
    DAY,
    HOUR,
    MINUTE
}

struct KeyValueDateScript
{
    1: required string key_field;
    2: required string value_script;
    3: optional list<ScriptParam> scriptParams;
}

union DateField
{
    1: string _field;
    2: KeyValueFacet keyValueDateField;
    3: KeyValueDateScript keyValueDateScript;
}

union DateInterval
{
    1: string customInterval;
    2: DateIntervalType staticInterval;
}

struct DateHistogramFacet
{
    1: required DateField field;
    2: required DateInterval interval;
    3: optional i32 factor;
    4: optional i16 post_zone_hours;
    5: optional i16 pre_zone_hours;
}

struct DateHistogramFacetEntry
{
    1: i64 time;
    2: i64 count;
    3: double mean;
    4: double min;
    5: double max;
    6: double total;
    7: i64 totalCount;
}

struct DateHistogramFacetResult
{
    1: list<DateHistogramFacetEntry> entries;
}

// Filter Facet

struct FilterFacet
{
    1: required string luceneQuery;
}

struct FilterFacetResult
{
    1: i64 count;
}

// Range Facet
enum RangeType
{
    INTEGER,
    DOUBLE,
    DATE
}

struct FacetRange
{
    1: required RangeType rangeType;
    2: optional string from;
    3: optional string to;
}

struct RangeFacet
{
    1: required list<FacetRange> ranges;
    2: required BaseFacetValue field;
}

struct RangeFacetEntry
{
    1: string from;
    2: string to;
    3: double min;
    4: double max;
    5: double mean;
    6: i64 count;
}

struct RangeFacetResult
{
    1: list<RangeFacetEntry> entries;
}

// Terms Facet

enum FacetOrder {
    COUNT,
    TERM,
    REVERSE_COUNT,
    REVERSE_TERM
}

struct TermsFacet
{
    1: required list<string> fields;
    2: optional FacetOrder order;
    3: optional list<string> exclude;
    4: optional string regex;
    5: optional i32 size;
    6: optional bool isScriptField;
    7: optional bool allTerms;
}

struct TermsFacetEntry
{
    1: string term;
    2: i64 count;
}

struct TermsFacetResult
{
    1: i64 totalCount;
    2: i64 otherCount;
    3: i64 missingCount;
    4: list<TermsFacetEntry> entries;
}

// Terms Script Facet

struct TermsScriptFacet
{
    1: optional ValueScript script;
    2: optional string scriptField;
    3: optional list<string> fields;
    4: optional FacetOrder order;
    5: optional list<string> exclude;
    6: optional string regex;
    7: optional i32 size;
    8: optional bool allTerms;
}

// Statistical Facet

union StatisticalFacet
{
    1: list<string> fields;   // Used for single or multi field Statistical Facet
    2: ValueScript script;    // Used for Statistical Script Facet
}

struct StatisticalFacetResult
{
    1: i64 count;
    2: double max;
    3: double mean;
    4: double min;
    5: double stdDeviation;
    6: double sumOfSquares;
    7: double total;
    8: double variance;

}

// Terms Stats Facet

enum TermStatOrder
{
    TERM,
    REVERSE_TERM,
    COUNT,
    REVERSE_COUNT,
    TOTAL,
    REVERSE_TOTAL,
    MIN,
    REVERSE_MIN,
    MAX,
    REVERSE_MAX,
    MEAN,
    REVERSE_MEAN
}

union TermsStatsValue
{
    1: string valueField;
    2: ValueScript valueScript;
}

struct TermsStatsFacet
{
    1: string keyField;
    2: TermsStatsValue valueField;
    3: TermStatOrder order;
    4: i32 size;
    5: bool allTerms;
}

struct TermsStatsFacetResultEntry
{
    1: i64 count;
    2: i64 totalCount;
    3: double total;
    4: double mean;
    5: double max;
    6: double min;
    7: double termAsNumber;
    8: string term;
}

struct TermsStatsFacetResult
{
    1: list<TermsStatsFacetResultEntry> entries;
}

// Facet

union FacetRequest
{
    1: HistogramFacet histogramFacet;
    2: RangeFacet rangeFacet;
    3: FilterFacet filterFacet;
    4: TermsFacet termsFacet;
    5: DateHistogramFacet dateHistogramFacet;
    6: TermsStatsFacet termsStatsFacet;
    7: StatisticalFacet statisticalFacet;
    8: TermsScriptFacet termsScriptFacet;
}

union FacetResult
{
    1: TermsFacetResult termsFacetResult;
    2: RangeFacetResult rangeFacetResult;
    3: DateHistogramFacetResult dateFacetResult;
    4: HistogramFacetResult histogramFacetResult;
    5: FilterFacetResult filterFacetResult;
    6: TermsStatsFacetResult termsStatsFacetResult;
    7: StatisticalFacetResult statisticalFacetResult;
}

struct Facet
{
    1: required string label;
    2: required FacetRequest facet;
    3: optional string filterJSON;
}
