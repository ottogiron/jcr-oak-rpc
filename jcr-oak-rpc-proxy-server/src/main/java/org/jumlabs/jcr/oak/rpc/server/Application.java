
package org.jumlabs.jcr.oak.rpc.server;

import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.THsHaServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;
import org.jumlabs.jcr.oak.rpc.api.ConnectionSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;


import org.springframework.context.annotation.Configuration;



@Configuration
@EnableAutoConfiguration
@EnableConfigurationProperties(ConnectionSettings.class)
@ComponentScan(basePackages = "org.jumlabs.jcr.oak.rpc")
public class Application implements CommandLineRunner{
    
    @Autowired
    private ConnectionSettings connectionSettings;
    
    @Autowired 
    private TProcessor mainProcessor;
    

    
    public static void main(String[] args) {
         SpringApplication.run(Application.class, args);
    }
    
        public static void simple(TProcessor processor, int serverPort) throws TTransportException {

        TServerTransport serverTransport = new TServerSocket(serverPort);

       TServer server = new TSimpleServer(new TServer.Args(serverTransport).processor(processor));
        System.out.println("Starting the simple server...");
        server.serve();

    }

    public static void nonBlocking(TProcessor processor, int serverPort) throws TTransportException {
        try{
           System.out.println("Starting server on port "+serverPort+" ...");
            TNonblockingServerSocket serverTransport = new TNonblockingServerSocket(serverPort);
           THsHaServer server = new THsHaServer(
                   new THsHaServer.Args(serverTransport)
                   .processor(processor)                
                   .protocolFactory(new TBinaryProtocol.Factory(false, false)));       
           
           server.serve();
           System.out.println("Server started on port "+serverPort);
        }
        catch(Exception e){
            System.out.println("Error on the server:" + e.getMessage());
        }
       
    }

    @Override
    public void run(String... strings) throws Exception {        
        nonBlocking(mainProcessor,connectionSettings.getProxyPort());
    }
    
    

}