/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.jumlabs.jcr.oak.rpc.api;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 *
 * @author otto
 */
@Service
@Component(immediate = true)
public class TestServiceImpl implements TestService{
private static Logger logger = LoggerFactory.getLogger(TestServiceImpl.class);


@Activate
protected void activate(BundleContext bundleContext){
    logger.info("Hello world");
    logger.debug("Hello workl debuging");    
}
    
    @Override
    public void sayHello() {
        System.out.println("hola mundo");
    }
    
}
