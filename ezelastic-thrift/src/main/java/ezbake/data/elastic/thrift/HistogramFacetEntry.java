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

public class HistogramFacetEntry implements org.apache.thrift.TBase<HistogramFacetEntry, HistogramFacetEntry._Fields>, java.io.Serializable, Cloneable, Comparable<HistogramFacetEntry> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("HistogramFacetEntry");

  private static final org.apache.thrift.protocol.TField KEY_FIELD_DESC = new org.apache.thrift.protocol.TField("key", org.apache.thrift.protocol.TType.I64, (short)1);
  private static final org.apache.thrift.protocol.TField COUNT_FIELD_DESC = new org.apache.thrift.protocol.TField("count", org.apache.thrift.protocol.TType.I64, (short)2);
  private static final org.apache.thrift.protocol.TField MEAN_FIELD_DESC = new org.apache.thrift.protocol.TField("mean", org.apache.thrift.protocol.TType.DOUBLE, (short)3);
  private static final org.apache.thrift.protocol.TField MIN_FIELD_DESC = new org.apache.thrift.protocol.TField("min", org.apache.thrift.protocol.TType.DOUBLE, (short)4);
  private static final org.apache.thrift.protocol.TField MAX_FIELD_DESC = new org.apache.thrift.protocol.TField("max", org.apache.thrift.protocol.TType.DOUBLE, (short)5);
  private static final org.apache.thrift.protocol.TField TOTAL_FIELD_DESC = new org.apache.thrift.protocol.TField("total", org.apache.thrift.protocol.TType.DOUBLE, (short)6);
  private static final org.apache.thrift.protocol.TField TOTAL_COUNT_FIELD_DESC = new org.apache.thrift.protocol.TField("totalCount", org.apache.thrift.protocol.TType.I64, (short)7);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new HistogramFacetEntryStandardSchemeFactory());
    schemes.put(TupleScheme.class, new HistogramFacetEntryTupleSchemeFactory());
  }

  public long key; // required
  public long count; // required
  public double mean; // required
  public double min; // required
  public double max; // required
  public double total; // required
  public long totalCount; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    KEY((short)1, "key"),
    COUNT((short)2, "count"),
    MEAN((short)3, "mean"),
    MIN((short)4, "min"),
    MAX((short)5, "max"),
    TOTAL((short)6, "total"),
    TOTAL_COUNT((short)7, "totalCount");

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
        case 1: // KEY
          return KEY;
        case 2: // COUNT
          return COUNT;
        case 3: // MEAN
          return MEAN;
        case 4: // MIN
          return MIN;
        case 5: // MAX
          return MAX;
        case 6: // TOTAL
          return TOTAL;
        case 7: // TOTAL_COUNT
          return TOTAL_COUNT;
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
  private static final int __KEY_ISSET_ID = 0;
  private static final int __COUNT_ISSET_ID = 1;
  private static final int __MEAN_ISSET_ID = 2;
  private static final int __MIN_ISSET_ID = 3;
  private static final int __MAX_ISSET_ID = 4;
  private static final int __TOTAL_ISSET_ID = 5;
  private static final int __TOTALCOUNT_ISSET_ID = 6;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.KEY, new org.apache.thrift.meta_data.FieldMetaData("key", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.COUNT, new org.apache.thrift.meta_data.FieldMetaData("count", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.MEAN, new org.apache.thrift.meta_data.FieldMetaData("mean", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    tmpMap.put(_Fields.MIN, new org.apache.thrift.meta_data.FieldMetaData("min", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    tmpMap.put(_Fields.MAX, new org.apache.thrift.meta_data.FieldMetaData("max", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    tmpMap.put(_Fields.TOTAL, new org.apache.thrift.meta_data.FieldMetaData("total", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    tmpMap.put(_Fields.TOTAL_COUNT, new org.apache.thrift.meta_data.FieldMetaData("totalCount", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(HistogramFacetEntry.class, metaDataMap);
  }

  public HistogramFacetEntry() {
  }

  public HistogramFacetEntry(
    long key,
    long count,
    double mean,
    double min,
    double max,
    double total,
    long totalCount)
  {
    this();
    this.key = key;
    setKeyIsSet(true);
    this.count = count;
    setCountIsSet(true);
    this.mean = mean;
    setMeanIsSet(true);
    this.min = min;
    setMinIsSet(true);
    this.max = max;
    setMaxIsSet(true);
    this.total = total;
    setTotalIsSet(true);
    this.totalCount = totalCount;
    setTotalCountIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public HistogramFacetEntry(HistogramFacetEntry other) {
    __isset_bitfield = other.__isset_bitfield;
    this.key = other.key;
    this.count = other.count;
    this.mean = other.mean;
    this.min = other.min;
    this.max = other.max;
    this.total = other.total;
    this.totalCount = other.totalCount;
  }

  public HistogramFacetEntry deepCopy() {
    return new HistogramFacetEntry(this);
  }

  @Override
  public void clear() {
    setKeyIsSet(false);
    this.key = 0;
    setCountIsSet(false);
    this.count = 0;
    setMeanIsSet(false);
    this.mean = 0.0;
    setMinIsSet(false);
    this.min = 0.0;
    setMaxIsSet(false);
    this.max = 0.0;
    setTotalIsSet(false);
    this.total = 0.0;
    setTotalCountIsSet(false);
    this.totalCount = 0;
  }

  public long getKey() {
    return this.key;
  }

  public HistogramFacetEntry setKey(long key) {
    this.key = key;
    setKeyIsSet(true);
    return this;
  }

  public void unsetKey() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __KEY_ISSET_ID);
  }

  /** Returns true if field key is set (has been assigned a value) and false otherwise */
  public boolean isSetKey() {
    return EncodingUtils.testBit(__isset_bitfield, __KEY_ISSET_ID);
  }

  public void setKeyIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __KEY_ISSET_ID, value);
  }

  public long getCount() {
    return this.count;
  }

  public HistogramFacetEntry setCount(long count) {
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

  public double getMean() {
    return this.mean;
  }

  public HistogramFacetEntry setMean(double mean) {
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

  public double getMin() {
    return this.min;
  }

  public HistogramFacetEntry setMin(double min) {
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

  public HistogramFacetEntry setMax(double max) {
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

  public double getTotal() {
    return this.total;
  }

  public HistogramFacetEntry setTotal(double total) {
    this.total = total;
    setTotalIsSet(true);
    return this;
  }

  public void unsetTotal() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __TOTAL_ISSET_ID);
  }

  /** Returns true if field total is set (has been assigned a value) and false otherwise */
  public boolean isSetTotal() {
    return EncodingUtils.testBit(__isset_bitfield, __TOTAL_ISSET_ID);
  }

  public void setTotalIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __TOTAL_ISSET_ID, value);
  }

  public long getTotalCount() {
    return this.totalCount;
  }

  public HistogramFacetEntry setTotalCount(long totalCount) {
    this.totalCount = totalCount;
    setTotalCountIsSet(true);
    return this;
  }

  public void unsetTotalCount() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __TOTALCOUNT_ISSET_ID);
  }

  /** Returns true if field totalCount is set (has been assigned a value) and false otherwise */
  public boolean isSetTotalCount() {
    return EncodingUtils.testBit(__isset_bitfield, __TOTALCOUNT_ISSET_ID);
  }

  public void setTotalCountIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __TOTALCOUNT_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case KEY:
      if (value == null) {
        unsetKey();
      } else {
        setKey((Long)value);
      }
      break;

    case COUNT:
      if (value == null) {
        unsetCount();
      } else {
        setCount((Long)value);
      }
      break;

    case MEAN:
      if (value == null) {
        unsetMean();
      } else {
        setMean((Double)value);
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

    case TOTAL:
      if (value == null) {
        unsetTotal();
      } else {
        setTotal((Double)value);
      }
      break;

    case TOTAL_COUNT:
      if (value == null) {
        unsetTotalCount();
      } else {
        setTotalCount((Long)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case KEY:
      return Long.valueOf(getKey());

    case COUNT:
      return Long.valueOf(getCount());

    case MEAN:
      return Double.valueOf(getMean());

    case MIN:
      return Double.valueOf(getMin());

    case MAX:
      return Double.valueOf(getMax());

    case TOTAL:
      return Double.valueOf(getTotal());

    case TOTAL_COUNT:
      return Long.valueOf(getTotalCount());

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case KEY:
      return isSetKey();
    case COUNT:
      return isSetCount();
    case MEAN:
      return isSetMean();
    case MIN:
      return isSetMin();
    case MAX:
      return isSetMax();
    case TOTAL:
      return isSetTotal();
    case TOTAL_COUNT:
      return isSetTotalCount();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof HistogramFacetEntry)
      return this.equals((HistogramFacetEntry)that);
    return false;
  }

  public boolean equals(HistogramFacetEntry that) {
    if (that == null)
      return false;

    boolean this_present_key = true;
    boolean that_present_key = true;
    if (this_present_key || that_present_key) {
      if (!(this_present_key && that_present_key))
        return false;
      if (this.key != that.key)
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

    boolean this_present_mean = true;
    boolean that_present_mean = true;
    if (this_present_mean || that_present_mean) {
      if (!(this_present_mean && that_present_mean))
        return false;
      if (this.mean != that.mean)
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

    boolean this_present_total = true;
    boolean that_present_total = true;
    if (this_present_total || that_present_total) {
      if (!(this_present_total && that_present_total))
        return false;
      if (this.total != that.total)
        return false;
    }

    boolean this_present_totalCount = true;
    boolean that_present_totalCount = true;
    if (this_present_totalCount || that_present_totalCount) {
      if (!(this_present_totalCount && that_present_totalCount))
        return false;
      if (this.totalCount != that.totalCount)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    HashCodeBuilder builder = new HashCodeBuilder();

    boolean present_key = true;
    builder.append(present_key);
    if (present_key)
      builder.append(key);

    boolean present_count = true;
    builder.append(present_count);
    if (present_count)
      builder.append(count);

    boolean present_mean = true;
    builder.append(present_mean);
    if (present_mean)
      builder.append(mean);

    boolean present_min = true;
    builder.append(present_min);
    if (present_min)
      builder.append(min);

    boolean present_max = true;
    builder.append(present_max);
    if (present_max)
      builder.append(max);

    boolean present_total = true;
    builder.append(present_total);
    if (present_total)
      builder.append(total);

    boolean present_totalCount = true;
    builder.append(present_totalCount);
    if (present_totalCount)
      builder.append(totalCount);

    return builder.toHashCode();
  }

  @Override
  public int compareTo(HistogramFacetEntry other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetKey()).compareTo(other.isSetKey());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetKey()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.key, other.key);
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
    lastComparison = Boolean.valueOf(isSetTotal()).compareTo(other.isSetTotal());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTotal()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.total, other.total);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetTotalCount()).compareTo(other.isSetTotalCount());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTotalCount()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.totalCount, other.totalCount);
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
    StringBuilder sb = new StringBuilder("HistogramFacetEntry(");
    boolean first = true;

    sb.append("key:");
    sb.append(this.key);
    first = false;
    if (!first) sb.append(", ");
    sb.append("count:");
    sb.append(this.count);
    first = false;
    if (!first) sb.append(", ");
    sb.append("mean:");
    sb.append(this.mean);
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
    sb.append("total:");
    sb.append(this.total);
    first = false;
    if (!first) sb.append(", ");
    sb.append("totalCount:");
    sb.append(this.totalCount);
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

  private static class HistogramFacetEntryStandardSchemeFactory implements SchemeFactory {
    public HistogramFacetEntryStandardScheme getScheme() {
      return new HistogramFacetEntryStandardScheme();
    }
  }

  private static class HistogramFacetEntryStandardScheme extends StandardScheme<HistogramFacetEntry> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, HistogramFacetEntry struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // KEY
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.key = iprot.readI64();
              struct.setKeyIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // COUNT
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.count = iprot.readI64();
              struct.setCountIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // MEAN
            if (schemeField.type == org.apache.thrift.protocol.TType.DOUBLE) {
              struct.mean = iprot.readDouble();
              struct.setMeanIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // MIN
            if (schemeField.type == org.apache.thrift.protocol.TType.DOUBLE) {
              struct.min = iprot.readDouble();
              struct.setMinIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // MAX
            if (schemeField.type == org.apache.thrift.protocol.TType.DOUBLE) {
              struct.max = iprot.readDouble();
              struct.setMaxIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // TOTAL
            if (schemeField.type == org.apache.thrift.protocol.TType.DOUBLE) {
              struct.total = iprot.readDouble();
              struct.setTotalIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 7: // TOTAL_COUNT
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.totalCount = iprot.readI64();
              struct.setTotalCountIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, HistogramFacetEntry struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(KEY_FIELD_DESC);
      oprot.writeI64(struct.key);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(COUNT_FIELD_DESC);
      oprot.writeI64(struct.count);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(MEAN_FIELD_DESC);
      oprot.writeDouble(struct.mean);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(MIN_FIELD_DESC);
      oprot.writeDouble(struct.min);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(MAX_FIELD_DESC);
      oprot.writeDouble(struct.max);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(TOTAL_FIELD_DESC);
      oprot.writeDouble(struct.total);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(TOTAL_COUNT_FIELD_DESC);
      oprot.writeI64(struct.totalCount);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class HistogramFacetEntryTupleSchemeFactory implements SchemeFactory {
    public HistogramFacetEntryTupleScheme getScheme() {
      return new HistogramFacetEntryTupleScheme();
    }
  }

  private static class HistogramFacetEntryTupleScheme extends TupleScheme<HistogramFacetEntry> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, HistogramFacetEntry struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetKey()) {
        optionals.set(0);
      }
      if (struct.isSetCount()) {
        optionals.set(1);
      }
      if (struct.isSetMean()) {
        optionals.set(2);
      }
      if (struct.isSetMin()) {
        optionals.set(3);
      }
      if (struct.isSetMax()) {
        optionals.set(4);
      }
      if (struct.isSetTotal()) {
        optionals.set(5);
      }
      if (struct.isSetTotalCount()) {
        optionals.set(6);
      }
      oprot.writeBitSet(optionals, 7);
      if (struct.isSetKey()) {
        oprot.writeI64(struct.key);
      }
      if (struct.isSetCount()) {
        oprot.writeI64(struct.count);
      }
      if (struct.isSetMean()) {
        oprot.writeDouble(struct.mean);
      }
      if (struct.isSetMin()) {
        oprot.writeDouble(struct.min);
      }
      if (struct.isSetMax()) {
        oprot.writeDouble(struct.max);
      }
      if (struct.isSetTotal()) {
        oprot.writeDouble(struct.total);
      }
      if (struct.isSetTotalCount()) {
        oprot.writeI64(struct.totalCount);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, HistogramFacetEntry struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(7);
      if (incoming.get(0)) {
        struct.key = iprot.readI64();
        struct.setKeyIsSet(true);
      }
      if (incoming.get(1)) {
        struct.count = iprot.readI64();
        struct.setCountIsSet(true);
      }
      if (incoming.get(2)) {
        struct.mean = iprot.readDouble();
        struct.setMeanIsSet(true);
      }
      if (incoming.get(3)) {
        struct.min = iprot.readDouble();
        struct.setMinIsSet(true);
      }
      if (incoming.get(4)) {
        struct.max = iprot.readDouble();
        struct.setMaxIsSet(true);
      }
      if (incoming.get(5)) {
        struct.total = iprot.readDouble();
        struct.setTotalIsSet(true);
      }
      if (incoming.get(6)) {
        struct.totalCount = iprot.readI64();
        struct.setTotalCountIsSet(true);
      }
    }
  }

}

