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

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.unit.DistanceUnit;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.index.query.FilterBuilder;
import org.elasticsearch.index.query.FilterBuilders;
import org.elasticsearch.index.query.FilteredQueryBuilder;
import org.elasticsearch.index.query.GeoDistanceFilterBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.github.tlrx.elasticsearch.test.EsSetup;
import com.google.common.collect.ImmutableSet;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import ezbake.base.thrift.EzSecurityToken;
import ezbake.base.thrift.Visibility;
import ezbake.configuration.ClasspathConfigurationLoader;
import ezbake.configuration.EzConfiguration;
import ezbake.configuration.constants.EzBakePropertyConstants;
import ezbake.data.elastic.test.TestUtils;
import ezbake.data.elastic.test.models.Location;
import ezbake.data.elastic.test.models.PlaceOfInterest;
import ezbake.data.elastic.thrift.Document;
import ezbake.data.elastic.thrift.EzElastic;
import ezbake.data.elastic.thrift.Facet;
import ezbake.data.elastic.thrift.FacetRequest;
import ezbake.data.elastic.thrift.FacetResult;
import ezbake.data.elastic.thrift.IndexResponse;
import ezbake.data.elastic.thrift.Page;
import ezbake.data.elastic.thrift.PercolateQuery;
import ezbake.data.elastic.thrift.PercolateRequest;
import ezbake.data.elastic.thrift.Query;
import ezbake.data.elastic.thrift.RangeFacetEntry;
import ezbake.data.elastic.thrift.ScriptParam;
import ezbake.data.elastic.thrift.SearchResult;
import ezbake.data.elastic.thrift.TermsFacetEntry;
import ezbake.data.elastic.thrift.TermsScriptFacet;
import ezbake.data.elastic.thrift.TermsStatsFacet;
import ezbake.data.elastic.thrift.TermsStatsFacetResultEntry;
import ezbake.data.elastic.thrift.TermsStatsValue;
import ezbake.data.elastic.thrift.ValueScript;
import ezbake.thrift.ThriftClientPool;
import ezbake.thrift.ThriftServerPool;
import ezbake.thrift.ThriftTestUtils;

import ezbakehelpers.ezconfigurationhelpers.application.EzBakeApplicationConfigurationHelper;
import ezbakehelpers.ezconfigurationhelpers.elasticsearch.ElasticsearchConfigurationHelper;

@SuppressWarnings("StaticNonFinalField")
public final class IT_EzElasticIntegrationTest {
    private static final String TEST_TYPE = "sample";
    private static final String SERVICE_NAME = "EzElastic";
    private static final String MOCK_SECURITY_ID = "mockSecurityId";
    private static final int PORT_NUMBER = 23471;

    private static String applicationName;
    private static Properties configuration;
    private static Gson gson;
    private static EsSetup esSetup;
    private static EzSecurityToken fakeSecurity;

    private ThriftClientPool pool;
    private ThriftServerPool servers;
    private Document washingtonMonumentDoc;
    private Document whiteHouseDoc;
    private Document oneaaColumbiaDoc;
    private Document oneaaNavyYardDoc;
    private PlaceOfInterest whiteHouse;
    private PlaceOfInterest oneaaColumbia;
    private PlaceOfInterest oneaaNavyYard;
    private EzElastic.Client client;

    @BeforeClass
    public static void setUpClass() throws Exception {
        gson = new GsonBuilder().setDateFormat("ddHHmm'Z' MMM yy").create();
        configuration = new EzConfiguration(new ClasspathConfigurationLoader()).getProperties();

        final EzBakeApplicationConfigurationHelper appConfig = new EzBakeApplicationConfigurationHelper(configuration);

        final String securityId = appConfig.getSecurityID();
        fakeSecurity =
                ThriftTestUtils.generateTestSecurityToken(securityId, securityId, Collections.singletonList("U"));
        applicationName = appConfig.getApplicationName();
        configuration.setProperty(EzBakePropertyConstants.ELASTICSEARCH_CLUSTER_NAME, "elasticsearch");
        final ElasticsearchConfigurationHelper helper = new ElasticsearchConfigurationHelper(configuration);

        final Settings settings = ImmutableSettings.settingsBuilder()
                .put("script.native.visibility.type", "ezbake.data.elastic.security.EzSecurityScriptFactory")
                .put("cluster.name", helper.getElasticsearchClusterName()).put("script.disable_dynamic", false)
                .put("network.host", helper.getElasticsearchHost())
                .put("transport.tcp.port", helper.getElasticsearchPort()).put("node.local", false).build();

        esSetup = new EsSetup(settings);
        esSetup.execute(EsSetup.deleteAll());

        if (esSetup.client() == null) {
            throw new Exception("Could not start EsSetup node!");
        }
    }

    private static String getMappingForTest() throws IOException {
        final XContentBuilder mapping = jsonBuilder();
        mapping.startObject();
        mapping.startObject(TEST_TYPE);
        mapping.startObject("properties");

        mapping.startObject("title");
        mapping.field("type", "string");
        mapping.field("stored", "yes");
        mapping.endObject();

        mapping.startObject("comments");
        mapping.field("type", "string");
        mapping.endObject();

        mapping.startObject("location");
        mapping.field("type", "geo_point");
        mapping.endObject();

        mapping.startObject("rating");
        mapping.field("type", "integer");
        mapping.field("stored", "yes");
        mapping.endObject();

        mapping.startObject("visit");
        mapping.field("type", "date");
        mapping.field("format", "ddHHmm'Z' MMM yy");
        mapping.field("stored", "yes");
        mapping.endObject();

        mapping.endObject();
        mapping.endObject();
        mapping.endObject();

        return mapping.string();
    }

    private static void deleteIndex(String name) {
        if (esSetup.exists(name)) {
            esSetup.execute(EsSetup.deleteIndex(name));
        }
    }

    private static void createIndexProbably(String name) {
        if (!esSetup.exists(name)) {
            esSetup.execute(EsSetup.createIndex(name));
        }
    }

    @Before
    public void setUp() throws Exception {
        // Start up thrift server
        servers = new ThriftServerPool(configuration, PORT_NUMBER);
        // Now start the service supplying the service implementation and the service name
        servers.startApplicationService(new EzElasticHandler(), SERVICE_NAME, applicationName, MOCK_SECURITY_ID);

        // Still create our client pool like we would for real
        pool = new ThriftClientPool(configuration);

        deleteIndex(applicationName);
        loadSamples();
    }

    @After
    public void tearDown() throws Exception {
        servers.shutdown();
        pool.clearPool();
        pool.close();
    }

    @Test
    public void testPut() throws Exception {
        // Prepare: Setup Thrift Client
        client = pool.getClient(SERVICE_NAME, EzElastic.Client.class);

        // Action: Index single document
        final IndexResponse response = client.put(whiteHouseDoc, fakeSecurity);

        // Assert: IndexResponse values should match initial supplied values
        assertEquals(whiteHouseDoc.get_id(), response.get_id());
        assertEquals(1, response.get_version());
        assertEquals(TEST_TYPE, response.get_type());

        pool.returnToPool(client);
    }

    @Test
    public void testGet() throws Exception {
        // Prepare: Setup Thrift Client and add some docs
        client = pool.getClient(SERVICE_NAME, EzElastic.Client.class);
        client.bulkPut(
                Arrays.asList(washingtonMonumentDoc, whiteHouseDoc, oneaaColumbiaDoc, oneaaNavyYardDoc), fakeSecurity);

        // Action: Retrieve single document by id
        final Document result = client.get(whiteHouseDoc.get_id(), fakeSecurity);

        // Assert: Document contents should match the expected contents
        final PlaceOfInterest fromDataset = gson.fromJson(result.get_jsonObject(), PlaceOfInterest.class);
        assertEquals(whiteHouse.getTitle(), fromDataset.getTitle());
        assertEquals(whiteHouse.getComments(), fromDataset.getComments());
        assertEquals(whiteHouse.getRating(), fromDataset.getRating());
        assertEquals(whiteHouseDoc.get_id(), result.get_id());

        pool.returnToPool(client);
    }

    @Test
    public void testBulkGet() throws Exception {
        // Prepare: Setup Thrift Client and add some docs
        client = pool.getClient(SERVICE_NAME, EzElastic.Client.class);
        final List<Document> twentyDocs = new ArrayList<>();
        final Set<String> ids = new HashSet<>();
        for (int i = 0; i < 20; i++) {
            final Document doc = TestUtils.generateDocument("BulkDoc", "{}");
            doc.set_id(Integer.toString(i));
            ids.add(Integer.toString(i));
            twentyDocs.add(doc);
        }
        client.bulkPut(twentyDocs, fakeSecurity);

        final List<Document> results = client.bulkGetWithType(ids, "BulkDoc", fakeSecurity);

        // Assert: We should see all the ids come back exactly once
        for (final Document doc : results) {
            assertTrue(ids.contains(doc.get_id()));
            ids.remove(doc.get_id());
        }
        pool.returnToPool(client);
    }

    @Test
    public void testGetNonExistantId() throws Exception {
        // Prepare: Setup Thrift Client and add some docs
        client = pool.getClient(SERVICE_NAME, EzElastic.Client.class);
        client.bulkPut(
                Arrays.asList(washingtonMonumentDoc, whiteHouseDoc, oneaaColumbiaDoc, oneaaNavyYardDoc), fakeSecurity);

        // Action: Retrieve single document by id with a non-existent id
        final Document result = client.get(UUID.randomUUID().toString(), fakeSecurity);

        // Assert: Document should be empty as it doesn't exist
        assertEquals(StringUtils.EMPTY, result.get_type());
        assertEquals(StringUtils.EMPTY, result.get_jsonObject());
        assertNull(result.getVisibility().getFormalVisibility());

        pool.returnToPool(client);
    }

    @Test
    public void testGetWithType() throws Exception {
        // Prepare: Setup Thrift Client and add some docs
        client = pool.getClient(SERVICE_NAME, EzElastic.Client.class);
        client.bulkPut(
                Arrays.asList(washingtonMonumentDoc, whiteHouseDoc, oneaaColumbiaDoc, oneaaNavyYardDoc), fakeSecurity);

        // Action: Retrieve single document by id
        final Document result = client.getWithType(oneaaColumbiaDoc.get_id(), TEST_TYPE, fakeSecurity);

        // Assert: Document contents should match the expected contents
        final PlaceOfInterest fromDataset = gson.fromJson(result.get_jsonObject(), PlaceOfInterest.class);
        assertEquals(oneaaColumbia.getTitle(), fromDataset.getTitle());
        assertEquals(oneaaColumbia.getComments(), fromDataset.getComments());
        assertEquals(oneaaColumbia.getRating(), fromDataset.getRating());
        assertEquals(oneaaColumbiaDoc.get_id(), result.get_id());

        pool.returnToPool(client);
    }

    @Test
    public void testGetWithInvalidType() throws Exception {
        // Prepare: Setup Thrift Client and add some docs
        client = pool.getClient(SERVICE_NAME, EzElastic.Client.class);
        client.bulkPut(
                Arrays.asList(washingtonMonumentDoc, whiteHouseDoc, oneaaColumbiaDoc, oneaaNavyYardDoc), fakeSecurity);

        // Action: Retrieve single document by id
        final Document result = client.getWithType(oneaaNavyYardDoc.get_id(), "fake_type", fakeSecurity);

        // Assert: Document should be empty since it doesn't exist
        assertEquals(StringUtils.EMPTY, result.get_type());
        assertEquals(StringUtils.EMPTY, result.get_jsonObject());
        assertNull(result.getVisibility().getFormalVisibility());

        pool.returnToPool(client);
    }

    @Test
    public void testGetWithFields() throws Exception {
        // Prepare: Setup Thrift Client and add some docs
        client = pool.getClient(SERVICE_NAME, EzElastic.Client.class);
        client.bulkPut(
                Arrays.asList(washingtonMonumentDoc, whiteHouseDoc, oneaaColumbiaDoc, oneaaNavyYardDoc), fakeSecurity);

        // Action: Retrieve rating, visit, and title from single document by id
        final Document result = client.getWithFields(
                oneaaColumbiaDoc.get_id(), TEST_TYPE, ImmutableSet.of("title", "rating"), fakeSecurity);

        final Map<String, Object> resultMap = TestUtils.jsonToMap(result.get_jsonObject());

        // Assert: Document contents should match the expected contents
        assertEquals(2, resultMap.size());
        assertTrue(resultMap.containsKey("title"));
        assertTrue(resultMap.containsKey("rating"));
        assertEquals(oneaaColumbia.getTitle(), resultMap.get("title"));
        assertEquals(oneaaColumbia.getRating(), Integer.parseInt(resultMap.get("rating").toString()));

        pool.returnToPool(client);
    }

    @Test
    public void testQuery() throws Exception {
        // Prepare: Setup Thrift Client and add some docs
        client = pool.getClient(SERVICE_NAME, EzElastic.Client.class);
        client.bulkPut(
                Arrays.asList(washingtonMonumentDoc, whiteHouseDoc, oneaaColumbiaDoc, oneaaNavyYardDoc), fakeSecurity);

        // Action: Create and execute range query on rating
        final String elasticQuery = QueryBuilders.rangeQuery("rating").gt(20).lte(100).toString();
        final SearchResult results = client.query(new Query(elasticQuery), fakeSecurity);

        // Assert: There should be 3 matching documents
        final List<String> expectedIds =
                Arrays.asList(oneaaColumbiaDoc.get_id(), whiteHouseDoc.get_id(), washingtonMonumentDoc.get_id());
        assertEquals(expectedIds.size(), results.getTotalHits());
        for (final Document result : results.getMatchingDocuments()) {
            assertTrue(expectedIds.contains(result.get_id()));
        }

        pool.returnToPool(client);
    }

    @Test
    public void testQueryWithIndex() throws Exception {
        // Prepare: Setup Thrift Client and add some docs
        client = pool.getClient(SERVICE_NAME, EzElastic.Client.class);
        client.bulkPut(
                Arrays.asList(washingtonMonumentDoc, whiteHouseDoc, oneaaColumbiaDoc, oneaaNavyYardDoc), fakeSecurity);

        // Action: Create and execute an AND match query on title
        final String elasticQuery =
                QueryBuilders.matchQuery("title", "42Six HQ").operator(MatchQueryBuilder.Operator.AND).toString();
        final SearchResult results = client.query(new Query(elasticQuery), fakeSecurity);

        // Assert: There should be a single matching document due to the AND operator
        assertEquals(1, results.getTotalHits());
        assertEquals(oneaaColumbiaDoc.get_id(), results.getMatchingDocuments().get(0).get_id());

        pool.returnToPool(client);
    }

    @Test
    public void testQueryWithType() throws Exception {
        // Prepare: Setup Thrift Client and add some docs
        client = pool.getClient(SERVICE_NAME, EzElastic.Client.class);
        client.bulkPut(
                Arrays.asList(washingtonMonumentDoc, whiteHouseDoc, oneaaColumbiaDoc, oneaaNavyYardDoc), fakeSecurity);

        // Action: Create and execute an OR match query on title
        final Query query = new Query(QueryBuilders.matchQuery("title", "42Six HQ").toString());
        query.setType(TEST_TYPE);
        final SearchResult results = client.query(query, fakeSecurity);

        // Assert: There should be 2 matching documents
        final List<String> expectedIds = Arrays.asList(oneaaColumbiaDoc.get_id(), oneaaNavyYardDoc.get_id());
        assertEquals(expectedIds.size(), results.getTotalHits());
        for (final Document result : results.getMatchingDocuments()) {
            assertTrue(expectedIds.contains(result.get_id()));
        }

        pool.returnToPool(client);
    }

    @Test
    public void testDeleteById() throws Exception {
        // Prepare: Setup Thrift Client and add some docs
        client = pool.getClient(SERVICE_NAME, EzElastic.Client.class);
        client.put(whiteHouseDoc, fakeSecurity);

        // Action: Delete by id and then try to retrieve document
        client.deleteById(whiteHouseDoc.get_id(), fakeSecurity);
        final Document result = client.get(whiteHouseDoc.get_id(), fakeSecurity);

        // Assert: Document should be empty since it doesn't exist
        assertEquals(StringUtils.EMPTY, result.get_type());
        assertEquals(StringUtils.EMPTY, result.get_jsonObject());
        assertNull(result.getVisibility().getFormalVisibility());

        pool.returnToPool(client);
    }

    @Test
    public void testCountByType() throws Exception {
        // Prepare: Setup Thrift Client and add some docs
        client = pool.getClient(SERVICE_NAME, EzElastic.Client.class);
        client.bulkPut(
                Arrays.asList(washingtonMonumentDoc, whiteHouseDoc, oneaaColumbiaDoc, oneaaNavyYardDoc), fakeSecurity);

        // Action: Create and execute an OR match query on title
        final long result = client.countByType(ImmutableSet.of(TEST_TYPE), fakeSecurity);

        // Assert: There should be 2 matching documents
        assertEquals(4, result);

        pool.returnToPool(client);
    }

    @Test
    public void testRangeDateFacets() throws Exception {
        // Prepare: Setup Thrift Client and add some docs
        final SimpleDateFormat dtg = new SimpleDateFormat("ddHHmm'Z' MMM yy");
        client = pool.getClient(SERVICE_NAME, EzElastic.Client.class);
        client.setTypeMapping(TEST_TYPE, getMappingForTest(), fakeSecurity);
        client.bulkPut(
                Arrays.asList(washingtonMonumentDoc, whiteHouseDoc, oneaaColumbiaDoc, oneaaNavyYardDoc), fakeSecurity);

        // Action: Create and execute a match all query with date bucket facets
        final Query query = new Query(QueryBuilders.matchAllQuery().toString());
        query.setType(TEST_TYPE).setFacets(Collections.singletonList(TestUtils.generateDateBucketFacet()))
                .setPage(new Page(0, (short) 10));
        final SearchResult results = client.query(query, fakeSecurity);

        // Assert: All records should be a match and the facet buckets should be organized as expected
        assertEquals(4, results.getTotalHits());
        assertFalse(results.getFacets().isEmpty());
        assertTrue(results.getFacets().containsKey("Report Date"));
        final FacetResult facetResult = results.getFacets().get("Report Date");
        for (final RangeFacetEntry entry : facetResult.getRangeFacetResult().getEntries()) {
            if (dtg.parse(entry.getFrom()).getTime() >= TestUtils.last24time
                    || dtg.parse(entry.getFrom()).getTime() >= TestUtils.last48time
                    || dtg.parse(entry.getFrom()).getTime() >= TestUtils.last72time) {
                assertEquals(3, entry.getCount());
            } else {
                assertEquals(4, entry.getCount());
            }
        }

        pool.returnToPool(client);
    }

    @Test(timeout = 60000)
    public void testNonExistantIndexQuery() throws Exception {
        deleteIndex(applicationName);
        if (esSetup.exists(applicationName)) {
            fail();
        }

        client = pool.getClient(SERVICE_NAME, EzElastic.Client.class);
        final Query query = new Query(QueryBuilders.matchAllQuery().toString()).setType(TEST_TYPE);
        final SearchResult results = client.query(query, fakeSecurity);

        assertEquals(0, results.getMatchingDocuments().size());
        assertEquals(QueryBuilders.matchAllQuery().toString(), results.actualQuery);
        pool.returnToPool(client);
    }

    @Test
    public void testExistingIndex() throws Exception {
        createIndexProbably(applicationName);

        // This will attempt to create an index testapp_v1 and alias it to testapp; this should not
        // throw an exception if there is already an index called testapp (and will not create the alias).
        final EzElasticHandler handler = new EzElasticHandler();
        handler.setConfigurationProperties(configuration);
        handler.init();

        assertFalse(esSetup.exists(String.format("%s_v1", applicationName)));
        assertTrue(esSetup.exists(applicationName));
    }

    @Test
    public void testQueryWithFilter() throws Exception {
        // Prepare: Setup Thrift Client and add some docs
        client = pool.getClient(SERVICE_NAME, EzElastic.Client.class);
        client.setTypeMapping(TEST_TYPE, getMappingForTest(), fakeSecurity);
        client.bulkPut(
                Arrays.asList(washingtonMonumentDoc, whiteHouseDoc, oneaaColumbiaDoc, oneaaNavyYardDoc), fakeSecurity);
        final String filter = FilterBuilders.andFilter(
                FilterBuilders.rangeFilter("rating").from(0).to(100), FilterBuilders.termFilter("title", "42six"))
                .toString();

        // Action: Create and execute a match all query with date bucket facets
        final Query query =
                new Query(QueryBuilders.matchAllQuery().toString()).setType(TEST_TYPE).setFilterJson(filter);
        final SearchResult results = client.query(query, fakeSecurity);

        // Assert: All records should be a match and the facet buckets should be organized as expected
        final List<String> expectedIds = Arrays.asList(oneaaColumbiaDoc.get_id(), oneaaNavyYardDoc.get_id());
        assertEquals(expectedIds.size(), results.getTotalHits());
        for (final Document result : results.getMatchingDocuments()) {
            assertTrue(expectedIds.contains(result.get_id()));
        }

        pool.returnToPool(client);
    }

    @Test
    public void testQueryWithElasticJsonAndFilter() throws Exception {
        // Prepare: Setup Thrift Client and add some docs
        client = pool.getClient(SERVICE_NAME, EzElastic.Client.class);
        client.setTypeMapping(TEST_TYPE, getMappingForTest(), fakeSecurity);
        client.bulkPut(
                Arrays.asList(washingtonMonumentDoc, whiteHouseDoc, oneaaColumbiaDoc, oneaaNavyYardDoc), fakeSecurity);
        final String filter = FilterBuilders.andFilter(
                FilterBuilders.rangeFilter("rating").from(0).to(100), FilterBuilders.termFilter("title", "42six"))
                .toString();
        final String queryJson = QueryBuilders.boolQuery().must(
                QueryBuilders.rangeQuery("rating").from(35).to(98).includeLower(true).includeLower(true))
                .must(QueryBuilders.matchQuery("comments", "42six")).mustNot(QueryBuilders.prefixQuery("title", "W"))
                .toString();

        // Action: Create and execute a match all query with date bucket facets
        final Query query =
                new Query(queryJson).setType(TEST_TYPE).setPage(new Page(0, (short) 10)).setFilterJson(filter);
        final SearchResult results = client.query(query, fakeSecurity);

        // Assert: All records should be a match and the facet buckets should be organized as expected
        final List<String> expectedIds = Collections.singletonList(oneaaColumbiaDoc.get_id());
        assertEquals(expectedIds.size(), results.getTotalHits());
        for (final Document result : results.getMatchingDocuments()) {
            assertTrue(expectedIds.contains(result.get_id()));
        }

        pool.returnToPool(client);
    }

    @Test
    public void testTermScript() throws Exception {
        // Prepare: Setup Thrift Client and add some docs
        client = pool.getClient(SERVICE_NAME, EzElastic.Client.class);
        client.setTypeMapping(TEST_TYPE, getMappingForTest(), fakeSecurity);
        client.bulkPut(
                Arrays.asList(washingtonMonumentDoc, whiteHouseDoc, oneaaColumbiaDoc, oneaaNavyYardDoc), fakeSecurity);

        final TermsScriptFacet tsf = new TermsScriptFacet();
        tsf.setFields(Collections.singletonList("title"));
        tsf.setScript(new ValueScript("term == '42six' ? 'Company' : 'Location'", new ArrayList<ScriptParam>()));
        final FacetRequest request = new FacetRequest();
        request.setTermsScriptFacet(tsf);
        final Facet facet = new Facet();
        facet.setLabel("magic");
        facet.setFacet(request);

        // Action: Create and execute a match all query with date bucket facets
        final Query query = new Query(QueryBuilders.matchAllQuery().toString()).setType(TEST_TYPE).setFacets(
                Collections.singletonList(facet)).setPage(new Page(0, (short) 10));
        final SearchResult results = client.query(query, fakeSecurity);

        // Assertion
        assertEquals(4, results.getTotalHits());
        int locationCount = 0;
        int companyCount = 0;

        for (final Document result : results.getMatchingDocuments()) {
            final PlaceOfInterest fromJson = gson.fromJson(result.get_jsonObject(), PlaceOfInterest.class);
            for (final String val : fromJson.getTitle().split(" ")) {
                if ("42six".equalsIgnoreCase(val)) {
                    companyCount++;
                } else {
                    locationCount++;
                }
            }
        }

        for (final TermsFacetEntry facetResult : results.getFacets().get("magic").getTermsFacetResult().getEntries()) {
            if ("Company".equalsIgnoreCase(facetResult.getTerm())) {
                assertEquals(companyCount, facetResult.getCount());
            } else {
                assertEquals(locationCount, facetResult.getCount());
            }
        }

        pool.returnToPool(client);
    }

    @Test
    public void testTermsStatsStringFacet() throws Exception {
        // Prepare: Setup Thrift Client and add some docs
        client = pool.getClient(SERVICE_NAME, EzElastic.Client.class);
        client.setTypeMapping(TEST_TYPE, getMappingForTest(), fakeSecurity);
        client.bulkPut(
                Arrays.asList(washingtonMonumentDoc, whiteHouseDoc, oneaaColumbiaDoc, oneaaNavyYardDoc), fakeSecurity);

        final TermsStatsValue val = new TermsStatsValue();
        val.setValueField("rating");
        final TermsStatsFacet tsf = new TermsStatsFacet();
        tsf.setKeyField("title");
        tsf.setValueField(val);
        final FacetRequest request = new FacetRequest();
        request.setTermsStatsFacet(tsf);
        final Facet facet = new Facet();
        facet.setLabel("magic");
        facet.setFacet(request);

        final Query query = new Query(QueryBuilders.matchAllQuery().toString()).setType(TEST_TYPE).setFacets(
                Collections.singletonList(facet)).setPage(new Page(0, (short) 10));
        final SearchResult results = client.query(query, fakeSecurity);

        // Assertion
        assertEquals(4, results.getTotalHits());
        for (final TermsStatsFacetResultEntry facetResult : results.getFacets().get("magic").getTermsStatsFacetResult()
                .getEntries()) {
            assertNotEquals(facetResult.getTerm(), Integer.toString((int) facetResult.getTermAsNumber()));
        }

        pool.returnToPool(client);
    }

    @Test
    public void testTermsStatsDoubleFacet() throws Exception {
        // Prepare: Setup Thrift Client and add some docs
        client = pool.getClient(SERVICE_NAME, EzElastic.Client.class);
        client.setTypeMapping(TEST_TYPE, getMappingForTest(), fakeSecurity);
        client.bulkPut(
                Arrays.asList(washingtonMonumentDoc, whiteHouseDoc, oneaaColumbiaDoc, oneaaNavyYardDoc), fakeSecurity);

        final TermsStatsValue val = new TermsStatsValue();
        val.setValueField("rating");
        final TermsStatsFacet tsf = new TermsStatsFacet();
        tsf.setKeyField("rating");
        tsf.setValueField(val);
        final FacetRequest request = new FacetRequest();
        request.setTermsStatsFacet(tsf);
        final Facet facet = new Facet();
        facet.setLabel("magic");
        facet.setFacet(request);

        final Query query = new Query(QueryBuilders.matchAllQuery().toString()).setType(TEST_TYPE).setFacets(
                Collections.singletonList(facet)).setPage(new Page(0, (short) 10));
        final SearchResult results = client.query(query, fakeSecurity);

        // Assertion
        assertEquals(4, results.getTotalHits());
        for (final TermsStatsFacetResultEntry facetResult : results.getFacets().get("magic").getTermsStatsFacetResult()
                .getEntries()) {
            assertEquals(facetResult.getTerm(), Integer.toString((int) facetResult.getTermAsNumber()));
        }

        pool.returnToPool(client);
    }

    @Test
    public void testTermsStatsFacetWithFilter() throws Exception {
        // Prepare: Setup Thrift Client and add some docs
        client = pool.getClient(SERVICE_NAME, EzElastic.Client.class);
        client.setTypeMapping(TEST_TYPE, getMappingForTest(), fakeSecurity);
        client.bulkPut(
                Arrays.asList(washingtonMonumentDoc, whiteHouseDoc, oneaaColumbiaDoc, oneaaNavyYardDoc), fakeSecurity);

        // Action: Filter will match two but query should only match one due to rating range of query.
        final String filter = FilterBuilders.andFilter(
                FilterBuilders.rangeFilter("rating").from(0).to(100), FilterBuilders.termFilter("title", "42six"))
                .toString();

        final TermsStatsValue val = new TermsStatsValue();
        val.setValueField("rating");
        final TermsStatsFacet tsf = new TermsStatsFacet();
        tsf.setKeyField("title");
        tsf.setValueField(val);
        final FacetRequest request = new FacetRequest();
        request.setTermsStatsFacet(tsf);
        final Facet facet = new Facet();
        facet.setLabel("magic");
        facet.setFacet(request);
        facet.setFilterJSON(filter);

        final Query query = new Query(QueryBuilders.matchAllQuery().toString());
        query.setType(TEST_TYPE);
        query.setFacets(Collections.singletonList(facet));
        query.setPage(new Page(0, (short) 10));
        final SearchResult results = client.query(query, fakeSecurity);

        // Assertion
        assertEquals(4, results.getTotalHits());
        final Set<String> uniqueTitleTerms = new HashSet<>();
        uniqueTitleTerms.addAll(Arrays.asList(oneaaNavyYard.getTitle().split(" ")));
        uniqueTitleTerms.addAll(Arrays.asList(oneaaColumbia.getTitle().split(" ")));

        assertEquals(
                uniqueTitleTerms.size(),
                results.getFacets().get("magic").getTermsStatsFacetResult().getEntries().size());

        pool.returnToPool(client);
    }

    @Test
    public void testPercolator() throws Exception {
        // Prepare: Setup Thrift Client and add some docs
        client = pool.getClient(SERVICE_NAME, EzElastic.Client.class);
        client.setTypeMapping(TEST_TYPE, getMappingForTest(), fakeSecurity);
        client.bulkPut(
                Arrays.asList(washingtonMonumentDoc, whiteHouseDoc, oneaaColumbiaDoc, oneaaNavyYardDoc), fakeSecurity);

        final FilterBuilder geoDistanceFilter =
                new GeoDistanceFilterBuilder(TEST_TYPE + ".location").distance(10, DistanceUnit.KILOMETERS)
                        .lat(whiteHouse.getLocation().getLat()).lon(whiteHouse.getLocation().getLon());

        final QueryBuilder filteredQuery = new FilteredQueryBuilder(QueryBuilders.matchAllQuery(), geoDistanceFilter);

        final PercolateQuery percolator = new PercolateQuery();
        percolator.setVisibility(new Visibility().setFormalVisibility("U"));
        percolator.setId(UUID.randomUUID().toString());

        final String queryDoc = jsonBuilder().startObject().field("query", filteredQuery).endObject().string();

        percolator.setQueryDocument(queryDoc);

        // Action: Create and execute an OR match query on title
        final IndexResponse percolateResponse = client.addPercolateQuery(percolator, fakeSecurity);
        assertTrue(percolateResponse.isSuccess());

        // Assert: There should be 3 matching documents
        oneaaNavyYardDoc.setPercolate(new PercolateRequest());
        oneaaColumbiaDoc.setPercolate(new PercolateRequest());
        whiteHouseDoc.setPercolate(new PercolateRequest());
        washingtonMonumentDoc.setPercolate(new PercolateRequest());
        final List<PercolateQuery> matches = client.percolate(
                Arrays.asList(
                        oneaaNavyYardDoc, oneaaColumbiaDoc, whiteHouseDoc, washingtonMonumentDoc), fakeSecurity);
        assertEquals(3, matches.size());

        pool.returnToPool(client);
    }

    private void loadSamples() {
        final Calendar visit = new GregorianCalendar();
        // Washington Monument
        final PlaceOfInterest washingtonMonument = new PlaceOfInterest();
        washingtonMonument.setTitle("Washington Monument");
        washingtonMonument.setComments(
                "The Washington Monument is an obelisk on the National Mall in "
                        + "Washington, D.C., built to commemorate George Washington, " +
                        "Commander-in-Chief of the Continental " + "Army and the first American president.");
        washingtonMonument.setLocation(new Location(38.889468, -77.03524));
        washingtonMonument.setRating(92);
        washingtonMonument.setVisit(visit.getTime());
        washingtonMonumentDoc = TestUtils.generateDocument(TEST_TYPE, gson.toJson(washingtonMonument));
        // 42Six Columbia
        oneaaColumbia = new PlaceOfInterest();
        oneaaColumbia.setTitle("42Six HQ");
        oneaaColumbia.setComments(
                "The headquarters for 42Six from the initial split from Berico. Located at "
                        + "6630 Eli Whitney Dr. At one point the office included a gym, a fully stocked kitchen, " +
                        "a fully "
                        + "stocked fridge, and an occasional ommlette chef. There was also plenty of space and " +
                        "monitors for " + "all. Alas the good times have come to an end.");
        oneaaColumbia.setLocation(new Location(39.182786, -76.808853));
        oneaaColumbia.setRating(85);
        visit.add(Calendar.HOUR, -5);
        oneaaColumbia.setVisit(visit.getTime());
        oneaaColumbiaDoc = TestUtils.generateDocument(TEST_TYPE, gson.toJson(oneaaColumbia));
        // 42Six DC
        oneaaNavyYard = new PlaceOfInterest();
        oneaaNavyYard.setTitle("42Six Annex (Navy Yard)");
        oneaaNavyYard.setComments(
                "The third location in a year for 42Six in DC. A far cry from the HQ location, the DC "
                        + "annex has always been a step (or 10) down from the columbia location. With a skeleton crew "
                        + "of 1 - 6 employees the dc office is lucky to have a fridge that employees occasionally "
                        + "contribute to and coffee which is available cold (not the kind you order cold) and costs "
                        + "25 cents a cup.");
        oneaaNavyYard.setLocation(new Location(38.875945, -76.9895913));
        oneaaNavyYard.setRating(2);
        visit.add(Calendar.HOUR, -2);
        oneaaNavyYard.setVisit(visit.getTime());
        oneaaNavyYardDoc = TestUtils.generateDocument(TEST_TYPE, gson.toJson(oneaaNavyYard));
        // White House
        whiteHouse = new PlaceOfInterest();
        whiteHouse.setTitle("White House");
        whiteHouse.setComments(
                "The home of the president of the US located at 1600 Pennsylvania Ave. Since 1800 it has "
                        + "been the home of every US president and is really just a big white mansion with a large "
                        + "staff and a bunch of other stuff.");
        whiteHouse.setLocation(new Location(38.8977, -77.0365));
        whiteHouse.setRating(23);
        visit.add(Calendar.DAY_OF_MONTH, -3);
        whiteHouse.setVisit(visit.getTime());
        whiteHouseDoc = TestUtils.generateDocument(TEST_TYPE, gson.toJson(whiteHouse));
    }
}
