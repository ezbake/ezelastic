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

public class BaseFacetValue extends org.apache.thrift.TUnion<BaseFacetValue, BaseFacetValue._Fields> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("BaseFacetValue");
  private static final org.apache.thrift.protocol.TField FACET_FIELD_FIELD_DESC = new org.apache.thrift.protocol.TField("facetField", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField KEY_VALUE_FACET_FIELD_DESC = new org.apache.thrift.protocol.TField("keyValueFacet", org.apache.thrift.protocol.TType.STRUCT, (short)2);
  private static final org.apache.thrift.protocol.TField KEY_VALUE_SCRIPT_FIELD_DESC = new org.apache.thrift.protocol.TField("keyValueScript", org.apache.thrift.protocol.TType.STRUCT, (short)3);

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    FACET_FIELD((short)1, "facetField"),
    KEY_VALUE_FACET((short)2, "keyValueFacet"),
    KEY_VALUE_SCRIPT((short)3, "keyValueScript");

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
        case 1: // FACET_FIELD
          return FACET_FIELD;
        case 2: // KEY_VALUE_FACET
          return KEY_VALUE_FACET;
        case 3: // KEY_VALUE_SCRIPT
          return KEY_VALUE_SCRIPT;
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
    tmpMap.put(_Fields.FACET_FIELD, new org.apache.thrift.meta_data.FieldMetaData("facetField", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.KEY_VALUE_FACET, new org.apache.thrift.meta_data.FieldMetaData("keyValueFacet", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, KeyValueFacet.class)));
    tmpMap.put(_Fields.KEY_VALUE_SCRIPT, new org.apache.thrift.meta_data.FieldMetaData("keyValueScript", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, KeyValueScript.class)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(BaseFacetValue.class, metaDataMap);
  }

  public BaseFacetValue() {
    super();
  }

  public BaseFacetValue(_Fields setField, Object value) {
    super(setField, value);
  }

  public BaseFacetValue(BaseFacetValue other) {
    super(other);
  }
  public BaseFacetValue deepCopy() {
    return new BaseFacetValue(this);
  }

  public static BaseFacetValue facetField(String value) {
    BaseFacetValue x = new BaseFacetValue();
    x.setFacetField(value);
    return x;
  }

  public static BaseFacetValue keyValueFacet(KeyValueFacet value) {
    BaseFacetValue x = new BaseFacetValue();
    x.setKeyValueFacet(value);
    return x;
  }

  public static BaseFacetValue keyValueScript(KeyValueScript value) {
    BaseFacetValue x = new BaseFacetValue();
    x.setKeyValueScript(value);
    return x;
  }


  @Override
  protected void checkType(_Fields setField, Object value) throws ClassCastException {
    switch (setField) {
      case FACET_FIELD:
        if (value instanceof String) {
          break;
        }
        throw new ClassCastException("Was expecting value of type String for field 'facetField', but got " + value.getClass().getSimpleName());
      case KEY_VALUE_FACET:
        if (value instanceof KeyValueFacet) {
          break;
        }
        throw new ClassCastException("Was expecting value of type KeyValueFacet for field 'keyValueFacet', but got " + value.getClass().getSimpleName());
      case KEY_VALUE_SCRIPT:
        if (value instanceof KeyValueScript) {
          break;
        }
        throw new ClassCastException("Was expecting value of type KeyValueScript for field 'keyValueScript', but got " + value.getClass().getSimpleName());
      default:
        throw new IllegalArgumentException("Unknown field id " + setField);
    }
  }

  @Override
  protected Object standardSchemeReadValue(org.apache.thrift.protocol.TProtocol iprot, org.apache.thrift.protocol.TField field) throws org.apache.thrift.TException {
    _Fields setField = _Fields.findByThriftId(field.id);
    if (setField != null) {
      switch (setField) {
        case FACET_FIELD:
          if (field.type == FACET_FIELD_FIELD_DESC.type) {
            String facetField;
            facetField = iprot.readString();
            return facetField;
          } else {
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
            return null;
          }
        case KEY_VALUE_FACET:
          if (field.type == KEY_VALUE_FACET_FIELD_DESC.type) {
            KeyValueFacet keyValueFacet;
            keyValueFacet = new KeyValueFacet();
            keyValueFacet.read(iprot);
            return keyValueFacet;
          } else {
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
            return null;
          }
        case KEY_VALUE_SCRIPT:
          if (field.type == KEY_VALUE_SCRIPT_FIELD_DESC.type) {
            KeyValueScript keyValueScript;
            keyValueScript = new KeyValueScript();
            keyValueScript.read(iprot);
            return keyValueScript;
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
      case FACET_FIELD:
        String facetField = (String)value_;
        oprot.writeString(facetField);
        return;
      case KEY_VALUE_FACET:
        KeyValueFacet keyValueFacet = (KeyValueFacet)value_;
        keyValueFacet.write(oprot);
        return;
      case KEY_VALUE_SCRIPT:
        KeyValueScript keyValueScript = (KeyValueScript)value_;
        keyValueScript.write(oprot);
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
        case FACET_FIELD:
          String facetField;
          facetField = iprot.readString();
          return facetField;
        case KEY_VALUE_FACET:
          KeyValueFacet keyValueFacet;
          keyValueFacet = new KeyValueFacet();
          keyValueFacet.read(iprot);
          return keyValueFacet;
        case KEY_VALUE_SCRIPT:
          KeyValueScript keyValueScript;
          keyValueScript = new KeyValueScript();
          keyValueScript.read(iprot);
          return keyValueScript;
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
      case FACET_FIELD:
        String facetField = (String)value_;
        oprot.writeString(facetField);
        return;
      case KEY_VALUE_FACET:
        KeyValueFacet keyValueFacet = (KeyValueFacet)value_;
        keyValueFacet.write(oprot);
        return;
      case KEY_VALUE_SCRIPT:
        KeyValueScript keyValueScript = (KeyValueScript)value_;
        keyValueScript.write(oprot);
        return;
      default:
        throw new IllegalStateException("Cannot write union with unknown field " + setField_);
    }
  }

  @Override
  protected org.apache.thrift.protocol.TField getFieldDesc(_Fields setField) {
    switch (setField) {
      case FACET_FIELD:
        return FACET_FIELD_FIELD_DESC;
      case KEY_VALUE_FACET:
        return KEY_VALUE_FACET_FIELD_DESC;
      case KEY_VALUE_SCRIPT:
        return KEY_VALUE_SCRIPT_FIELD_DESC;
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


  public String getFacetField() {
    if (getSetField() == _Fields.FACET_FIELD) {
      return (String)getFieldValue();
    } else {
      throw new RuntimeException("Cannot get field 'facetField' because union is currently set to " + getFieldDesc(getSetField()).name);
    }
  }

  public void setFacetField(String value) {
    if (value == null) throw new NullPointerException();
    setField_ = _Fields.FACET_FIELD;
    value_ = value;
  }

  public KeyValueFacet getKeyValueFacet() {
    if (getSetField() == _Fields.KEY_VALUE_FACET) {
      return (KeyValueFacet)getFieldValue();
    } else {
      throw new RuntimeException("Cannot get field 'keyValueFacet' because union is currently set to " + getFieldDesc(getSetField()).name);
    }
  }

  public void setKeyValueFacet(KeyValueFacet value) {
    if (value == null) throw new NullPointerException();
    setField_ = _Fields.KEY_VALUE_FACET;
    value_ = value;
  }

  public KeyValueScript getKeyValueScript() {
    if (getSetField() == _Fields.KEY_VALUE_SCRIPT) {
      return (KeyValueScript)getFieldValue();
    } else {
      throw new RuntimeException("Cannot get field 'keyValueScript' because union is currently set to " + getFieldDesc(getSetField()).name);
    }
  }

  public void setKeyValueScript(KeyValueScript value) {
    if (value == null) throw new NullPointerException();
    setField_ = _Fields.KEY_VALUE_SCRIPT;
    value_ = value;
  }

  public boolean isSetFacetField() {
    return setField_ == _Fields.FACET_FIELD;
  }


  public boolean isSetKeyValueFacet() {
    return setField_ == _Fields.KEY_VALUE_FACET;
  }


  public boolean isSetKeyValueScript() {
    return setField_ == _Fields.KEY_VALUE_SCRIPT;
  }


  public boolean equals(Object other) {
    if (other instanceof BaseFacetValue) {
      return equals((BaseFacetValue)other);
    } else {
      return false;
    }
  }

  public boolean equals(BaseFacetValue other) {
    return other != null && getSetField() == other.getSetField() && getFieldValue().equals(other.getFieldValue());
  }

  @Override
  public int compareTo(BaseFacetValue other) {
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
