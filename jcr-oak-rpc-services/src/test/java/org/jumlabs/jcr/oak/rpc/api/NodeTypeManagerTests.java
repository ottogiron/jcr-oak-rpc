/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.jumlabs.jcr.oak.rpc.api;

import java.util.ArrayList;
import java.util.List;
import javax.jcr.NoSuchWorkspaceException;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.nodetype.NodeTypeIterator;
import javax.jcr.nodetype.NodeTypeManager;
import javax.security.auth.login.LoginException;
import org.apache.jackrabbit.oak.api.ContentSession;
import org.apache.jackrabbit.oak.api.Tree;
import org.apache.thrift.TException;
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
public class NodeTypeManagerTests {
    
    
    @Autowired
    private JRepository repository;
    
  @Test
  public void testGetAllNodeTypes() throws RepositoryException{
     List<String> allNodeTypes = new ArrayList<>();
     Session session = repository.jcrLoginAdministrative();
     NodeTypeManager nodeTypeManager = session.getWorkspace().getNodeTypeManager();
     NodeTypeIterator nodeTypeIterator =  nodeTypeManager.getAllNodeTypes();
     while(nodeTypeIterator.hasNext()){
       //  NodeType nodeType = (NodeType)nodeTypeIterator.next();
         
     }
     assertNotNull(allNodeTypes);
  }
    
}
