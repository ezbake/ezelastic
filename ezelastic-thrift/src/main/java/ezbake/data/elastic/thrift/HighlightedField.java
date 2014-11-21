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
 * A field to return for highlighting including parameters for surrounding fragments to return.
 */
public class HighlightedField implements org.apache.thrift.TBase<HighlightedField, HighlightedField._Fields>, java.io.Serializable, Cloneable, Comparable<HighlightedField> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("HighlightedField");

  private static final org.apache.thrift.protocol.TField FIELD_FIELD_DESC = new org.apache.thrift.protocol.TField("field", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField FRAGMENT_SIZE_FIELD_DESC = new org.apache.thrift.protocol.TField("fragmentSize", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField NUMBER_OF_FRAGMENTS_FIELD_DESC = new org.apache.thrift.protocol.TField("numberOfFragments", org.apache.thrift.protocol.TType.I32, (short)3);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new HighlightedFieldStandardSchemeFactory());
    schemes.put(TupleScheme.class, new HighlightedFieldTupleSchemeFactory());
  }

  /**
   * Name of the field to highlight
   */
  public String field; // required
  /**
   * Approximate characters to return for the fragment
   */
  public int fragmentSize; // optional
  /**
   * Number of fragments
   */
  public int numberOfFragments; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    /**
     * Name of the field to highlight
     */
    FIELD((short)1, "field"),
    /**
     * Approximate characters to return for the fragment
     */
    FRAGMENT_SIZE((short)2, "fragmentSize"),
    /**
     * Number of fragments
     */
    NUMBER_OF_FRAGMENTS((short)3, "numberOfFragments");

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
        case 1: // FIELD
          return FIELD;
        case 2: // FRAGMENT_SIZE
          return FRAGMENT_SIZE;
        case 3: // NUMBER_OF_FRAGMENTS
          return NUMBER_OF_FRAGMENTS;
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
  private static final int __FRAGMENTSIZE_ISSET_ID = 0;
  private static final int __NUMBEROFFRAGMENTS_ISSET_ID = 1;
  private byte __isset_bitfield = 0;
  private _Fields optionals[] = {_Fields.FRAGMENT_SIZE,_Fields.NUMBER_OF_FRAGMENTS};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.FIELD, new org.apache.thrift.meta_data.FieldMetaData("field", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.FRAGMENT_SIZE, new org.apache.thrift.meta_data.FieldMetaData("fragmentSize", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.NUMBER_OF_FRAGMENTS, new org.apache.thrift.meta_data.FieldMetaData("numberOfFragments", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(HighlightedField.class, metaDataMap);
  }

  public HighlightedField() {
    this.fragmentSize = 100;

    this.numberOfFragments = 5;

  }

  public HighlightedField(
    String field)
  {
    this();
    this.field = field;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public HighlightedField(HighlightedField other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetField()) {
      this.field = other.field;
    }
    this.fragmentSize = other.fragmentSize;
    this.numberOfFragments = other.numberOfFragments;
  }

  public HighlightedField deepCopy() {
    return new HighlightedField(this);
  }

  @Override
  public void clear() {
    this.field = null;
    this.fragmentSize = 100;

    this.numberOfFragments = 5;

  }

  /**
   * Name of the field to highlight
   */
  public String getField() {
    return this.field;
  }

  /**
   * Name of the field to highlight
   */
  public HighlightedField setField(String field) {
    this.field = field;
    return this;
  }

  public void unsetField() {
    this.field = null;
  }

  /** Returns true if field field is set (has been assigned a value) and false otherwise */
  public boolean isSetField() {
    return this.field != null;
  }

  public void setFieldIsSet(boolean value) {
    if (!value) {
      this.field = null;
    }
  }

  /**
   * Approximate characters to return for the fragment
   */
  public int getFragmentSize() {
    return this.fragmentSize;
  }

  /**
   * Approximate characters to return for the fragment
   */
  public HighlightedField setFragmentSize(int fragmentSize) {
    this.fragmentSize = fragmentSize;
    setFragmentSizeIsSet(true);
    return this;
  }

  public void unsetFragmentSize() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __FRAGMENTSIZE_ISSET_ID);
  }

  /** Returns true if field fragmentSize is set (has been assigned a value) and false otherwise */
  public boolean isSetFragmentSize() {
    return EncodingUtils.testBit(__isset_bitfield, __FRAGMENTSIZE_ISSET_ID);
  }

  public void setFragmentSizeIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __FRAGMENTSIZE_ISSET_ID, value);
  }

  /**
   * Number of fragments
   */
  public int getNumberOfFragments() {
    return this.numberOfFragments;
  }

  /**
   * Number of fragments
   */
  public HighlightedField setNumberOfFragments(int numberOfFragments) {
    this.numberOfFragments = numberOfFragments;
    setNumberOfFragmentsIsSet(true);
    return this;
  }

  public void unsetNumberOfFragments() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __NUMBEROFFRAGMENTS_ISSET_ID);
  }

  /** Returns true if field numberOfFragments is set (has been assigned a value) and false otherwise */
  public boolean isSetNumberOfFragments() {
    return EncodingUtils.testBit(__isset_bitfield, __NUMBEROFFRAGMENTS_ISSET_ID);
  }

  public void setNumberOfFragmentsIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __NUMBEROFFRAGMENTS_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case FIELD:
      if (value == null) {
        unsetField();
      } else {
        setField((String)value);
      }
      break;

    case FRAGMENT_SIZE:
      if (value == null) {
        unsetFragmentSize();
      } else {
        setFragmentSize((Integer)value);
      }
      break;

    case NUMBER_OF_FRAGMENTS:
      if (value == null) {
        unsetNumberOfFragments();
      } else {
        setNumberOfFragments((Integer)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case FIELD:
      return getField();

    case FRAGMENT_SIZE:
      return Integer.valueOf(getFragmentSize());

    case NUMBER_OF_FRAGMENTS:
      return Integer.valueOf(getNumberOfFragments());

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case FIELD:
      return isSetField();
    case FRAGMENT_SIZE:
      return isSetFragmentSize();
    case NUMBER_OF_FRAGMENTS:
      return isSetNumberOfFragments();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof HighlightedField)
      return this.equals((HighlightedField)that);
    return false;
  }

  public boolean equals(HighlightedField that) {
    if (that == null)
      return false;

    boolean this_present_field = true && this.isSetField();
    boolean that_present_field = true && that.isSetField();
    if (this_present_field || that_present_field) {
      if (!(this_present_field && that_present_field))
        return false;
      if (!this.field.equals(that.field))
        return false;
    }

    boolean this_present_fragmentSize = true && this.isSetFragmentSize();
    boolean that_present_fragmentSize = true && that.isSetFragmentSize();
    if (this_present_fragmentSize || that_present_fragmentSize) {
      if (!(this_present_fragmentSize && that_present_fragmentSize))
        return false;
      if (this.fragmentSize != that.fragmentSize)
        return false;
    }

    boolean this_present_numberOfFragments = true && this.isSetNumberOfFragments();
    boolean that_present_numberOfFragments = true && that.isSetNumberOfFragments();
    if (this_present_numberOfFragments || that_present_numberOfFragments) {
      if (!(this_present_numberOfFragments && that_present_numberOfFragments))
        return false;
      if (this.numberOfFragments != that.numberOfFragments)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    HashCodeBuilder builder = new HashCodeBuilder();

    boolean present_field = true && (isSetField());
    builder.append(present_field);
    if (present_field)
      builder.append(field);

    boolean present_fragmentSize = true && (isSetFragmentSize());
    builder.append(present_fragmentSize);
    if (present_fragmentSize)
      builder.append(fragmentSize);

    boolean present_numberOfFragments = true && (isSetNumberOfFragments());
    builder.append(present_numberOfFragments);
    if (present_numberOfFragments)
      builder.append(numberOfFragments);

    return builder.toHashCode();
  }

  @Override
  public int compareTo(HighlightedField other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetField()).compareTo(other.isSetField());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetField()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.field, other.field);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetFragmentSize()).compareTo(other.isSetFragmentSize());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetFragmentSize()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.fragmentSize, other.fragmentSize);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetNumberOfFragments()).compareTo(other.isSetNumberOfFragments());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetNumberOfFragments()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.numberOfFragments, other.numberOfFragments);
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
    StringBuilder sb = new StringBuilder("HighlightedField(");
    boolean first = true;

    sb.append("field:");
    if (this.field == null) {
      sb.append("null");
    } else {
      sb.append(this.field);
    }
    first = false;
    if (isSetFragmentSize()) {
      if (!first) sb.append(", ");
      sb.append("fragmentSize:");
      sb.append(this.fragmentSize);
      first = false;
    }
    if (isSetNumberOfFragments()) {
      if (!first) sb.append(", ");
      sb.append("numberOfFragments:");
      sb.append(this.numberOfFragments);
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (field == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'field' was not present! Struct: " + toString());
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

  private static class HighlightedFieldStandardSchemeFactory implements SchemeFactory {
    public HighlightedFieldStandardScheme getScheme() {
      return new HighlightedFieldStandardScheme();
    }
  }

  private static class HighlightedFieldStandardScheme extends StandardScheme<HighlightedField> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, HighlightedField struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // FIELD
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.field = iprot.readString();
              struct.setFieldIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // FRAGMENT_SIZE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.fragmentSize = iprot.readI32();
              struct.setFragmentSizeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // NUMBER_OF_FRAGMENTS
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.numberOfFragments = iprot.readI32();
              struct.setNumberOfFragmentsIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, HighlightedField struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.field != null) {
        oprot.writeFieldBegin(FIELD_FIELD_DESC);
        oprot.writeString(struct.field);
        oprot.writeFieldEnd();
      }
      if (struct.isSetFragmentSize()) {
        oprot.writeFieldBegin(FRAGMENT_SIZE_FIELD_DESC);
        oprot.writeI32(struct.fragmentSize);
        oprot.writeFieldEnd();
      }
      if (struct.isSetNumberOfFragments()) {
        oprot.writeFieldBegin(NUMBER_OF_FRAGMENTS_FIELD_DESC);
        oprot.writeI32(struct.numberOfFragments);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class HighlightedFieldTupleSchemeFactory implements SchemeFactory {
    public HighlightedFieldTupleScheme getScheme() {
      return new HighlightedFieldTupleScheme();
    }
  }

  private static class HighlightedFieldTupleScheme extends TupleScheme<HighlightedField> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, HighlightedField struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeString(struct.field);
      BitSet optionals = new BitSet();
      if (struct.isSetFragmentSize()) {
        optionals.set(0);
      }
      if (struct.isSetNumberOfFragments()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetFragmentSize()) {
        oprot.writeI32(struct.fragmentSize);
      }
      if (struct.isSetNumberOfFragments()) {
        oprot.writeI32(struct.numberOfFragments);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, HighlightedField struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.field = iprot.readString();
      struct.setFieldIsSet(true);
      BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.fragmentSize = iprot.readI32();
        struct.setFragmentSizeIsSet(true);
      }
      if (incoming.get(1)) {
        struct.numberOfFragments = iprot.readI32();
        struct.setNumberOfFragmentsIsSet(true);
      }
    }
  }

}

