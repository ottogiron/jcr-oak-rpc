/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.jumlabs.jcr.oak.rpc.api;

import java.io.IOException;
import org.jumlabs.jcr.oak.rpc.thrift.api.TTree;
import javax.jcr.NoSuchWorkspaceException;
import javax.security.auth.login.LoginException;
import org.apache.jackrabbit.oak.api.CommitFailedException;
import org.apache.jackrabbit.oak.api.ContentSession;
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
    public void testAddChild() throws NoSuchWorkspaceException, LoginException, TException, CommitFailedException, IOException{
        
        String childName = TestUtils.randomIdentifier();
        Tree rootTree;
    
        try (ContentSession session = repository.loginAdministrative(null)) {
            Root root;
            root = session.getLatestRoot();
            rootTree = root.getTree("/");
            TTree parentTTree = RepositoryUtils.toTTree(rootTree);
            TTree ttreChilde =  treeService.addChild(childName, parentTTree);
            assertEquals("/"+childName, ttreChilde.getPath());
            //session.close();
        }
        
        

        
        
    }
    
    
}
