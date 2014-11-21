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

public class StatisticalFacet extends org.apache.thrift.TUnion<StatisticalFacet, StatisticalFacet._Fields> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("StatisticalFacet");
  private static final org.apache.thrift.protocol.TField FIELDS_FIELD_DESC = new org.apache.thrift.protocol.TField("fields", org.apache.thrift.protocol.TType.LIST, (short)1);
  private static final org.apache.thrift.protocol.TField SCRIPT_FIELD_DESC = new org.apache.thrift.protocol.TField("script", org.apache.thrift.protocol.TType.STRUCT, (short)2);

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    FIELDS((short)1, "fields"),
    SCRIPT((short)2, "script");

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
        case 2: // SCRIPT
          return SCRIPT;
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
    tmpMap.put(_Fields.FIELDS, new org.apache.thrift.meta_data.FieldMetaData("fields", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING))));
    tmpMap.put(_Fields.SCRIPT, new org.apache.thrift.meta_data.FieldMetaData("script", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, ValueScript.class)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(StatisticalFacet.class, metaDataMap);
  }

  public StatisticalFacet() {
    super();
  }

  public StatisticalFacet(_Fields setField, Object value) {
    super(setField, value);
  }

  public StatisticalFacet(StatisticalFacet other) {
    super(other);
  }
  public StatisticalFacet deepCopy() {
    return new StatisticalFacet(this);
  }

  public static StatisticalFacet fields(List<String> value) {
    StatisticalFacet x = new StatisticalFacet();
    x.setFields(value);
    return x;
  }

  public static StatisticalFacet script(ValueScript value) {
    StatisticalFacet x = new StatisticalFacet();
    x.setScript(value);
    return x;
  }


  @Override
  protected void checkType(_Fields setField, Object value) throws ClassCastException {
    switch (setField) {
      case FIELDS:
        if (value instanceof List) {
          break;
        }
        throw new ClassCastException("Was expecting value of type List<String> for field 'fields', but got " + value.getClass().getSimpleName());
      case SCRIPT:
        if (value instanceof ValueScript) {
          break;
        }
        throw new ClassCastException("Was expecting value of type ValueScript for field 'script', but got " + value.getClass().getSimpleName());
      default:
        throw new IllegalArgumentException("Unknown field id " + setField);
    }
  }

  @Override
  protected Object standardSchemeReadValue(org.apache.thrift.protocol.TProtocol iprot, org.apache.thrift.protocol.TField field) throws org.apache.thrift.TException {
    _Fields setField = _Fields.findByThriftId(field.id);
    if (setField != null) {
      switch (setField) {
        case FIELDS:
          if (field.type == FIELDS_FIELD_DESC.type) {
            List<String> fields;
            {
              org.apache.thrift.protocol.TList _list96 = iprot.readListBegin();
              fields = new ArrayList<String>(_list96.size);
              for (int _i97 = 0; _i97 < _list96.size; ++_i97)
              {
                String _elem98;
                _elem98 = iprot.readString();
                fields.add(_elem98);
              }
              iprot.readListEnd();
            }
            return fields;
          } else {
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
            return null;
          }
        case SCRIPT:
          if (field.type == SCRIPT_FIELD_DESC.type) {
            ValueScript script;
            script = new ValueScript();
            script.read(iprot);
            return script;
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
      case FIELDS:
        List<String> fields = (List<String>)value_;
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, fields.size()));
          for (String _iter99 : fields)
          {
            oprot.writeString(_iter99);
          }
          oprot.writeListEnd();
        }
        return;
      case SCRIPT:
        ValueScript script = (ValueScript)value_;
        script.write(oprot);
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
        case FIELDS:
          List<String> fields;
          {
            org.apache.thrift.protocol.TList _list100 = iprot.readListBegin();
            fields = new ArrayList<String>(_list100.size);
            for (int _i101 = 0; _i101 < _list100.size; ++_i101)
            {
              String _elem102;
              _elem102 = iprot.readString();
              fields.add(_elem102);
            }
            iprot.readListEnd();
          }
          return fields;
        case SCRIPT:
          ValueScript script;
          script = new ValueScript();
          script.read(iprot);
          return script;
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
      case FIELDS:
        List<String> fields = (List<String>)value_;
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, fields.size()));
          for (String _iter103 : fields)
          {
            oprot.writeString(_iter103);
          }
          oprot.writeListEnd();
        }
        return;
      case SCRIPT:
        ValueScript script = (ValueScript)value_;
        script.write(oprot);
        return;
      default:
        throw new IllegalStateException("Cannot write union with unknown field " + setField_);
    }
  }

  @Override
  protected org.apache.thrift.protocol.TField getFieldDesc(_Fields setField) {
    switch (setField) {
      case FIELDS:
        return FIELDS_FIELD_DESC;
      case SCRIPT:
        return SCRIPT_FIELD_DESC;
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


  public List<String> getFields() {
    if (getSetField() == _Fields.FIELDS) {
      return (List<String>)getFieldValue();
    } else {
      throw new RuntimeException("Cannot get field 'fields' because union is currently set to " + getFieldDesc(getSetField()).name);
    }
  }

  public void setFields(List<String> value) {
    if (value == null) throw new NullPointerException();
    setField_ = _Fields.FIELDS;
    value_ = value;
  }

  public ValueScript getScript() {
    if (getSetField() == _Fields.SCRIPT) {
      return (ValueScript)getFieldValue();
    } else {
      throw new RuntimeException("Cannot get field 'script' because union is currently set to " + getFieldDesc(getSetField()).name);
    }
  }

  public void setScript(ValueScript value) {
    if (value == null) throw new NullPointerException();
    setField_ = _Fields.SCRIPT;
    value_ = value;
  }

  public boolean isSetFields() {
    return setField_ == _Fields.FIELDS;
  }


  public boolean isSetScript() {
    return setField_ == _Fields.SCRIPT;
  }


  public boolean equals(Object other) {
    if (other instanceof StatisticalFacet) {
      return equals((StatisticalFacet)other);
    } else {
      return false;
    }
  }

  public boolean equals(StatisticalFacet other) {
    return other != null && getSetField() == other.getSetField() && getFieldValue().equals(other.getFieldValue());
  }

  @Override
  public int compareTo(StatisticalFacet other) {
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