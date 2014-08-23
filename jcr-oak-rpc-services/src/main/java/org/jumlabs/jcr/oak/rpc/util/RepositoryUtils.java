/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.jumlabs.jcr.oak.rpc.util;

import javax.jcr.NoSuchWorkspaceException;
import javax.security.auth.login.LoginException;
import org.apache.jackrabbit.oak.api.ContentSession;
import org.apache.jackrabbit.oak.api.Root;
import org.apache.jackrabbit.oak.api.Tree;
import org.jumlabs.jcr.oak.rpc.api.JRepository;
import org.jumlabs.jcr.oak.rpc.api.TTree;
import org.jumlabs.jcr.oak.rpc.api.TTreeStatus;
import org.springframework.beans.BeanUtils;

/**
 *
 * @author otto
 */
public class RepositoryUtils {
    
     public static Tree getTree(JRepository repository,String path) throws LoginException, NoSuchWorkspaceException{
       Tree tree = null;
       if(path != null){
        ContentSession session = repository.logginAdministrative(null);
         tree = session.getLatestRoot().getTree(path);    
       }       
       return tree;
   }  
    
   public static Tree getTree(JRepository repository,TTree ttree) throws LoginException, NoSuchWorkspaceException{
       Tree tree = getTree(repository, ttree.getPath());
       return tree;
   } 
   
   public static Root getJCRRoot(JRepository repository) throws LoginException, NoSuchWorkspaceException{
       ContentSession session = repository.logginAdministrative(null);
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
}
