/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.jumlabs.jcr.oak.rpc.api;

import javax.jcr.NoSuchWorkspaceException;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.security.auth.login.LoginException;
import org.apache.jackrabbit.oak.api.ContentSession;

/**
 *
 * @author otto
 */
public interface JRepository {

    ContentSession loginAdministrative(String workspaceName) throws LoginException, NoSuchWorkspaceException;
    Session jcrLoginAdministrative() throws RepositoryException;
    
}
