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

package ezbake.data.elastic.security;

import static ezbake.security.permissions.PermissionUtils.getPermissions;
import static ezbake.thrift.ThriftUtils.deserializeFromBase64;

import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.thrift.TException;
import org.elasticsearch.common.logging.ESLogger;
import org.elasticsearch.index.fielddata.ScriptDocValues;
import org.elasticsearch.script.AbstractSearchScript;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import ezbake.base.thrift.Authorizations;
import ezbake.base.thrift.Permission;
import ezbake.base.thrift.Visibility;

public final class EzSecurityVisibilityFilter extends AbstractSearchScript {
    public static final String VISIBILITY_FIELD_PARAM = "visibilityField";
    public static final String REQUIRED_PERMISSIONS_PARAM = "requiredPermissions";
    public static final String AUTHS_PARAM = "auths";

    private final ESLogger logger;

    private final String visibilityField;
    private final Authorizations authorizations;
    private final Set<Permission> requiredPermissions;

    public EzSecurityVisibilityFilter(Map<String, Object> params, ESLogger logger) {
        this.logger = logger;

        if (params == null) {
            throw new IllegalArgumentException("Script parameters may not be null");
        }

        visibilityField = (String) params.get(VISIBILITY_FIELD_PARAM);
        if (StringUtils.isEmpty(visibilityField)) {
            throw new IllegalArgumentException("Visibility must be given");
        }

        final String requiredPermsParam = (String) params.get(REQUIRED_PERMISSIONS_PARAM);
        if (StringUtils.isEmpty(requiredPermsParam)) {
            throw new IllegalArgumentException("Required permissions must be given");
        }

        final String[] requiredPermNamesArray = StringUtils.split(requiredPermsParam, ',');
        final List<String> requiredPermNames = Lists.newArrayList(requiredPermNamesArray);

        final List<Permission> requiredPermsList = Lists.transform(
                requiredPermNames, new Function<String, Permission>() {
                    @Override
                    public Permission apply(String input) {
                        return Permission.valueOf(input);
                    }
                });

        requiredPermissions = EnumSet.copyOf(requiredPermsList);

        final String authsBase64 = (String) params.get(AUTHS_PARAM);
        try {
            authorizations = deserializeFromBase64(Authorizations.class, authsBase64);
        } catch (final TException e) {
            final String errMsg = "Could not deserialize authorizations parameter to Authorizations POJO";
            logger.error(errMsg, e);
            throw new IllegalArgumentException(errMsg, e);
        }
    }

    @Override
    public Object run() {
        final String visibilityBase64 = getStringField(visibilityField);
        Visibility visibility = null;
        try {
            if (visibilityBase64 == null) {
                visibility = new Visibility();
            } else {
                visibility = deserializeFromBase64(Visibility.class, visibilityBase64);
            }
        } catch (final TException e) {
            logger.error("Could not deserialize visibility in document to Visibility POJO", e);
            return false;
        }

        final Set<Permission> userPerms = getPermissions(authorizations, visibility, true, requiredPermissions);

        return Sets.intersection(requiredPermissions, userPerms).equals(requiredPermissions);
    }

    private String getStringField(String fieldName) {
        final ScriptDocValues docValues = (ScriptDocValues) doc().get(fieldName);
        if (docValues == null) {
            logger.warn("Document didn't contain '" + fieldName + '\'');
            return null;
        }

        final List<?> values = docValues.getValues();
        if (values == null || values.isEmpty()) {
            logger.warn("Document contained no values in '" + fieldName + '\'');
            return null;
        }

        return values.get(0).toString();
    }
}
