/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.jumlabs.jcr.oak.rpc.api;

import javax.jcr.Credentials;
import javax.jcr.GuestCredentials;
import javax.jcr.NoSuchWorkspaceException;
import javax.jcr.Node;
import javax.jcr.Repository;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
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
public class JCRRepositoryTests {
    @Autowired
    private Repository repository;
    
    @Autowired
    private Credentials adminCredentials;
    
    @Test
    public void testRepositoryInitialized(){
        assertNotNull(repository);
    }
    
    @Test
    public void testRepositorySession() {
        Session session = null;
        try{
            session = repository.login(adminCredentials);
            String nodePath = "/jcr:system";
            Node node = session.getNode(nodePath);
            assertEquals(nodePath, node.getPath());
        } catch (RepositoryException ex){
            fail(ex.getMessage());
        }   
        finally{
           if(session != null){
                session.logout();
           }
        }
        
    }
}
