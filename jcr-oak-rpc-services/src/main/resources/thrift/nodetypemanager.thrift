namespace java org.jumlabs.jcr.oak.rpc.api

struct Value {
    1:binary binaryValue,
    2:string stringValue,
    3:bool boolValue,
    4:double doubleValue,
    5:i64 longValue,
    6:i32 type, 
}

struct PropertyDefinition {
    1:list<Value> defaultValues,
    2:i32 requiredType,
    3:string name,
    4:bool isMultiple,
    5:bool isQueryOrderable,
    6:bool isFullTextSercheable
}

struct NodeDefinition {
    1:string defaultPrimaryType,
    2:list<string> requiredPrimaryTypes,   
}

struct NodeType {
    1:string name,
    2:list<PropertyDefinition> propertyDefinitions,
    3:list<NodeDefinition> childNodeDefinitions
    
}

service NodeTypeService {
    bool canAddChildNodeWithName(1:NodeType nodeType, 2:string childNodeName),
    bool canAddChildNodeWithType(1:NodeType nodeType, 2:string childNodeName, 3:string nodeTypeName),
    bool canRemoveNode(1:NodeType nodeType, 2:string nodeName),
    bool isNodeType(1:NodeType nodeType, 2:string nodeTypeName),
    
}

service TNodeTypeManager {
    list<string> getAllNodeTypes(),
    NodeType getNodeType(1:string nodeTypeName),
    list<string> getPrimaryNodeTypes(),
    bool hasNodeType(1:string name),
}