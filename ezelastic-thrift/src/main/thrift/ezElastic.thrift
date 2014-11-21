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

include "ezbakeBaseTypes.thrift"
include "ezbakeBaseVisibility.thrift"
include "ezbakeBaseService.thrift"
include "elasticFacetTypes.thrift"
include "baseDataService.thrift"

/**
 * Sort order for sorting; ascending is A-Z, descending is Z-A lexicographically
 */
enum SortOrder
{
    ASCENDING,
    DESCENDING
}

/**
 * Sort mode for arrays/multi-fields
 * @see: http://www.elasticsearch.org/guide/en/elasticsearch/reference/current/search-request-sort.html
 */
enum SortMode
{
    AVG,
    MAX,
    MIN,
    SUM
}

/**
 * Which end of the results to place the items that do not have the sorting field.
 */
enum MissingOrder
{
    FIRST,
    LAST
}

/**
 * Specified the way to sort items when they are missing the sorting field. If custom is specified that value will be
 * used to sort any items that are missing.
 */
union MissingSort
{
    1: MissingOrder basic;
    2: string custom;
}

/**
 * A geo value used for comparisons  in sorting. For example, to sort by a distance from a point `coordinate`.
 */
union GeoSortValue
{
    1: string geoHash;
    2: ezbakeBaseTypes.Coordinate coordinate;
}

/**
 * Unit of distance to use for sorting
 */
enum DistanceUnit
{
    CENTIMETERS,
    INCH,
    KILOMETERS,
    METERS,
    MILES,
    MILLIMETERS,
    YARD
}

/**
 * Defines a geo-distance sort on a field mapped as a geospatial type.
 */
struct GeoDistanceSort
{
    /**
     * The name of the field to sort on (must be mapped as a geospatial type)
     */
    1: required string field;

    /**
     * The order to sort
     */
    2: required SortOrder order;

    /**
     * The unit of distance to use
     */
    3: required DistanceUnit unit;

    /**
     * The value to compare against to compute distance
     */
    4: required GeoSortValue value;

    /**
     * Sort mode (geo supports MIN, MAX, and AVG)
     */
    5: optional SortMode mode;
}

/**
 * Defines a lexicographic sort on a given field
 */
struct FieldSort
{
    /**
     * The name of the field to sort on
     */
    1: required string field;

    /**
     * The order to sort
     */
    2: required SortOrder order;

    /**
     * The sorting mode for array/multi-value fields
     */
    3: optional SortMode mode;

    /**
     * What to do with missing values
     */
    4: optional MissingSort missing;

    /**
     * If true ES will ignore sorting fields that are not mapped on the type
     */
    5: optional bool ignoreUnmapped;
}

/**
 * Sorting criteria for a query, either a geo sort or a normal field sort.
 */
union SortCriteria
{
    1: GeoDistanceSort geoSort;
    2: FieldSort fieldSort;
}

/**
 * Options for an update operation
 */
struct UpdateOptions
{
    /**
     * Number of times to retry an update before failing
     */
    1: optional i32 retryCount = 0;
}

/**
 * A script to update an existing document.
 */
struct UpdateScript
{
    /**
     * The MVEL script to execute
     */
    1: optional string script;

    /**
     * Parameters to pass to the script (surround strings in quotes)
     */
    2: optional map<string, string> parameters;
}

/**
 * A field to return for highlighting including parameters for surrounding fragments to return.
 */
struct HighlightedField
{
    /**
     * Name of the field to highlight
     */
    1: required string field;

    /**
     * Approximate characters to return for the fragment
     */
    2: optional i32 fragmentSize = 100;

    /**
     * Number of fragments
     */
    3: optional i32 numberOfFragments = 5;
}

/**
 * A request to highlight a set of fields
 */
struct HighlightRequest
{
    /**
     * Set of fields to highlight
     */
    1: required set<HighlightedField> fields;

    /**
     * Order to highlight
     */
    2: optional string order;

    /**
     * Tags to begin fragments (default <em>)
     */
    3: optional list<string> pre_tags;

    /**
     * Tags to end fragments (default </em>)
     */
    4: optional list<string> post_tags;

    /**
     * Schema for tags
     */
    5: optional string tags_schema;

    /**
     * Whether to require a field match to highlight
     */
    6: optional bool requireFieldMatch;
}

/**
 * Result of highlighting
 */
struct HighlightResult
{
    /**
     * Map from field name => [fragments...]
     */
    1: required map<string, list<string>> results;
}

/**
 * Defines options for percolating documents upon insert
 */
struct PercolateRequest
{
    /**
     * Filter JSON to filter out queries that should not applySettings
     */
    1: optional string filterJson;

    /**
     * Maximum number of queries to return
     */
    2: optional i32 maxMatches = 50;

    /**
     * Facets to request for the returned queries
     */
    3: optional list<elasticFacetTypes.Facet> facets;
}

/**
 * A percolate query to be registered with the percolator
 */
struct PercolateQuery
{
    /**
     * The query to register as an ES query
     */
    1: optional string queryDocument;

    /**
     * The visibility of this query
     */
    2: optional ezbakeBaseVisibility.Visibility visibility;

    /**
     * The id of this percolate query
     */
    3: optional string id;
}

/**
 * A page of results
 */
struct Page
{
    /**
     * Offset as the number of items since the start of the result list
     */
    1: required i32 offset;

    /**
     * Number of items in this page
     */
    2: required i16 pageSize;
}

/**
 * Query object for use with searching.
 */
struct Query
{
    /**
     * A Lucene query string or ES JSON query
     */
    1: required string searchString;

    /**
     * A type to restrict the search to
     */
    2: optional string type;

    /**
     * A page of results to request
     */
    3: optional Page page;

    /**
     * Sorting criteria
     */
    4: optional list<SortCriteria> sortCriteria;

    /**
     * Requests for facets on the results
     */
    5: optional list<elasticFacetTypes.Facet> facets;

    /**
     * A subset of the fields to return
     */
    6: optional set<string> returnedFields;

    /**
     * ES filter JSON to add
     */
    7: optional string filterJson;

    /**
     * Highlighting information to return
     */
    8: optional HighlightRequest highlighting;
}

/**
 * A document to insert
 */
struct Document
{
    /**
     * Elastic type to search
     */
    1: required string _type;

    /**
     * Visibility to control who has access to this document
     */
    2: required ezbakeBaseVisibility.Visibility visibility;

    /**
     * JSON of document
     */
    3: required string _jsonObject

    /**
     * Elastic Version ID
     */
    4: optional i64 _version;

    /**
     * Elastic document ID
     */
    5: optional string _id;

    /**
     * Percolate request
     */
    6: optional PercolateRequest percolate;
}

/**
 * Results of a search
 */
struct SearchResult
{
    /**
     * Documents matching the search
     */
    1: required list<Document> matchingDocuments;

    /**
     * Total number of results across all pages
     */
    2: required i64 totalHits;

    /**
     * Paging offset
     */
    3: required i32 offset;

    /**
     * Page size
     */
    4: required i16 pagesize;

    /**
     * JSON query that created these results
     */
    5: required string actualQuery;

    /**
     * Map of facet name (from ImageSearch) to its results
     */
    6: optional map<string, elasticFacetTypes.FacetResult> facets;

    /**
     *  Maps from doc id => highlight result
     */
    7: optional map<string, HighlightResult> highlights;
}

/**
 * This is the response when a document is indexed (inserted).
 */
struct IndexResponse
{
    /**
     * The type the document was inserted under
     */
    1: required string _type;

    /**
     * The id of the inserted document
     */
    2: required string _id;

    /**
     * The ES version (unrelated to EzElastic)
     */
    3: required i64 _version;

    /**
     * True if the index operation succeeded, otherwise false.
     */
    4: optional bool success = true;

    /**
     * If percolation was requested this holds the queries that matched
     */
    5: optional list<PercolateQuery> percolateResults;
}

/**
 * Used to pass unique document identifiers around
 */
struct DocumentIdentifier
{
    /**
     * Elastic document ID
     */
    1: required string id;

    /**
     * Elastic type
     */
    2: optional string type;
}

/**
 * Exception thrown when requested field(s) could not be found in the document
 */
exception FieldsNotFound
{
    /**
     * Elastic ID for document for which field(s) were missing
     */
    1: required string _id;

    /**
     * Elastic type field for document for which field(s) were missing
     */
    2: required string _type;

    /**
     * The field(s)s that were missing
     */
    3: required list<string> fields;

    /**
     * Message giving context to why and where error occurred
     */
    4: optional string message;
}

/**
 * Exception thrown when a document could not be indexed/inserted into Elasticsearch
 */
exception DocumentIndexingException
{
    /**
     * Elastic type field into which the document indexing attempt occurred
     */
    1: required string _type

    /**
     * Message giving context to why and where error occurred
     */
    2: required string message

    /**
     * Elastic ID for document
     */
    3: optional string _id
}

/**
 * Exception thrown when a search query could not be parsed and is otherwise invalid
 */
exception MalformedQueryException
{
    /**
     * Query string that was malformed
     */
    1: required string query

    /**
     * Message giving context to why and where error occurred
     */
    2: required string message
}

service EzElastic extends baseDataService.BaseDataService
{
    //
    // Index Operations - Insert and Update
    //

    /**
     * If no document exists with the supplied id (or if no id was specified), the document will be added.
     */
    IndexResponse put(1:Document document, 2: ezbakeBaseTypes.EzSecurityToken userToken) throws
        (1:DocumentIndexingException failure);

    /**
     * Updates a document using a script
     */
    IndexResponse update(
        1: DocumentIdentifier id, 2: UpdateScript script, 3: UpdateOptions options,
        4: ezbakeBaseTypes.EzSecurityToken userToken);

    //
    // Get Operations
    //

    /**
     * Retrieves the document with the supplied ID
     */
    Document get(1:string _id, 2: ezbakeBaseTypes.EzSecurityToken userToken);

    /**
     * Retrieves the document with the supplied ID and type
     */
    Document getWithType(1:string _id, 2: string _type, 3: ezbakeBaseTypes.EzSecurityToken userToken);

    /**
     * Retrieves a subset of fields for the document with the supplied ID and type
     */
    Document getWithFields(
        1:string _id, 2: string _type, 3: set<string> fields, 4: ezbakeBaseTypes.EzSecurityToken userToken) throws
        (1:FieldsNotFound invalidFields);

    //
    // Query Operations
    //

    /**
     * Retrieves documents based on the given Query including sorting and paging.
     */
    SearchResult query(1:Query query, 2:ezbakeBaseTypes.EzSecurityToken userToken) throws
        (1:MalformedQueryException malformedQueryException);

    //
    // Delete Operations
    //

    /**
     * Deletes documents with the given ID across all types
     */
    void deleteById(1:string _id, 2:ezbakeBaseTypes.EzSecurityToken userToken);

    /**
     * Deletes the document with the given ID within the supplied type
     */
    void deleteWithType(1:string _id, 2:string _type, 3:ezbakeBaseTypes.EzSecurityToken userToken);

    /**
     * Deletes documents matching the given query across all types
     */
    void deleteByQuery(1:string query, 2:ezbakeBaseTypes.EzSecurityToken userToken) throws
        (1:MalformedQueryException malformedQueryException);

    /**
     * Deletes documents matching the given query within the supplied type
     */
    void deleteByQueryWithType(1:string query, 2:string _type, 3:ezbakeBaseTypes.EzSecurityToken userToken) throws
        (1:MalformedQueryException malformedQueryException);

    //
    // Bulk Operations
    //

    /**
     * Insert multiple documents. For each document, if no document exists with the supplied id (or if no id was
     * specified), the document will be added.
     */
    list<IndexResponse> bulkPut(1:list<Document> documents, 2:ezbakeBaseTypes.EzSecurityToken userToken) throws
        (1:DocumentIndexingException failure);

    /**
     * Retrieves multiple documents with the given IDs within the supplied type
     */
    list<Document> bulkGetWithType(1:set<string> ids, 2:string _type, 3:ezbakeBaseTypes.EzSecurityToken userToken);

    /**
     * Deletes multiple documents with the given IDs across all types
     */
    void bulkDelete(1:set<string> ids, 2:ezbakeBaseTypes.EzSecurityToken userToken);

    /**
     * Deletes multiple documents with the given IDs within the supplied type
     */
    void bulkDeleteWithType(1:set<string> ids, 2:string _type, 3:ezbakeBaseTypes.EzSecurityToken userToken);

    //
    // Count Operations
    //

    /**
     * Counts the number of documents matching the query across all types
     */
    i64 countByQuery(1:string query, 2:ezbakeBaseTypes.EzSecurityToken userToken) throws
        (1:MalformedQueryException malformedQueryException);

    /**
     * Counts the number of documents within the given types
     */
    i64 countByType(1:set<string> types, 2:ezbakeBaseTypes.EzSecurityToken userToken);

    /**
     * Counts the number of documents matching the given query across the supplied types
     */
    i64 countByQueryAndType(1:set<string> types, 2:string query, 3:ezbakeBaseTypes.EzSecurityToken userToken) throws
        (1:MalformedQueryException malformedQueryException);

    //
    // Percolate Operations
    //

    /**
     * Add a percolate query to the index
     */
    IndexResponse addPercolateQuery(1: PercolateQuery query, 2:ezbakeBaseTypes.EzSecurityToken userToken);

    /**
     * Remove a percolate query by the given ID
     */
    void removePercolateQuery(1: string queryId, 2: ezbakeBaseTypes.EzSecurityToken userToken);

    /**
     * Performs a multi-percolate operation with the given documents
     */
    list<PercolateQuery> percolate(1: list<Document> documents, 2: ezbakeBaseTypes.EzSecurityToken userToken);

    //
    // Index Admin Operations
    //

    /**
     * Open the index for use
     */
    void openIndex(1:ezbakeBaseTypes.EzSecurityToken userToken);

    /**
     * Close the index
     */
    void closeIndex(1:ezbakeBaseTypes.EzSecurityToken userToken);

    /**
     * Apply the given settings to the index
     */
    void applySettings(1:string settingsJson, 2:ezbakeBaseTypes.EzSecurityToken userToken);

    /**
     * Set/add a type mapping to the index
     */
    void setTypeMapping(1:string type, 2:string mappingJson, 3:ezbakeBaseTypes.EzSecurityToken userToken);

    /**
     * Force a refresh of the index
     */
    void forceIndexRefresh(1:ezbakeBaseTypes.EzSecurityToken userToken);
}
