/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.jumlabs.jcr.oak.rpc.api;

import org.jumlabs.jcr.oak.rpc.thrift.api.TTree;
import javax.jcr.NoSuchWorkspaceException;
import javax.security.auth.login.LoginException;
import org.apache.jackrabbit.oak.api.CommitFailedException;
import org.apache.jackrabbit.oak.api.Root;
import org.apache.jackrabbit.oak.api.Tree;
import org.apache.thrift.TException;
import org.jumlabs.jcr.oak.rpc.TestUtils;
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
    public void testAddChild() throws NoSuchWorkspaceException, LoginException, TException, CommitFailedException{
        String parentName =  TestUtils.randomIdentifier();
        String childName = TestUtils.randomIdentifier();
        Root root = RepositoryUtils.getJCRRoot(repository);
        Tree rootTree = root.getTree("/");
        Tree parentTree =  rootTree.addChild(parentName);
        root.commit();
        TTree parentTTree = RepositoryUtils.toTTree(parentTree);
        TTree ttreChilde =  treeService.addChild(childName, parentTTree);
      
        assertEquals("/"+parentName+"/"+childName, ttreChilde.getPath());
        //clean 
        rootTree.getChild(parentName).remove();
        root.commit();
    }
    
    
}
