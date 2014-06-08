/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.jumlabs.jcr.oak.rpc.api;

import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author otto
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-config.xml")
public class JcrOakThritServerTests {
  
    @Autowired
    private TSession.Processor sessionProcesor;
    
    @Test
    public void testServerServe(){
        simple(sessionProcesor);
    }
    
      public static void simple(TSession.Processor processor) {
    try {
      TServerTransport serverTransport = new TServerSocket(9090);
      
      TServer server = new TSimpleServer(new TServer.Args(serverTransport).processor(processor));
      

      // Use this for a multithreaded server
      // TServer server = new TThreadPoolServer(new TThreadPoolServer.Args(serverTransport).processor(processor));

      System.out.println("Starting the simple server...");
      server.serve();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

    
}
