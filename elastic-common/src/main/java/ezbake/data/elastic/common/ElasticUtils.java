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

package ezbake.data.elastic.common;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.thrift.TException;
import org.elasticsearch.action.admin.cluster.health.ClusterHealthStatus;
import org.elasticsearch.action.admin.indices.refresh.RefreshRequest;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.unit.DistanceUnit;
import org.elasticsearch.index.query.FilterBuilder;
import org.elasticsearch.index.query.FilterBuilders;
import org.elasticsearch.index.query.IdsQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.ScriptFilterBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.GeoDistanceSortBuilder;
import org.elasticsearch.search.sort.SortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;

import com.google.common.collect.ImmutableSet;

import ezbake.base.thrift.EzSecurityToken;
import ezbake.data.elastic.thrift.Facet;
import ezbake.data.elastic.thrift.FacetRequest;
import ezbake.data.elastic.thrift.FacetResult;
import ezbake.data.elastic.thrift.FieldSort;
import ezbake.data.elastic.thrift.GeoDistanceSort;
import ezbake.data.elastic.thrift.GeoSortValue;
import ezbake.data.elastic.thrift.MissingOrder;
import ezbake.data.elastic.thrift.MissingSort;
import ezbake.thrift.ThriftUtils;

public final class ElasticUtils {
    /**
     * This is defined by ES 1.2.1 as a reserved type for all percolator entries
     */
    public static final String PERCOLATOR_TYPE = ".percolator";

    private ElasticUtils() {
    }

    public static SortBuilder convertFieldSort(FieldSort fieldSort) {
        final FieldSortBuilder fs = SortBuilders.fieldSort(fieldSort.getField());

        // Sort Order
        switch (fieldSort.getOrder()) {
            case ASCENDING:
                fs.order(SortOrder.ASC);
                break;
            case DESCENDING:
                fs.order(SortOrder.DESC);
                break;
        }

        // Sort Mode
        if (fieldSort.isSetMode()) {
            switch (fieldSort.getMode()) {
                case SUM:
                    fs.sortMode("sum");
                    break;
                case AVG:
                    fs.sortMode("avg");
                    break;
                case MAX:
                    fs.sortMode("max");
                    break;
                case MIN:
                    fs.sortMode("min");
                    break;
                default:
                    throw new IllegalArgumentException("Field sort has unknown mode " + fieldSort.getMode());
            }
        }

        // Ignore Unmapped?
        if (fieldSort.isSetIgnoreUnmapped()) {
            fs.ignoreUnmapped(fieldSort.ignoreUnmapped);
        }

        // How to handle missing values
        if (fieldSort.isSetMissing()) {
            final MissingSort missing = fieldSort.getMissing();
            if (missing.isSet(MissingSort._Fields.BASIC)) {
                if (missing.getBasic() == MissingOrder.FIRST) {
                    fs.missing("_first");
                } else {
                    fs.missing("_last");
                }
            } else {
                fs.missing(missing.getCustom());
            }
        }

        return fs;
    }

    public static SortBuilder convertGeoSort(GeoDistanceSort geoDistanceSort) {
        final GeoDistanceSortBuilder gs = SortBuilders.geoDistanceSort(geoDistanceSort.getField());

        // Sort Order
        switch (geoDistanceSort.getOrder()) {
            case ASCENDING:
                gs.order(SortOrder.ASC);
                break;
            case DESCENDING:
                gs.order(SortOrder.DESC);
                break;
        }

        // Unit
        gs.unit(DistanceUnit.valueOf(geoDistanceSort.getUnit().toString()));

        // Value
        final GeoSortValue geoVal = geoDistanceSort.getValue();
        if (geoVal.isSet(GeoSortValue._Fields.GEO_HASH)) {
            gs.geohash(geoVal.getGeoHash());
        } else {
            gs.point(geoVal.getCoordinate().getLatitude(), geoVal.getCoordinate().getLongitude());
        }

        // Sort Mode
        if (geoDistanceSort.isSetMode()) {
            switch (geoDistanceSort.getMode()) {
                case AVG:
                    gs.sortMode("avg");
                    break;
                case MAX:
                    gs.sortMode("max");
                    break;
                case MIN:
                    gs.sortMode("min");
                    break;
                case SUM:
                    throw new IllegalArgumentException("Geo distance sort does not support SUM as a mode");
                default:
                    throw new IllegalArgumentException(
                            "Geo distance sort has unknown mode " + geoDistanceSort.getMode());
            }
        }

        return gs;
    }

    public static Map<String, FacetRequest._Fields> addFacetsToSearch(
            List<Facet> facets, SearchRequestBuilder builder, FilterBuilder filter) {
        return ThriftToFacetConversions.addFacetsToSearch(facets, builder, filter);
    }

    public static Map<String, FacetResult> getFacetsFromResult(
            Map<String, FacetRequest._Fields> facetMap,
            Map<String, org.elasticsearch.search.facet.Facet> elasticFacets) {
        return FacetResultsToThriftConversions.getFacetsFromResult(facetMap, elasticFacets);
    }

    public static ScriptFilterBuilder getVisibilityFilter(
            EzSecurityToken userToken, VisibilityFilterConfig filterConfig) throws TException {
        final ScriptFilterBuilder visibilityFilter = FilterBuilders.scriptFilter("visibility").lang("native");
        visibilityFilter.addParam("auths", ThriftUtils.serializeToBase64(userToken.getAuthorizations()));
        visibilityFilter.addParam("visibilityField", filterConfig.getVisibilityField());
        visibilityFilter.addParam("requiredPermissions", filterConfig.getRequiredPermsString());

        return visibilityFilter;
    }

    public static void refreshIndex(Client client, String indexName) {
        client.admin().indices().refresh(new RefreshRequest(indexName)).actionGet();
    }

    public static boolean isClusterHealthy(Client client) {
        final ClusterHealthStatus status = client.admin().cluster().prepareHealth().get().getStatus();
        return status == ClusterHealthStatus.YELLOW || status == ClusterHealthStatus.GREEN;
    }

    public static SearchResponse getById(
            Client client, String index, String type, String id, EzSecurityToken token,
            VisibilityFilterConfig filterConfig) throws TException {
        return getByIds(client, index, type, ImmutableSet.of(id), token, filterConfig);
    }

    public static SearchResponse getByIds(
            Client client, String index, String type, Set<String> ids, EzSecurityToken token,
            VisibilityFilterConfig filterConfig) throws TException {
        final SearchRequestBuilder request = createIdSearch(client, index, type, ids, token, filterConfig);
        return request.get();
    }

    public static void deleteById(
            Client client, String index, String type, String id, EzSecurityToken token,
            VisibilityFilterConfig filterConfig) throws TException {
        deleteByIds(client, index, type, ImmutableSet.of(id), token, filterConfig);
    }

    public static void deleteByIds(
            Client client, String index, String type, Set<String> ids, EzSecurityToken token,
            VisibilityFilterConfig filterConfig) throws TException {
        final SearchRequestBuilder idRequest = createIdSearch(client, index, type, ids, token, filterConfig);
        idRequest.setNoFields();

        final SearchResponse idResponse = idRequest.get();
        final IdsQueryBuilder deleteQuery = QueryBuilders.idsQuery(type);
        for (final SearchHit hit : idResponse.getHits().getHits()) {
            deleteQuery.addIds(hit.getId());
        }

        client.prepareDeleteByQuery(index).setQuery(deleteQuery).get();
        refreshIndex(client, index);
    }

    private static SearchRequestBuilder createIdSearch(
            Client client, String index, String type, Set<String> ids, EzSecurityToken token,
            VisibilityFilterConfig filterConfig) throws TException {
        final QueryBuilder idQuery = QueryBuilders.idsQuery(type).addIds(ids.toArray(new String[ids.size()]));
        final FilterBuilder visibilityFilter = getVisibilityFilter(token, filterConfig);

        return client.prepareSearch(index).setQuery(idQuery).setPostFilter(visibilityFilter).setSize(ids.size());
    }
}
