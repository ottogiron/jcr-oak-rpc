/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jumlabs.jcr.oak.rpc.api.impl;


import org.jumlabs.jcr.oak.rpc.api.Repository;
import javax.jcr.Credentials;
import javax.jcr.NoSuchWorkspaceException;
import javax.security.auth.login.LoginException;
import org.apache.jackrabbit.oak.api.ContentRepository;
import org.apache.jackrabbit.oak.api.ContentSession;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author otto
 */
public class RepositoryImpl implements Repository {
    
    @Autowired
    private ContentRepository repository;
    
    @Autowired 
    Credentials adminCredentials;

    @Override
    public  ContentSession logginAdministrative(String workspaceName) throws LoginException, NoSuchWorkspaceException {        
        return repository.login(adminCredentials, null);
    }

   
}
