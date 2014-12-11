/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jumlabs.jcr.oak.rpc.server;
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
import org.jumlabs.jcr.oak.rpc.api.TRootService;
import org.jumlabs.jcr.oak.rpc.api.TTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


import org.springframework.context.annotation.Configuration;



@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "org.jumlabs.jcr.oak.rpc.api")
public class Application implements CommandLineRunner{
    @Autowired
    private TRootService.Processor rootProcessor;
    
    @Autowired
    private TTreeService.Processor treeProcessor;
    private static int SERVER_PORT = 9090;
    public static void main(String[] args) {
         SpringApplication.run(Application.class, args);
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

    @Override
    public void run(String... strings) throws Exception {
        TMultiplexedProcessor processor = new TMultiplexedProcessor();        
        processor.registerProcessor("TRootService", rootProcessor);
        processor.registerProcessor("TTreeService", treeProcessor);
        nonBlocking(processor);
    }
    
    

}