/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jumlabs.jcr.oak.rpc.api;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.*;
/**
 *
 * @author otto
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/META-INF/spring/spring-config.xml")
public class JcrOakThritClientTests {
    
    @Autowired
    private TTreeService treeService;
  
    @Test
    public void testServerServe() throws TTransportException, TException {
        TTransport transport;
        transport = new TSocket("localhost", 9090);
        transport.open();
        TProtocol protocol = new TBinaryProtocol(transport);
        TRootService.Client client = new TRootService.Client(protocol);
        TTree tree = client.getTree("/");
        System.out.println(tree.getName());
        assertEquals("/", tree.getPath());
        transport.close();
    }



}
