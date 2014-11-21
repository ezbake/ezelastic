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

public class RangeFacetEntry implements org.apache.thrift.TBase<RangeFacetEntry, RangeFacetEntry._Fields>, java.io.Serializable, Cloneable, Comparable<RangeFacetEntry> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("RangeFacetEntry");

  private static final org.apache.thrift.protocol.TField FROM_FIELD_DESC = new org.apache.thrift.protocol.TField("from", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField TO_FIELD_DESC = new org.apache.thrift.protocol.TField("to", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField MIN_FIELD_DESC = new org.apache.thrift.protocol.TField("min", org.apache.thrift.protocol.TType.DOUBLE, (short)3);
  private static final org.apache.thrift.protocol.TField MAX_FIELD_DESC = new org.apache.thrift.protocol.TField("max", org.apache.thrift.protocol.TType.DOUBLE, (short)4);
  private static final org.apache.thrift.protocol.TField MEAN_FIELD_DESC = new org.apache.thrift.protocol.TField("mean", org.apache.thrift.protocol.TType.DOUBLE, (short)5);
  private static final org.apache.thrift.protocol.TField COUNT_FIELD_DESC = new org.apache.thrift.protocol.TField("count", org.apache.thrift.protocol.TType.I64, (short)6);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new RangeFacetEntryStandardSchemeFactory());
    schemes.put(TupleScheme.class, new RangeFacetEntryTupleSchemeFactory());
  }

  public String from; // required
  public String to; // required
  public double min; // required
  public double max; // required
  public double mean; // required
  public long count; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    FROM((short)1, "from"),
    TO((short)2, "to"),
    MIN((short)3, "min"),
    MAX((short)4, "max"),
    MEAN((short)5, "mean"),
    COUNT((short)6, "count");

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
        case 1: // FROM
          return FROM;
        case 2: // TO
          return TO;
        case 3: // MIN
          return MIN;
        case 4: // MAX
          return MAX;
        case 5: // MEAN
          return MEAN;
        case 6: // COUNT
          return COUNT;
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
  private static final int __MIN_ISSET_ID = 0;
  private static final int __MAX_ISSET_ID = 1;
  private static final int __MEAN_ISSET_ID = 2;
  private static final int __COUNT_ISSET_ID = 3;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.FROM, new org.apache.thrift.meta_data.FieldMetaData("from", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.TO, new org.apache.thrift.meta_data.FieldMetaData("to", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.MIN, new org.apache.thrift.meta_data.FieldMetaData("min", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    tmpMap.put(_Fields.MAX, new org.apache.thrift.meta_data.FieldMetaData("max", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    tmpMap.put(_Fields.MEAN, new org.apache.thrift.meta_data.FieldMetaData("mean", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    tmpMap.put(_Fields.COUNT, new org.apache.thrift.meta_data.FieldMetaData("count", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(RangeFacetEntry.class, metaDataMap);
  }

  public RangeFacetEntry() {
  }

  public RangeFacetEntry(
    String from,
    String to,
    double min,
    double max,
    double mean,
    long count)
  {
    this();
    this.from = from;
    this.to = to;
    this.min = min;
    setMinIsSet(true);
    this.max = max;
    setMaxIsSet(true);
    this.mean = mean;
    setMeanIsSet(true);
    this.count = count;
    setCountIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public RangeFacetEntry(RangeFacetEntry other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetFrom()) {
      this.from = other.from;
    }
    if (other.isSetTo()) {
      this.to = other.to;
    }
    this.min = other.min;
    this.max = other.max;
    this.mean = other.mean;
    this.count = other.count;
  }

  public RangeFacetEntry deepCopy() {
    return new RangeFacetEntry(this);
  }

  @Override
  public void clear() {
    this.from = null;
    this.to = null;
    setMinIsSet(false);
    this.min = 0.0;
    setMaxIsSet(false);
    this.max = 0.0;
    setMeanIsSet(false);
    this.mean = 0.0;
    setCountIsSet(false);
    this.count = 0;
  }

  public String getFrom() {
    return this.from;
  }

  public RangeFacetEntry setFrom(String from) {
    this.from = from;
    return this;
  }

  public void unsetFrom() {
    this.from = null;
  }

  /** Returns true if field from is set (has been assigned a value) and false otherwise */
  public boolean isSetFrom() {
    return this.from != null;
  }

  public void setFromIsSet(boolean value) {
    if (!value) {
      this.from = null;
    }
  }

  public String getTo() {
    return this.to;
  }

  public RangeFacetEntry setTo(String to) {
    this.to = to;
    return this;
  }

  public void unsetTo() {
    this.to = null;
  }

  /** Returns true if field to is set (has been assigned a value) and false otherwise */
  public boolean isSetTo() {
    return this.to != null;
  }

  public void setToIsSet(boolean value) {
    if (!value) {
      this.to = null;
    }
  }

  public double getMin() {
    return this.min;
  }

  public RangeFacetEntry setMin(double min) {
    this.min = min;
    setMinIsSet(true);
    return this;
  }

  public void unsetMin() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __MIN_ISSET_ID);
  }

  /** Returns true if field min is set (has been assigned a value) and false otherwise */
  public boolean isSetMin() {
    return EncodingUtils.testBit(__isset_bitfield, __MIN_ISSET_ID);
  }

  public void setMinIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __MIN_ISSET_ID, value);
  }

  public double getMax() {
    return this.max;
  }

  public RangeFacetEntry setMax(double max) {
    this.max = max;
    setMaxIsSet(true);
    return this;
  }

  public void unsetMax() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __MAX_ISSET_ID);
  }

  /** Returns true if field max is set (has been assigned a value) and false otherwise */
  public boolean isSetMax() {
    return EncodingUtils.testBit(__isset_bitfield, __MAX_ISSET_ID);
  }

  public void setMaxIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __MAX_ISSET_ID, value);
  }

  public double getMean() {
    return this.mean;
  }

  public RangeFacetEntry setMean(double mean) {
    this.mean = mean;
    setMeanIsSet(true);
    return this;
  }

  public void unsetMean() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __MEAN_ISSET_ID);
  }

  /** Returns true if field mean is set (has been assigned a value) and false otherwise */
  public boolean isSetMean() {
    return EncodingUtils.testBit(__isset_bitfield, __MEAN_ISSET_ID);
  }

  public void setMeanIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __MEAN_ISSET_ID, value);
  }

  public long getCount() {
    return this.count;
  }

  public RangeFacetEntry setCount(long count) {
    this.count = count;
    setCountIsSet(true);
    return this;
  }

  public void unsetCount() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __COUNT_ISSET_ID);
  }

  /** Returns true if field count is set (has been assigned a value) and false otherwise */
  public boolean isSetCount() {
    return EncodingUtils.testBit(__isset_bitfield, __COUNT_ISSET_ID);
  }

  public void setCountIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __COUNT_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case FROM:
      if (value == null) {
        unsetFrom();
      } else {
        setFrom((String)value);
      }
      break;

    case TO:
      if (value == null) {
        unsetTo();
      } else {
        setTo((String)value);
      }
      break;

    case MIN:
      if (value == null) {
        unsetMin();
      } else {
        setMin((Double)value);
      }
      break;

    case MAX:
      if (value == null) {
        unsetMax();
      } else {
        setMax((Double)value);
      }
      break;

    case MEAN:
      if (value == null) {
        unsetMean();
      } else {
        setMean((Double)value);
      }
      break;

    case COUNT:
      if (value == null) {
        unsetCount();
      } else {
        setCount((Long)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case FROM:
      return getFrom();

    case TO:
      return getTo();

    case MIN:
      return Double.valueOf(getMin());

    case MAX:
      return Double.valueOf(getMax());

    case MEAN:
      return Double.valueOf(getMean());

    case COUNT:
      return Long.valueOf(getCount());

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case FROM:
      return isSetFrom();
    case TO:
      return isSetTo();
    case MIN:
      return isSetMin();
    case MAX:
      return isSetMax();
    case MEAN:
      return isSetMean();
    case COUNT:
      return isSetCount();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof RangeFacetEntry)
      return this.equals((RangeFacetEntry)that);
    return false;
  }

  public boolean equals(RangeFacetEntry that) {
    if (that == null)
      return false;

    boolean this_present_from = true && this.isSetFrom();
    boolean that_present_from = true && that.isSetFrom();
    if (this_present_from || that_present_from) {
      if (!(this_present_from && that_present_from))
        return false;
      if (!this.from.equals(that.from))
        return false;
    }

    boolean this_present_to = true && this.isSetTo();
    boolean that_present_to = true && that.isSetTo();
    if (this_present_to || that_present_to) {
      if (!(this_present_to && that_present_to))
        return false;
      if (!this.to.equals(that.to))
        return false;
    }

    boolean this_present_min = true;
    boolean that_present_min = true;
    if (this_present_min || that_present_min) {
      if (!(this_present_min && that_present_min))
        return false;
      if (this.min != that.min)
        return false;
    }

    boolean this_present_max = true;
    boolean that_present_max = true;
    if (this_present_max || that_present_max) {
      if (!(this_present_max && that_present_max))
        return false;
      if (this.max != that.max)
        return false;
    }

    boolean this_present_mean = true;
    boolean that_present_mean = true;
    if (this_present_mean || that_present_mean) {
      if (!(this_present_mean && that_present_mean))
        return false;
      if (this.mean != that.mean)
        return false;
    }

    boolean this_present_count = true;
    boolean that_present_count = true;
    if (this_present_count || that_present_count) {
      if (!(this_present_count && that_present_count))
        return false;
      if (this.count != that.count)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    HashCodeBuilder builder = new HashCodeBuilder();

    boolean present_from = true && (isSetFrom());
    builder.append(present_from);
    if (present_from)
      builder.append(from);

    boolean present_to = true && (isSetTo());
    builder.append(present_to);
    if (present_to)
      builder.append(to);

    boolean present_min = true;
    builder.append(present_min);
    if (present_min)
      builder.append(min);

    boolean present_max = true;
    builder.append(present_max);
    if (present_max)
      builder.append(max);

    boolean present_mean = true;
    builder.append(present_mean);
    if (present_mean)
      builder.append(mean);

    boolean present_count = true;
    builder.append(present_count);
    if (present_count)
      builder.append(count);

    return builder.toHashCode();
  }

  @Override
  public int compareTo(RangeFacetEntry other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetFrom()).compareTo(other.isSetFrom());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetFrom()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.from, other.from);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetTo()).compareTo(other.isSetTo());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTo()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.to, other.to);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetMin()).compareTo(other.isSetMin());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMin()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.min, other.min);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetMax()).compareTo(other.isSetMax());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMax()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.max, other.max);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetMean()).compareTo(other.isSetMean());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMean()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.mean, other.mean);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetCount()).compareTo(other.isSetCount());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCount()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.count, other.count);
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
    StringBuilder sb = new StringBuilder("RangeFacetEntry(");
    boolean first = true;

    sb.append("from:");
    if (this.from == null) {
      sb.append("null");
    } else {
      sb.append(this.from);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("to:");
    if (this.to == null) {
      sb.append("null");
    } else {
      sb.append(this.to);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("min:");
    sb.append(this.min);
    first = false;
    if (!first) sb.append(", ");
    sb.append("max:");
    sb.append(this.max);
    first = false;
    if (!first) sb.append(", ");
    sb.append("mean:");
    sb.append(this.mean);
    first = false;
    if (!first) sb.append(", ");
    sb.append("count:");
    sb.append(this.count);
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
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class RangeFacetEntryStandardSchemeFactory implements SchemeFactory {
    public RangeFacetEntryStandardScheme getScheme() {
      return new RangeFacetEntryStandardScheme();
    }
  }

  private static class RangeFacetEntryStandardScheme extends StandardScheme<RangeFacetEntry> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, RangeFacetEntry struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // FROM
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.from = iprot.readString();
              struct.setFromIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // TO
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.to = iprot.readString();
              struct.setToIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // MIN
            if (schemeField.type == org.apache.thrift.protocol.TType.DOUBLE) {
              struct.min = iprot.readDouble();
              struct.setMinIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // MAX
            if (schemeField.type == org.apache.thrift.protocol.TType.DOUBLE) {
              struct.max = iprot.readDouble();
              struct.setMaxIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // MEAN
            if (schemeField.type == org.apache.thrift.protocol.TType.DOUBLE) {
              struct.mean = iprot.readDouble();
              struct.setMeanIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // COUNT
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.count = iprot.readI64();
              struct.setCountIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, RangeFacetEntry struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.from != null) {
        oprot.writeFieldBegin(FROM_FIELD_DESC);
        oprot.writeString(struct.from);
        oprot.writeFieldEnd();
      }
      if (struct.to != null) {
        oprot.writeFieldBegin(TO_FIELD_DESC);
        oprot.writeString(struct.to);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(MIN_FIELD_DESC);
      oprot.writeDouble(struct.min);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(MAX_FIELD_DESC);
      oprot.writeDouble(struct.max);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(MEAN_FIELD_DESC);
      oprot.writeDouble(struct.mean);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(COUNT_FIELD_DESC);
      oprot.writeI64(struct.count);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class RangeFacetEntryTupleSchemeFactory implements SchemeFactory {
    public RangeFacetEntryTupleScheme getScheme() {
      return new RangeFacetEntryTupleScheme();
    }
  }

  private static class RangeFacetEntryTupleScheme extends TupleScheme<RangeFacetEntry> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, RangeFacetEntry struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetFrom()) {
        optionals.set(0);
      }
      if (struct.isSetTo()) {
        optionals.set(1);
      }
      if (struct.isSetMin()) {
        optionals.set(2);
      }
      if (struct.isSetMax()) {
        optionals.set(3);
      }
      if (struct.isSetMean()) {
        optionals.set(4);
      }
      if (struct.isSetCount()) {
        optionals.set(5);
      }
      oprot.writeBitSet(optionals, 6);
      if (struct.isSetFrom()) {
        oprot.writeString(struct.from);
      }
      if (struct.isSetTo()) {
        oprot.writeString(struct.to);
      }
      if (struct.isSetMin()) {
        oprot.writeDouble(struct.min);
      }
      if (struct.isSetMax()) {
        oprot.writeDouble(struct.max);
      }
      if (struct.isSetMean()) {
        oprot.writeDouble(struct.mean);
      }
      if (struct.isSetCount()) {
        oprot.writeI64(struct.count);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, RangeFacetEntry struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(6);
      if (incoming.get(0)) {
        struct.from = iprot.readString();
        struct.setFromIsSet(true);
      }
      if (incoming.get(1)) {
        struct.to = iprot.readString();
        struct.setToIsSet(true);
      }
      if (incoming.get(2)) {
        struct.min = iprot.readDouble();
        struct.setMinIsSet(true);
      }
      if (incoming.get(3)) {
        struct.max = iprot.readDouble();
        struct.setMaxIsSet(true);
      }
      if (incoming.get(4)) {
        struct.mean = iprot.readDouble();
        struct.setMeanIsSet(true);
      }
      if (incoming.get(5)) {
        struct.count = iprot.readI64();
        struct.setCountIsSet(true);
      }
    }
  }

}

