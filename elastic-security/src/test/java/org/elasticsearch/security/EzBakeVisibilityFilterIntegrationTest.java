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

package org.elasticsearch.security;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import static ezbake.thrift.ThriftUtils.serializeToBase64;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.index.query.FilterBuilders;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.ScriptFilterBuilder;
import org.elasticsearch.search.SearchHit;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.github.tlrx.elasticsearch.test.EsSetup;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;

import ezbake.base.thrift.AdvancedMarkings;
import ezbake.base.thrift.Authorizations;
import ezbake.base.thrift.Permission;
import ezbake.base.thrift.PlatformObjectVisibilities;
import ezbake.base.thrift.Visibility;
import ezbake.data.elastic.security.EzSecurityVisibilityFilter;

@SuppressWarnings("StaticNonFinalField")
public final class EzBakeVisibilityFilterIntegrationTest {
    private static final String INDEX_NAME = "my_test";
    private static final String TYPE_NAME = "my_type";

    private static final String VISIBILITY_FIELD = "visibility";
    private static final String DATA_FIELD = "data";

    private static EsSetup esSetup;

    @BeforeClass
    public static void setUpClass() throws Exception {
        final Settings settings = ImmutableSettings.settingsBuilder().put("script.disable_dynamic", false)
                .put("script.native.visibility.type", "ezbake.data.elastic.security.EzSecurityScriptFactory").build();

        esSetup = new EsSetup(settings);
        esSetup.execute(EsSetup.deleteAll());
        createIndexAndType();

        writeTestDoc("noVis", null, null, null, null, "noVisData");
        writeTestDoc("formalVisOnly", "TS&USA", null, null, null, "formalVisOnlyData");
        writeTestDoc("formalAndExternalVis", "TS&USA", "Foo&(Bar|Baz)", null, null, "formalAndExternalVisData");

        writeTestDoc(
                "allVis", "TS&USA", "Foo&(Bar|Baz)", Sets.newHashSet(92472393432L),
                Sets.newHashSet(324L, 43267L, 92472393432L), "allVisData");

        Thread.sleep(2000); // Wait for docs to be added
    }

    @AfterClass
    public static void tearDownClass() {
        esSetup.terminate();
    }

    private static void createIndexAndType() throws Exception {
        final XContentBuilder mapping = XContentFactory.jsonBuilder().prettyPrint();
        mapping.startObject();
        mapping.startObject(TYPE_NAME);
        mapping.startObject("properties");

        mapping.startObject(VISIBILITY_FIELD);
        mapping.field("type", "string");
        mapping.field("index", "not_analyzed");
        mapping.endObject();

        mapping.startObject(DATA_FIELD);
        mapping.field("type", "string");
        mapping.field("index", "not_analyzed");
        mapping.endObject();

        mapping.endObject();
        mapping.endObject();
        mapping.endObject();

        mapping.close();

        esSetup.client().admin().indices().prepareCreate(INDEX_NAME).addMapping(TYPE_NAME, mapping).get();
    }

    private static void writeTestDoc(
            String id, String formalVisibility, String externalVisibility, Set<Long> readVisibility,
            Set<Long> discoverVisibility, String data) throws Exception {
        final PlatformObjectVisibilities pov = new PlatformObjectVisibilities();
        pov.setPlatformObjectReadVisibility(readVisibility);
        pov.setPlatformObjectDiscoverVisibility(discoverVisibility);

        final AdvancedMarkings markings = new AdvancedMarkings();
        markings.setExternalCommunityVisibility(externalVisibility);
        markings.setPlatformObjectVisibility(pov);

        final Visibility visibility = new Visibility();
        visibility.setFormalVisibility(formalVisibility);
        visibility.setAdvancedMarkings(markings);

        final XContentBuilder doc = XContentFactory.jsonBuilder().prettyPrint();
        doc.startObject();
        doc.field(VISIBILITY_FIELD, serializeToBase64(visibility));
        doc.field(DATA_FIELD, data);
        doc.endObject();
        doc.close();

        esSetup.client().prepareIndex(INDEX_NAME, TYPE_NAME, id).setSource(doc).get();
    }

    private static Map<String, String> searchDocs(ScriptFilterBuilder filter) {
        final SearchResponse results = esSetup.client().prepareSearch(INDEX_NAME).setTypes(TYPE_NAME)
                .setQuery(QueryBuilders.filteredQuery(QueryBuilders.matchAllQuery(), filter)).get();

        final Map<String, String> foundDocs = new HashMap<>();
        for (final SearchHit hit : results.getHits().getHits()) {
            foundDocs.put(hit.getId(), (String) hit.getSource().get(DATA_FIELD));
        }

        return foundDocs;
    }

    private static long countDocs(ScriptFilterBuilder filter) {
        return esSetup.client().prepareCount(INDEX_NAME).setTypes(TYPE_NAME)
                .setQuery(QueryBuilders.filteredQuery(QueryBuilders.matchAllQuery(), filter)).get().getCount();
    }

    private static ScriptFilterBuilder createVisibilityFilter(
            Set<String> formalAuths, Set<String> externalAuths, Set<Long> platformAuths,
            boolean docSourceAccessRequired) throws Exception {
        final Authorizations auths = new Authorizations();
        auths.setFormalAuthorizations(formalAuths);
        auths.setExternalCommunityAuthorizations(externalAuths);
        auths.setPlatformObjectAuthorizations(platformAuths);

        final String requiredPerms = docSourceAccessRequired ? Permission.READ.name() : Permission.DISCOVER.name();

        final ScriptFilterBuilder visibilityFilter = FilterBuilders.scriptFilter("visibility").lang("native");
        visibilityFilter.addParam(EzSecurityVisibilityFilter.VISIBILITY_FIELD_PARAM, VISIBILITY_FIELD);
        visibilityFilter.addParam(EzSecurityVisibilityFilter.AUTHS_PARAM, serializeToBase64(auths));
        visibilityFilter.addParam(EzSecurityVisibilityFilter.REQUIRED_PERMISSIONS_PARAM, requiredPerms);

        return visibilityFilter;
    }

    @Test
    public void testNoVisibility() throws Exception {
        final Map<String, String> searchResults = searchDocs(createVisibilityFilter(null, null, null, true));

        assertNotNull(searchResults);
        assertEquals(1, searchResults.size());
        assertTrue(searchResults.containsKey("noVis"));
        assertEquals("noVisData", searchResults.get("noVis"));
    }

    @Test
    public void testFormalVisibilityOnlyMatch() throws Exception {
        final Map<String, String> searchResults =
                searchDocs(createVisibilityFilter(ImmutableSet.of("TS", "USA"), null, null, true));

        assertNotNull(searchResults);
        assertEquals(2, searchResults.size());
        assertTrue(searchResults.containsKey("noVis"));
        assertEquals("noVisData", searchResults.get("noVis"));
        assertTrue(searchResults.containsKey("formalVisOnly"));
        assertEquals("formalVisOnlyData", searchResults.get("formalVisOnly"));
    }

    @Test
    public void testFormalVisibilityOnlyMismatch() throws Exception {
        final Map<String, String> searchResults =
                searchDocs(createVisibilityFilter(ImmutableSet.of("S"), null, null, true));

        assertNotNull(searchResults);
        assertEquals(1, searchResults.size());
        assertTrue(searchResults.containsKey("noVis"));
        assertEquals("noVisData", searchResults.get("noVis"));
    }

    @Test
    public void testExternalCommunityVisibilityMatch() throws Exception {
        final Map<String, String> searchResults = searchDocs(
                createVisibilityFilter(
                        ImmutableSet.of("TS", "USA"), ImmutableSet.of("Foo", "Bar"), null, true));

        assertNotNull(searchResults);
        assertEquals(3, searchResults.size());
        assertTrue(searchResults.containsKey("noVis"));
        assertEquals("noVisData", searchResults.get("noVis"));
        assertTrue(searchResults.containsKey("formalVisOnly"));
        assertEquals("formalVisOnlyData", searchResults.get("formalVisOnly"));
        assertTrue(searchResults.containsKey("formalAndExternalVis"));
        assertEquals("formalAndExternalVisData", searchResults.get("formalAndExternalVis"));
    }

    @Test
    public void testExternalCommunityVisibilityMismatch() throws Exception {
        final Map<String, String> searchResults =
                searchDocs(createVisibilityFilter(ImmutableSet.of("TS", "USA"), ImmutableSet.of("Foo"), null, true));

        assertNotNull(searchResults);
        assertEquals(2, searchResults.size());
        assertTrue(searchResults.containsKey("noVis"));
        assertEquals("noVisData", searchResults.get("noVis"));
        assertTrue(searchResults.containsKey("formalVisOnly"));
        assertEquals("formalVisOnlyData", searchResults.get("formalVisOnly"));
    }

    @Test
    public void testPlatformObjectVisibilities() throws Exception {
        final Set<Long> readAndDiscover = Sets.newHashSet(92472393432L);
        final Set<Long> discoverOnly = Sets.newHashSet(324L);
        final Set<Long> mismatch = Sets.newHashSet(99L);

        final Map<String, String> hasReadSearchResults = searchDocs(
                createVisibilityFilter(
                        ImmutableSet.of("TS", "USA"), ImmutableSet.of("Foo", "Bar"), readAndDiscover, true));

        assertNotNull(hasReadSearchResults);
        assertEquals(4, hasReadSearchResults.size());
        assertTrue(hasReadSearchResults.containsKey("noVis"));
        assertEquals("noVisData", hasReadSearchResults.get("noVis"));
        assertTrue(hasReadSearchResults.containsKey("formalVisOnly"));
        assertEquals("formalVisOnlyData", hasReadSearchResults.get("formalVisOnly"));
        assertTrue(hasReadSearchResults.containsKey("formalAndExternalVis"));
        assertEquals("formalAndExternalVisData", hasReadSearchResults.get("formalAndExternalVis"));
        assertTrue(hasReadSearchResults.containsKey("allVis"));
        assertEquals("allVisData", hasReadSearchResults.get("allVis"));

        final Map<String, String> hasDiscoverOnlySearchResults = searchDocs(
                createVisibilityFilter(
                        ImmutableSet.of("TS", "USA"), ImmutableSet.of("Foo", "Bar"), discoverOnly, true));

        assertNotNull(hasDiscoverOnlySearchResults);
        assertEquals(3, hasDiscoverOnlySearchResults.size());
        assertTrue(hasDiscoverOnlySearchResults.containsKey("noVis"));
        assertEquals("noVisData", hasDiscoverOnlySearchResults.get("noVis"));
        assertTrue(hasDiscoverOnlySearchResults.containsKey("formalVisOnly"));
        assertEquals("formalVisOnlyData", hasDiscoverOnlySearchResults.get("formalVisOnly"));
        assertTrue(hasDiscoverOnlySearchResults.containsKey("formalAndExternalVis"));
        assertEquals("formalAndExternalVisData", hasDiscoverOnlySearchResults.get("formalAndExternalVis"));

        final Map<String, String> mismatchSearchResults = searchDocs(
                createVisibilityFilter(
                        ImmutableSet.of("TS", "USA"), ImmutableSet.of("Foo", "Bar"), mismatch, true));

        assertNotNull(mismatchSearchResults);
        assertEquals(3, mismatchSearchResults.size());
        assertTrue(mismatchSearchResults.containsKey("noVis"));
        assertEquals("noVisData", mismatchSearchResults.get("noVis"));
        assertTrue(mismatchSearchResults.containsKey("formalVisOnly"));
        assertEquals("formalVisOnlyData", mismatchSearchResults.get("formalVisOnly"));
        assertTrue(mismatchSearchResults.containsKey("formalAndExternalVis"));
        assertEquals("formalAndExternalVisData", mismatchSearchResults.get("formalAndExternalVis"));

        final long hasReadCount = countDocs(
                createVisibilityFilter(
                        ImmutableSet.of("TS", "USA"), ImmutableSet.of("Foo", "Bar"), readAndDiscover, false));

        assertEquals(4, hasReadCount);

        final long hasDiscoverOnlyCount = countDocs(
                createVisibilityFilter(
                        ImmutableSet.of("TS", "USA"), ImmutableSet.of("Foo", "Bar"), discoverOnly, false));

        assertEquals(4, hasDiscoverOnlyCount);

        final long mismatchCount = countDocs(
                createVisibilityFilter(
                        ImmutableSet.of("TS", "USA"), ImmutableSet.of("Foo", "Bar"), mismatch, false));

        assertEquals(3, mismatchCount);
    }
}
