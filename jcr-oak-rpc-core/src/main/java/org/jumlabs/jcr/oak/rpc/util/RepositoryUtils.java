/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.jumlabs.jcr.oak.rpc.util;

import javax.jcr.NoSuchWorkspaceException;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.nodetype.NodeType;
import javax.jcr.nodetype.NodeTypeManager;
import javax.security.auth.login.LoginException;
import org.apache.jackrabbit.oak.api.ContentSession;
import org.apache.jackrabbit.oak.api.Root;
import org.apache.jackrabbit.oak.api.Tree;
import org.jumlabs.jcr.oak.rpc.api.JRepository;
import org.jumlabs.jcr.oak.rpc.thrift.api.TTree;
import org.jumlabs.jcr.oak.rpc.thrift.api.TTreeStatus;
import org.jumlabs.jcr.oak.rpc.thrift.nodetype.TNodeType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

/**
 *
 * @author otto
 */
public class RepositoryUtils {
    
    
    private static final Logger logger = LoggerFactory.getLogger(RepositoryUtils.class);
     public static Tree getTree(JRepository repository,String path) throws LoginException, NoSuchWorkspaceException{
       Tree tree = null;
       if(path != null){
        ContentSession session = repository.loginAdministrative(null);
         tree = session.getLatestRoot().getTree(path);    
       }       
       return tree;
   }  
    
   public static Tree getTree(JRepository repository,TTree ttree) throws LoginException, NoSuchWorkspaceException{
       Tree tree = getTree(repository, ttree.getPath());
       return tree;
   } 
   
   public static Root getJCRRoot(JRepository repository) throws LoginException, NoSuchWorkspaceException{
       ContentSession session = repository.loginAdministrative(null);
       return session.getLatestRoot();
   }
   
   public static TTree toTTree(Tree tree){
      TTree ttree = new TTree();
            BeanUtils.copyProperties(tree, ttree);
            ttree.setExists(tree.exists());
            switch (tree.getStatus()) {
                case MODIFIED:
                    ttree.setStatus(TTreeStatus.MODIFIED);
                    break;
                case NEW:
                    ttree.setStatus(TTreeStatus.NEW);
                    break;
                case UNCHANGED:
                    ttree.setStatus(TTreeStatus.UNCHANGED);
                    break;
            }
       return ttree;
   }
   
   public static NodeType getNodeType(Session session, TNodeType tnodeType) throws RepositoryException{      
        NodeTypeManager jcrNodeTypeManager = session.getWorkspace().getNodeTypeManager();
        NodeType nodeType = jcrNodeTypeManager.getNodeType(tnodeType.getName());
        return nodeType;
     
   }
   
   public static void closeSession(Root root){
       if(root != null){
           try{
               root.getContentSession().close();
           }
           catch(Exception e){
               logger.error(e.getMessage());
           }
       }
   }
}
