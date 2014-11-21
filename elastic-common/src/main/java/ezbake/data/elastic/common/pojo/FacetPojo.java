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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import ezbake.data.elastic.thrift.Facet;

public final class FacetPojo {
    private String label;
    private FacetRequestPojo facet;
    private String filterJSON; // optional

    public static FacetPojo fromThrift(Facet thrift) {
        if (thrift == null) {
            return null;
        }

        final FacetPojo pojo = new FacetPojo();
        pojo.label = thrift.getLabel();
        pojo.facet = FacetRequestPojo.fromThrift(thrift.getFacet());
        pojo.filterJSON = thrift.getFilterJSON();

        return pojo;
    }

    public static List<FacetPojo> fromThrift(List<Facet> thrifts) {
        if (thrifts == null) {
            return null;
        }

        final List<FacetPojo> pojos = new ArrayList<>(thrifts.size());
        for (final Facet thrift : thrifts) {
            pojos.add(fromThrift(thrift));
        }

        return pojos;
    }

    public static Facet toThrift(FacetPojo pojo) throws TException {
        if (pojo == null) {
            return null;
        }

        final Facet thrift = new Facet();
        thrift.setLabel(pojo.label);
        thrift.setFacet(FacetRequestPojo.toThrift(pojo.facet));
        thrift.setFilterJSON(pojo.filterJSON);

        thrift.validate();

        return thrift;
    }

    public static List<Facet> toThrift(List<FacetPojo> pojos) throws TException {
        if (pojos == null) {
            return null;
        }

        final List<Facet> thrifts = new ArrayList<>(pojos.size());
        for (final FacetPojo pojo : pojos) {
            thrifts.add(toThrift(pojo));
        }

        return thrifts;
    }

    public static FacetPojo fromJson(String json) {
        try {
            final Gson gson = new GsonBuilder().create();
            return gson.fromJson(json, FacetPojo.class);
        } catch (final JsonSyntaxException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public Facet toThrift() throws TException {
        return toThrift(this);
    }

    public String toJson() {
        final Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this, FacetPojo.class);
    }
}
