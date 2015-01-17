namespace java org.jumlabs.jcr.oak.rpc.thrift.nodetype
namespace js NodeType

struct TValue {
    1:binary binaryValue,
    2:string stringValue,
    3:bool boolValue,
    4:double doubleValue,
    5:i64 longValue,
    6:i32 type, 
}

struct TPropertyDefinition {
    1:list<TValue> defaultValues,
    2:i32 requiredType,
    3:string name,
    4:bool isMultiple,
    5:bool isQueryOrderable,
    6:bool isFullTextSercheable 
    7:bool isAutocreated,
    8:bool isMandatory,
    9:bool isProtected,
 
}

struct TNodeDefinition {
    1:string defaultPrimaryType,
    2:list<string> requiredPrimaryTypes,
    3:string declaringNodeType,
    4:string name,
}

struct TNodeType {
    1:string name,
    2:list<TPropertyDefinition> propertyDefinitions,
    3:list<TNodeDefinition> childNodeDefinitions,
    
    
}

service TNodeTypeService {
    bool canAddChildNodeWithName(1:TNodeType nodeType, 2:string childNodeName),
    bool canAddChildNodeWithType(1:TNodeType nodeType, 2:string childNodeName, 3:string nodeTypeName),
    bool canRemoveNode(1:TNodeType nodeType, 2:string nodeName),
    bool isNodeType(1:TNodeType nodeType, 2:string nodeTypeName),
    
}

service TNodeTypeManager {
    list<string> getAllNodeTypes(),
    TNodeType getNodeType(1:string nodeTypeName),
    list<string> getPrimaryNodeTypes(),
    bool hasNodeType(1:string name),
}