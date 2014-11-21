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

public class FacetResult extends org.apache.thrift.TUnion<FacetResult, FacetResult._Fields> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("FacetResult");
  private static final org.apache.thrift.protocol.TField TERMS_FACET_RESULT_FIELD_DESC = new org.apache.thrift.protocol.TField("termsFacetResult", org.apache.thrift.protocol.TType.STRUCT, (short)1);
  private static final org.apache.thrift.protocol.TField RANGE_FACET_RESULT_FIELD_DESC = new org.apache.thrift.protocol.TField("rangeFacetResult", org.apache.thrift.protocol.TType.STRUCT, (short)2);
  private static final org.apache.thrift.protocol.TField DATE_FACET_RESULT_FIELD_DESC = new org.apache.thrift.protocol.TField("dateFacetResult", org.apache.thrift.protocol.TType.STRUCT, (short)3);
  private static final org.apache.thrift.protocol.TField HISTOGRAM_FACET_RESULT_FIELD_DESC = new org.apache.thrift.protocol.TField("histogramFacetResult", org.apache.thrift.protocol.TType.STRUCT, (short)4);
  private static final org.apache.thrift.protocol.TField FILTER_FACET_RESULT_FIELD_DESC = new org.apache.thrift.protocol.TField("filterFacetResult", org.apache.thrift.protocol.TType.STRUCT, (short)5);
  private static final org.apache.thrift.protocol.TField TERMS_STATS_FACET_RESULT_FIELD_DESC = new org.apache.thrift.protocol.TField("termsStatsFacetResult", org.apache.thrift.protocol.TType.STRUCT, (short)6);
  private static final org.apache.thrift.protocol.TField STATISTICAL_FACET_RESULT_FIELD_DESC = new org.apache.thrift.protocol.TField("statisticalFacetResult", org.apache.thrift.protocol.TType.STRUCT, (short)7);

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    TERMS_FACET_RESULT((short)1, "termsFacetResult"),
    RANGE_FACET_RESULT((short)2, "rangeFacetResult"),
    DATE_FACET_RESULT((short)3, "dateFacetResult"),
    HISTOGRAM_FACET_RESULT((short)4, "histogramFacetResult"),
    FILTER_FACET_RESULT((short)5, "filterFacetResult"),
    TERMS_STATS_FACET_RESULT((short)6, "termsStatsFacetResult"),
    STATISTICAL_FACET_RESULT((short)7, "statisticalFacetResult");

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
        case 1: // TERMS_FACET_RESULT
          return TERMS_FACET_RESULT;
        case 2: // RANGE_FACET_RESULT
          return RANGE_FACET_RESULT;
        case 3: // DATE_FACET_RESULT
          return DATE_FACET_RESULT;
        case 4: // HISTOGRAM_FACET_RESULT
          return HISTOGRAM_FACET_RESULT;
        case 5: // FILTER_FACET_RESULT
          return FILTER_FACET_RESULT;
        case 6: // TERMS_STATS_FACET_RESULT
          return TERMS_STATS_FACET_RESULT;
        case 7: // STATISTICAL_FACET_RESULT
          return STATISTICAL_FACET_RESULT;
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

  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.TERMS_FACET_RESULT, new org.apache.thrift.meta_data.FieldMetaData("termsFacetResult", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, TermsFacetResult.class)));
    tmpMap.put(_Fields.RANGE_FACET_RESULT, new org.apache.thrift.meta_data.FieldMetaData("rangeFacetResult", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, RangeFacetResult.class)));
    tmpMap.put(_Fields.DATE_FACET_RESULT, new org.apache.thrift.meta_data.FieldMetaData("dateFacetResult", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, DateHistogramFacetResult.class)));
    tmpMap.put(_Fields.HISTOGRAM_FACET_RESULT, new org.apache.thrift.meta_data.FieldMetaData("histogramFacetResult", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, HistogramFacetResult.class)));
    tmpMap.put(_Fields.FILTER_FACET_RESULT, new org.apache.thrift.meta_data.FieldMetaData("filterFacetResult", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, FilterFacetResult.class)));
    tmpMap.put(_Fields.TERMS_STATS_FACET_RESULT, new org.apache.thrift.meta_data.FieldMetaData("termsStatsFacetResult", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, TermsStatsFacetResult.class)));
    tmpMap.put(_Fields.STATISTICAL_FACET_RESULT, new org.apache.thrift.meta_data.FieldMetaData("statisticalFacetResult", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, StatisticalFacetResult.class)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(FacetResult.class, metaDataMap);
  }

  public FacetResult() {
    super();
  }

  public FacetResult(_Fields setField, Object value) {
    super(setField, value);
  }

  public FacetResult(FacetResult other) {
    super(other);
  }
  public FacetResult deepCopy() {
    return new FacetResult(this);
  }

  public static FacetResult termsFacetResult(TermsFacetResult value) {
    FacetResult x = new FacetResult();
    x.setTermsFacetResult(value);
    return x;
  }

  public static FacetResult rangeFacetResult(RangeFacetResult value) {
    FacetResult x = new FacetResult();
    x.setRangeFacetResult(value);
    return x;
  }

  public static FacetResult dateFacetResult(DateHistogramFacetResult value) {
    FacetResult x = new FacetResult();
    x.setDateFacetResult(value);
    return x;
  }

  public static FacetResult histogramFacetResult(HistogramFacetResult value) {
    FacetResult x = new FacetResult();
    x.setHistogramFacetResult(value);
    return x;
  }

  public static FacetResult filterFacetResult(FilterFacetResult value) {
    FacetResult x = new FacetResult();
    x.setFilterFacetResult(value);
    return x;
  }

  public static FacetResult termsStatsFacetResult(TermsStatsFacetResult value) {
    FacetResult x = new FacetResult();
    x.setTermsStatsFacetResult(value);
    return x;
  }

  public static FacetResult statisticalFacetResult(StatisticalFacetResult value) {
    FacetResult x = new FacetResult();
    x.setStatisticalFacetResult(value);
    return x;
  }


  @Override
  protected void checkType(_Fields setField, Object value) throws ClassCastException {
    switch (setField) {
      case TERMS_FACET_RESULT:
        if (value instanceof TermsFacetResult) {
          break;
        }
        throw new ClassCastException("Was expecting value of type TermsFacetResult for field 'termsFacetResult', but got " + value.getClass().getSimpleName());
      case RANGE_FACET_RESULT:
        if (value instanceof RangeFacetResult) {
          break;
        }
        throw new ClassCastException("Was expecting value of type RangeFacetResult for field 'rangeFacetResult', but got " + value.getClass().getSimpleName());
      case DATE_FACET_RESULT:
        if (value instanceof DateHistogramFacetResult) {
          break;
        }
        throw new ClassCastException("Was expecting value of type DateHistogramFacetResult for field 'dateFacetResult', but got " + value.getClass().getSimpleName());
      case HISTOGRAM_FACET_RESULT:
        if (value instanceof HistogramFacetResult) {
          break;
        }
        throw new ClassCastException("Was expecting value of type HistogramFacetResult for field 'histogramFacetResult', but got " + value.getClass().getSimpleName());
      case FILTER_FACET_RESULT:
        if (value instanceof FilterFacetResult) {
          break;
        }
        throw new ClassCastException("Was expecting value of type FilterFacetResult for field 'filterFacetResult', but got " + value.getClass().getSimpleName());
      case TERMS_STATS_FACET_RESULT:
        if (value instanceof TermsStatsFacetResult) {
          break;
        }
        throw new ClassCastException("Was expecting value of type TermsStatsFacetResult for field 'termsStatsFacetResult', but got " + value.getClass().getSimpleName());
      case STATISTICAL_FACET_RESULT:
        if (value instanceof StatisticalFacetResult) {
          break;
        }
        throw new ClassCastException("Was expecting value of type StatisticalFacetResult for field 'statisticalFacetResult', but got " + value.getClass().getSimpleName());
      default:
        throw new IllegalArgumentException("Unknown field id " + setField);
    }
  }

  @Override
  protected Object standardSchemeReadValue(org.apache.thrift.protocol.TProtocol iprot, org.apache.thrift.protocol.TField field) throws org.apache.thrift.TException {
    _Fields setField = _Fields.findByThriftId(field.id);
    if (setField != null) {
      switch (setField) {
        case TERMS_FACET_RESULT:
          if (field.type == TERMS_FACET_RESULT_FIELD_DESC.type) {
            TermsFacetResult termsFacetResult;
            termsFacetResult = new TermsFacetResult();
            termsFacetResult.read(iprot);
            return termsFacetResult;
          } else {
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
            return null;
          }
        case RANGE_FACET_RESULT:
          if (field.type == RANGE_FACET_RESULT_FIELD_DESC.type) {
            RangeFacetResult rangeFacetResult;
            rangeFacetResult = new RangeFacetResult();
            rangeFacetResult.read(iprot);
            return rangeFacetResult;
          } else {
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
            return null;
          }
        case DATE_FACET_RESULT:
          if (field.type == DATE_FACET_RESULT_FIELD_DESC.type) {
            DateHistogramFacetResult dateFacetResult;
            dateFacetResult = new DateHistogramFacetResult();
            dateFacetResult.read(iprot);
            return dateFacetResult;
          } else {
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
            return null;
          }
        case HISTOGRAM_FACET_RESULT:
          if (field.type == HISTOGRAM_FACET_RESULT_FIELD_DESC.type) {
            HistogramFacetResult histogramFacetResult;
            histogramFacetResult = new HistogramFacetResult();
            histogramFacetResult.read(iprot);
            return histogramFacetResult;
          } else {
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
            return null;
          }
        case FILTER_FACET_RESULT:
          if (field.type == FILTER_FACET_RESULT_FIELD_DESC.type) {
            FilterFacetResult filterFacetResult;
            filterFacetResult = new FilterFacetResult();
            filterFacetResult.read(iprot);
            return filterFacetResult;
          } else {
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
            return null;
          }
        case TERMS_STATS_FACET_RESULT:
          if (field.type == TERMS_STATS_FACET_RESULT_FIELD_DESC.type) {
            TermsStatsFacetResult termsStatsFacetResult;
            termsStatsFacetResult = new TermsStatsFacetResult();
            termsStatsFacetResult.read(iprot);
            return termsStatsFacetResult;
          } else {
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
            return null;
          }
        case STATISTICAL_FACET_RESULT:
          if (field.type == STATISTICAL_FACET_RESULT_FIELD_DESC.type) {
            StatisticalFacetResult statisticalFacetResult;
            statisticalFacetResult = new StatisticalFacetResult();
            statisticalFacetResult.read(iprot);
            return statisticalFacetResult;
          } else {
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
            return null;
          }
        default:
          throw new IllegalStateException("setField wasn't null, but didn't match any of the case statements!");
      }
    } else {
      org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
      return null;
    }
  }

  @Override
  protected void standardSchemeWriteValue(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    switch (setField_) {
      case TERMS_FACET_RESULT:
        TermsFacetResult termsFacetResult = (TermsFacetResult)value_;
        termsFacetResult.write(oprot);
        return;
      case RANGE_FACET_RESULT:
        RangeFacetResult rangeFacetResult = (RangeFacetResult)value_;
        rangeFacetResult.write(oprot);
        return;
      case DATE_FACET_RESULT:
        DateHistogramFacetResult dateFacetResult = (DateHistogramFacetResult)value_;
        dateFacetResult.write(oprot);
        return;
      case HISTOGRAM_FACET_RESULT:
        HistogramFacetResult histogramFacetResult = (HistogramFacetResult)value_;
        histogramFacetResult.write(oprot);
        return;
      case FILTER_FACET_RESULT:
        FilterFacetResult filterFacetResult = (FilterFacetResult)value_;
        filterFacetResult.write(oprot);
        return;
      case TERMS_STATS_FACET_RESULT:
        TermsStatsFacetResult termsStatsFacetResult = (TermsStatsFacetResult)value_;
        termsStatsFacetResult.write(oprot);
        return;
      case STATISTICAL_FACET_RESULT:
        StatisticalFacetResult statisticalFacetResult = (StatisticalFacetResult)value_;
        statisticalFacetResult.write(oprot);
        return;
      default:
        throw new IllegalStateException("Cannot write union with unknown field " + setField_);
    }
  }

  @Override
  protected Object tupleSchemeReadValue(org.apache.thrift.protocol.TProtocol iprot, short fieldID) throws org.apache.thrift.TException {
    _Fields setField = _Fields.findByThriftId(fieldID);
    if (setField != null) {
      switch (setField) {
        case TERMS_FACET_RESULT:
          TermsFacetResult termsFacetResult;
          termsFacetResult = new TermsFacetResult();
          termsFacetResult.read(iprot);
          return termsFacetResult;
        case RANGE_FACET_RESULT:
          RangeFacetResult rangeFacetResult;
          rangeFacetResult = new RangeFacetResult();
          rangeFacetResult.read(iprot);
          return rangeFacetResult;
        case DATE_FACET_RESULT:
          DateHistogramFacetResult dateFacetResult;
          dateFacetResult = new DateHistogramFacetResult();
          dateFacetResult.read(iprot);
          return dateFacetResult;
        case HISTOGRAM_FACET_RESULT:
          HistogramFacetResult histogramFacetResult;
          histogramFacetResult = new HistogramFacetResult();
          histogramFacetResult.read(iprot);
          return histogramFacetResult;
        case FILTER_FACET_RESULT:
          FilterFacetResult filterFacetResult;
          filterFacetResult = new FilterFacetResult();
          filterFacetResult.read(iprot);
          return filterFacetResult;
        case TERMS_STATS_FACET_RESULT:
          TermsStatsFacetResult termsStatsFacetResult;
          termsStatsFacetResult = new TermsStatsFacetResult();
          termsStatsFacetResult.read(iprot);
          return termsStatsFacetResult;
        case STATISTICAL_FACET_RESULT:
          StatisticalFacetResult statisticalFacetResult;
          statisticalFacetResult = new StatisticalFacetResult();
          statisticalFacetResult.read(iprot);
          return statisticalFacetResult;
        default:
          throw new IllegalStateException("setField wasn't null, but didn't match any of the case statements!");
      }
    } else {
      throw new TProtocolException("Couldn't find a field with field id " + fieldID);
    }
  }

  @Override
  protected void tupleSchemeWriteValue(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    switch (setField_) {
      case TERMS_FACET_RESULT:
        TermsFacetResult termsFacetResult = (TermsFacetResult)value_;
        termsFacetResult.write(oprot);
        return;
      case RANGE_FACET_RESULT:
        RangeFacetResult rangeFacetResult = (RangeFacetResult)value_;
        rangeFacetResult.write(oprot);
        return;
      case DATE_FACET_RESULT:
        DateHistogramFacetResult dateFacetResult = (DateHistogramFacetResult)value_;
        dateFacetResult.write(oprot);
        return;
      case HISTOGRAM_FACET_RESULT:
        HistogramFacetResult histogramFacetResult = (HistogramFacetResult)value_;
        histogramFacetResult.write(oprot);
        return;
      case FILTER_FACET_RESULT:
        FilterFacetResult filterFacetResult = (FilterFacetResult)value_;
        filterFacetResult.write(oprot);
        return;
      case TERMS_STATS_FACET_RESULT:
        TermsStatsFacetResult termsStatsFacetResult = (TermsStatsFacetResult)value_;
        termsStatsFacetResult.write(oprot);
        return;
      case STATISTICAL_FACET_RESULT:
        StatisticalFacetResult statisticalFacetResult = (StatisticalFacetResult)value_;
        statisticalFacetResult.write(oprot);
        return;
      default:
        throw new IllegalStateException("Cannot write union with unknown field " + setField_);
    }
  }

  @Override
  protected org.apache.thrift.protocol.TField getFieldDesc(_Fields setField) {
    switch (setField) {
      case TERMS_FACET_RESULT:
        return TERMS_FACET_RESULT_FIELD_DESC;
      case RANGE_FACET_RESULT:
        return RANGE_FACET_RESULT_FIELD_DESC;
      case DATE_FACET_RESULT:
        return DATE_FACET_RESULT_FIELD_DESC;
      case HISTOGRAM_FACET_RESULT:
        return HISTOGRAM_FACET_RESULT_FIELD_DESC;
      case FILTER_FACET_RESULT:
        return FILTER_FACET_RESULT_FIELD_DESC;
      case TERMS_STATS_FACET_RESULT:
        return TERMS_STATS_FACET_RESULT_FIELD_DESC;
      case STATISTICAL_FACET_RESULT:
        return STATISTICAL_FACET_RESULT_FIELD_DESC;
      default:
        throw new IllegalArgumentException("Unknown field id " + setField);
    }
  }

  @Override
  protected org.apache.thrift.protocol.TStruct getStructDesc() {
    return STRUCT_DESC;
  }

  @Override
  protected _Fields enumForId(short id) {
    return _Fields.findByThriftIdOrThrow(id);
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }


  public TermsFacetResult getTermsFacetResult() {
    if (getSetField() == _Fields.TERMS_FACET_RESULT) {
      return (TermsFacetResult)getFieldValue();
    } else {
      throw new RuntimeException("Cannot get field 'termsFacetResult' because union is currently set to " + getFieldDesc(getSetField()).name);
    }
  }

  public void setTermsFacetResult(TermsFacetResult value) {
    if (value == null) throw new NullPointerException();
    setField_ = _Fields.TERMS_FACET_RESULT;
    value_ = value;
  }

  public RangeFacetResult getRangeFacetResult() {
    if (getSetField() == _Fields.RANGE_FACET_RESULT) {
      return (RangeFacetResult)getFieldValue();
    } else {
      throw new RuntimeException("Cannot get field 'rangeFacetResult' because union is currently set to " + getFieldDesc(getSetField()).name);
    }
  }

  public void setRangeFacetResult(RangeFacetResult value) {
    if (value == null) throw new NullPointerException();
    setField_ = _Fields.RANGE_FACET_RESULT;
    value_ = value;
  }

  public DateHistogramFacetResult getDateFacetResult() {
    if (getSetField() == _Fields.DATE_FACET_RESULT) {
      return (DateHistogramFacetResult)getFieldValue();
    } else {
      throw new RuntimeException("Cannot get field 'dateFacetResult' because union is currently set to " + getFieldDesc(getSetField()).name);
    }
  }

  public void setDateFacetResult(DateHistogramFacetResult value) {
    if (value == null) throw new NullPointerException();
    setField_ = _Fields.DATE_FACET_RESULT;
    value_ = value;
  }

  public HistogramFacetResult getHistogramFacetResult() {
    if (getSetField() == _Fields.HISTOGRAM_FACET_RESULT) {
      return (HistogramFacetResult)getFieldValue();
    } else {
      throw new RuntimeException("Cannot get field 'histogramFacetResult' because union is currently set to " + getFieldDesc(getSetField()).name);
    }
  }

  public void setHistogramFacetResult(HistogramFacetResult value) {
    if (value == null) throw new NullPointerException();
    setField_ = _Fields.HISTOGRAM_FACET_RESULT;
    value_ = value;
  }

  public FilterFacetResult getFilterFacetResult() {
    if (getSetField() == _Fields.FILTER_FACET_RESULT) {
      return (FilterFacetResult)getFieldValue();
    } else {
      throw new RuntimeException("Cannot get field 'filterFacetResult' because union is currently set to " + getFieldDesc(getSetField()).name);
    }
  }

  public void setFilterFacetResult(FilterFacetResult value) {
    if (value == null) throw new NullPointerException();
    setField_ = _Fields.FILTER_FACET_RESULT;
    value_ = value;
  }

  public TermsStatsFacetResult getTermsStatsFacetResult() {
    if (getSetField() == _Fields.TERMS_STATS_FACET_RESULT) {
      return (TermsStatsFacetResult)getFieldValue();
    } else {
      throw new RuntimeException("Cannot get field 'termsStatsFacetResult' because union is currently set to " + getFieldDesc(getSetField()).name);
    }
  }

  public void setTermsStatsFacetResult(TermsStatsFacetResult value) {
    if (value == null) throw new NullPointerException();
    setField_ = _Fields.TERMS_STATS_FACET_RESULT;
    value_ = value;
  }

  public StatisticalFacetResult getStatisticalFacetResult() {
    if (getSetField() == _Fields.STATISTICAL_FACET_RESULT) {
      return (StatisticalFacetResult)getFieldValue();
    } else {
      throw new RuntimeException("Cannot get field 'statisticalFacetResult' because union is currently set to " + getFieldDesc(getSetField()).name);
    }
  }

  public void setStatisticalFacetResult(StatisticalFacetResult value) {
    if (value == null) throw new NullPointerException();
    setField_ = _Fields.STATISTICAL_FACET_RESULT;
    value_ = value;
  }

  public boolean isSetTermsFacetResult() {
    return setField_ == _Fields.TERMS_FACET_RESULT;
  }


  public boolean isSetRangeFacetResult() {
    return setField_ == _Fields.RANGE_FACET_RESULT;
  }


  public boolean isSetDateFacetResult() {
    return setField_ == _Fields.DATE_FACET_RESULT;
  }


  public boolean isSetHistogramFacetResult() {
    return setField_ == _Fields.HISTOGRAM_FACET_RESULT;
  }


  public boolean isSetFilterFacetResult() {
    return setField_ == _Fields.FILTER_FACET_RESULT;
  }


  public boolean isSetTermsStatsFacetResult() {
    return setField_ == _Fields.TERMS_STATS_FACET_RESULT;
  }


  public boolean isSetStatisticalFacetResult() {
    return setField_ == _Fields.STATISTICAL_FACET_RESULT;
  }


  public boolean equals(Object other) {
    if (other instanceof FacetResult) {
      return equals((FacetResult)other);
    } else {
      return false;
    }
  }

  public boolean equals(FacetResult other) {
    return other != null && getSetField() == other.getSetField() && getFieldValue().equals(other.getFieldValue());
  }

  @Override
  public int compareTo(FacetResult other) {
    int lastComparison = org.apache.thrift.TBaseHelper.compareTo(getSetField(), other.getSetField());
    if (lastComparison == 0) {
      return org.apache.thrift.TBaseHelper.compareTo(getFieldValue(), other.getFieldValue());
    }
    return lastComparison;
  }


  @Override
  public int hashCode() {
    HashCodeBuilder hcb = new HashCodeBuilder();
    hcb.append(this.getClass().getName());
    org.apache.thrift.TFieldIdEnum setField = getSetField();
    if (setField != null) {
      hcb.append(setField.getThriftFieldId());
      Object value = getFieldValue();
      if (value instanceof org.apache.thrift.TEnum) {
        hcb.append(((org.apache.thrift.TEnum)getFieldValue()).getValue());
      } else {
        hcb.append(value);
      }
    }
    return hcb.toHashCode();
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


}