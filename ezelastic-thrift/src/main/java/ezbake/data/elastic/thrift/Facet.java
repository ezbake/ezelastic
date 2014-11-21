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

public class Facet implements org.apache.thrift.TBase<Facet, Facet._Fields>, java.io.Serializable, Cloneable, Comparable<Facet> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("Facet");

  private static final org.apache.thrift.protocol.TField LABEL_FIELD_DESC = new org.apache.thrift.protocol.TField("label", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField FACET_FIELD_DESC = new org.apache.thrift.protocol.TField("facet", org.apache.thrift.protocol.TType.STRUCT, (short)2);
  private static final org.apache.thrift.protocol.TField FILTER_JSON_FIELD_DESC = new org.apache.thrift.protocol.TField("filterJSON", org.apache.thrift.protocol.TType.STRING, (short)3);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new FacetStandardSchemeFactory());
    schemes.put(TupleScheme.class, new FacetTupleSchemeFactory());
  }

  public String label; // required
  public FacetRequest facet; // required
  public String filterJSON; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    LABEL((short)1, "label"),
    FACET((short)2, "facet"),
    FILTER_JSON((short)3, "filterJSON");

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
        case 1: // LABEL
          return LABEL;
        case 2: // FACET
          return FACET;
        case 3: // FILTER_JSON
          return FILTER_JSON;
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
  private _Fields optionals[] = {_Fields.FILTER_JSON};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.LABEL, new org.apache.thrift.meta_data.FieldMetaData("label", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.FACET, new org.apache.thrift.meta_data.FieldMetaData("facet", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, FacetRequest.class)));
    tmpMap.put(_Fields.FILTER_JSON, new org.apache.thrift.meta_data.FieldMetaData("filterJSON", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(Facet.class, metaDataMap);
  }

  public Facet() {
  }

  public Facet(
    String label,
    FacetRequest facet)
  {
    this();
    this.label = label;
    this.facet = facet;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Facet(Facet other) {
    if (other.isSetLabel()) {
      this.label = other.label;
    }
    if (other.isSetFacet()) {
      this.facet = new FacetRequest(other.facet);
    }
    if (other.isSetFilterJSON()) {
      this.filterJSON = other.filterJSON;
    }
  }

  public Facet deepCopy() {
    return new Facet(this);
  }

  @Override
  public void clear() {
    this.label = null;
    this.facet = null;
    this.filterJSON = null;
  }

  public String getLabel() {
    return this.label;
  }

  public Facet setLabel(String label) {
    this.label = label;
    return this;
  }

  public void unsetLabel() {
    this.label = null;
  }

  /** Returns true if field label is set (has been assigned a value) and false otherwise */
  public boolean isSetLabel() {
    return this.label != null;
  }

  public void setLabelIsSet(boolean value) {
    if (!value) {
      this.label = null;
    }
  }

  public FacetRequest getFacet() {
    return this.facet;
  }

  public Facet setFacet(FacetRequest facet) {
    this.facet = facet;
    return this;
  }

  public void unsetFacet() {
    this.facet = null;
  }

  /** Returns true if field facet is set (has been assigned a value) and false otherwise */
  public boolean isSetFacet() {
    return this.facet != null;
  }

  public void setFacetIsSet(boolean value) {
    if (!value) {
      this.facet = null;
    }
  }

  public String getFilterJSON() {
    return this.filterJSON;
  }

  public Facet setFilterJSON(String filterJSON) {
    this.filterJSON = filterJSON;
    return this;
  }

  public void unsetFilterJSON() {
    this.filterJSON = null;
  }

  /** Returns true if field filterJSON is set (has been assigned a value) and false otherwise */
  public boolean isSetFilterJSON() {
    return this.filterJSON != null;
  }

  public void setFilterJSONIsSet(boolean value) {
    if (!value) {
      this.filterJSON = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case LABEL:
      if (value == null) {
        unsetLabel();
      } else {
        setLabel((String)value);
      }
      break;

    case FACET:
      if (value == null) {
        unsetFacet();
      } else {
        setFacet((FacetRequest)value);
      }
      break;

    case FILTER_JSON:
      if (value == null) {
        unsetFilterJSON();
      } else {
        setFilterJSON((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case LABEL:
      return getLabel();

    case FACET:
      return getFacet();

    case FILTER_JSON:
      return getFilterJSON();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case LABEL:
      return isSetLabel();
    case FACET:
      return isSetFacet();
    case FILTER_JSON:
      return isSetFilterJSON();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof Facet)
      return this.equals((Facet)that);
    return false;
  }

  public boolean equals(Facet that) {
    if (that == null)
      return false;

    boolean this_present_label = true && this.isSetLabel();
    boolean that_present_label = true && that.isSetLabel();
    if (this_present_label || that_present_label) {
      if (!(this_present_label && that_present_label))
        return false;
      if (!this.label.equals(that.label))
        return false;
    }

    boolean this_present_facet = true && this.isSetFacet();
    boolean that_present_facet = true && that.isSetFacet();
    if (this_present_facet || that_present_facet) {
      if (!(this_present_facet && that_present_facet))
        return false;
      if (!this.facet.equals(that.facet))
        return false;
    }

    boolean this_present_filterJSON = true && this.isSetFilterJSON();
    boolean that_present_filterJSON = true && that.isSetFilterJSON();
    if (this_present_filterJSON || that_present_filterJSON) {
      if (!(this_present_filterJSON && that_present_filterJSON))
        return false;
      if (!this.filterJSON.equals(that.filterJSON))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    HashCodeBuilder builder = new HashCodeBuilder();

    boolean present_label = true && (isSetLabel());
    builder.append(present_label);
    if (present_label)
      builder.append(label);

    boolean present_facet = true && (isSetFacet());
    builder.append(present_facet);
    if (present_facet)
      builder.append(facet);

    boolean present_filterJSON = true && (isSetFilterJSON());
    builder.append(present_filterJSON);
    if (present_filterJSON)
      builder.append(filterJSON);

    return builder.toHashCode();
  }

  @Override
  public int compareTo(Facet other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetLabel()).compareTo(other.isSetLabel());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetLabel()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.label, other.label);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetFacet()).compareTo(other.isSetFacet());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetFacet()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.facet, other.facet);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetFilterJSON()).compareTo(other.isSetFilterJSON());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetFilterJSON()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.filterJSON, other.filterJSON);
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
    StringBuilder sb = new StringBuilder("Facet(");
    boolean first = true;

    sb.append("label:");
    if (this.label == null) {
      sb.append("null");
    } else {
      sb.append(this.label);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("facet:");
    if (this.facet == null) {
      sb.append("null");
    } else {
      sb.append(this.facet);
    }
    first = false;
    if (isSetFilterJSON()) {
      if (!first) sb.append(", ");
      sb.append("filterJSON:");
      if (this.filterJSON == null) {
        sb.append("null");
      } else {
        sb.append(this.filterJSON);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (label == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'label' was not present! Struct: " + toString());
    }
    if (facet == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'facet' was not present! Struct: " + toString());
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
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class FacetStandardSchemeFactory implements SchemeFactory {
    public FacetStandardScheme getScheme() {
      return new FacetStandardScheme();
    }
  }

  private static class FacetStandardScheme extends StandardScheme<Facet> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, Facet struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // LABEL
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.label = iprot.readString();
              struct.setLabelIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // FACET
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.facet = new FacetRequest();
              struct.facet.read(iprot);
              struct.setFacetIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // FILTER_JSON
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.filterJSON = iprot.readString();
              struct.setFilterJSONIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, Facet struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.label != null) {
        oprot.writeFieldBegin(LABEL_FIELD_DESC);
        oprot.writeString(struct.label);
        oprot.writeFieldEnd();
      }
      if (struct.facet != null) {
        oprot.writeFieldBegin(FACET_FIELD_DESC);
        struct.facet.write(oprot);
        oprot.writeFieldEnd();
      }
      if (struct.filterJSON != null) {
        if (struct.isSetFilterJSON()) {
          oprot.writeFieldBegin(FILTER_JSON_FIELD_DESC);
          oprot.writeString(struct.filterJSON);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class FacetTupleSchemeFactory implements SchemeFactory {
    public FacetTupleScheme getScheme() {
      return new FacetTupleScheme();
    }
  }

  private static class FacetTupleScheme extends TupleScheme<Facet> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, Facet struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeString(struct.label);
      struct.facet.write(oprot);
      BitSet optionals = new BitSet();
      if (struct.isSetFilterJSON()) {
        optionals.set(0);
      }
      oprot.writeBitSet(optionals, 1);
      if (struct.isSetFilterJSON()) {
        oprot.writeString(struct.filterJSON);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, Facet struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.label = iprot.readString();
      struct.setLabelIsSet(true);
      struct.facet = new FacetRequest();
      struct.facet.read(iprot);
      struct.setFacetIsSet(true);
      BitSet incoming = iprot.readBitSet(1);
      if (incoming.get(0)) {
        struct.filterJSON = iprot.readString();
        struct.setFilterJSONIsSet(true);
      }
    }
  }

}
