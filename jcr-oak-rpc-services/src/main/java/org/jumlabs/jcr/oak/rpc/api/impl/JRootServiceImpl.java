/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jumlabs.jcr.oak.rpc.api.impl;


import javax.jcr.NoSuchWorkspaceException;
import javax.security.auth.login.LoginException;
import org.apache.jackrabbit.oak.api.ContentSession;
import org.apache.jackrabbit.oak.api.Tree;
import org.apache.thrift.TException;
import org.jumlabs.jcr.oak.rpc.api.JRepository;
import org.jumlabs.jcr.oak.rpc.api.JRootService;
import org.jumlabs.jcr.oak.rpc.api.TTree;
import org.jumlabs.jcr.oak.rpc.util.RepositoryUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author otto
 */
public class JRootServiceImpl implements JRootService {

    private static final Logger logger = LoggerFactory.getLogger(JRootServiceImpl.class);    
    
    @Autowired
    private JRepository repository;

    @Override
    public TTree getTree(String path) throws TException {
        TTree ttree = null;
        try {
           
            Tree tree = RepositoryUtils.getTree(repository, path);
            ttree = RepositoryUtils.toTTree(tree);

        } catch (LoginException | NoSuchWorkspaceException | BeansException ex) {
            logger.error(ex.getMessage(), ex);
        }
        return ttree;
    }


    @Override
    public boolean move(String sourcePath, String destPath) throws TException {
        boolean move = false;
        try {
            ContentSession session = repository.logginAdministrative(null);
            move = session.getLatestRoot().move(sourcePath, destPath);
        } catch (LoginException | NoSuchWorkspaceException ex) {
            logger.error(ex.getMessage(), ex);
        }
        return move;
    }


}
