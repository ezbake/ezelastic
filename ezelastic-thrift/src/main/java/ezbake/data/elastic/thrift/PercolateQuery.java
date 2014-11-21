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
 * A percolate query to be registered with the percolator
 */
public class PercolateQuery implements org.apache.thrift.TBase<PercolateQuery, PercolateQuery._Fields>, java.io.Serializable, Cloneable, Comparable<PercolateQuery> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("PercolateQuery");

  private static final org.apache.thrift.protocol.TField QUERY_DOCUMENT_FIELD_DESC = new org.apache.thrift.protocol.TField("queryDocument", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField VISIBILITY_FIELD_DESC = new org.apache.thrift.protocol.TField("visibility", org.apache.thrift.protocol.TType.STRUCT, (short)2);
  private static final org.apache.thrift.protocol.TField ID_FIELD_DESC = new org.apache.thrift.protocol.TField("id", org.apache.thrift.protocol.TType.STRING, (short)3);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new PercolateQueryStandardSchemeFactory());
    schemes.put(TupleScheme.class, new PercolateQueryTupleSchemeFactory());
  }

  /**
   * The query to register as an ES query
   */
  public String queryDocument; // optional
  /**
   * The visibility of this query
   */
  public ezbake.base.thrift.Visibility visibility; // optional
  /**
   * The id of this percolate query
   */
  public String id; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    /**
     * The query to register as an ES query
     */
    QUERY_DOCUMENT((short)1, "queryDocument"),
    /**
     * The visibility of this query
     */
    VISIBILITY((short)2, "visibility"),
    /**
     * The id of this percolate query
     */
    ID((short)3, "id");

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
        case 1: // QUERY_DOCUMENT
          return QUERY_DOCUMENT;
        case 2: // VISIBILITY
          return VISIBILITY;
        case 3: // ID
          return ID;
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
  private _Fields optionals[] = {_Fields.QUERY_DOCUMENT,_Fields.VISIBILITY,_Fields.ID};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.QUERY_DOCUMENT, new org.apache.thrift.meta_data.FieldMetaData("queryDocument", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.VISIBILITY, new org.apache.thrift.meta_data.FieldMetaData("visibility", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, ezbake.base.thrift.Visibility.class)));
    tmpMap.put(_Fields.ID, new org.apache.thrift.meta_data.FieldMetaData("id", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(PercolateQuery.class, metaDataMap);
  }

  public PercolateQuery() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public PercolateQuery(PercolateQuery other) {
    if (other.isSetQueryDocument()) {
      this.queryDocument = other.queryDocument;
    }
    if (other.isSetVisibility()) {
      this.visibility = new ezbake.base.thrift.Visibility(other.visibility);
    }
    if (other.isSetId()) {
      this.id = other.id;
    }
  }

  public PercolateQuery deepCopy() {
    return new PercolateQuery(this);
  }

  @Override
  public void clear() {
    this.queryDocument = null;
    this.visibility = null;
    this.id = null;
  }

  /**
   * The query to register as an ES query
   */
  public String getQueryDocument() {
    return this.queryDocument;
  }

  /**
   * The query to register as an ES query
   */
  public PercolateQuery setQueryDocument(String queryDocument) {
    this.queryDocument = queryDocument;
    return this;
  }

  public void unsetQueryDocument() {
    this.queryDocument = null;
  }

  /** Returns true if field queryDocument is set (has been assigned a value) and false otherwise */
  public boolean isSetQueryDocument() {
    return this.queryDocument != null;
  }

  public void setQueryDocumentIsSet(boolean value) {
    if (!value) {
      this.queryDocument = null;
    }
  }

  /**
   * The visibility of this query
   */
  public ezbake.base.thrift.Visibility getVisibility() {
    return this.visibility;
  }

  /**
   * The visibility of this query
   */
  public PercolateQuery setVisibility(ezbake.base.thrift.Visibility visibility) {
    this.visibility = visibility;
    return this;
  }

  public void unsetVisibility() {
    this.visibility = null;
  }

  /** Returns true if field visibility is set (has been assigned a value) and false otherwise */
  public boolean isSetVisibility() {
    return this.visibility != null;
  }

  public void setVisibilityIsSet(boolean value) {
    if (!value) {
      this.visibility = null;
    }
  }

  /**
   * The id of this percolate query
   */
  public String getId() {
    return this.id;
  }

  /**
   * The id of this percolate query
   */
  public PercolateQuery setId(String id) {
    this.id = id;
    return this;
  }

  public void unsetId() {
    this.id = null;
  }

  /** Returns true if field id is set (has been assigned a value) and false otherwise */
  public boolean isSetId() {
    return this.id != null;
  }

  public void setIdIsSet(boolean value) {
    if (!value) {
      this.id = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case QUERY_DOCUMENT:
      if (value == null) {
        unsetQueryDocument();
      } else {
        setQueryDocument((String)value);
      }
      break;

    case VISIBILITY:
      if (value == null) {
        unsetVisibility();
      } else {
        setVisibility((ezbake.base.thrift.Visibility)value);
      }
      break;

    case ID:
      if (value == null) {
        unsetId();
      } else {
        setId((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case QUERY_DOCUMENT:
      return getQueryDocument();

    case VISIBILITY:
      return getVisibility();

    case ID:
      return getId();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case QUERY_DOCUMENT:
      return isSetQueryDocument();
    case VISIBILITY:
      return isSetVisibility();
    case ID:
      return isSetId();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof PercolateQuery)
      return this.equals((PercolateQuery)that);
    return false;
  }

  public boolean equals(PercolateQuery that) {
    if (that == null)
      return false;

    boolean this_present_queryDocument = true && this.isSetQueryDocument();
    boolean that_present_queryDocument = true && that.isSetQueryDocument();
    if (this_present_queryDocument || that_present_queryDocument) {
      if (!(this_present_queryDocument && that_present_queryDocument))
        return false;
      if (!this.queryDocument.equals(that.queryDocument))
        return false;
    }

    boolean this_present_visibility = true && this.isSetVisibility();
    boolean that_present_visibility = true && that.isSetVisibility();
    if (this_present_visibility || that_present_visibility) {
      if (!(this_present_visibility && that_present_visibility))
        return false;
      if (!this.visibility.equals(that.visibility))
        return false;
    }

    boolean this_present_id = true && this.isSetId();
    boolean that_present_id = true && that.isSetId();
    if (this_present_id || that_present_id) {
      if (!(this_present_id && that_present_id))
        return false;
      if (!this.id.equals(that.id))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    HashCodeBuilder builder = new HashCodeBuilder();

    boolean present_queryDocument = true && (isSetQueryDocument());
    builder.append(present_queryDocument);
    if (present_queryDocument)
      builder.append(queryDocument);

    boolean present_visibility = true && (isSetVisibility());
    builder.append(present_visibility);
    if (present_visibility)
      builder.append(visibility);

    boolean present_id = true && (isSetId());
    builder.append(present_id);
    if (present_id)
      builder.append(id);

    return builder.toHashCode();
  }

  @Override
  public int compareTo(PercolateQuery other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetQueryDocument()).compareTo(other.isSetQueryDocument());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetQueryDocument()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.queryDocument, other.queryDocument);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetVisibility()).compareTo(other.isSetVisibility());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetVisibility()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.visibility, other.visibility);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetId()).compareTo(other.isSetId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.id, other.id);
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
    StringBuilder sb = new StringBuilder("PercolateQuery(");
    boolean first = true;

    if (isSetQueryDocument()) {
      sb.append("queryDocument:");
      if (this.queryDocument == null) {
        sb.append("null");
      } else {
        sb.append(this.queryDocument);
      }
      first = false;
    }
    if (isSetVisibility()) {
      if (!first) sb.append(", ");
      sb.append("visibility:");
      if (this.visibility == null) {
        sb.append("null");
      } else {
        sb.append(this.visibility);
      }
      first = false;
    }
    if (isSetId()) {
      if (!first) sb.append(", ");
      sb.append("id:");
      if (this.id == null) {
        sb.append("null");
      } else {
        sb.append(this.id);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
    if (visibility != null) {
      visibility.validate();
    }
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
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class PercolateQueryStandardSchemeFactory implements SchemeFactory {
    public PercolateQueryStandardScheme getScheme() {
      return new PercolateQueryStandardScheme();
    }
  }

  private static class PercolateQueryStandardScheme extends StandardScheme<PercolateQuery> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, PercolateQuery struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // QUERY_DOCUMENT
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.queryDocument = iprot.readString();
              struct.setQueryDocumentIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // VISIBILITY
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.visibility = new ezbake.base.thrift.Visibility();
              struct.visibility.read(iprot);
              struct.setVisibilityIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // ID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.id = iprot.readString();
              struct.setIdIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, PercolateQuery struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.queryDocument != null) {
        if (struct.isSetQueryDocument()) {
          oprot.writeFieldBegin(QUERY_DOCUMENT_FIELD_DESC);
          oprot.writeString(struct.queryDocument);
          oprot.writeFieldEnd();
        }
      }
      if (struct.visibility != null) {
        if (struct.isSetVisibility()) {
          oprot.writeFieldBegin(VISIBILITY_FIELD_DESC);
          struct.visibility.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      if (struct.id != null) {
        if (struct.isSetId()) {
          oprot.writeFieldBegin(ID_FIELD_DESC);
          oprot.writeString(struct.id);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class PercolateQueryTupleSchemeFactory implements SchemeFactory {
    public PercolateQueryTupleScheme getScheme() {
      return new PercolateQueryTupleScheme();
    }
  }

  private static class PercolateQueryTupleScheme extends TupleScheme<PercolateQuery> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, PercolateQuery struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetQueryDocument()) {
        optionals.set(0);
      }
      if (struct.isSetVisibility()) {
        optionals.set(1);
      }
      if (struct.isSetId()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetQueryDocument()) {
        oprot.writeString(struct.queryDocument);
      }
      if (struct.isSetVisibility()) {
        struct.visibility.write(oprot);
      }
      if (struct.isSetId()) {
        oprot.writeString(struct.id);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, PercolateQuery struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        struct.queryDocument = iprot.readString();
        struct.setQueryDocumentIsSet(true);
      }
      if (incoming.get(1)) {
        struct.visibility = new ezbake.base.thrift.Visibility();
        struct.visibility.read(iprot);
        struct.setVisibilityIsSet(true);
      }
      if (incoming.get(2)) {
        struct.id = iprot.readString();
        struct.setIdIsSet(true);
      }
    }
  }

}
