/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jumlabs.jcr.oak.rpc.util;


import javax.jcr.NoSuchWorkspaceException;
import javax.jcr.SimpleCredentials;
import javax.security.auth.login.LoginException;
import org.apache.jackrabbit.oak.api.ContentRepository;
import org.apache.jackrabbit.oak.api.ContentSession;

/**
 *
 * @author otto
 */
public class RepositoryUtil {

    public static ContentSession loggin(ContentRepository repository, String usr, String psw) throws LoginException, NoSuchWorkspaceException {
        return repository.login(new SimpleCredentials("admin", "admin".toCharArray()), null);
    }

   
}
