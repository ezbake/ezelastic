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

package ezbake.data.elastic;

import java.util.List;
import java.util.Set;

import org.apache.thrift.TException;

import ezbake.base.thrift.CancelStatus;
import ezbake.base.thrift.EzSecurityToken;
import ezbake.data.base.thrift.PurgeResult;
import ezbake.data.elastic.thrift.Document;
import ezbake.data.elastic.thrift.DocumentIdentifier;
import ezbake.data.elastic.thrift.Facet;
import ezbake.data.elastic.thrift.HighlightRequest;
import ezbake.data.elastic.thrift.IndexResponse;
import ezbake.data.elastic.thrift.MalformedQueryException;
import ezbake.data.elastic.thrift.PercolateQuery;
import ezbake.data.elastic.thrift.SearchResult;
import ezbake.data.elastic.thrift.SortCriteria;
import ezbake.data.elastic.thrift.UpdateOptions;
import ezbake.data.elastic.thrift.UpdateScript;

public interface DocumentStore {
    /**
     * For each of the supplied documents, if no document exists with the supplied id (or if no id was specified), the
     * document will be added to specified index/database with the supplied type/collection.
     *
     * @param documents The documents to be stored in the document repository.
     * @return Index responses for the puts on the given documents
     */
    List<IndexResponse> put(List<Document> documents);

    /**
     * Updates a document using a script or using a document.
     *
     * @param id Unique identifier of the document to update with type. If the document is not visible this method will
     * return null.
     * @param script An elasticsearch MVEL script to update fields of the document.
     * @param token The user's security token with information for auditing and verifying the user has access to update
     * the given data.
     * @return null if the document is unavailable, otherwise it will return the index response for updating (see ES).
     */
    IndexResponse update(DocumentIdentifier id, UpdateScript script, UpdateOptions options, EzSecurityToken token)
            throws TException;

    /**
     * Retrieves a collection of documents from the repository using the ids and if supplied, index/database and
     * type/collection.
     *
     * @param ids Unique ids of the document within the document store. If an index and/or type are supplied those will
     * be used to limit the scope of results. If they are not supplied, the first object with a matching id will be
     * returned.
     * @param type Used to limit the scope when searching for the document with the supplied id. If a document matches
     * the supplied id but does not exist in the supplied type/collection, it will not be returned. If no
     * type/collection is supplied the action will occur across the entire index.
     * @param userToken Users security token with user information used for auditing and verifying the user has access
     * to the requested data.
     * @return List of retrieved documents with the given IDs and type
     * @throws TException
     */
    List<Document> get(Set<String> ids, String type, EzSecurityToken userToken) throws TException;

    /**
     * Retrieves a subset of fields for a document in the repository using the id and if supplied, index/database and
     * type/collection.
     *
     * @param id Unique id of the document within the document store. If an index and/or type are supplied those will be
     * used to limit the scope of results. If they are not supplied, the first object with a matching id will be
     * returned.
     * @param type Used to limit the scope when searching for the document with the supplied id. If a document matches
     * the supplied id but does not exist in the supplied type/collection, it will not be returned. If no
     * type/collection is supplied the action will occur across the entire index.
     * @param fields The subset of fields with the document that should be returned. If the fields are indexed properly
     * this can be faster than retrieving an entire document.
     * @param userToken Users security token with user information used for auditing and verifying the user has access
     * to the requested data.
     * @return Retrieved document with the specified ID and type
     * @throws TException
     */
    Document get(String id, String type, Set<String> fields, EzSecurityToken userToken) throws TException;

    /**
     * Retrieves a paged and sorted (optional) collection of documents and the related facets (optional) based on the
     * supplied query and criteria.
     *
     * @param query Either a lucene string based query or a json query representation specific to the DocumentStore
     * implementation.
     * @param type Used to limit the scope when searching for the document with the supplied id. If a document matches
     * the supplied id but does not exist in the supplied type/collection, it will not be returned. If no
     * type/collection is supplied the action will occur across the entire index.
     * @param sortCriteria Sorting criteria to apply to the result set, the implementation's default sort will be used.
     * @param fields The subset of fields with the document that should be returned. If the fields are indexed properly
     * this can be faster than retrieving an entire document.
     * @param facets List of facets to retrieve along with the results.
     * @param offset Result offset to start at (not a page number but an actual offset).
     * @param pageSize Size of result set to return.
     * @param userToken Users security token with user information used for auditing and verifying the user has access
     * to the requested data.
     * @return Results of search
     * @throws MalformedQueryException
     * @throws TException
     */
    SearchResult get(
            String query, String type, List<SortCriteria> sortCriteria, Set<String> fields, List<Facet> facets,
            String facetsJson, int offset, short pageSize, HighlightRequest highlight, EzSecurityToken userToken)
            throws TException;

    /**
     * Deletes records that match the supplied ids and type. If not type is supplied all records with a matching id to
     * which the user has access will be removed.
     *
     * @param ids Set of ids matching the documents to remove.
     * @param type Used to limit the scope when searching for the document with the supplied id. If a document matches
     * the supplied id but does not exist in the supplied type/collection, it will not be returned. If no
     * type/collection is supplied the action will occur across the entire index.
     * @param userToken Users security token with user information used for auditing and verifying the user has access
     * to the requested data.
     * @throws TException
     */
    void delete(Set<String> ids, String type, EzSecurityToken userToken) throws TException;

    /**
     * Deletes all objects matching the given query and type from the index given the user has the proper
     * authorizations.
     *
     * @param query Either a lucene string based query or a json query representation specific to the DocumentStore
     * implementation.
     * @param type Used to limit the scope when searching for the document with the supplied id. If a document matches
     * the supplied id but does not exist in the supplied type/collection, it will not be returned. If no
     * type/collection is supplied the action will occur across the entire index.
     * @param userToken Users security token with user information used for auditing and verifying the user has access
     * to the requested data.
     * @throws TException
     */
    void delete(String query, String type, EzSecurityToken userToken) throws TException;

    /**
     * Returns a count of the matches across the supplied types based on the query. If no query is provided, the count
     * will be a total of all records within the supplied index/type constraints. If a set of filterIds is provided, the
     * results will be filtered based on the supplied id set.
     *
     * @param types Set of types to restrict the query with.
     * @param query Either a lucene string based query or a json query representation specific to the DocumentStore
     * implementation.
     * @param filterIds Set of ids to restrict the query with.
     * @param userToken Users security token with user information used for auditing and verifying the user has access
     * to the requested data.
     * @return The number of documents matching the count criteria
     * @throws TException
     */
    long count(Set<String> types, String query, Set<String> filterIds, EzSecurityToken userToken) throws TException;

    List<PercolateQuery> percolate(List<Document> docs);

    /**
     * Used to modify the mapping of a specific object type within the backend document store. The mapping json should
     * be something that can be used by the backing store or parsed and handled by the implementation of {@link
     * DocumentStore}
     *
     * @param type The type to create/modify the mapping for
     * @param mappingJson The settings to be applied
     */
    void setTypeMapping(String type, String mappingJson);

    /**
     * Used to modify the indexing settings of the backend document store. The settings json should be something that
     * can be used by the backing store or parsed and handled by the implementation of .
     *
     * @param settingsJson The settings to be applied
     */
    void applySettings(String settingsJson);

    /**
     * Performs status check on the document backend.
     *
     * @return true if the backend is operational else false
     */
    boolean ping();

    /**
     * Opens the index if it is closed.
     */
    void openIndex();

    /**
     * Closes the index if it is open.
     */
    void closeIndex();

    /**
     * Immediately refreshes the index for the current application. This will cause all pending data to be indexed
     * before returning to the caller.
     */
    void forceIndexRefresh();

    /**
     * Purge endpoint for central purge.
     */
    PurgeResult purge(long id, Set<Long> toPurge, int batchSize);

    /**
     * Cancel an ongoing purge.
     *
     * @param purgeId ID of purge to cancel
     * @return Status of cancellation
     */
    CancelStatus cancelPurge(long purgeId);
}
