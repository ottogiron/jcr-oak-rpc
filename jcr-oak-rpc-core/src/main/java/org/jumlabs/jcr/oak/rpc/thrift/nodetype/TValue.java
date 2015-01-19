/**
 * Autogenerated by Thrift Compiler (1.0.0-dev)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.jumlabs.jcr.oak.rpc.thrift.nodetype;

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
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
@Generated(value = "Autogenerated by Thrift Compiler (1.0.0-dev)", date = "2015-1-17")
public class TValue implements org.apache.thrift.TBase<TValue, TValue._Fields>, java.io.Serializable, Cloneable, Comparable<TValue> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TValue");

  private static final org.apache.thrift.protocol.TField BINARY_VALUE_FIELD_DESC = new org.apache.thrift.protocol.TField("binaryValue", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField STRING_VALUE_FIELD_DESC = new org.apache.thrift.protocol.TField("stringValue", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField BOOL_VALUE_FIELD_DESC = new org.apache.thrift.protocol.TField("boolValue", org.apache.thrift.protocol.TType.BOOL, (short)3);
  private static final org.apache.thrift.protocol.TField DOUBLE_VALUE_FIELD_DESC = new org.apache.thrift.protocol.TField("doubleValue", org.apache.thrift.protocol.TType.DOUBLE, (short)4);
  private static final org.apache.thrift.protocol.TField LONG_VALUE_FIELD_DESC = new org.apache.thrift.protocol.TField("longValue", org.apache.thrift.protocol.TType.I64, (short)5);
  private static final org.apache.thrift.protocol.TField TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("type", org.apache.thrift.protocol.TType.I32, (short)6);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new TValueStandardSchemeFactory());
    schemes.put(TupleScheme.class, new TValueTupleSchemeFactory());
  }

  public ByteBuffer binaryValue; // required
  public String stringValue; // required
  public boolean boolValue; // required
  public double doubleValue; // required
  public long longValue; // required
  public int type; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    BINARY_VALUE((short)1, "binaryValue"),
    STRING_VALUE((short)2, "stringValue"),
    BOOL_VALUE((short)3, "boolValue"),
    DOUBLE_VALUE((short)4, "doubleValue"),
    LONG_VALUE((short)5, "longValue"),
    TYPE((short)6, "type");

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
        case 1: // BINARY_VALUE
          return BINARY_VALUE;
        case 2: // STRING_VALUE
          return STRING_VALUE;
        case 3: // BOOL_VALUE
          return BOOL_VALUE;
        case 4: // DOUBLE_VALUE
          return DOUBLE_VALUE;
        case 5: // LONG_VALUE
          return LONG_VALUE;
        case 6: // TYPE
          return TYPE;
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
  private static final int __BOOLVALUE_ISSET_ID = 0;
  private static final int __DOUBLEVALUE_ISSET_ID = 1;
  private static final int __LONGVALUE_ISSET_ID = 2;
  private static final int __TYPE_ISSET_ID = 3;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.BINARY_VALUE, new org.apache.thrift.meta_data.FieldMetaData("binaryValue", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING        , true)));
    tmpMap.put(_Fields.STRING_VALUE, new org.apache.thrift.meta_data.FieldMetaData("stringValue", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.BOOL_VALUE, new org.apache.thrift.meta_data.FieldMetaData("boolValue", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BOOL)));
    tmpMap.put(_Fields.DOUBLE_VALUE, new org.apache.thrift.meta_data.FieldMetaData("doubleValue", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    tmpMap.put(_Fields.LONG_VALUE, new org.apache.thrift.meta_data.FieldMetaData("longValue", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.TYPE, new org.apache.thrift.meta_data.FieldMetaData("type", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TValue.class, metaDataMap);
  }

  public TValue() {
  }

  public TValue(
    ByteBuffer binaryValue,
    String stringValue,
    boolean boolValue,
    double doubleValue,
    long longValue,
    int type)
  {
    this();
    this.binaryValue = binaryValue;
    this.stringValue = stringValue;
    this.boolValue = boolValue;
    setBoolValueIsSet(true);
    this.doubleValue = doubleValue;
    setDoubleValueIsSet(true);
    this.longValue = longValue;
    setLongValueIsSet(true);
    this.type = type;
    setTypeIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TValue(TValue other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetBinaryValue()) {
      this.binaryValue = org.apache.thrift.TBaseHelper.copyBinary(other.binaryValue);
    }
    if (other.isSetStringValue()) {
      this.stringValue = other.stringValue;
    }
    this.boolValue = other.boolValue;
    this.doubleValue = other.doubleValue;
    this.longValue = other.longValue;
    this.type = other.type;
  }

  public TValue deepCopy() {
    return new TValue(this);
  }

  @Override
  public void clear() {
    this.binaryValue = null;
    this.stringValue = null;
    setBoolValueIsSet(false);
    this.boolValue = false;
    setDoubleValueIsSet(false);
    this.doubleValue = 0.0;
    setLongValueIsSet(false);
    this.longValue = 0;
    setTypeIsSet(false);
    this.type = 0;
  }

  public byte[] getBinaryValue() {
    setBinaryValue(org.apache.thrift.TBaseHelper.rightSize(binaryValue));
    return binaryValue == null ? null : binaryValue.array();
  }

  public ByteBuffer bufferForBinaryValue() {
    return binaryValue;
  }

  public TValue setBinaryValue(byte[] binaryValue) {
    setBinaryValue(binaryValue == null ? (ByteBuffer)null : ByteBuffer.wrap(binaryValue));
    return this;
  }

  public TValue setBinaryValue(ByteBuffer binaryValue) {
    this.binaryValue = binaryValue;
    return this;
  }

  public void unsetBinaryValue() {
    this.binaryValue = null;
  }

  /** Returns true if field binaryValue is set (has been assigned a value) and false otherwise */
  public boolean isSetBinaryValue() {
    return this.binaryValue != null;
  }

  public void setBinaryValueIsSet(boolean value) {
    if (!value) {
      this.binaryValue = null;
    }
  }

  public String getStringValue() {
    return this.stringValue;
  }

  public TValue setStringValue(String stringValue) {
    this.stringValue = stringValue;
    return this;
  }

  public void unsetStringValue() {
    this.stringValue = null;
  }

  /** Returns true if field stringValue is set (has been assigned a value) and false otherwise */
  public boolean isSetStringValue() {
    return this.stringValue != null;
  }

  public void setStringValueIsSet(boolean value) {
    if (!value) {
      this.stringValue = null;
    }
  }

  public boolean isBoolValue() {
    return this.boolValue;
  }

  public TValue setBoolValue(boolean boolValue) {
    this.boolValue = boolValue;
    setBoolValueIsSet(true);
    return this;
  }

  public void unsetBoolValue() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __BOOLVALUE_ISSET_ID);
  }

  /** Returns true if field boolValue is set (has been assigned a value) and false otherwise */
  public boolean isSetBoolValue() {
    return EncodingUtils.testBit(__isset_bitfield, __BOOLVALUE_ISSET_ID);
  }

  public void setBoolValueIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __BOOLVALUE_ISSET_ID, value);
  }

  public double getDoubleValue() {
    return this.doubleValue;
  }

  public TValue setDoubleValue(double doubleValue) {
    this.doubleValue = doubleValue;
    setDoubleValueIsSet(true);
    return this;
  }

  public void unsetDoubleValue() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __DOUBLEVALUE_ISSET_ID);
  }

  /** Returns true if field doubleValue is set (has been assigned a value) and false otherwise */
  public boolean isSetDoubleValue() {
    return EncodingUtils.testBit(__isset_bitfield, __DOUBLEVALUE_ISSET_ID);
  }

  public void setDoubleValueIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __DOUBLEVALUE_ISSET_ID, value);
  }

  public long getLongValue() {
    return this.longValue;
  }

  public TValue setLongValue(long longValue) {
    this.longValue = longValue;
    setLongValueIsSet(true);
    return this;
  }

  public void unsetLongValue() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __LONGVALUE_ISSET_ID);
  }

  /** Returns true if field longValue is set (has been assigned a value) and false otherwise */
  public boolean isSetLongValue() {
    return EncodingUtils.testBit(__isset_bitfield, __LONGVALUE_ISSET_ID);
  }

  public void setLongValueIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __LONGVALUE_ISSET_ID, value);
  }

  public int getType() {
    return this.type;
  }

  public TValue setType(int type) {
    this.type = type;
    setTypeIsSet(true);
    return this;
  }

  public void unsetType() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __TYPE_ISSET_ID);
  }

  /** Returns true if field type is set (has been assigned a value) and false otherwise */
  public boolean isSetType() {
    return EncodingUtils.testBit(__isset_bitfield, __TYPE_ISSET_ID);
  }

  public void setTypeIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __TYPE_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case BINARY_VALUE:
      if (value == null) {
        unsetBinaryValue();
      } else {
        setBinaryValue((ByteBuffer)value);
      }
      break;

    case STRING_VALUE:
      if (value == null) {
        unsetStringValue();
      } else {
        setStringValue((String)value);
      }
      break;

    case BOOL_VALUE:
      if (value == null) {
        unsetBoolValue();
      } else {
        setBoolValue((Boolean)value);
      }
      break;

    case DOUBLE_VALUE:
      if (value == null) {
        unsetDoubleValue();
      } else {
        setDoubleValue((Double)value);
      }
      break;

    case LONG_VALUE:
      if (value == null) {
        unsetLongValue();
      } else {
        setLongValue((Long)value);
      }
      break;

    case TYPE:
      if (value == null) {
        unsetType();
      } else {
        setType((Integer)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case BINARY_VALUE:
      return getBinaryValue();

    case STRING_VALUE:
      return getStringValue();

    case BOOL_VALUE:
      return Boolean.valueOf(isBoolValue());

    case DOUBLE_VALUE:
      return Double.valueOf(getDoubleValue());

    case LONG_VALUE:
      return Long.valueOf(getLongValue());

    case TYPE:
      return Integer.valueOf(getType());

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case BINARY_VALUE:
      return isSetBinaryValue();
    case STRING_VALUE:
      return isSetStringValue();
    case BOOL_VALUE:
      return isSetBoolValue();
    case DOUBLE_VALUE:
      return isSetDoubleValue();
    case LONG_VALUE:
      return isSetLongValue();
    case TYPE:
      return isSetType();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof TValue)
      return this.equals((TValue)that);
    return false;
  }

  public boolean equals(TValue that) {
    if (that == null)
      return false;

    boolean this_present_binaryValue = true && this.isSetBinaryValue();
    boolean that_present_binaryValue = true && that.isSetBinaryValue();
    if (this_present_binaryValue || that_present_binaryValue) {
      if (!(this_present_binaryValue && that_present_binaryValue))
        return false;
      if (!this.binaryValue.equals(that.binaryValue))
        return false;
    }

    boolean this_present_stringValue = true && this.isSetStringValue();
    boolean that_present_stringValue = true && that.isSetStringValue();
    if (this_present_stringValue || that_present_stringValue) {
      if (!(this_present_stringValue && that_present_stringValue))
        return false;
      if (!this.stringValue.equals(that.stringValue))
        return false;
    }

    boolean this_present_boolValue = true;
    boolean that_present_boolValue = true;
    if (this_present_boolValue || that_present_boolValue) {
      if (!(this_present_boolValue && that_present_boolValue))
        return false;
      if (this.boolValue != that.boolValue)
        return false;
    }

    boolean this_present_doubleValue = true;
    boolean that_present_doubleValue = true;
    if (this_present_doubleValue || that_present_doubleValue) {
      if (!(this_present_doubleValue && that_present_doubleValue))
        return false;
      if (this.doubleValue != that.doubleValue)
        return false;
    }

    boolean this_present_longValue = true;
    boolean that_present_longValue = true;
    if (this_present_longValue || that_present_longValue) {
      if (!(this_present_longValue && that_present_longValue))
        return false;
      if (this.longValue != that.longValue)
        return false;
    }

    boolean this_present_type = true;
    boolean that_present_type = true;
    if (this_present_type || that_present_type) {
      if (!(this_present_type && that_present_type))
        return false;
      if (this.type != that.type)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_binaryValue = true && (isSetBinaryValue());
    list.add(present_binaryValue);
    if (present_binaryValue)
      list.add(binaryValue);

    boolean present_stringValue = true && (isSetStringValue());
    list.add(present_stringValue);
    if (present_stringValue)
      list.add(stringValue);

    boolean present_boolValue = true;
    list.add(present_boolValue);
    if (present_boolValue)
      list.add(boolValue);

    boolean present_doubleValue = true;
    list.add(present_doubleValue);
    if (present_doubleValue)
      list.add(doubleValue);

    boolean present_longValue = true;
    list.add(present_longValue);
    if (present_longValue)
      list.add(longValue);

    boolean present_type = true;
    list.add(present_type);
    if (present_type)
      list.add(type);

    return list.hashCode();
  }

  @Override
  public int compareTo(TValue other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetBinaryValue()).compareTo(other.isSetBinaryValue());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetBinaryValue()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.binaryValue, other.binaryValue);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetStringValue()).compareTo(other.isSetStringValue());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetStringValue()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.stringValue, other.stringValue);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetBoolValue()).compareTo(other.isSetBoolValue());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetBoolValue()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.boolValue, other.boolValue);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetDoubleValue()).compareTo(other.isSetDoubleValue());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDoubleValue()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.doubleValue, other.doubleValue);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetLongValue()).compareTo(other.isSetLongValue());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetLongValue()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.longValue, other.longValue);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetType()).compareTo(other.isSetType());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetType()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.type, other.type);
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
    StringBuilder sb = new StringBuilder("TValue(");
    boolean first = true;

    sb.append("binaryValue:");
    if (this.binaryValue == null) {
      sb.append("null");
    } else {
      org.apache.thrift.TBaseHelper.toString(this.binaryValue, sb);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("stringValue:");
    if (this.stringValue == null) {
      sb.append("null");
    } else {
      sb.append(this.stringValue);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("boolValue:");
    sb.append(this.boolValue);
    first = false;
    if (!first) sb.append(", ");
    sb.append("doubleValue:");
    sb.append(this.doubleValue);
    first = false;
    if (!first) sb.append(", ");
    sb.append("longValue:");
    sb.append(this.longValue);
    first = false;
    if (!first) sb.append(", ");
    sb.append("type:");
    sb.append(this.type);
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

  private static class TValueStandardSchemeFactory implements SchemeFactory {
    public TValueStandardScheme getScheme() {
      return new TValueStandardScheme();
    }
  }

  private static class TValueStandardScheme extends StandardScheme<TValue> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, TValue struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // BINARY_VALUE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.binaryValue = iprot.readBinary();
              struct.setBinaryValueIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // STRING_VALUE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.stringValue = iprot.readString();
              struct.setStringValueIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // BOOL_VALUE
            if (schemeField.type == org.apache.thrift.protocol.TType.BOOL) {
              struct.boolValue = iprot.readBool();
              struct.setBoolValueIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // DOUBLE_VALUE
            if (schemeField.type == org.apache.thrift.protocol.TType.DOUBLE) {
              struct.doubleValue = iprot.readDouble();
              struct.setDoubleValueIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // LONG_VALUE
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.longValue = iprot.readI64();
              struct.setLongValueIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // TYPE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.type = iprot.readI32();
              struct.setTypeIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, TValue struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.binaryValue != null) {
        oprot.writeFieldBegin(BINARY_VALUE_FIELD_DESC);
        oprot.writeBinary(struct.binaryValue);
        oprot.writeFieldEnd();
      }
      if (struct.stringValue != null) {
        oprot.writeFieldBegin(STRING_VALUE_FIELD_DESC);
        oprot.writeString(struct.stringValue);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(BOOL_VALUE_FIELD_DESC);
      oprot.writeBool(struct.boolValue);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(DOUBLE_VALUE_FIELD_DESC);
      oprot.writeDouble(struct.doubleValue);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(LONG_VALUE_FIELD_DESC);
      oprot.writeI64(struct.longValue);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(TYPE_FIELD_DESC);
      oprot.writeI32(struct.type);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TValueTupleSchemeFactory implements SchemeFactory {
    public TValueTupleScheme getScheme() {
      return new TValueTupleScheme();
    }
  }

  private static class TValueTupleScheme extends TupleScheme<TValue> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TValue struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetBinaryValue()) {
        optionals.set(0);
      }
      if (struct.isSetStringValue()) {
        optionals.set(1);
      }
      if (struct.isSetBoolValue()) {
        optionals.set(2);
      }
      if (struct.isSetDoubleValue()) {
        optionals.set(3);
      }
      if (struct.isSetLongValue()) {
        optionals.set(4);
      }
      if (struct.isSetType()) {
        optionals.set(5);
      }
      oprot.writeBitSet(optionals, 6);
      if (struct.isSetBinaryValue()) {
        oprot.writeBinary(struct.binaryValue);
      }
      if (struct.isSetStringValue()) {
        oprot.writeString(struct.stringValue);
      }
      if (struct.isSetBoolValue()) {
        oprot.writeBool(struct.boolValue);
      }
      if (struct.isSetDoubleValue()) {
        oprot.writeDouble(struct.doubleValue);
      }
      if (struct.isSetLongValue()) {
        oprot.writeI64(struct.longValue);
      }
      if (struct.isSetType()) {
        oprot.writeI32(struct.type);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TValue struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(6);
      if (incoming.get(0)) {
        struct.binaryValue = iprot.readBinary();
        struct.setBinaryValueIsSet(true);
      }
      if (incoming.get(1)) {
        struct.stringValue = iprot.readString();
        struct.setStringValueIsSet(true);
      }
      if (incoming.get(2)) {
        struct.boolValue = iprot.readBool();
        struct.setBoolValueIsSet(true);
      }
      if (incoming.get(3)) {
        struct.doubleValue = iprot.readDouble();
        struct.setDoubleValueIsSet(true);
      }
      if (incoming.get(4)) {
        struct.longValue = iprot.readI64();
        struct.setLongValueIsSet(true);
      }
      if (incoming.get(5)) {
        struct.type = iprot.readI32();
        struct.setTypeIsSet(true);
      }
    }
  }

}

