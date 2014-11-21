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

import java.util.Collection;
import java.util.EnumSet;
import java.util.Set;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.Collections2;

import ezbake.base.thrift.Permission;

public final class VisibilityFilterConfig {
    private String visibilityField;
    private Set<Permission> requiredPerms;

    public VisibilityFilterConfig(String visibilityField, Set<Permission> requiredPerms) {
        this.visibilityField = visibilityField;
        this.requiredPerms = EnumSet.copyOf(requiredPerms);
    }

    public String getVisibilityField() {
        return visibilityField;
    }

    public void setVisibilityField(String visibilityField) {
        this.visibilityField = visibilityField;
    }

    public Set<Permission> getRequiredPerms() {
        return requiredPerms;
    }

    public void setRequiredPerms(Set<Permission> requiredPerms) {
        this.requiredPerms = EnumSet.copyOf(requiredPerms);
    }

    public String getRequiredPermsString() {
        if (requiredPerms == null) {
            return null;
        }

        final Collection<String> permStrings = Collections2.transform(
                requiredPerms, new Function<Permission, String>() {
                    @Override
                    public String apply(Permission input) {
                        return input.name();
                    }
                });

        return Joiner.on(',').join(permStrings);
    }
}
