/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jumlabs.jcr.oak.rpc.api.impl;


import org.jumlabs.jcr.oak.rpc.api.JRepository;
import javax.jcr.Credentials;
import javax.jcr.NoSuchWorkspaceException;
import javax.jcr.Repository;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.security.auth.login.LoginException;
import org.apache.jackrabbit.oak.api.ContentRepository;
import org.apache.jackrabbit.oak.api.ContentSession;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author otto
 */
public class RepositoryImpl implements JRepository {
    
    @Autowired
    private ContentRepository repository;
    
    @Autowired Repository jcrRepository;
    
    @Autowired 
    Credentials adminCredentials;

    @Override
    public  ContentSession loginAdministrative(String workspaceName) throws LoginException, NoSuchWorkspaceException {        
        return repository.login(adminCredentials, null);
    }

    @Override
    public Session jcrLoginAdministrative() throws RepositoryException {
        return jcrRepository.login(adminCredentials);
    }

   
}
