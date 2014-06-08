/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.jumlabs.jcr.oak.rpc.api;

import javax.jcr.NoSuchWorkspaceException;
import javax.security.auth.login.LoginException;
import org.apache.jackrabbit.oak.api.ContentRepository;
import org.apache.jackrabbit.oak.api.ContentSession;
import org.apache.jackrabbit.oak.api.Tree;
import org.apache.thrift.TException;
import org.jumlabs.jcr.oak.rpc.util.RepositoryUtil;
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
@ContextConfiguration("/spring-config.xml")
public class SessionTests {
    
    @Autowired
    private Session session;
    @Autowired
    private ContentRepository repository;
    
    @Test
    public void testGetTree() throws TException, LoginException, NoSuchWorkspaceException{
        ContentSession csession = RepositoryUtil.loggin(repository,"admin", "admin");       
        Tree oriTree = csession.getLatestRoot().getTree("/");        
        TTree tree = session.getTree("/");        
               
        assertEquals(oriTree.getPath(),tree.getPath());
        assertEquals(oriTree.isRoot(),tree.isRoot());
        assertEquals(oriTree.getName(),tree.getName());
        assertEquals(oriTree.exists(),tree.isExists());
        
        
        
    }
    
    
}
