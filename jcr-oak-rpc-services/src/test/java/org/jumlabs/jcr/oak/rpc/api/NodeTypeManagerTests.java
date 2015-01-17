/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jumlabs.jcr.oak.rpc.api;

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
import org.jumlabs.jcr.oak.rpc.api.thrift.TNodeDefinition;
import org.jumlabs.jcr.oak.rpc.api.thrift.TNodeType;
import org.jumlabs.jcr.oak.rpc.api.thrift.TPropertyDefinition;
import org.jumlabs.jcr.oak.rpc.api.thrift.TType;
import org.jumlabs.jcr.oak.rpc.api.thrift.TValue;
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

    @Autowired
    private JNodeTypeManager nodeTypeManager;

    @Test
    public void testGetAllNodeTypes() throws Exception {
        List<String> allNodeTypes = nodeTypeManager.getAllNodeTypes();
        assertTrue(allNodeTypes.size() > 0);
    }

    @Test
    public void testGetNodeType() throws Exception {
        String nodeTypeName = "nt:file";       
        TNodeType tNodeType = nodeTypeManager.getNodeType(nodeTypeName);
        assertNotNull(tNodeType);
        assertNotNull(tNodeType.getName());
    }
    
    @Test
    public void testHasNodeType() throws Exception {
        boolean hasNodeType = nodeTypeManager.hasNodeType("nt:file");
        assertTrue(hasNodeType);
    }
    
    @Test
    public void testPrimaryNodeTypes() throws Exception {
      List<String> primaryNodeTypes = nodeTypeManager.getPrimaryNodeTypes();
        assertTrue(primaryNodeTypes.size() > 0);
    }


}
