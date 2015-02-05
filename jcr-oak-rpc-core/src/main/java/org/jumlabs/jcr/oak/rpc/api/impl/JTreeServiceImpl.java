/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jumlabs.jcr.oak.rpc.api.impl;

import com.google.common.collect.Lists;
import com.google.common.io.ByteStreams;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.jcr.NoSuchWorkspaceException;
import javax.security.auth.login.LoginException;
import org.apache.jackrabbit.oak.api.Blob;
import org.apache.jackrabbit.oak.api.CommitFailedException;
import org.apache.jackrabbit.oak.api.PropertyState;
import org.apache.jackrabbit.oak.api.Root;
import org.apache.jackrabbit.oak.api.Tree;
import org.apache.jackrabbit.oak.api.Type;
import org.apache.jackrabbit.oak.util.NodeUtil;
import org.apache.thrift.TException;
import org.jumlabs.jcr.oak.rpc.api.JRepository;
import org.jumlabs.jcr.oak.rpc.api.JTreeService;
import org.jumlabs.jcr.oak.rpc.thrift.api.TPropertyState;
import org.jumlabs.jcr.oak.rpc.thrift.api.TTree;
import org.jumlabs.jcr.oak.rpc.thrift.api.TType;
import org.jumlabs.jcr.oak.rpc.util.RepositoryUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author otto
 */
public class JTreeServiceImpl implements JTreeService {

    private static final Logger logger = LoggerFactory.getLogger(JTreeServiceImpl.class);
    
    @Autowired
    private JRepository repository;
    

    @Override
    public TTree addChild(String name, TTree ttree) throws TException {
       TTree childTTree = null;
        Root root = null;
        try {
            root = RepositoryUtils.getJCRRoot(repository);
            Tree tree = root.getTree(ttree.getPath());
            Tree childTree = tree.addChild(name);
            root.commit();
            childTTree = RepositoryUtils.toTTree(childTree);            
        } catch (LoginException | NoSuchWorkspaceException | CommitFailedException ex) {
            logger.error(ex.getMessage(), ex);
        }
        finally{
            RepositoryUtils.closeSession(root);
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
            Tree tree = RepositoryUtils.getTree(repository, ttree);
            Tree childTree = tree.getChild(name);
            childTTree = RepositoryUtils.toTTree(childTree);
        } catch (LoginException | NoSuchWorkspaceException ex) {
            logger.error(ex.getMessage(), ex);
        }
        return childTTree;
    }

    @Override
    public TTree getParent(TTree ttree) throws TException {
        TTree parentTTree = null;
        try {
            Tree tree = RepositoryUtils.getTree(repository, ttree);
            Tree parentTree = tree.getParent();
            parentTTree = RepositoryUtils.toTTree(parentTree);
        } catch (LoginException | NoSuchWorkspaceException ex) {
            logger.error(ex.getMessage(), ex);
        }
        return parentTTree;
    }

    @Override
    public Map<String, TPropertyState> getPropertiesByNames(List<String> propertyNames, TTree ttree) throws TException {
        Map<String, TPropertyState> tPropertyValues = new HashMap<>();
        try {
            Tree tree = RepositoryUtils.getTree(repository, ttree);
            propertyNames.forEach(propertyName -> {
                TPropertyState propertyValue;
                try {
                    propertyValue = getPropertyValue(propertyName, tree);
                    tPropertyValues.put(propertyValue.getName(), propertyValue);
                } catch (TException e) {
                    logger.error(e.getMessage(), e);
                }

            });
            return tPropertyValues;
        } catch (LoginException | NoSuchWorkspaceException ex) {
            logger.error(ex.getMessage(), ex);
        }
        return tPropertyValues;
    }

    @Override
    public void setPropertiesValue(List<TPropertyState> values, TTree ttree) throws TException {
          Root root = null;
          try {
            root = RepositoryUtils.getJCRRoot(repository);
            Tree tree = root.getTree(ttree.getPath());
            NodeUtil nodeUtil = new NodeUtil(tree);
            
            values.forEach((propertyState) -> {                
                TType type = propertyState.getType();
                String key = propertyState.getName();
                switch(type){
                    case BINARIES:
                        tree.setProperty(key,propertyState.getBinaryValues());
                        break;
                    case BINARY:
                        tree.setProperty(key, propertyState.getBinaryValue());
                        break;
                    case BOOLEAN:
                        tree.setProperty(key,propertyState.isBooleanValue());
                        break;
                    case BOOLEANS:
                        tree.setProperty(key,propertyState.getBooleanValues());
                        break;
                    case DATE:
                        tree.setProperty(key,propertyState.getDateValue());
                        break;
                    case DATES:
                        tree.setProperty(key,propertyState.getDateValues());
                        break;
                    case DOUBLE:
                        tree.setProperty(key,propertyState.getDoubleValue());
                        break;
                    case DOUBLES:
                        tree.setProperty(key,propertyState.getDoubleValues());
                        break;
                    case LONG:
                        tree.setProperty(key,propertyState.getLongValue());
                        break;
                    case LONGS:
                        tree.setProperty(key,propertyState.getLongValues());
                        break;
                   
                    case STRING:
                        tree.setProperty(key,propertyState.getStringValue());
                            break;
                    case STRINGS:
                        tree.setProperty(key,propertyState.getStringValues());
                        break;
                    default:
                        tree.setProperty(key,propertyState.getStringValue());
                        break;                                                            
                }
      
                
            });
            root.commit();
            
        } catch (LoginException | CommitFailedException | NoSuchWorkspaceException ex) {
            logger.error(ex.getMessage(), ex);
        }
        finally{
              RepositoryUtils.closeSession(root);
          }
    }
    
    

    public TPropertyState getPropertyValue(String propertyName, Tree tree) throws TException {
        PropertyState propertyState = tree.getProperty(propertyName);
        TPropertyState tpropertyState = getPropertyValue(propertyState);
        return tpropertyState;
    }

    public TPropertyState getPropertyValue(PropertyState propertyState) {
        TType ttype = null;
        TPropertyState tpropertyState = new TPropertyState();
        Type type = propertyState.getType();
        if (type.equals(Type.BINARIES)) {
            ttype = TType.BINARIES;
            List<ByteBuffer> tbyteValues = Lists.newArrayList();
            List<Blob> binaryValues = Lists.newArrayList(propertyState.getValue(Type.BINARIES));
            binaryValues.forEach(blob -> {
                try {

                    byte[] currentByteValue = ByteStreams.toByteArray(blob.getNewStream());
                    tbyteValues.add(ByteBuffer.wrap(currentByteValue));
                } catch (IOException ex) {
                    logger.error(ex.getMessage(), ex);
                }
                tpropertyState.setBinaryValues(tbyteValues);

            });

        } else if (type.equals(Type.BINARY)) {
            ttype = TType.BINARY;
            Blob blobValue = propertyState.getValue(Type.BINARY);
            byte[] binaryValue;
            try {
                binaryValue = ByteStreams.toByteArray(blobValue.getNewStream());
                tpropertyState.setBinaryValue(binaryValue);
            } catch (IOException ex) {
                logger.error(ex.getMessage(), ex);
            }
        } else if (type.equals(Type.BOOLEAN)) {
            ttype = TType.BOOLEAN;
            tpropertyState.setBooleanValue(propertyState.getValue(Type.BOOLEAN));
        } else if (type.equals(Type.BOOLEANS)) {
            ttype = TType.BOOLEANS;
            List<Boolean> booleanValues = Lists.newArrayList(propertyState.getValue(Type.BOOLEANS));
            tpropertyState.setBooleanValues(booleanValues);
        } else if (type.equals(Type.DATE)) {
            ttype = TType.DATE;
            tpropertyState.setDateValue(Long.parseLong(propertyState.getValue(Type.DATE)));
        } else if (type.equals(Type.DATES)) {
            ttype = TType.DATES;
            List<String> datesValues = Lists.newArrayList(propertyState.getValue(Type.DATES));
            List<Long> dateLongValues = Lists.newArrayList();
            datesValues.forEach(dateStr -> Long.parseLong(dateStr));
            tpropertyState.setLongValues(dateLongValues);
        } else if (type.equals(Type.DOUBLE)) {
            ttype = TType.DOUBLE;
            tpropertyState.setDoubleValue(propertyState.getValue(Type.DOUBLE));
        } else if (type.equals(Type.DOUBLES)) {
            ttype = TType.DOUBLES;
            List<Double> doubleValues = Lists.newArrayList(propertyState.getValue(Type.DOUBLES));
            tpropertyState.setDoubleValues(doubleValues);
        } else if (type.equals(Type.LONGS)) {
            ttype = TType.LONGS;
            List<Long> longValues = Lists.newArrayList(propertyState.getValue(Type.LONGS));
            tpropertyState.setLongValues(longValues);
        } else if (type.equals(Type.LONG)) {
            ttype = TType.LONG;
            tpropertyState.setLongValue(propertyState.getValue(Type.LONG));
        }
        else if(type.equals(Type.STRING)||type.equals(Type.NAME)){
            ttype = TType.STRING;
            tpropertyState.setStringValue(propertyState.getValue(Type.STRING));
        }
        else if(type.equals(Type.STRINGS)||type.equals(Type.NAMES)){
            ttype = TType.STRINGS;
            List<String> stringValues = Lists.newArrayList(propertyState.getValue(Type.STRINGS));
            tpropertyState.setStringValues(stringValues);
        }
        tpropertyState.setName(propertyState.getName());
        tpropertyState.setType(ttype);
        return tpropertyState;
    }

    @Override
    public boolean remove(TTree ttree) throws TException {
        boolean removed = false;
        Root root = null;
        try {
             root = RepositoryUtils.getJCRRoot(repository);
            Tree tree = root.getTree(ttree.getPath());            
            removed = tree.remove();
            root.commit();

        } catch (LoginException | NoSuchWorkspaceException |  CommitFailedException ex) {
            logger.error(ex.getMessage(), ex);
        }
        finally{
            RepositoryUtils.closeSession(root);
        }
        return removed;
    }

    @Override
    public Map<String, TPropertyState> getProperties(TTree ttree) throws TException {
           Map<String,TPropertyState> properties = new HashMap<>();
        try {
            Tree tree = RepositoryUtils.getTree(repository, ttree);            
            tree.getProperties().forEach(propertyState -> {
                String name = propertyState.getName();
                TPropertyState tpropertyState = getPropertyValue(propertyState);
                properties.put(name, tpropertyState);
            });
        } catch (LoginException | NoSuchWorkspaceException ex) {
            logger.error(ex.getMessage(), ex);
        }
        return properties;
    }

}
