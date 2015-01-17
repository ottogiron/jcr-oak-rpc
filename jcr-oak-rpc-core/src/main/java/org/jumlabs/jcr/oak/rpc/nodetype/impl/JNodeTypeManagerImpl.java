package org.jumlabs.jcr.oak.rpc.nodetype.impl;

import com.google.common.io.ByteStreams;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.jcr.PropertyType;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.Value;
import javax.jcr.nodetype.NodeDefinition;
import javax.jcr.nodetype.NodeType;
import javax.jcr.nodetype.NodeTypeIterator;
import javax.jcr.nodetype.NodeTypeManager;
import javax.jcr.nodetype.PropertyDefinition;
import org.apache.thrift.TException;
import org.jumlabs.jcr.oak.rpc.nodetype.JNodeTypeManager;
import org.jumlabs.jcr.oak.rpc.api.JRepository;
import org.jumlabs.jcr.oak.rpc.thrift.TNodeDefinition;
import org.jumlabs.jcr.oak.rpc.thrift.TNodeType;
import org.jumlabs.jcr.oak.rpc.thrift.TPropertyDefinition;
import org.jumlabs.jcr.oak.rpc.thrift.TType;
import org.jumlabs.jcr.oak.rpc.thrift.TValue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author otto
 */
public class JNodeTypeManagerImpl implements JNodeTypeManager {

    private static final Logger logger = LoggerFactory.getLogger(JNodeTypeManagerImpl.class);

    @Autowired
    private JRepository repository;

    @Override
    public List<String> getAllNodeTypes() throws TException {
        List<String> allNodeTypes = new ArrayList<>();
        Session session = null;
        try {
            session = repository.jcrLoginAdministrative();
            NodeTypeManager nodeTypeManager = session.getWorkspace().getNodeTypeManager();
            NodeTypeIterator nodeTypeIterator = nodeTypeManager.getAllNodeTypes();
            while (nodeTypeIterator.hasNext()) {
                NodeType nodeType = (NodeType) nodeTypeIterator.next();
                allNodeTypes.add(nodeType.getName());

            }
        } catch (RepositoryException ex) {
            logger.error(ex.getMessage());
            throw new TException(ex);
        }
        finally{
            if(session != null)
                session.logout();
        }

        return allNodeTypes;
    }

    @Override
    public TNodeType getNodeType(String nodeTypeName) throws TException {
        TNodeType tNodeType = new TNodeType();
        Session session = null;
        try{
            session = repository.jcrLoginAdministrative();
            NodeTypeManager jcrNodeTypeManager = session.getWorkspace().getNodeTypeManager();
            NodeType nodeType = jcrNodeTypeManager.getNodeType(nodeTypeName);            
            tNodeType.setName(nodeType.getName());
            List<TPropertyDefinition> tpropertyDefinitions = extractPropertyDefinitions(nodeType);
            List<TNodeDefinition> tnodeDefinitions = extractChildNodesDefinitions(nodeType);
            tNodeType.setChildNodeDefinitions(tnodeDefinitions);
            tNodeType.setPropertyDefinitions(tpropertyDefinitions);  
        }
        catch(Exception ex){
            logger.error(ex.getMessage());
            throw  new TException(ex);
        }
        finally {
            if(session != null){
                session.logout();
            }
        }
        
        return tNodeType;
    }

    private List<TNodeDefinition> extractChildNodesDefinitions(NodeType nodeType) {
        List<TNodeDefinition> nodeDefinitions = new ArrayList<>();
        for (NodeDefinition nodeDefinition : nodeType.getChildNodeDefinitions()) {
            TNodeDefinition tnodedefinition = new TNodeDefinition();
            tnodedefinition.setDefaultPrimaryType(nodeDefinition.getDefaultPrimaryTypeName());
            tnodedefinition.setDeclaringNodeType(nodeDefinition.getDeclaringNodeType().getName());
            List<String> requiredPrimaryTypes = new ArrayList<>();
            for (String requiredPrimaryType : nodeDefinition.getRequiredPrimaryTypeNames()) {
                requiredPrimaryTypes.add(requiredPrimaryType);
            }
            tnodedefinition.setRequiredPrimaryTypes(requiredPrimaryTypes);
            tnodedefinition.setName(nodeDefinition.getName());
            nodeDefinitions.add(tnodedefinition);
        }
        return nodeDefinitions;
    }

    private List<TPropertyDefinition> extractPropertyDefinitions(NodeType nodeType) throws RepositoryException, IOException {
        List<TPropertyDefinition> propertyDefinitions = new ArrayList<>();
        for (PropertyDefinition propertyDefinition : nodeType.getPropertyDefinitions()) {
            TPropertyDefinition tPropertyDefinition = new TPropertyDefinition();
            List<TValue> values = extractDefaultValues(propertyDefinition);
            tPropertyDefinition.setDefaultValues(values);
            tPropertyDefinition.setName(propertyDefinition.getName());
            tPropertyDefinition.setIsMultiple(propertyDefinition.isMultiple());
            tPropertyDefinition.setIsQueryOrderable(propertyDefinition.isQueryOrderable());
            tPropertyDefinition.setIsFullTextSercheable(propertyDefinition.isFullTextSearchable());
            tPropertyDefinition.setIsAutocreated(propertyDefinition.isAutoCreated());
            tPropertyDefinition.setIsMandatory(propertyDefinition.isMandatory());
            tPropertyDefinition.setIsProtected(propertyDefinition.isProtected());

            int type = -1;
            switch (propertyDefinition.getRequiredType()) {
                case PropertyType.STRING:
                    type = TType.STRING.getValue();
                    break;
                case PropertyType.BINARY:
                    type = TType.BINARY.getValue();
                    break;
                case PropertyType.DOUBLE:
                    type = TType.DOUBLE.getValue();
                    break;
                case PropertyType.LONG:
                    type = TType.LONG.getValue();
                    break;
                case PropertyType.BOOLEAN:
                    type = TType.BOOLEAN.getValue();
                    break;
                default:
                    type = TType.STRING.getValue();
                    break;
            }
            tPropertyDefinition.setRequiredType(type);
            propertyDefinitions.add(tPropertyDefinition);
        }
        return propertyDefinitions;
    }

    private List<TValue> extractDefaultValues(PropertyDefinition propertyDefinition) throws RepositoryException, IOException {
        List<TValue> tpropertyDefinitions = new ArrayList<>();
        for (Value value : propertyDefinition.getDefaultValues()) {
            TValue tvalue = new TValue();
            int type = -1;
            switch (value.getType()) {
                case PropertyType.STRING:
                    tvalue.setStringValue(value.getString());
                    type = TType.STRING.getValue();
                    break;
                case PropertyType.BINARY:
                    byte[] bytes = ByteStreams.toByteArray(value.getBinary().getStream());
                    tvalue.setBinaryValue(bytes);
                    type = TType.BINARY.getValue();
                    break;
                case PropertyType.DOUBLE:
                    tvalue.setDoubleValue(value.getDouble());
                    type = TType.DOUBLE.getValue();
                    break;
                case PropertyType.LONG:
                    tvalue.setLongValue(value.getLong());
                    type = TType.LONG.getValue();
                    break;
                case PropertyType.BOOLEAN:
                    tvalue.setBoolValue(value.getBoolean());
                    type = TType.BOOLEAN.getValue();
                    break;
                default:
                    type = TType.STRING.getValue();
                    break;
            }
            tvalue.setType(type);
            tpropertyDefinitions.add(tvalue);

        }
        return tpropertyDefinitions;
    }

    @Override
    public List<String> getPrimaryNodeTypes() throws TException {
        List<String> primaryNodeTypes = new ArrayList<>();
        Session session = null;
        try{
            session = repository.jcrLoginAdministrative();
            NodeTypeManager nodeTypeManager = session.getWorkspace().getNodeTypeManager();
            NodeTypeIterator nodeTypeIterator = nodeTypeManager.getPrimaryNodeTypes();
            while(nodeTypeIterator.hasNext()){
                NodeType nodeType = nodeTypeIterator.nextNodeType();
                primaryNodeTypes.add(nodeType.getName());
            }
        }
        catch(Exception ex){
            logger.error(ex.getMessage());
            throw new TException(ex);
        }
        finally{
            if(session != null){
                session.logout();
            }
        }
        return primaryNodeTypes;
    }

    @Override
    public boolean hasNodeType(String name) throws TException {
        boolean hasNodeType = false;
        Session session = null;
        try{
            session = repository.jcrLoginAdministrative();
            NodeTypeManager nodeTypeManager = session.getWorkspace().getNodeTypeManager();
            hasNodeType = nodeTypeManager.hasNodeType(name);
        }
        catch(Exception ex){
            logger.error(ex.getMessage());
            throw new TException(ex);
        }
        finally{
            if(session != null){
                session.logout();
            }
        }
        return hasNodeType;
    }

}
