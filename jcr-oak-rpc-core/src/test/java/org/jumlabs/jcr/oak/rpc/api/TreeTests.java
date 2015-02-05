/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.jumlabs.jcr.oak.rpc.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.jcr.AccessDeniedException;
import org.jumlabs.jcr.oak.rpc.thrift.api.TTree;
import javax.jcr.NoSuchWorkspaceException;
import javax.security.auth.login.LoginException;
import org.apache.jackrabbit.JcrConstants;
import org.apache.jackrabbit.oak.api.CommitFailedException;
import org.apache.jackrabbit.oak.api.ContentSession;
import org.apache.jackrabbit.oak.api.PropertyState;
import org.apache.jackrabbit.oak.api.Root;
import org.apache.jackrabbit.oak.api.Tree;
import org.apache.jackrabbit.oak.api.Type;
import org.apache.jackrabbit.oak.util.NodeUtil;
import org.apache.jackrabbit.oak.util.TreeUtil;
import org.apache.thrift.TException;
import org.jumlabs.jcr.oak.rpc.TestUtils;
import org.jumlabs.jcr.oak.rpc.thrift.api.TPropertyState;
import org.jumlabs.jcr.oak.rpc.thrift.api.TType;
import org.jumlabs.jcr.oak.rpc.util.RepositoryUtils;
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
public class TreeTests {
    
    
    
    @Autowired
    private JTreeService treeService;
    
    @Autowired
    private JRepository repository;
    
    @Test
    public void testAddChild() throws NoSuchWorkspaceException, LoginException, TException, CommitFailedException, IOException{
        
        String childName = TestUtils.randomIdentifier();
        Tree rootTree;
    
        try (ContentSession session = repository.loginAdministrative(null)) {
            Root root;
            root = session.getLatestRoot();
            rootTree = root.getTree("/");
            TTree parentTTree = RepositoryUtils.toTTree(rootTree);
            TTree ttreChilde =  treeService.addChild(childName, parentTTree);
            session.close();
            assertEquals("/"+childName, ttreChilde.getPath());
            
        } 
    }
    
    
    @Test
    public void testChangeProperty() throws NoSuchWorkspaceException, LoginException, TException, CommitFailedException, IOException, AccessDeniedException{
        String childName = TestUtils.randomIdentifier();
        TTree tchild;
        ContentSession session = repository.loginAdministrative(null);
        Root root;
        root = session.getLatestRoot();
        Tree rootTree = root.getTree("/");
        NodeUtil rootTreeUtil = new NodeUtil(rootTree);
        NodeUtil child = rootTreeUtil.addChild(childName,JcrConstants.NT_UNSTRUCTURED);
        tchild = RepositoryUtils.toTTree(child.getTree()) ;
        root.commit();
      
       

        String propertyName = "testProperty";
        String propertyValue = "testValue";
        TPropertyState propertyState = new TPropertyState();
        propertyState.setName(propertyName);
        propertyState.setType(TType.STRING);
        propertyState.setStringValue(propertyValue);
        List<TPropertyState> propertiesValues = new ArrayList<>();
        propertiesValues.add(propertyState);
        treeService.setPropertiesValue(propertiesValues, tchild);
        
        root.refresh();
           
        Tree savedCHildTree = root.getTree("/" + childName);
        String savedPropertyValue = TreeUtil.getString(savedCHildTree, propertyName);
        assertEquals(propertyValue, savedPropertyValue);
        //session.close();
        
        
        
      
    }
    
    
}
