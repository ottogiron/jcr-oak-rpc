/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jumlabs.jcr.oak.rpc.api.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.jcr.NoSuchWorkspaceException;
import javax.security.auth.login.LoginException;
import org.apache.jackrabbit.oak.api.CommitFailedException;
import org.apache.jackrabbit.oak.api.Root;
import org.apache.jackrabbit.oak.api.Tree;
import org.apache.thrift.TException;
import org.jumlabs.jcr.oak.rpc.api.JRepository;
import org.jumlabs.jcr.oak.rpc.api.TTree;
import org.jumlabs.jcr.oak.rpc.api.JTreeService;
import org.jumlabs.jcr.oak.rpc.util.RepositoryUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author otto
 */
public class JTreeServiceImpl implements JTreeService {

    private static Logger logger = LoggerFactory.getLogger(JTreeServiceImpl.class);
    @Autowired
    private JRepository repository;

    @Override
    public TTree addChild(String name, TTree ttree) throws TException {
        TTree childTTree = null;
        try {
            Root root = RepositoryUtils.getJCRRoot(repository);
            Tree tree = root.getTree(ttree.getPath());
            Tree childTree = tree.addChild(name);
            childTTree = RepositoryUtils.toTTree(childTree);
            root.commit();
        } catch (LoginException | NoSuchWorkspaceException | CommitFailedException ex) {
            logger.error(ex.getMessage(), ex);
        }
        return childTTree;
    }

    @Override
    public List<TTree> getChildren(TTree ttree) throws TException {
        List<TTree> tchildren = new ArrayList<>();
        try {            
            Tree tree = RepositoryUtils.getTree(repository, ttree);
            Iterable<Tree> children = tree.getChildren();
            children.forEach(childTree -> {
              TTree childTTree = RepositoryUtils.toTTree(childTree);
              tchildren.add(childTTree);
            });
        } catch (LoginException | NoSuchWorkspaceException ex) {
            logger.error(ex.getMessage(), ex);
        }
        return tchildren;
    }

    @Override
    public TTree getChild(String name, TTree ttree) throws TException {
        TTree childTTree = null;
        try {
            Tree tree = RepositoryUtils.getTree(repository,ttree);
            Tree childTree = tree.getChild(name);
            childTTree = RepositoryUtils.toTTree(childTree);
        }   catch (LoginException | NoSuchWorkspaceException ex) {
            logger.error(ex.getMessage(), ex);
        }
        return childTTree;
    }

    @Override
    public TTree getParent(TTree ttree) throws TException {
        TTree parentTTree = null;
        try {
            Tree tree = RepositoryUtils.getTree(repository,ttree);
            Tree parentTree = tree.getParent();
            parentTTree = RepositoryUtils.toTTree(parentTree);
        }   catch (LoginException | NoSuchWorkspaceException ex) {
            logger.error(ex.getMessage(), ex);
        }
        return parentTTree;
    }

}
