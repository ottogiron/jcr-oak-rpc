/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jumlabs.jcr.oak.rpc.nodetype;

import org.jumlabs.jcr.oak.rpc.nodetype.JNodeTypeManager;
import com.google.common.io.ByteStreams;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.jcr.NoSuchWorkspaceException;
import javax.jcr.PropertyType;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.Value;
import javax.jcr.nodetype.NodeDefinition;
import javax.jcr.nodetype.NodeType;
import javax.jcr.nodetype.NodeTypeIterator;
import javax.jcr.nodetype.NodeTypeManager;
import javax.jcr.nodetype.PropertyDefinition;
import javax.security.auth.login.LoginException;
import org.apache.jackrabbit.oak.api.ContentSession;
import org.apache.jackrabbit.oak.api.Tree;
import org.apache.thrift.TException;
import org.jumlabs.jcr.oak.rpc.api.JRepository;
import org.jumlabs.jcr.oak.rpc.thrift.nodetype.TNodeDefinition;
import org.jumlabs.jcr.oak.rpc.thrift.nodetype.TNodeType;
import org.jumlabs.jcr.oak.rpc.thrift.nodetype.TPropertyDefinition;
import org.jumlabs.jcr.oak.rpc.thrift.api.TType;
import org.jumlabs.jcr.oak.rpc.thrift.nodetype.TValue;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author otto
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/META-INF/spring/spring-config.xml")
public class NodeTypeServiceTests {

    @Autowired
    private JRepository repository;

    @Autowired
    private JNodeTypeManager nodeTypeManager;
    
    
    @Test
    public void testCanAddChildNodeWithName()  {
        boolean canAddChildNodeWithName = false;        
        Session session = null;
        try{        
            session = repository.jcrLoginAdministrative();
            NodeTypeManager jcrNodeTypeManager = session.getWorkspace().getNodeTypeManager();
            NodeType nodeType = jcrNodeTypeManager.getNodeType("nt:folder");
            canAddChildNodeWithName = nodeType.canAddChildNode("archivo","nt:file");
            assertTrue(canAddChildNodeWithName);
        }
        catch(Exception e){
            fail(e.getMessage());
        }
        finally{
            if(session != null){
                session.logout();
            }
        }
        
    }
    


}
