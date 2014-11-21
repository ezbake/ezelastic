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

public class TermsStatsFacetResult implements org.apache.thrift.TBase<TermsStatsFacetResult, TermsStatsFacetResult._Fields>, java.io.Serializable, Cloneable, Comparable<TermsStatsFacetResult> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TermsStatsFacetResult");

  private static final org.apache.thrift.protocol.TField ENTRIES_FIELD_DESC = new org.apache.thrift.protocol.TField("entries", org.apache.thrift.protocol.TType.LIST, (short)1);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new TermsStatsFacetResultStandardSchemeFactory());
    schemes.put(TupleScheme.class, new TermsStatsFacetResultTupleSchemeFactory());
  }

  public List<TermsStatsFacetResultEntry> entries; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    ENTRIES((short)1, "entries");

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
        case 1: // ENTRIES
          return ENTRIES;
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
    tmpMap.put(_Fields.ENTRIES, new org.apache.thrift.meta_data.FieldMetaData("entries", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, TermsStatsFacetResultEntry.class))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TermsStatsFacetResult.class, metaDataMap);
  }

  public TermsStatsFacetResult() {
  }

  public TermsStatsFacetResult(
    List<TermsStatsFacetResultEntry> entries)
  {
    this();
    this.entries = entries;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TermsStatsFacetResult(TermsStatsFacetResult other) {
    if (other.isSetEntries()) {
      List<TermsStatsFacetResultEntry> __this__entries = new ArrayList<TermsStatsFacetResultEntry>(other.entries.size());
      for (TermsStatsFacetResultEntry other_element : other.entries) {
        __this__entries.add(new TermsStatsFacetResultEntry(other_element));
      }
      this.entries = __this__entries;
    }
  }

  public TermsStatsFacetResult deepCopy() {
    return new TermsStatsFacetResult(this);
  }

  @Override
  public void clear() {
    this.entries = null;
  }

  public int getEntriesSize() {
    return (this.entries == null) ? 0 : this.entries.size();
  }

  public java.util.Iterator<TermsStatsFacetResultEntry> getEntriesIterator() {
    return (this.entries == null) ? null : this.entries.iterator();
  }

  public void addToEntries(TermsStatsFacetResultEntry elem) {
    if (this.entries == null) {
      this.entries = new ArrayList<TermsStatsFacetResultEntry>();
    }
    this.entries.add(elem);
  }

  public List<TermsStatsFacetResultEntry> getEntries() {
    return this.entries;
  }

  public TermsStatsFacetResult setEntries(List<TermsStatsFacetResultEntry> entries) {
    this.entries = entries;
    return this;
  }

  public void unsetEntries() {
    this.entries = null;
  }

  /** Returns true if field entries is set (has been assigned a value) and false otherwise */
  public boolean isSetEntries() {
    return this.entries != null;
  }

  public void setEntriesIsSet(boolean value) {
    if (!value) {
      this.entries = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case ENTRIES:
      if (value == null) {
        unsetEntries();
      } else {
        setEntries((List<TermsStatsFacetResultEntry>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case ENTRIES:
      return getEntries();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case ENTRIES:
      return isSetEntries();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof TermsStatsFacetResult)
      return this.equals((TermsStatsFacetResult)that);
    return false;
  }

  public boolean equals(TermsStatsFacetResult that) {
    if (that == null)
      return false;

    boolean this_present_entries = true && this.isSetEntries();
    boolean that_present_entries = true && that.isSetEntries();
    if (this_present_entries || that_present_entries) {
      if (!(this_present_entries && that_present_entries))
        return false;
      if (!this.entries.equals(that.entries))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    HashCodeBuilder builder = new HashCodeBuilder();

    boolean present_entries = true && (isSetEntries());
    builder.append(present_entries);
    if (present_entries)
      builder.append(entries);

    return builder.toHashCode();
  }

  @Override
  public int compareTo(TermsStatsFacetResult other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetEntries()).compareTo(other.isSetEntries());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetEntries()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.entries, other.entries);
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
    StringBuilder sb = new StringBuilder("TermsStatsFacetResult(");
    boolean first = true;

    sb.append("entries:");
    if (this.entries == null) {
      sb.append("null");
    } else {
      sb.append(this.entries);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
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

  private static class TermsStatsFacetResultStandardSchemeFactory implements SchemeFactory {
    public TermsStatsFacetResultStandardScheme getScheme() {
      return new TermsStatsFacetResultStandardScheme();
    }
  }

  private static class TermsStatsFacetResultStandardScheme extends StandardScheme<TermsStatsFacetResult> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, TermsStatsFacetResult struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // ENTRIES
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list104 = iprot.readListBegin();
                struct.entries = new ArrayList<TermsStatsFacetResultEntry>(_list104.size);
                for (int _i105 = 0; _i105 < _list104.size; ++_i105)
                {
                  TermsStatsFacetResultEntry _elem106;
                  _elem106 = new TermsStatsFacetResultEntry();
                  _elem106.read(iprot);
                  struct.entries.add(_elem106);
                }
                iprot.readListEnd();
              }
              struct.setEntriesIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, TermsStatsFacetResult struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.entries != null) {
        oprot.writeFieldBegin(ENTRIES_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.entries.size()));
          for (TermsStatsFacetResultEntry _iter107 : struct.entries)
          {
            _iter107.write(oprot);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TermsStatsFacetResultTupleSchemeFactory implements SchemeFactory {
    public TermsStatsFacetResultTupleScheme getScheme() {
      return new TermsStatsFacetResultTupleScheme();
    }
  }

  private static class TermsStatsFacetResultTupleScheme extends TupleScheme<TermsStatsFacetResult> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TermsStatsFacetResult struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetEntries()) {
        optionals.set(0);
      }
      oprot.writeBitSet(optionals, 1);
      if (struct.isSetEntries()) {
        {
          oprot.writeI32(struct.entries.size());
          for (TermsStatsFacetResultEntry _iter108 : struct.entries)
          {
            _iter108.write(oprot);
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TermsStatsFacetResult struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(1);
      if (incoming.get(0)) {
        {
          org.apache.thrift.protocol.TList _list109 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.entries = new ArrayList<TermsStatsFacetResultEntry>(_list109.size);
          for (int _i110 = 0; _i110 < _list109.size; ++_i110)
          {
            TermsStatsFacetResultEntry _elem111;
            _elem111 = new TermsStatsFacetResultEntry();
            _elem111.read(iprot);
            struct.entries.add(_elem111);
          }
        }
        struct.setEntriesIsSet(true);
      }
    }
  }

}
