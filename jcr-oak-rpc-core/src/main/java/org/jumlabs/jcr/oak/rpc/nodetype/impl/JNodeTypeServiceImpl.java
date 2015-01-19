
package org.jumlabs.jcr.oak.rpc.nodetype.impl;
import javax.jcr.Session;
import javax.jcr.nodetype.NodeType;
import org.apache.thrift.TException;
import org.jumlabs.jcr.oak.rpc.api.JRepository;
import org.jumlabs.jcr.oak.rpc.nodetype.JNodeTypeService;
import org.jumlabs.jcr.oak.rpc.thrift.nodetype.TNodeType;
import org.jumlabs.jcr.oak.rpc.util.RepositoryUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author otto
 */
public class JNodeTypeServiceImpl implements JNodeTypeService{
    @Autowired
    private JRepository repository;
    
     private static final Logger logger = LoggerFactory.getLogger(JNodeTypeServiceImpl.class);

    @Override
    public boolean canAddChildNodeWithName(TNodeType tnodeType, String childNodeName) throws TException {
        boolean canAddChildNodeWithName = false;
        Session session = null;
        try{        
            session = repository.jcrLoginAdministrative();
           
            NodeType nodeType = RepositoryUtils.getNodeType(session, tnodeType);
            canAddChildNodeWithName = nodeType.canAddChildNode(childNodeName);            
        }
        catch(Exception e){
            logger.error(e.getMessage());
            throw new TException(e);
        }
        finally{
            if(session != null){
                session.logout();
            }
        }
        return canAddChildNodeWithName;
    }

    @Override
    public boolean canAddChildNodeWithType(TNodeType tnodeType, String childNodeName, String nodeTypeName) throws TException {
            boolean canAddChildNodeWithName = false;
        Session session = null;
        try{        
            session = repository.jcrLoginAdministrative();
           
            NodeType nodeType = RepositoryUtils.getNodeType(session, tnodeType);
            canAddChildNodeWithName = nodeType.canAddChildNode(childNodeName,nodeTypeName);            
        }
        catch(Exception e){
            logger.error(e.getMessage());
            throw new TException(e);
        }
        finally{
            if(session != null){
                session.logout();
            }
        }
        return canAddChildNodeWithName;
    }

    @Override
    public boolean canRemoveNode(TNodeType tnodeType, String nodeName) throws TException {
        boolean canRemoveNode = false;
        Session session = null;
        try{        
            session = repository.jcrLoginAdministrative();
           
            NodeType nodeType = RepositoryUtils.getNodeType(session, tnodeType);
            canRemoveNode = nodeType.canRemoveNode(nodeName);
        }
        catch(Exception e){
            logger.error(e.getMessage());
            throw new TException(e);
        }
        finally{
            if(session != null){
                session.logout();
            }
        }
        return canRemoveNode;
    }

    @Override
    public boolean isNodeType(TNodeType tnodeType, String nodeTypeName) throws TException {
        boolean isNodeType = false;
        Session session = null;
        try{        
            session = repository.jcrLoginAdministrative();
           
            NodeType nodeType = RepositoryUtils.getNodeType(session, tnodeType);
            isNodeType = nodeType.isNodeType(nodeTypeName);
        }
        catch(Exception e){
            logger.error(e.getMessage());
            throw new TException(e);
        }
        finally{
            if(session != null){
                session.logout();
            }
        }
        return isNodeType;
    }
    
   
    
}
