/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jumlabs.jcr.oak.rpc.api.impl;

import javax.jcr.NoSuchWorkspaceException;
import javax.security.auth.login.LoginException;
import org.apache.jackrabbit.oak.api.ContentRepository;
import org.apache.jackrabbit.oak.api.ContentSession;
import org.apache.jackrabbit.oak.api.Tree;
import org.apache.thrift.TException;
import org.jumlabs.jcr.oak.rpc.api.Root;
import org.jumlabs.jcr.oak.rpc.api.TStatus;
import org.jumlabs.jcr.oak.rpc.api.TTree;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author otto
 */
public class RootImpl implements Root {

    private static final Logger logger = LoggerFactory.getLogger(SessionImpl.class);    
    
    @Autowired
    private RepositoryImpl repository;

    @Override
    public TTree getTree(String path) throws TException {
        TTree ttree = null;
        try {
            ContentSession session = repository.logginAdministrative(null);
            Tree tree = session.getLatestRoot().getTree(path);
            ttree = new TTree();
            BeanUtils.copyProperties(tree, ttree);
            ttree.setExists(tree.exists());
            switch (tree.getStatus()) {
                case MODIFIED:
                    ttree.setStatus(TStatus.MODIFIED);
                    break;
                case NEW:
                    ttree.setStatus(TStatus.NEW);
                    break;
                case UNCHANGED:
                    ttree.setStatus(TStatus.UNCHANGED);
                    break;
            }

        } catch (LoginException | NoSuchWorkspaceException | BeansException ex) {
            logger.error(ex.getMessage(), ex);
        }
        return ttree;
    }

}
