/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jumlabs.jcr.oak.rpc.api;

import org.apache.thrift.TMultiplexedProcessor;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.THsHaServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;
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
@ContextConfiguration("/META-INF/spring/spring-config.xml")
public class JcrOakThritServerTests {
    
    private static int SERVER_PORT = 9090;

    
    @Autowired
    private TRootService.Processor rootProcessor;
    
    @Autowired
    private TTreeService.Processor treeProcessor;

    @Test
    public void testServerServe() throws TTransportException {
        //simple(sessionProcesor);
        TMultiplexedProcessor processor = new TMultiplexedProcessor();        
        processor.registerProcessor("TRootService", rootProcessor);
        processor.registerProcessor("TTreeService", treeProcessor);
        nonBlocking(processor);
    }

    public static void simple(TProcessor processor) throws TTransportException {

        TServerTransport serverTransport = new TServerSocket(SERVER_PORT);

       TServer server = new TSimpleServer(new TServer.Args(serverTransport).processor(processor));
        System.out.println("Starting the simple server...");
        server.serve();

    }

    public static void nonBlocking(TProcessor processor) throws TTransportException {
        try{
                TNonblockingServerSocket serverTransport = new TNonblockingServerSocket(SERVER_PORT);
           THsHaServer server = new THsHaServer(
                   new THsHaServer.Args(serverTransport)
                   .processor(processor)                
                   .protocolFactory(new TBinaryProtocol.Factory(false, false)));       
           System.out.println("Starting server on port "+SERVER_PORT+" ...");
           server.serve();
        }
        catch(Exception e){
            System.out.println("Error on the server:" + e.getMessage());
        }
       
    }

}
