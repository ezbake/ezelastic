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

package ezbake.data.elastic.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang.time.DateUtils;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import ezbake.base.thrift.Visibility;
import ezbake.data.elastic.thrift.BaseFacetValue;
import ezbake.data.elastic.thrift.Document;
import ezbake.data.elastic.thrift.Facet;
import ezbake.data.elastic.thrift.FacetRange;
import ezbake.data.elastic.thrift.FacetRequest;
import ezbake.data.elastic.thrift.RangeFacet;
import ezbake.data.elastic.thrift.RangeType;

@SuppressWarnings({"StaticNonFinalField", "PublicField"})
public final class TestUtils {
    public static long last24time;
    public static long last48time;
    public static long last72time;
    public static long lastWeekTime;
    public static long last30DaysTime;
    public static long last90DaysTime;
    public static long lastYearTime;

    private TestUtils() {
    }

    public static Document generateDocument(String type, String jsonObject) {
        return generateDocument(type, jsonObject, "U");
    }

    public static Document generateDocument(String type, String jsonObject, String auth) {
        return generateDocument(type, jsonObject, new Visibility().setFormalVisibility(auth));
    }

    public static Document generateDocument(String type, String jsonObject, Visibility vis) {
        final Document doc = new Document();
        doc.set_id(UUID.randomUUID().toString());
        doc.set_type(type);
        doc.set_jsonObject(jsonObject);
        doc.setVisibility(vis);
        return doc;
    }

    public static Map<String, Object> jsonToMap(String json) {
        final JsonObject object = (JsonObject) new JsonParser().parse(json);
        final Iterator<Map.Entry<String, JsonElement>> iterator = object.entrySet().iterator();
        final Map<String, Object> map = new HashMap<>();
        while (iterator.hasNext()) {
            final Map.Entry<String, JsonElement> entry = iterator.next();
            final String key = entry.getKey();
            final JsonElement value = entry.getValue();
            if (value.isJsonPrimitive()) {
                map.put(key, value.getAsString());
            } else {
                map.put(key, jsonToMap(value.toString()));
            }
        }
        return map;
    }

    public static Facet generateDateBucketFacet() {
        final SimpleDateFormat dtg = new SimpleDateFormat("ddHHmm'Z' MM yy");
        final Calendar calendar = new GregorianCalendar();
        final Facet ssrDateFacet = new Facet();
        final RangeFacet dateRangeFacet = new RangeFacet();
        final BaseFacetValue dateField = new BaseFacetValue();
        dateField.setFacetField("visit");
        dateRangeFacet.setField(dateField);

        final FacetRange last24 = new FacetRange(RangeType.DATE);
        calendar.add(Calendar.DAY_OF_YEAR, -1);
        last24time = DateUtils.round(calendar, Calendar.HOUR).getTimeInMillis();
        last24.setFrom(dtg.format(last24time));
        dateRangeFacet.addToRanges(last24);

        final FacetRange last48 = new FacetRange(RangeType.DATE);
        calendar.add(Calendar.DAY_OF_YEAR, -1);
        last48time = DateUtils.round(calendar, Calendar.HOUR).getTimeInMillis();
        last48.setFrom(dtg.format(last48time));
        dateRangeFacet.addToRanges(last48);

        final FacetRange last72 = new FacetRange(RangeType.DATE);
        calendar.add(Calendar.DAY_OF_YEAR, -1);
        last72time = DateUtils.round(calendar, Calendar.HOUR).getTimeInMillis();
        last72.setFrom(dtg.format(last72time));
        dateRangeFacet.addToRanges(last72);

        final FacetRange lastWeek = new FacetRange(RangeType.DATE);
        calendar.add(Calendar.DAY_OF_YEAR, -4);
        lastWeekTime = DateUtils.round(calendar, Calendar.HOUR).getTimeInMillis();
        lastWeek.setFrom(dtg.format(lastWeekTime));
        dateRangeFacet.addToRanges(lastWeek);

        final FacetRange last30Days = new FacetRange(RangeType.DATE);
        calendar.add(Calendar.DAY_OF_YEAR, -23);
        last30DaysTime = DateUtils.round(calendar, Calendar.HOUR).getTimeInMillis();
        last30Days.setFrom(dtg.format(last30DaysTime));
        dateRangeFacet.addToRanges(last30Days);

        final FacetRange last90Days = new FacetRange(RangeType.DATE);
        calendar.add(Calendar.DAY_OF_YEAR, -60);
        last90DaysTime = DateUtils.round(calendar, Calendar.HOUR).getTimeInMillis();
        last90Days.setFrom(dtg.format(last90DaysTime));
        dateRangeFacet.addToRanges(last90Days);

        final FacetRange lastYear = new FacetRange(RangeType.DATE);
        calendar.add(Calendar.DAY_OF_YEAR, -275);
        lastYearTime = DateUtils.round(calendar, Calendar.HOUR).getTimeInMillis();
        lastYear.setFrom(dtg.format(lastYearTime));
        dateRangeFacet.addToRanges(lastYear);

        final FacetRequest dateRequest = new FacetRequest();
        dateRequest.setRangeFacet(dateRangeFacet);

        ssrDateFacet.setLabel("Report Date");
        ssrDateFacet.setFacet(dateRequest);

        return ssrDateFacet;
    }
}
