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
public class TNodeDefinition implements org.apache.thrift.TBase<TNodeDefinition, TNodeDefinition._Fields>, java.io.Serializable, Cloneable, Comparable<TNodeDefinition> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TNodeDefinition");

  private static final org.apache.thrift.protocol.TField DEFAULT_PRIMARY_TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("defaultPrimaryType", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField REQUIRED_PRIMARY_TYPES_FIELD_DESC = new org.apache.thrift.protocol.TField("requiredPrimaryTypes", org.apache.thrift.protocol.TType.LIST, (short)2);
  private static final org.apache.thrift.protocol.TField DECLARING_NODE_TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("declaringNodeType", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("name", org.apache.thrift.protocol.TType.STRING, (short)4);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new TNodeDefinitionStandardSchemeFactory());
    schemes.put(TupleScheme.class, new TNodeDefinitionTupleSchemeFactory());
  }

  public String defaultPrimaryType; // required
  public List<String> requiredPrimaryTypes; // required
  public String declaringNodeType; // required
  public String name; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    DEFAULT_PRIMARY_TYPE((short)1, "defaultPrimaryType"),
    REQUIRED_PRIMARY_TYPES((short)2, "requiredPrimaryTypes"),
    DECLARING_NODE_TYPE((short)3, "declaringNodeType"),
    NAME((short)4, "name");

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
        case 1: // DEFAULT_PRIMARY_TYPE
          return DEFAULT_PRIMARY_TYPE;
        case 2: // REQUIRED_PRIMARY_TYPES
          return REQUIRED_PRIMARY_TYPES;
        case 3: // DECLARING_NODE_TYPE
          return DECLARING_NODE_TYPE;
        case 4: // NAME
          return NAME;
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
    tmpMap.put(_Fields.DEFAULT_PRIMARY_TYPE, new org.apache.thrift.meta_data.FieldMetaData("defaultPrimaryType", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.REQUIRED_PRIMARY_TYPES, new org.apache.thrift.meta_data.FieldMetaData("requiredPrimaryTypes", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING))));
    tmpMap.put(_Fields.DECLARING_NODE_TYPE, new org.apache.thrift.meta_data.FieldMetaData("declaringNodeType", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.NAME, new org.apache.thrift.meta_data.FieldMetaData("name", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TNodeDefinition.class, metaDataMap);
  }

  public TNodeDefinition() {
  }

  public TNodeDefinition(
    String defaultPrimaryType,
    List<String> requiredPrimaryTypes,
    String declaringNodeType,
    String name)
  {
    this();
    this.defaultPrimaryType = defaultPrimaryType;
    this.requiredPrimaryTypes = requiredPrimaryTypes;
    this.declaringNodeType = declaringNodeType;
    this.name = name;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TNodeDefinition(TNodeDefinition other) {
    if (other.isSetDefaultPrimaryType()) {
      this.defaultPrimaryType = other.defaultPrimaryType;
    }
    if (other.isSetRequiredPrimaryTypes()) {
      List<String> __this__requiredPrimaryTypes = new ArrayList<String>(other.requiredPrimaryTypes);
      this.requiredPrimaryTypes = __this__requiredPrimaryTypes;
    }
    if (other.isSetDeclaringNodeType()) {
      this.declaringNodeType = other.declaringNodeType;
    }
    if (other.isSetName()) {
      this.name = other.name;
    }
  }

  public TNodeDefinition deepCopy() {
    return new TNodeDefinition(this);
  }

  @Override
  public void clear() {
    this.defaultPrimaryType = null;
    this.requiredPrimaryTypes = null;
    this.declaringNodeType = null;
    this.name = null;
  }

  public String getDefaultPrimaryType() {
    return this.defaultPrimaryType;
  }

  public TNodeDefinition setDefaultPrimaryType(String defaultPrimaryType) {
    this.defaultPrimaryType = defaultPrimaryType;
    return this;
  }

  public void unsetDefaultPrimaryType() {
    this.defaultPrimaryType = null;
  }

  /** Returns true if field defaultPrimaryType is set (has been assigned a value) and false otherwise */
  public boolean isSetDefaultPrimaryType() {
    return this.defaultPrimaryType != null;
  }

  public void setDefaultPrimaryTypeIsSet(boolean value) {
    if (!value) {
      this.defaultPrimaryType = null;
    }
  }

  public int getRequiredPrimaryTypesSize() {
    return (this.requiredPrimaryTypes == null) ? 0 : this.requiredPrimaryTypes.size();
  }

  public java.util.Iterator<String> getRequiredPrimaryTypesIterator() {
    return (this.requiredPrimaryTypes == null) ? null : this.requiredPrimaryTypes.iterator();
  }

  public void addToRequiredPrimaryTypes(String elem) {
    if (this.requiredPrimaryTypes == null) {
      this.requiredPrimaryTypes = new ArrayList<String>();
    }
    this.requiredPrimaryTypes.add(elem);
  }

  public List<String> getRequiredPrimaryTypes() {
    return this.requiredPrimaryTypes;
  }

  public TNodeDefinition setRequiredPrimaryTypes(List<String> requiredPrimaryTypes) {
    this.requiredPrimaryTypes = requiredPrimaryTypes;
    return this;
  }

  public void unsetRequiredPrimaryTypes() {
    this.requiredPrimaryTypes = null;
  }

  /** Returns true if field requiredPrimaryTypes is set (has been assigned a value) and false otherwise */
  public boolean isSetRequiredPrimaryTypes() {
    return this.requiredPrimaryTypes != null;
  }

  public void setRequiredPrimaryTypesIsSet(boolean value) {
    if (!value) {
      this.requiredPrimaryTypes = null;
    }
  }

  public String getDeclaringNodeType() {
    return this.declaringNodeType;
  }

  public TNodeDefinition setDeclaringNodeType(String declaringNodeType) {
    this.declaringNodeType = declaringNodeType;
    return this;
  }

  public void unsetDeclaringNodeType() {
    this.declaringNodeType = null;
  }

  /** Returns true if field declaringNodeType is set (has been assigned a value) and false otherwise */
  public boolean isSetDeclaringNodeType() {
    return this.declaringNodeType != null;
  }

  public void setDeclaringNodeTypeIsSet(boolean value) {
    if (!value) {
      this.declaringNodeType = null;
    }
  }

  public String getName() {
    return this.name;
  }

  public TNodeDefinition setName(String name) {
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

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case DEFAULT_PRIMARY_TYPE:
      if (value == null) {
        unsetDefaultPrimaryType();
      } else {
        setDefaultPrimaryType((String)value);
      }
      break;

    case REQUIRED_PRIMARY_TYPES:
      if (value == null) {
        unsetRequiredPrimaryTypes();
      } else {
        setRequiredPrimaryTypes((List<String>)value);
      }
      break;

    case DECLARING_NODE_TYPE:
      if (value == null) {
        unsetDeclaringNodeType();
      } else {
        setDeclaringNodeType((String)value);
      }
      break;

    case NAME:
      if (value == null) {
        unsetName();
      } else {
        setName((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case DEFAULT_PRIMARY_TYPE:
      return getDefaultPrimaryType();

    case REQUIRED_PRIMARY_TYPES:
      return getRequiredPrimaryTypes();

    case DECLARING_NODE_TYPE:
      return getDeclaringNodeType();

    case NAME:
      return getName();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case DEFAULT_PRIMARY_TYPE:
      return isSetDefaultPrimaryType();
    case REQUIRED_PRIMARY_TYPES:
      return isSetRequiredPrimaryTypes();
    case DECLARING_NODE_TYPE:
      return isSetDeclaringNodeType();
    case NAME:
      return isSetName();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof TNodeDefinition)
      return this.equals((TNodeDefinition)that);
    return false;
  }

  public boolean equals(TNodeDefinition that) {
    if (that == null)
      return false;

    boolean this_present_defaultPrimaryType = true && this.isSetDefaultPrimaryType();
    boolean that_present_defaultPrimaryType = true && that.isSetDefaultPrimaryType();
    if (this_present_defaultPrimaryType || that_present_defaultPrimaryType) {
      if (!(this_present_defaultPrimaryType && that_present_defaultPrimaryType))
        return false;
      if (!this.defaultPrimaryType.equals(that.defaultPrimaryType))
        return false;
    }

    boolean this_present_requiredPrimaryTypes = true && this.isSetRequiredPrimaryTypes();
    boolean that_present_requiredPrimaryTypes = true && that.isSetRequiredPrimaryTypes();
    if (this_present_requiredPrimaryTypes || that_present_requiredPrimaryTypes) {
      if (!(this_present_requiredPrimaryTypes && that_present_requiredPrimaryTypes))
        return false;
      if (!this.requiredPrimaryTypes.equals(that.requiredPrimaryTypes))
        return false;
    }

    boolean this_present_declaringNodeType = true && this.isSetDeclaringNodeType();
    boolean that_present_declaringNodeType = true && that.isSetDeclaringNodeType();
    if (this_present_declaringNodeType || that_present_declaringNodeType) {
      if (!(this_present_declaringNodeType && that_present_declaringNodeType))
        return false;
      if (!this.declaringNodeType.equals(that.declaringNodeType))
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

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_defaultPrimaryType = true && (isSetDefaultPrimaryType());
    list.add(present_defaultPrimaryType);
    if (present_defaultPrimaryType)
      list.add(defaultPrimaryType);

    boolean present_requiredPrimaryTypes = true && (isSetRequiredPrimaryTypes());
    list.add(present_requiredPrimaryTypes);
    if (present_requiredPrimaryTypes)
      list.add(requiredPrimaryTypes);

    boolean present_declaringNodeType = true && (isSetDeclaringNodeType());
    list.add(present_declaringNodeType);
    if (present_declaringNodeType)
      list.add(declaringNodeType);

    boolean present_name = true && (isSetName());
    list.add(present_name);
    if (present_name)
      list.add(name);

    return list.hashCode();
  }

  @Override
  public int compareTo(TNodeDefinition other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetDefaultPrimaryType()).compareTo(other.isSetDefaultPrimaryType());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDefaultPrimaryType()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.defaultPrimaryType, other.defaultPrimaryType);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetRequiredPrimaryTypes()).compareTo(other.isSetRequiredPrimaryTypes());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetRequiredPrimaryTypes()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.requiredPrimaryTypes, other.requiredPrimaryTypes);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetDeclaringNodeType()).compareTo(other.isSetDeclaringNodeType());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDeclaringNodeType()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.declaringNodeType, other.declaringNodeType);
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
    StringBuilder sb = new StringBuilder("TNodeDefinition(");
    boolean first = true;

    sb.append("defaultPrimaryType:");
    if (this.defaultPrimaryType == null) {
      sb.append("null");
    } else {
      sb.append(this.defaultPrimaryType);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("requiredPrimaryTypes:");
    if (this.requiredPrimaryTypes == null) {
      sb.append("null");
    } else {
      sb.append(this.requiredPrimaryTypes);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("declaringNodeType:");
    if (this.declaringNodeType == null) {
      sb.append("null");
    } else {
      sb.append(this.declaringNodeType);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("name:");
    if (this.name == null) {
      sb.append("null");
    } else {
      sb.append(this.name);
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

  private static class TNodeDefinitionStandardSchemeFactory implements SchemeFactory {
    public TNodeDefinitionStandardScheme getScheme() {
      return new TNodeDefinitionStandardScheme();
    }
  }

  private static class TNodeDefinitionStandardScheme extends StandardScheme<TNodeDefinition> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, TNodeDefinition struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // DEFAULT_PRIMARY_TYPE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.defaultPrimaryType = iprot.readString();
              struct.setDefaultPrimaryTypeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // REQUIRED_PRIMARY_TYPES
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list8 = iprot.readListBegin();
                struct.requiredPrimaryTypes = new ArrayList<String>(_list8.size);
                String _elem9;
                for (int _i10 = 0; _i10 < _list8.size; ++_i10)
                {
                  _elem9 = iprot.readString();
                  struct.requiredPrimaryTypes.add(_elem9);
                }
                iprot.readListEnd();
              }
              struct.setRequiredPrimaryTypesIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // DECLARING_NODE_TYPE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.declaringNodeType = iprot.readString();
              struct.setDeclaringNodeTypeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.name = iprot.readString();
              struct.setNameIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, TNodeDefinition struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.defaultPrimaryType != null) {
        oprot.writeFieldBegin(DEFAULT_PRIMARY_TYPE_FIELD_DESC);
        oprot.writeString(struct.defaultPrimaryType);
        oprot.writeFieldEnd();
      }
      if (struct.requiredPrimaryTypes != null) {
        oprot.writeFieldBegin(REQUIRED_PRIMARY_TYPES_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, struct.requiredPrimaryTypes.size()));
          for (String _iter11 : struct.requiredPrimaryTypes)
          {
            oprot.writeString(_iter11);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      if (struct.declaringNodeType != null) {
        oprot.writeFieldBegin(DECLARING_NODE_TYPE_FIELD_DESC);
        oprot.writeString(struct.declaringNodeType);
        oprot.writeFieldEnd();
      }
      if (struct.name != null) {
        oprot.writeFieldBegin(NAME_FIELD_DESC);
        oprot.writeString(struct.name);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TNodeDefinitionTupleSchemeFactory implements SchemeFactory {
    public TNodeDefinitionTupleScheme getScheme() {
      return new TNodeDefinitionTupleScheme();
    }
  }

  private static class TNodeDefinitionTupleScheme extends TupleScheme<TNodeDefinition> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TNodeDefinition struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetDefaultPrimaryType()) {
        optionals.set(0);
      }
      if (struct.isSetRequiredPrimaryTypes()) {
        optionals.set(1);
      }
      if (struct.isSetDeclaringNodeType()) {
        optionals.set(2);
      }
      if (struct.isSetName()) {
        optionals.set(3);
      }
      oprot.writeBitSet(optionals, 4);
      if (struct.isSetDefaultPrimaryType()) {
        oprot.writeString(struct.defaultPrimaryType);
      }
      if (struct.isSetRequiredPrimaryTypes()) {
        {
          oprot.writeI32(struct.requiredPrimaryTypes.size());
          for (String _iter12 : struct.requiredPrimaryTypes)
          {
            oprot.writeString(_iter12);
          }
        }
      }
      if (struct.isSetDeclaringNodeType()) {
        oprot.writeString(struct.declaringNodeType);
      }
      if (struct.isSetName()) {
        oprot.writeString(struct.name);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TNodeDefinition struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(4);
      if (incoming.get(0)) {
        struct.defaultPrimaryType = iprot.readString();
        struct.setDefaultPrimaryTypeIsSet(true);
      }
      if (incoming.get(1)) {
        {
          org.apache.thrift.protocol.TList _list13 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, iprot.readI32());
          struct.requiredPrimaryTypes = new ArrayList<String>(_list13.size);
          String _elem14;
          for (int _i15 = 0; _i15 < _list13.size; ++_i15)
          {
            _elem14 = iprot.readString();
            struct.requiredPrimaryTypes.add(_elem14);
          }
        }
        struct.setRequiredPrimaryTypesIsSet(true);
      }
      if (incoming.get(2)) {
        struct.declaringNodeType = iprot.readString();
        struct.setDeclaringNodeTypeIsSet(true);
      }
      if (incoming.get(3)) {
        struct.name = iprot.readString();
        struct.setNameIsSet(true);
      }
    }
  }

}
