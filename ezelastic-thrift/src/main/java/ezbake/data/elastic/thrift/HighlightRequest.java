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

/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package ezbake.data.elastic.thrift;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A request to highlight a set of fields
 */
public class HighlightRequest implements org.apache.thrift.TBase<HighlightRequest, HighlightRequest._Fields>, java.io.Serializable, Cloneable, Comparable<HighlightRequest> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("HighlightRequest");

  private static final org.apache.thrift.protocol.TField FIELDS_FIELD_DESC = new org.apache.thrift.protocol.TField("fields", org.apache.thrift.protocol.TType.SET, (short)1);
  private static final org.apache.thrift.protocol.TField ORDER_FIELD_DESC = new org.apache.thrift.protocol.TField("order", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField PRE_TAGS_FIELD_DESC = new org.apache.thrift.protocol.TField("pre_tags", org.apache.thrift.protocol.TType.LIST, (short)3);
  private static final org.apache.thrift.protocol.TField POST_TAGS_FIELD_DESC = new org.apache.thrift.protocol.TField("post_tags", org.apache.thrift.protocol.TType.LIST, (short)4);
  private static final org.apache.thrift.protocol.TField TAGS_SCHEMA_FIELD_DESC = new org.apache.thrift.protocol.TField("tags_schema", org.apache.thrift.protocol.TType.STRING, (short)5);
  private static final org.apache.thrift.protocol.TField REQUIRE_FIELD_MATCH_FIELD_DESC = new org.apache.thrift.protocol.TField("requireFieldMatch", org.apache.thrift.protocol.TType.BOOL, (short)6);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new HighlightRequestStandardSchemeFactory());
    schemes.put(TupleScheme.class, new HighlightRequestTupleSchemeFactory());
  }

  /**
   * Set of fields to highlight
   */
  public Set<HighlightedField> fields; // required
  /**
   * Order to highlight
   */
  public String order; // optional
  /**
   * Tags to begin fragments (default <em>)
   */
  public List<String> pre_tags; // optional
  /**
   * Tags to end fragments (default </em>)
   */
  public List<String> post_tags; // optional
  /**
   * Schema for tags
   */
  public String tags_schema; // optional
  /**
   * Whether to require a field match to highlight
   */
  public boolean requireFieldMatch; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    /**
     * Set of fields to highlight
     */
    FIELDS((short)1, "fields"),
    /**
     * Order to highlight
     */
    ORDER((short)2, "order"),
    /**
     * Tags to begin fragments (default <em>)
     */
    PRE_TAGS((short)3, "pre_tags"),
    /**
     * Tags to end fragments (default </em>)
     */
    POST_TAGS((short)4, "post_tags"),
    /**
     * Schema for tags
     */
    TAGS_SCHEMA((short)5, "tags_schema"),
    /**
     * Whether to require a field match to highlight
     */
    REQUIRE_FIELD_MATCH((short)6, "requireFieldMatch");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // FIELDS
          return FIELDS;
        case 2: // ORDER
          return ORDER;
        case 3: // PRE_TAGS
          return PRE_TAGS;
        case 4: // POST_TAGS
          return POST_TAGS;
        case 5: // TAGS_SCHEMA
          return TAGS_SCHEMA;
        case 6: // REQUIRE_FIELD_MATCH
          return REQUIRE_FIELD_MATCH;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __REQUIREFIELDMATCH_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  private _Fields optionals[] = {_Fields.ORDER,_Fields.PRE_TAGS,_Fields.POST_TAGS,_Fields.TAGS_SCHEMA,_Fields.REQUIRE_FIELD_MATCH};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.FIELDS, new org.apache.thrift.meta_data.FieldMetaData("fields", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.SetMetaData(org.apache.thrift.protocol.TType.SET, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, HighlightedField.class))));
    tmpMap.put(_Fields.ORDER, new org.apache.thrift.meta_data.FieldMetaData("order", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.PRE_TAGS, new org.apache.thrift.meta_data.FieldMetaData("pre_tags", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING))));
    tmpMap.put(_Fields.POST_TAGS, new org.apache.thrift.meta_data.FieldMetaData("post_tags", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING))));
    tmpMap.put(_Fields.TAGS_SCHEMA, new org.apache.thrift.meta_data.FieldMetaData("tags_schema", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.REQUIRE_FIELD_MATCH, new org.apache.thrift.meta_data.FieldMetaData("requireFieldMatch", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BOOL)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(HighlightRequest.class, metaDataMap);
  }

  public HighlightRequest() {
  }

  public HighlightRequest(
    Set<HighlightedField> fields)
  {
    this();
    this.fields = fields;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public HighlightRequest(HighlightRequest other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetFields()) {
      Set<HighlightedField> __this__fields = new HashSet<HighlightedField>(other.fields.size());
      for (HighlightedField other_element : other.fields) {
        __this__fields.add(new HighlightedField(other_element));
      }
      this.fields = __this__fields;
    }
    if (other.isSetOrder()) {
      this.order = other.order;
    }
    if (other.isSetPre_tags()) {
      List<String> __this__pre_tags = new ArrayList<String>(other.pre_tags);
      this.pre_tags = __this__pre_tags;
    }
    if (other.isSetPost_tags()) {
      List<String> __this__post_tags = new ArrayList<String>(other.post_tags);
      this.post_tags = __this__post_tags;
    }
    if (other.isSetTags_schema()) {
      this.tags_schema = other.tags_schema;
    }
    this.requireFieldMatch = other.requireFieldMatch;
  }

  public HighlightRequest deepCopy() {
    return new HighlightRequest(this);
  }

  @Override
  public void clear() {
    this.fields = null;
    this.order = null;
    this.pre_tags = null;
    this.post_tags = null;
    this.tags_schema = null;
    setRequireFieldMatchIsSet(false);
    this.requireFieldMatch = false;
  }

  public int getFieldsSize() {
    return (this.fields == null) ? 0 : this.fields.size();
  }

  public java.util.Iterator<HighlightedField> getFieldsIterator() {
    return (this.fields == null) ? null : this.fields.iterator();
  }

  public void addToFields(HighlightedField elem) {
    if (this.fields == null) {
      this.fields = new HashSet<HighlightedField>();
    }
    this.fields.add(elem);
  }

  /**
   * Set of fields to highlight
   */
  public Set<HighlightedField> getFields() {
    return this.fields;
  }

  /**
   * Set of fields to highlight
   */
  public HighlightRequest setFields(Set<HighlightedField> fields) {
    this.fields = fields;
    return this;
  }

  public void unsetFields() {
    this.fields = null;
  }

  /** Returns true if field fields is set (has been assigned a value) and false otherwise */
  public boolean isSetFields() {
    return this.fields != null;
  }

  public void setFieldsIsSet(boolean value) {
    if (!value) {
      this.fields = null;
    }
  }

  /**
   * Order to highlight
   */
  public String getOrder() {
    return this.order;
  }

  /**
   * Order to highlight
   */
  public HighlightRequest setOrder(String order) {
    this.order = order;
    return this;
  }

  public void unsetOrder() {
    this.order = null;
  }

  /** Returns true if field order is set (has been assigned a value) and false otherwise */
  public boolean isSetOrder() {
    return this.order != null;
  }

  public void setOrderIsSet(boolean value) {
    if (!value) {
      this.order = null;
    }
  }

  public int getPre_tagsSize() {
    return (this.pre_tags == null) ? 0 : this.pre_tags.size();
  }

  public java.util.Iterator<String> getPre_tagsIterator() {
    return (this.pre_tags == null) ? null : this.pre_tags.iterator();
  }

  public void addToPre_tags(String elem) {
    if (this.pre_tags == null) {
      this.pre_tags = new ArrayList<String>();
    }
    this.pre_tags.add(elem);
  }

  /**
   * Tags to begin fragments (default <em>)
   */
  public List<String> getPre_tags() {
    return this.pre_tags;
  }

  /**
   * Tags to begin fragments (default <em>)
   */
  public HighlightRequest setPre_tags(List<String> pre_tags) {
    this.pre_tags = pre_tags;
    return this;
  }

  public void unsetPre_tags() {
    this.pre_tags = null;
  }

  /** Returns true if field pre_tags is set (has been assigned a value) and false otherwise */
  public boolean isSetPre_tags() {
    return this.pre_tags != null;
  }

  public void setPre_tagsIsSet(boolean value) {
    if (!value) {
      this.pre_tags = null;
    }
  }

  public int getPost_tagsSize() {
    return (this.post_tags == null) ? 0 : this.post_tags.size();
  }

  public java.util.Iterator<String> getPost_tagsIterator() {
    return (this.post_tags == null) ? null : this.post_tags.iterator();
  }

  public void addToPost_tags(String elem) {
    if (this.post_tags == null) {
      this.post_tags = new ArrayList<String>();
    }
    this.post_tags.add(elem);
  }

  /**
   * Tags to end fragments (default </em>)
   */
  public List<String> getPost_tags() {
    return this.post_tags;
  }

  /**
   * Tags to end fragments (default </em>)
   */
  public HighlightRequest setPost_tags(List<String> post_tags) {
    this.post_tags = post_tags;
    return this;
  }

  public void unsetPost_tags() {
    this.post_tags = null;
  }

  /** Returns true if field post_tags is set (has been assigned a value) and false otherwise */
  public boolean isSetPost_tags() {
    return this.post_tags != null;
  }

  public void setPost_tagsIsSet(boolean value) {
    if (!value) {
      this.post_tags = null;
    }
  }

  /**
   * Schema for tags
   */
  public String getTags_schema() {
    return this.tags_schema;
  }

  /**
   * Schema for tags
   */
  public HighlightRequest setTags_schema(String tags_schema) {
    this.tags_schema = tags_schema;
    return this;
  }

  public void unsetTags_schema() {
    this.tags_schema = null;
  }

  /** Returns true if field tags_schema is set (has been assigned a value) and false otherwise */
  public boolean isSetTags_schema() {
    return this.tags_schema != null;
  }

  public void setTags_schemaIsSet(boolean value) {
    if (!value) {
      this.tags_schema = null;
    }
  }

  /**
   * Whether to require a field match to highlight
   */
  public boolean isRequireFieldMatch() {
    return this.requireFieldMatch;
  }

  /**
   * Whether to require a field match to highlight
   */
  public HighlightRequest setRequireFieldMatch(boolean requireFieldMatch) {
    this.requireFieldMatch = requireFieldMatch;
    setRequireFieldMatchIsSet(true);
    return this;
  }

  public void unsetRequireFieldMatch() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __REQUIREFIELDMATCH_ISSET_ID);
  }

  /** Returns true if field requireFieldMatch is set (has been assigned a value) and false otherwise */
  public boolean isSetRequireFieldMatch() {
    return EncodingUtils.testBit(__isset_bitfield, __REQUIREFIELDMATCH_ISSET_ID);
  }

  public void setRequireFieldMatchIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __REQUIREFIELDMATCH_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case FIELDS:
      if (value == null) {
        unsetFields();
      } else {
        setFields((Set<HighlightedField>)value);
      }
      break;

    case ORDER:
      if (value == null) {
        unsetOrder();
      } else {
        setOrder((String)value);
      }
      break;

    case PRE_TAGS:
      if (value == null) {
        unsetPre_tags();
      } else {
        setPre_tags((List<String>)value);
      }
      break;

    case POST_TAGS:
      if (value == null) {
        unsetPost_tags();
      } else {
        setPost_tags((List<String>)value);
      }
      break;

    case TAGS_SCHEMA:
      if (value == null) {
        unsetTags_schema();
      } else {
        setTags_schema((String)value);
      }
      break;

    case REQUIRE_FIELD_MATCH:
      if (value == null) {
        unsetRequireFieldMatch();
      } else {
        setRequireFieldMatch((Boolean)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case FIELDS:
      return getFields();

    case ORDER:
      return getOrder();

    case PRE_TAGS:
      return getPre_tags();

    case POST_TAGS:
      return getPost_tags();

    case TAGS_SCHEMA:
      return getTags_schema();

    case REQUIRE_FIELD_MATCH:
      return Boolean.valueOf(isRequireFieldMatch());

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case FIELDS:
      return isSetFields();
    case ORDER:
      return isSetOrder();
    case PRE_TAGS:
      return isSetPre_tags();
    case POST_TAGS:
      return isSetPost_tags();
    case TAGS_SCHEMA:
      return isSetTags_schema();
    case REQUIRE_FIELD_MATCH:
      return isSetRequireFieldMatch();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof HighlightRequest)
      return this.equals((HighlightRequest)that);
    return false;
  }

  public boolean equals(HighlightRequest that) {
    if (that == null)
      return false;

    boolean this_present_fields = true && this.isSetFields();
    boolean that_present_fields = true && that.isSetFields();
    if (this_present_fields || that_present_fields) {
      if (!(this_present_fields && that_present_fields))
        return false;
      if (!this.fields.equals(that.fields))
        return false;
    }

    boolean this_present_order = true && this.isSetOrder();
    boolean that_present_order = true && that.isSetOrder();
    if (this_present_order || that_present_order) {
      if (!(this_present_order && that_present_order))
        return false;
      if (!this.order.equals(that.order))
        return false;
    }

    boolean this_present_pre_tags = true && this.isSetPre_tags();
    boolean that_present_pre_tags = true && that.isSetPre_tags();
    if (this_present_pre_tags || that_present_pre_tags) {
      if (!(this_present_pre_tags && that_present_pre_tags))
        return false;
      if (!this.pre_tags.equals(that.pre_tags))
        return false;
    }

    boolean this_present_post_tags = true && this.isSetPost_tags();
    boolean that_present_post_tags = true && that.isSetPost_tags();
    if (this_present_post_tags || that_present_post_tags) {
      if (!(this_present_post_tags && that_present_post_tags))
        return false;
      if (!this.post_tags.equals(that.post_tags))
        return false;
    }

    boolean this_present_tags_schema = true && this.isSetTags_schema();
    boolean that_present_tags_schema = true && that.isSetTags_schema();
    if (this_present_tags_schema || that_present_tags_schema) {
      if (!(this_present_tags_schema && that_present_tags_schema))
        return false;
      if (!this.tags_schema.equals(that.tags_schema))
        return false;
    }

    boolean this_present_requireFieldMatch = true && this.isSetRequireFieldMatch();
    boolean that_present_requireFieldMatch = true && that.isSetRequireFieldMatch();
    if (this_present_requireFieldMatch || that_present_requireFieldMatch) {
      if (!(this_present_requireFieldMatch && that_present_requireFieldMatch))
        return false;
      if (this.requireFieldMatch != that.requireFieldMatch)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    HashCodeBuilder builder = new HashCodeBuilder();

    boolean present_fields = true && (isSetFields());
    builder.append(present_fields);
    if (present_fields)
      builder.append(fields);

    boolean present_order = true && (isSetOrder());
    builder.append(present_order);
    if (present_order)
      builder.append(order);

    boolean present_pre_tags = true && (isSetPre_tags());
    builder.append(present_pre_tags);
    if (present_pre_tags)
      builder.append(pre_tags);

    boolean present_post_tags = true && (isSetPost_tags());
    builder.append(present_post_tags);
    if (present_post_tags)
      builder.append(post_tags);

    boolean present_tags_schema = true && (isSetTags_schema());
    builder.append(present_tags_schema);
    if (present_tags_schema)
      builder.append(tags_schema);

    boolean present_requireFieldMatch = true && (isSetRequireFieldMatch());
    builder.append(present_requireFieldMatch);
    if (present_requireFieldMatch)
      builder.append(requireFieldMatch);

    return builder.toHashCode();
  }

  @Override
  public int compareTo(HighlightRequest other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetFields()).compareTo(other.isSetFields());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetFields()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.fields, other.fields);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetOrder()).compareTo(other.isSetOrder());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetOrder()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.order, other.order);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPre_tags()).compareTo(other.isSetPre_tags());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPre_tags()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.pre_tags, other.pre_tags);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPost_tags()).compareTo(other.isSetPost_tags());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPost_tags()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.post_tags, other.post_tags);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetTags_schema()).compareTo(other.isSetTags_schema());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTags_schema()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.tags_schema, other.tags_schema);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetRequireFieldMatch()).compareTo(other.isSetRequireFieldMatch());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetRequireFieldMatch()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.requireFieldMatch, other.requireFieldMatch);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("HighlightRequest(");
    boolean first = true;

    sb.append("fields:");
    if (this.fields == null) {
      sb.append("null");
    } else {
      sb.append(this.fields);
    }
    first = false;
    if (isSetOrder()) {
      if (!first) sb.append(", ");
      sb.append("order:");
      if (this.order == null) {
        sb.append("null");
      } else {
        sb.append(this.order);
      }
      first = false;
    }
    if (isSetPre_tags()) {
      if (!first) sb.append(", ");
      sb.append("pre_tags:");
      if (this.pre_tags == null) {
        sb.append("null");
      } else {
        sb.append(this.pre_tags);
      }
      first = false;
    }
    if (isSetPost_tags()) {
      if (!first) sb.append(", ");
      sb.append("post_tags:");
      if (this.post_tags == null) {
        sb.append("null");
      } else {
        sb.append(this.post_tags);
      }
      first = false;
    }
    if (isSetTags_schema()) {
      if (!first) sb.append(", ");
      sb.append("tags_schema:");
      if (this.tags_schema == null) {
        sb.append("null");
      } else {
        sb.append(this.tags_schema);
      }
      first = false;
    }
    if (isSetRequireFieldMatch()) {
      if (!first) sb.append(", ");
      sb.append("requireFieldMatch:");
      sb.append(this.requireFieldMatch);
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (fields == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'fields' was not present! Struct: " + toString());
    }
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class HighlightRequestStandardSchemeFactory implements SchemeFactory {
    public HighlightRequestStandardScheme getScheme() {
      return new HighlightRequestStandardScheme();
    }
  }

  private static class HighlightRequestStandardScheme extends StandardScheme<HighlightRequest> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, HighlightRequest struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // FIELDS
            if (schemeField.type == org.apache.thrift.protocol.TType.SET) {
              {
                org.apache.thrift.protocol.TSet _set10 = iprot.readSetBegin();
                struct.fields = new HashSet<HighlightedField>(2*_set10.size);
                for (int _i11 = 0; _i11 < _set10.size; ++_i11)
                {
                  HighlightedField _elem12;
                  _elem12 = new HighlightedField();
                  _elem12.read(iprot);
                  struct.fields.add(_elem12);
                }
                iprot.readSetEnd();
              }
              struct.setFieldsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // ORDER
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.order = iprot.readString();
              struct.setOrderIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // PRE_TAGS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list13 = iprot.readListBegin();
                struct.pre_tags = new ArrayList<String>(_list13.size);
                for (int _i14 = 0; _i14 < _list13.size; ++_i14)
                {
                  String _elem15;
                  _elem15 = iprot.readString();
                  struct.pre_tags.add(_elem15);
                }
                iprot.readListEnd();
              }
              struct.setPre_tagsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // POST_TAGS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list16 = iprot.readListBegin();
                struct.post_tags = new ArrayList<String>(_list16.size);
                for (int _i17 = 0; _i17 < _list16.size; ++_i17)
                {
                  String _elem18;
                  _elem18 = iprot.readString();
                  struct.post_tags.add(_elem18);
                }
                iprot.readListEnd();
              }
              struct.setPost_tagsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // TAGS_SCHEMA
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.tags_schema = iprot.readString();
              struct.setTags_schemaIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // REQUIRE_FIELD_MATCH
            if (schemeField.type == org.apache.thrift.protocol.TType.BOOL) {
              struct.requireFieldMatch = iprot.readBool();
              struct.setRequireFieldMatchIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, HighlightRequest struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.fields != null) {
        oprot.writeFieldBegin(FIELDS_FIELD_DESC);
        {
          oprot.writeSetBegin(new org.apache.thrift.protocol.TSet(org.apache.thrift.protocol.TType.STRUCT, struct.fields.size()));
          for (HighlightedField _iter19 : struct.fields)
          {
            _iter19.write(oprot);
          }
          oprot.writeSetEnd();
        }
        oprot.writeFieldEnd();
      }
      if (struct.order != null) {
        if (struct.isSetOrder()) {
          oprot.writeFieldBegin(ORDER_FIELD_DESC);
          oprot.writeString(struct.order);
          oprot.writeFieldEnd();
        }
      }
      if (struct.pre_tags != null) {
        if (struct.isSetPre_tags()) {
          oprot.writeFieldBegin(PRE_TAGS_FIELD_DESC);
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, struct.pre_tags.size()));
            for (String _iter20 : struct.pre_tags)
            {
              oprot.writeString(_iter20);
            }
            oprot.writeListEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      if (struct.post_tags != null) {
        if (struct.isSetPost_tags()) {
          oprot.writeFieldBegin(POST_TAGS_FIELD_DESC);
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, struct.post_tags.size()));
            for (String _iter21 : struct.post_tags)
            {
              oprot.writeString(_iter21);
            }
            oprot.writeListEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      if (struct.tags_schema != null) {
        if (struct.isSetTags_schema()) {
          oprot.writeFieldBegin(TAGS_SCHEMA_FIELD_DESC);
          oprot.writeString(struct.tags_schema);
          oprot.writeFieldEnd();
        }
      }
      if (struct.isSetRequireFieldMatch()) {
        oprot.writeFieldBegin(REQUIRE_FIELD_MATCH_FIELD_DESC);
        oprot.writeBool(struct.requireFieldMatch);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class HighlightRequestTupleSchemeFactory implements SchemeFactory {
    public HighlightRequestTupleScheme getScheme() {
      return new HighlightRequestTupleScheme();
    }
  }

  private static class HighlightRequestTupleScheme extends TupleScheme<HighlightRequest> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, HighlightRequest struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      {
        oprot.writeI32(struct.fields.size());
        for (HighlightedField _iter22 : struct.fields)
        {
          _iter22.write(oprot);
        }
      }
      BitSet optionals = new BitSet();
      if (struct.isSetOrder()) {
        optionals.set(0);
      }
      if (struct.isSetPre_tags()) {
        optionals.set(1);
      }
      if (struct.isSetPost_tags()) {
        optionals.set(2);
      }
      if (struct.isSetTags_schema()) {
        optionals.set(3);
      }
      if (struct.isSetRequireFieldMatch()) {
        optionals.set(4);
      }
      oprot.writeBitSet(optionals, 5);
      if (struct.isSetOrder()) {
        oprot.writeString(struct.order);
      }
      if (struct.isSetPre_tags()) {
        {
          oprot.writeI32(struct.pre_tags.size());
          for (String _iter23 : struct.pre_tags)
          {
            oprot.writeString(_iter23);
          }
        }
      }
      if (struct.isSetPost_tags()) {
        {
          oprot.writeI32(struct.post_tags.size());
          for (String _iter24 : struct.post_tags)
          {
            oprot.writeString(_iter24);
          }
        }
      }
      if (struct.isSetTags_schema()) {
        oprot.writeString(struct.tags_schema);
      }
      if (struct.isSetRequireFieldMatch()) {
        oprot.writeBool(struct.requireFieldMatch);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, HighlightRequest struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      {
        org.apache.thrift.protocol.TSet _set25 = new org.apache.thrift.protocol.TSet(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
        struct.fields = new HashSet<HighlightedField>(2*_set25.size);
        for (int _i26 = 0; _i26 < _set25.size; ++_i26)
        {
          HighlightedField _elem27;
          _elem27 = new HighlightedField();
          _elem27.read(iprot);
          struct.fields.add(_elem27);
        }
      }
      struct.setFieldsIsSet(true);
      BitSet incoming = iprot.readBitSet(5);
      if (incoming.get(0)) {
        struct.order = iprot.readString();
        struct.setOrderIsSet(true);
      }
      if (incoming.get(1)) {
        {
          org.apache.thrift.protocol.TList _list28 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, iprot.readI32());
          struct.pre_tags = new ArrayList<String>(_list28.size);
          for (int _i29 = 0; _i29 < _list28.size; ++_i29)
          {
            String _elem30;
            _elem30 = iprot.readString();
            struct.pre_tags.add(_elem30);
          }
        }
        struct.setPre_tagsIsSet(true);
      }
      if (incoming.get(2)) {
        {
          org.apache.thrift.protocol.TList _list31 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, iprot.readI32());
          struct.post_tags = new ArrayList<String>(_list31.size);
          for (int _i32 = 0; _i32 < _list31.size; ++_i32)
          {
            String _elem33;
            _elem33 = iprot.readString();
            struct.post_tags.add(_elem33);
          }
        }
        struct.setPost_tagsIsSet(true);
      }
      if (incoming.get(3)) {
        struct.tags_schema = iprot.readString();
        struct.setTags_schemaIsSet(true);
      }
      if (incoming.get(4)) {
        struct.requireFieldMatch = iprot.readBool();
        struct.setRequireFieldMatchIsSet(true);
      }
    }
  }

}

