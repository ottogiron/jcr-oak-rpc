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
@Generated(value = "Autogenerated by Thrift Compiler (1.0.0-dev)", date = "2015-2-4")
public class TNodeType implements org.apache.thrift.TBase<TNodeType, TNodeType._Fields>, java.io.Serializable, Cloneable, Comparable<TNodeType> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TNodeType");

  private static final org.apache.thrift.protocol.TField NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("name", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField PROPERTY_DEFINITIONS_FIELD_DESC = new org.apache.thrift.protocol.TField("propertyDefinitions", org.apache.thrift.protocol.TType.LIST, (short)2);
  private static final org.apache.thrift.protocol.TField CHILD_NODE_DEFINITIONS_FIELD_DESC = new org.apache.thrift.protocol.TField("childNodeDefinitions", org.apache.thrift.protocol.TType.LIST, (short)3);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new TNodeTypeStandardSchemeFactory());
    schemes.put(TupleScheme.class, new TNodeTypeTupleSchemeFactory());
  }

  public String name; // required
  public List<TPropertyDefinition> propertyDefinitions; // required
  public List<TNodeDefinition> childNodeDefinitions; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    NAME((short)1, "name"),
    PROPERTY_DEFINITIONS((short)2, "propertyDefinitions"),
    CHILD_NODE_DEFINITIONS((short)3, "childNodeDefinitions");

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
        case 1: // NAME
          return NAME;
        case 2: // PROPERTY_DEFINITIONS
          return PROPERTY_DEFINITIONS;
        case 3: // CHILD_NODE_DEFINITIONS
          return CHILD_NODE_DEFINITIONS;
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
    tmpMap.put(_Fields.NAME, new org.apache.thrift.meta_data.FieldMetaData("name", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.PROPERTY_DEFINITIONS, new org.apache.thrift.meta_data.FieldMetaData("propertyDefinitions", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, TPropertyDefinition.class))));
    tmpMap.put(_Fields.CHILD_NODE_DEFINITIONS, new org.apache.thrift.meta_data.FieldMetaData("childNodeDefinitions", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, TNodeDefinition.class))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TNodeType.class, metaDataMap);
  }

  public TNodeType() {
  }

  public TNodeType(
    String name,
    List<TPropertyDefinition> propertyDefinitions,
    List<TNodeDefinition> childNodeDefinitions)
  {
    this();
    this.name = name;
    this.propertyDefinitions = propertyDefinitions;
    this.childNodeDefinitions = childNodeDefinitions;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TNodeType(TNodeType other) {
    if (other.isSetName()) {
      this.name = other.name;
    }
    if (other.isSetPropertyDefinitions()) {
      List<TPropertyDefinition> __this__propertyDefinitions = new ArrayList<TPropertyDefinition>(other.propertyDefinitions.size());
      for (TPropertyDefinition other_element : other.propertyDefinitions) {
        __this__propertyDefinitions.add(new TPropertyDefinition(other_element));
      }
      this.propertyDefinitions = __this__propertyDefinitions;
    }
    if (other.isSetChildNodeDefinitions()) {
      List<TNodeDefinition> __this__childNodeDefinitions = new ArrayList<TNodeDefinition>(other.childNodeDefinitions.size());
      for (TNodeDefinition other_element : other.childNodeDefinitions) {
        __this__childNodeDefinitions.add(new TNodeDefinition(other_element));
      }
      this.childNodeDefinitions = __this__childNodeDefinitions;
    }
  }

  public TNodeType deepCopy() {
    return new TNodeType(this);
  }

  @Override
  public void clear() {
    this.name = null;
    this.propertyDefinitions = null;
    this.childNodeDefinitions = null;
  }

  public String getName() {
    return this.name;
  }

  public TNodeType setName(String name) {
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

  public int getPropertyDefinitionsSize() {
    return (this.propertyDefinitions == null) ? 0 : this.propertyDefinitions.size();
  }

  public java.util.Iterator<TPropertyDefinition> getPropertyDefinitionsIterator() {
    return (this.propertyDefinitions == null) ? null : this.propertyDefinitions.iterator();
  }

  public void addToPropertyDefinitions(TPropertyDefinition elem) {
    if (this.propertyDefinitions == null) {
      this.propertyDefinitions = new ArrayList<TPropertyDefinition>();
    }
    this.propertyDefinitions.add(elem);
  }

  public List<TPropertyDefinition> getPropertyDefinitions() {
    return this.propertyDefinitions;
  }

  public TNodeType setPropertyDefinitions(List<TPropertyDefinition> propertyDefinitions) {
    this.propertyDefinitions = propertyDefinitions;
    return this;
  }

  public void unsetPropertyDefinitions() {
    this.propertyDefinitions = null;
  }

  /** Returns true if field propertyDefinitions is set (has been assigned a value) and false otherwise */
  public boolean isSetPropertyDefinitions() {
    return this.propertyDefinitions != null;
  }

  public void setPropertyDefinitionsIsSet(boolean value) {
    if (!value) {
      this.propertyDefinitions = null;
    }
  }

  public int getChildNodeDefinitionsSize() {
    return (this.childNodeDefinitions == null) ? 0 : this.childNodeDefinitions.size();
  }

  public java.util.Iterator<TNodeDefinition> getChildNodeDefinitionsIterator() {
    return (this.childNodeDefinitions == null) ? null : this.childNodeDefinitions.iterator();
  }

  public void addToChildNodeDefinitions(TNodeDefinition elem) {
    if (this.childNodeDefinitions == null) {
      this.childNodeDefinitions = new ArrayList<TNodeDefinition>();
    }
    this.childNodeDefinitions.add(elem);
  }

  public List<TNodeDefinition> getChildNodeDefinitions() {
    return this.childNodeDefinitions;
  }

  public TNodeType setChildNodeDefinitions(List<TNodeDefinition> childNodeDefinitions) {
    this.childNodeDefinitions = childNodeDefinitions;
    return this;
  }

  public void unsetChildNodeDefinitions() {
    this.childNodeDefinitions = null;
  }

  /** Returns true if field childNodeDefinitions is set (has been assigned a value) and false otherwise */
  public boolean isSetChildNodeDefinitions() {
    return this.childNodeDefinitions != null;
  }

  public void setChildNodeDefinitionsIsSet(boolean value) {
    if (!value) {
      this.childNodeDefinitions = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case NAME:
      if (value == null) {
        unsetName();
      } else {
        setName((String)value);
      }
      break;

    case PROPERTY_DEFINITIONS:
      if (value == null) {
        unsetPropertyDefinitions();
      } else {
        setPropertyDefinitions((List<TPropertyDefinition>)value);
      }
      break;

    case CHILD_NODE_DEFINITIONS:
      if (value == null) {
        unsetChildNodeDefinitions();
      } else {
        setChildNodeDefinitions((List<TNodeDefinition>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case NAME:
      return getName();

    case PROPERTY_DEFINITIONS:
      return getPropertyDefinitions();

    case CHILD_NODE_DEFINITIONS:
      return getChildNodeDefinitions();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case NAME:
      return isSetName();
    case PROPERTY_DEFINITIONS:
      return isSetPropertyDefinitions();
    case CHILD_NODE_DEFINITIONS:
      return isSetChildNodeDefinitions();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof TNodeType)
      return this.equals((TNodeType)that);
    return false;
  }

  public boolean equals(TNodeType that) {
    if (that == null)
      return false;

    boolean this_present_name = true && this.isSetName();
    boolean that_present_name = true && that.isSetName();
    if (this_present_name || that_present_name) {
      if (!(this_present_name && that_present_name))
        return false;
      if (!this.name.equals(that.name))
        return false;
    }

    boolean this_present_propertyDefinitions = true && this.isSetPropertyDefinitions();
    boolean that_present_propertyDefinitions = true && that.isSetPropertyDefinitions();
    if (this_present_propertyDefinitions || that_present_propertyDefinitions) {
      if (!(this_present_propertyDefinitions && that_present_propertyDefinitions))
        return false;
      if (!this.propertyDefinitions.equals(that.propertyDefinitions))
        return false;
    }

    boolean this_present_childNodeDefinitions = true && this.isSetChildNodeDefinitions();
    boolean that_present_childNodeDefinitions = true && that.isSetChildNodeDefinitions();
    if (this_present_childNodeDefinitions || that_present_childNodeDefinitions) {
      if (!(this_present_childNodeDefinitions && that_present_childNodeDefinitions))
        return false;
      if (!this.childNodeDefinitions.equals(that.childNodeDefinitions))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_name = true && (isSetName());
    list.add(present_name);
    if (present_name)
      list.add(name);

    boolean present_propertyDefinitions = true && (isSetPropertyDefinitions());
    list.add(present_propertyDefinitions);
    if (present_propertyDefinitions)
      list.add(propertyDefinitions);

    boolean present_childNodeDefinitions = true && (isSetChildNodeDefinitions());
    list.add(present_childNodeDefinitions);
    if (present_childNodeDefinitions)
      list.add(childNodeDefinitions);

    return list.hashCode();
  }

  @Override
  public int compareTo(TNodeType other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

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
    lastComparison = Boolean.valueOf(isSetPropertyDefinitions()).compareTo(other.isSetPropertyDefinitions());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPropertyDefinitions()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.propertyDefinitions, other.propertyDefinitions);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetChildNodeDefinitions()).compareTo(other.isSetChildNodeDefinitions());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetChildNodeDefinitions()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.childNodeDefinitions, other.childNodeDefinitions);
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
    StringBuilder sb = new StringBuilder("TNodeType(");
    boolean first = true;

    sb.append("name:");
    if (this.name == null) {
      sb.append("null");
    } else {
      sb.append(this.name);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("propertyDefinitions:");
    if (this.propertyDefinitions == null) {
      sb.append("null");
    } else {
      sb.append(this.propertyDefinitions);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("childNodeDefinitions:");
    if (this.childNodeDefinitions == null) {
      sb.append("null");
    } else {
      sb.append(this.childNodeDefinitions);
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

  private static class TNodeTypeStandardSchemeFactory implements SchemeFactory {
    public TNodeTypeStandardScheme getScheme() {
      return new TNodeTypeStandardScheme();
    }
  }

  private static class TNodeTypeStandardScheme extends StandardScheme<TNodeType> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, TNodeType struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.name = iprot.readString();
              struct.setNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // PROPERTY_DEFINITIONS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list16 = iprot.readListBegin();
                struct.propertyDefinitions = new ArrayList<TPropertyDefinition>(_list16.size);
                TPropertyDefinition _elem17;
                for (int _i18 = 0; _i18 < _list16.size; ++_i18)
                {
                  _elem17 = new TPropertyDefinition();
                  _elem17.read(iprot);
                  struct.propertyDefinitions.add(_elem17);
                }
                iprot.readListEnd();
              }
              struct.setPropertyDefinitionsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // CHILD_NODE_DEFINITIONS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list19 = iprot.readListBegin();
                struct.childNodeDefinitions = new ArrayList<TNodeDefinition>(_list19.size);
                TNodeDefinition _elem20;
                for (int _i21 = 0; _i21 < _list19.size; ++_i21)
                {
                  _elem20 = new TNodeDefinition();
                  _elem20.read(iprot);
                  struct.childNodeDefinitions.add(_elem20);
                }
                iprot.readListEnd();
              }
              struct.setChildNodeDefinitionsIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, TNodeType struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.name != null) {
        oprot.writeFieldBegin(NAME_FIELD_DESC);
        oprot.writeString(struct.name);
        oprot.writeFieldEnd();
      }
      if (struct.propertyDefinitions != null) {
        oprot.writeFieldBegin(PROPERTY_DEFINITIONS_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.propertyDefinitions.size()));
          for (TPropertyDefinition _iter22 : struct.propertyDefinitions)
          {
            _iter22.write(oprot);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      if (struct.childNodeDefinitions != null) {
        oprot.writeFieldBegin(CHILD_NODE_DEFINITIONS_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.childNodeDefinitions.size()));
          for (TNodeDefinition _iter23 : struct.childNodeDefinitions)
          {
            _iter23.write(oprot);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TNodeTypeTupleSchemeFactory implements SchemeFactory {
    public TNodeTypeTupleScheme getScheme() {
      return new TNodeTypeTupleScheme();
    }
  }

  private static class TNodeTypeTupleScheme extends TupleScheme<TNodeType> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TNodeType struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetName()) {
        optionals.set(0);
      }
      if (struct.isSetPropertyDefinitions()) {
        optionals.set(1);
      }
      if (struct.isSetChildNodeDefinitions()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetName()) {
        oprot.writeString(struct.name);
      }
      if (struct.isSetPropertyDefinitions()) {
        {
          oprot.writeI32(struct.propertyDefinitions.size());
          for (TPropertyDefinition _iter24 : struct.propertyDefinitions)
          {
            _iter24.write(oprot);
          }
        }
      }
      if (struct.isSetChildNodeDefinitions()) {
        {
          oprot.writeI32(struct.childNodeDefinitions.size());
          for (TNodeDefinition _iter25 : struct.childNodeDefinitions)
          {
            _iter25.write(oprot);
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TNodeType struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        struct.name = iprot.readString();
        struct.setNameIsSet(true);
      }
      if (incoming.get(1)) {
        {
          org.apache.thrift.protocol.TList _list26 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.propertyDefinitions = new ArrayList<TPropertyDefinition>(_list26.size);
          TPropertyDefinition _elem27;
          for (int _i28 = 0; _i28 < _list26.size; ++_i28)
          {
            _elem27 = new TPropertyDefinition();
            _elem27.read(iprot);
            struct.propertyDefinitions.add(_elem27);
          }
        }
        struct.setPropertyDefinitionsIsSet(true);
      }
      if (incoming.get(2)) {
        {
          org.apache.thrift.protocol.TList _list29 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.childNodeDefinitions = new ArrayList<TNodeDefinition>(_list29.size);
          TNodeDefinition _elem30;
          for (int _i31 = 0; _i31 < _list29.size; ++_i31)
          {
            _elem30 = new TNodeDefinition();
            _elem30.read(iprot);
            struct.childNodeDefinitions.add(_elem30);
          }
        }
        struct.setChildNodeDefinitionsIsSet(true);
      }
    }
  }

}

