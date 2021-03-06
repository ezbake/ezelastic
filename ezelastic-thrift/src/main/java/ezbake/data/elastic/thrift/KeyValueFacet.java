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

public class KeyValueFacet implements org.apache.thrift.TBase<KeyValueFacet, KeyValueFacet._Fields>, java.io.Serializable, Cloneable, Comparable<KeyValueFacet> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("KeyValueFacet");

  private static final org.apache.thrift.protocol.TField KEY_FIELD_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("key_field_name", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField VALUE_FIELD_FIELD_DESC = new org.apache.thrift.protocol.TField("value_field", org.apache.thrift.protocol.TType.STRING, (short)2);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new KeyValueFacetStandardSchemeFactory());
    schemes.put(TupleScheme.class, new KeyValueFacetTupleSchemeFactory());
  }

  public String key_field_name; // required
  public String value_field; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    KEY_FIELD_NAME((short)1, "key_field_name"),
    VALUE_FIELD((short)2, "value_field");

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
        case 1: // KEY_FIELD_NAME
          return KEY_FIELD_NAME;
        case 2: // VALUE_FIELD
          return VALUE_FIELD;
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
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.KEY_FIELD_NAME, new org.apache.thrift.meta_data.FieldMetaData("key_field_name", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.VALUE_FIELD, new org.apache.thrift.meta_data.FieldMetaData("value_field", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(KeyValueFacet.class, metaDataMap);
  }

  public KeyValueFacet() {
  }

  public KeyValueFacet(
    String key_field_name,
    String value_field)
  {
    this();
    this.key_field_name = key_field_name;
    this.value_field = value_field;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public KeyValueFacet(KeyValueFacet other) {
    if (other.isSetKey_field_name()) {
      this.key_field_name = other.key_field_name;
    }
    if (other.isSetValue_field()) {
      this.value_field = other.value_field;
    }
  }

  public KeyValueFacet deepCopy() {
    return new KeyValueFacet(this);
  }

  @Override
  public void clear() {
    this.key_field_name = null;
    this.value_field = null;
  }

  public String getKey_field_name() {
    return this.key_field_name;
  }

  public KeyValueFacet setKey_field_name(String key_field_name) {
    this.key_field_name = key_field_name;
    return this;
  }

  public void unsetKey_field_name() {
    this.key_field_name = null;
  }

  /** Returns true if field key_field_name is set (has been assigned a value) and false otherwise */
  public boolean isSetKey_field_name() {
    return this.key_field_name != null;
  }

  public void setKey_field_nameIsSet(boolean value) {
    if (!value) {
      this.key_field_name = null;
    }
  }

  public String getValue_field() {
    return this.value_field;
  }

  public KeyValueFacet setValue_field(String value_field) {
    this.value_field = value_field;
    return this;
  }

  public void unsetValue_field() {
    this.value_field = null;
  }

  /** Returns true if field value_field is set (has been assigned a value) and false otherwise */
  public boolean isSetValue_field() {
    return this.value_field != null;
  }

  public void setValue_fieldIsSet(boolean value) {
    if (!value) {
      this.value_field = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case KEY_FIELD_NAME:
      if (value == null) {
        unsetKey_field_name();
      } else {
        setKey_field_name((String)value);
      }
      break;

    case VALUE_FIELD:
      if (value == null) {
        unsetValue_field();
      } else {
        setValue_field((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case KEY_FIELD_NAME:
      return getKey_field_name();

    case VALUE_FIELD:
      return getValue_field();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case KEY_FIELD_NAME:
      return isSetKey_field_name();
    case VALUE_FIELD:
      return isSetValue_field();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof KeyValueFacet)
      return this.equals((KeyValueFacet)that);
    return false;
  }

  public boolean equals(KeyValueFacet that) {
    if (that == null)
      return false;

    boolean this_present_key_field_name = true && this.isSetKey_field_name();
    boolean that_present_key_field_name = true && that.isSetKey_field_name();
    if (this_present_key_field_name || that_present_key_field_name) {
      if (!(this_present_key_field_name && that_present_key_field_name))
        return false;
      if (!this.key_field_name.equals(that.key_field_name))
        return false;
    }

    boolean this_present_value_field = true && this.isSetValue_field();
    boolean that_present_value_field = true && that.isSetValue_field();
    if (this_present_value_field || that_present_value_field) {
      if (!(this_present_value_field && that_present_value_field))
        return false;
      if (!this.value_field.equals(that.value_field))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    HashCodeBuilder builder = new HashCodeBuilder();

    boolean present_key_field_name = true && (isSetKey_field_name());
    builder.append(present_key_field_name);
    if (present_key_field_name)
      builder.append(key_field_name);

    boolean present_value_field = true && (isSetValue_field());
    builder.append(present_value_field);
    if (present_value_field)
      builder.append(value_field);

    return builder.toHashCode();
  }

  @Override
  public int compareTo(KeyValueFacet other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetKey_field_name()).compareTo(other.isSetKey_field_name());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetKey_field_name()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.key_field_name, other.key_field_name);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetValue_field()).compareTo(other.isSetValue_field());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetValue_field()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.value_field, other.value_field);
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
    StringBuilder sb = new StringBuilder("KeyValueFacet(");
    boolean first = true;

    sb.append("key_field_name:");
    if (this.key_field_name == null) {
      sb.append("null");
    } else {
      sb.append(this.key_field_name);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("value_field:");
    if (this.value_field == null) {
      sb.append("null");
    } else {
      sb.append(this.value_field);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (key_field_name == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'key_field_name' was not present! Struct: " + toString());
    }
    if (value_field == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'value_field' was not present! Struct: " + toString());
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

  private static class KeyValueFacetStandardSchemeFactory implements SchemeFactory {
    public KeyValueFacetStandardScheme getScheme() {
      return new KeyValueFacetStandardScheme();
    }
  }

  private static class KeyValueFacetStandardScheme extends StandardScheme<KeyValueFacet> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, KeyValueFacet struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // KEY_FIELD_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.key_field_name = iprot.readString();
              struct.setKey_field_nameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // VALUE_FIELD
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.value_field = iprot.readString();
              struct.setValue_fieldIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, KeyValueFacet struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.key_field_name != null) {
        oprot.writeFieldBegin(KEY_FIELD_NAME_FIELD_DESC);
        oprot.writeString(struct.key_field_name);
        oprot.writeFieldEnd();
      }
      if (struct.value_field != null) {
        oprot.writeFieldBegin(VALUE_FIELD_FIELD_DESC);
        oprot.writeString(struct.value_field);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class KeyValueFacetTupleSchemeFactory implements SchemeFactory {
    public KeyValueFacetTupleScheme getScheme() {
      return new KeyValueFacetTupleScheme();
    }
  }

  private static class KeyValueFacetTupleScheme extends TupleScheme<KeyValueFacet> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, KeyValueFacet struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeString(struct.key_field_name);
      oprot.writeString(struct.value_field);
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, KeyValueFacet struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.key_field_name = iprot.readString();
      struct.setKey_field_nameIsSet(true);
      struct.value_field = iprot.readString();
      struct.setValue_fieldIsSet(true);
    }
  }

}

