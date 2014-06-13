/**
 * Autogenerated by Thrift Compiler (1.0.0-dev)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.jumlabs.jcr.oak.rpc.api;

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
@Generated(value = "Autogenerated by Thrift Compiler (1.0.0-dev)", date = "2014-6-12")
public class TPropertyState implements org.apache.thrift.TBase<TPropertyState, TPropertyState._Fields>, java.io.Serializable, Cloneable, Comparable<TPropertyState> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TPropertyState");

  private static final org.apache.thrift.protocol.TField COUNT_FIELD_DESC = new org.apache.thrift.protocol.TField("count", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("name", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField SIZE_FIELD_DESC = new org.apache.thrift.protocol.TField("size", org.apache.thrift.protocol.TType.I32, (short)3);
  private static final org.apache.thrift.protocol.TField IS_ARRAY_FIELD_DESC = new org.apache.thrift.protocol.TField("isArray", org.apache.thrift.protocol.TType.BOOL, (short)4);
  private static final org.apache.thrift.protocol.TField TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("type", org.apache.thrift.protocol.TType.I32, (short)5);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new TPropertyStateStandardSchemeFactory());
    schemes.put(TupleScheme.class, new TPropertyStateTupleSchemeFactory());
  }

  public int count; // required
  public String name; // required
  public int size; // required
  public boolean isArray; // required
  /**
   * 
   * @see TType
   */
  public TType type; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    COUNT((short)1, "count"),
    NAME((short)2, "name"),
    SIZE((short)3, "size"),
    IS_ARRAY((short)4, "isArray"),
    /**
     * 
     * @see TType
     */
    TYPE((short)5, "type");

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
        case 1: // COUNT
          return COUNT;
        case 2: // NAME
          return NAME;
        case 3: // SIZE
          return SIZE;
        case 4: // IS_ARRAY
          return IS_ARRAY;
        case 5: // TYPE
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
  private static final int __COUNT_ISSET_ID = 0;
  private static final int __SIZE_ISSET_ID = 1;
  private static final int __ISARRAY_ISSET_ID = 2;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.COUNT, new org.apache.thrift.meta_data.FieldMetaData("count", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.NAME, new org.apache.thrift.meta_data.FieldMetaData("name", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.SIZE, new org.apache.thrift.meta_data.FieldMetaData("size", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.IS_ARRAY, new org.apache.thrift.meta_data.FieldMetaData("isArray", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BOOL)));
    tmpMap.put(_Fields.TYPE, new org.apache.thrift.meta_data.FieldMetaData("type", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, TType.class)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TPropertyState.class, metaDataMap);
  }

  public TPropertyState() {
  }

  public TPropertyState(
    int count,
    String name,
    int size,
    boolean isArray,
    TType type)
  {
    this();
    this.count = count;
    setCountIsSet(true);
    this.name = name;
    this.size = size;
    setSizeIsSet(true);
    this.isArray = isArray;
    setIsArrayIsSet(true);
    this.type = type;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TPropertyState(TPropertyState other) {
    __isset_bitfield = other.__isset_bitfield;
    this.count = other.count;
    if (other.isSetName()) {
      this.name = other.name;
    }
    this.size = other.size;
    this.isArray = other.isArray;
    if (other.isSetType()) {
      this.type = other.type;
    }
  }

  public TPropertyState deepCopy() {
    return new TPropertyState(this);
  }

  @Override
  public void clear() {
    setCountIsSet(false);
    this.count = 0;
    this.name = null;
    setSizeIsSet(false);
    this.size = 0;
    setIsArrayIsSet(false);
    this.isArray = false;
    this.type = null;
  }

  public int getCount() {
    return this.count;
  }

  public TPropertyState setCount(int count) {
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

  public String getName() {
    return this.name;
  }

  public TPropertyState setName(String name) {
    this.name = name;
    return this;
  }

  public void unsetName() {
    this.name = null;
  }

  /** Returns true if field name is set (has been assigned a value) and false otherwise */
  public boolean isSetName() {
    return this.name != null;
  }

  public void setNameIsSet(boolean value) {
    if (!value) {
      this.name = null;
    }
  }

  public int getSize() {
    return this.size;
  }

  public TPropertyState setSize(int size) {
    this.size = size;
    setSizeIsSet(true);
    return this;
  }

  public void unsetSize() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __SIZE_ISSET_ID);
  }

  /** Returns true if field size is set (has been assigned a value) and false otherwise */
  public boolean isSetSize() {
    return EncodingUtils.testBit(__isset_bitfield, __SIZE_ISSET_ID);
  }

  public void setSizeIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __SIZE_ISSET_ID, value);
  }

  public boolean isIsArray() {
    return this.isArray;
  }

  public TPropertyState setIsArray(boolean isArray) {
    this.isArray = isArray;
    setIsArrayIsSet(true);
    return this;
  }

  public void unsetIsArray() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __ISARRAY_ISSET_ID);
  }

  /** Returns true if field isArray is set (has been assigned a value) and false otherwise */
  public boolean isSetIsArray() {
    return EncodingUtils.testBit(__isset_bitfield, __ISARRAY_ISSET_ID);
  }

  public void setIsArrayIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __ISARRAY_ISSET_ID, value);
  }

  /**
   * 
   * @see TType
   */
  public TType getType() {
    return this.type;
  }

  /**
   * 
   * @see TType
   */
  public TPropertyState setType(TType type) {
    this.type = type;
    return this;
  }

  public void unsetType() {
    this.type = null;
  }

  /** Returns true if field type is set (has been assigned a value) and false otherwise */
  public boolean isSetType() {
    return this.type != null;
  }

  public void setTypeIsSet(boolean value) {
    if (!value) {
      this.type = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case COUNT:
      if (value == null) {
        unsetCount();
      } else {
        setCount((Integer)value);
      }
      break;

    case NAME:
      if (value == null) {
        unsetName();
      } else {
        setName((String)value);
      }
      break;

    case SIZE:
      if (value == null) {
        unsetSize();
      } else {
        setSize((Integer)value);
      }
      break;

    case IS_ARRAY:
      if (value == null) {
        unsetIsArray();
      } else {
        setIsArray((Boolean)value);
      }
      break;

    case TYPE:
      if (value == null) {
        unsetType();
      } else {
        setType((TType)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case COUNT:
      return Integer.valueOf(getCount());

    case NAME:
      return getName();

    case SIZE:
      return Integer.valueOf(getSize());

    case IS_ARRAY:
      return Boolean.valueOf(isIsArray());

    case TYPE:
      return getType();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case COUNT:
      return isSetCount();
    case NAME:
      return isSetName();
    case SIZE:
      return isSetSize();
    case IS_ARRAY:
      return isSetIsArray();
    case TYPE:
      return isSetType();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof TPropertyState)
      return this.equals((TPropertyState)that);
    return false;
  }

  public boolean equals(TPropertyState that) {
    if (that == null)
      return false;

    boolean this_present_count = true;
    boolean that_present_count = true;
    if (this_present_count || that_present_count) {
      if (!(this_present_count && that_present_count))
        return false;
      if (this.count != that.count)
        return false;
    }

    boolean this_present_name = true && this.isSetName();
    boolean that_present_name = true && that.isSetName();
    if (this_present_name || that_present_name) {
      if (!(this_present_name && that_present_name))
        return false;
      if (!this.name.equals(that.name))
        return false;
    }

    boolean this_present_size = true;
    boolean that_present_size = true;
    if (this_present_size || that_present_size) {
      if (!(this_present_size && that_present_size))
        return false;
      if (this.size != that.size)
        return false;
    }

    boolean this_present_isArray = true;
    boolean that_present_isArray = true;
    if (this_present_isArray || that_present_isArray) {
      if (!(this_present_isArray && that_present_isArray))
        return false;
      if (this.isArray != that.isArray)
        return false;
    }

    boolean this_present_type = true && this.isSetType();
    boolean that_present_type = true && that.isSetType();
    if (this_present_type || that_present_type) {
      if (!(this_present_type && that_present_type))
        return false;
      if (!this.type.equals(that.type))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_count = true;
    list.add(present_count);
    if (present_count)
      list.add(count);

    boolean present_name = true && (isSetName());
    list.add(present_name);
    if (present_name)
      list.add(name);

    boolean present_size = true;
    list.add(present_size);
    if (present_size)
      list.add(size);

    boolean present_isArray = true;
    list.add(present_isArray);
    if (present_isArray)
      list.add(isArray);

    boolean present_type = true && (isSetType());
    list.add(present_type);
    if (present_type)
      list.add(type.getValue());

    return list.hashCode();
  }

  @Override
  public int compareTo(TPropertyState other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

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
    lastComparison = Boolean.valueOf(isSetName()).compareTo(other.isSetName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.name, other.name);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetSize()).compareTo(other.isSetSize());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSize()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.size, other.size);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetIsArray()).compareTo(other.isSetIsArray());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetIsArray()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.isArray, other.isArray);
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
    StringBuilder sb = new StringBuilder("TPropertyState(");
    boolean first = true;

    sb.append("count:");
    sb.append(this.count);
    first = false;
    if (!first) sb.append(", ");
    sb.append("name:");
    if (this.name == null) {
      sb.append("null");
    } else {
      sb.append(this.name);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("size:");
    sb.append(this.size);
    first = false;
    if (!first) sb.append(", ");
    sb.append("isArray:");
    sb.append(this.isArray);
    first = false;
    if (!first) sb.append(", ");
    sb.append("type:");
    if (this.type == null) {
      sb.append("null");
    } else {
      sb.append(this.type);
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
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class TPropertyStateStandardSchemeFactory implements SchemeFactory {
    public TPropertyStateStandardScheme getScheme() {
      return new TPropertyStateStandardScheme();
    }
  }

  private static class TPropertyStateStandardScheme extends StandardScheme<TPropertyState> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, TPropertyState struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // COUNT
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.count = iprot.readI32();
              struct.setCountIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.name = iprot.readString();
              struct.setNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // SIZE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.size = iprot.readI32();
              struct.setSizeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // IS_ARRAY
            if (schemeField.type == org.apache.thrift.protocol.TType.BOOL) {
              struct.isArray = iprot.readBool();
              struct.setIsArrayIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // TYPE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.type = org.jumlabs.jcr.oak.rpc.api.TType.findByValue(iprot.readI32());
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, TPropertyState struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(COUNT_FIELD_DESC);
      oprot.writeI32(struct.count);
      oprot.writeFieldEnd();
      if (struct.name != null) {
        oprot.writeFieldBegin(NAME_FIELD_DESC);
        oprot.writeString(struct.name);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(SIZE_FIELD_DESC);
      oprot.writeI32(struct.size);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(IS_ARRAY_FIELD_DESC);
      oprot.writeBool(struct.isArray);
      oprot.writeFieldEnd();
      if (struct.type != null) {
        oprot.writeFieldBegin(TYPE_FIELD_DESC);
        oprot.writeI32(struct.type.getValue());
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TPropertyStateTupleSchemeFactory implements SchemeFactory {
    public TPropertyStateTupleScheme getScheme() {
      return new TPropertyStateTupleScheme();
    }
  }

  private static class TPropertyStateTupleScheme extends TupleScheme<TPropertyState> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TPropertyState struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetCount()) {
        optionals.set(0);
      }
      if (struct.isSetName()) {
        optionals.set(1);
      }
      if (struct.isSetSize()) {
        optionals.set(2);
      }
      if (struct.isSetIsArray()) {
        optionals.set(3);
      }
      if (struct.isSetType()) {
        optionals.set(4);
      }
      oprot.writeBitSet(optionals, 5);
      if (struct.isSetCount()) {
        oprot.writeI32(struct.count);
      }
      if (struct.isSetName()) {
        oprot.writeString(struct.name);
      }
      if (struct.isSetSize()) {
        oprot.writeI32(struct.size);
      }
      if (struct.isSetIsArray()) {
        oprot.writeBool(struct.isArray);
      }
      if (struct.isSetType()) {
        oprot.writeI32(struct.type.getValue());
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TPropertyState struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(5);
      if (incoming.get(0)) {
        struct.count = iprot.readI32();
        struct.setCountIsSet(true);
      }
      if (incoming.get(1)) {
        struct.name = iprot.readString();
        struct.setNameIsSet(true);
      }
      if (incoming.get(2)) {
        struct.size = iprot.readI32();
        struct.setSizeIsSet(true);
      }
      if (incoming.get(3)) {
        struct.isArray = iprot.readBool();
        struct.setIsArrayIsSet(true);
      }
      if (incoming.get(4)) {
        struct.type = org.jumlabs.jcr.oak.rpc.api.TType.findByValue(iprot.readI32());
        struct.setTypeIsSet(true);
      }
    }
  }

}

