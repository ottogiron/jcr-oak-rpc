/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.jumlabs.jcr.oak.rpc.test;

import org.jumlabs.jcr.oak.rpc.nodetype.JNodeTypeManager;
import org.jumlabs.jcr.oak.rpc.thrift.api.TTreeService;
import org.jumlabs.jcr.oak.rpc.thrift.api.TRootService;
import com.mongodb.MongoClientURI;
import java.net.UnknownHostException;
import javax.jcr.Credentials;
import javax.jcr.Repository;
import javax.jcr.SimpleCredentials;
import org.apache.jackrabbit.oak.Oak;
import org.apache.jackrabbit.oak.api.ContentRepository;
import org.apache.jackrabbit.oak.jcr.Jcr;
import org.apache.jackrabbit.oak.plugins.document.DocumentMK;
import org.slf4j.Logger;
import org.apache.jackrabbit.oak.plugins.document.util.MongoConnection;
import org.apache.jackrabbit.oak.plugins.index.property.PropertyIndexProvider;
import org.apache.jackrabbit.oak.plugins.name.NameValidatorProvider;
import org.apache.jackrabbit.oak.plugins.nodetype.write.InitialContent;
import org.apache.jackrabbit.oak.plugins.segment.SegmentNodeStore;
import org.apache.jackrabbit.oak.plugins.segment.memory.MemoryStore;
import org.apache.jackrabbit.oak.security.SecurityProviderImpl;
import org.apache.jackrabbit.oak.spi.commit.DefaultEditor;
import org.apache.jackrabbit.oak.spi.state.NodeStore;
import org.apache.thrift.TMultiplexedProcessor;
import org.apache.thrift.TProcessor;
import org.jumlabs.jcr.oak.rpc.api.ConnectionSettings;
import org.jumlabs.jcr.oak.rpc.api.JRepository;
import org.jumlabs.jcr.oak.rpc.api.JRootService;
import org.jumlabs.jcr.oak.rpc.api.JTreeService;
import org.jumlabs.jcr.oak.rpc.nodetype.impl.JNodeTypeManagerImpl;
import org.jumlabs.jcr.oak.rpc.api.impl.RepositoryImpl;
import org.jumlabs.jcr.oak.rpc.api.impl.JRootServiceImpl;
import org.jumlabs.jcr.oak.rpc.api.impl.JTreeServiceImpl;
import org.jumlabs.jcr.oak.rpc.nodetype.JNodeTypeService;
import org.jumlabs.jcr.oak.rpc.nodetype.impl.JNodeTypeServiceImpl;
import org.jumlabs.jcr.oak.rpc.thrift.nodetype.TNodeTypeManager;
import org.jumlabs.jcr.oak.rpc.thrift.nodetype.TNodeTypeService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 *
 * @author otto
 */
@Configuration
@EnableConfigurationProperties(ConnectionSettings.class)
public class AppConfiguration {
    private  static final Logger logger = LoggerFactory.getLogger(AppConfiguration.class);
    private NodeStore nodeStore;
    
    @Autowired
    ConnectionSettings connectionSettings;
    
  
    
    @Bean
    public Repository  jcrRepository(){
        Repository repository = new Jcr(nodeStore())
                                .createRepository();
        return repository;
    }
    
    
    @Bean
    public NodeStore nodeStore(){
       return new SegmentNodeStore(new MemoryStore());
    }
    
    
    @Bean
    public Credentials adminCredentials(){
        return new SimpleCredentials(connectionSettings.getOakUser(), connectionSettings.getOakPassword().toCharArray());
    }
    
    @Bean
    public ContentRepository contentRepository(){
        ContentRepository repository;
        repository = new Oak(nodeStore())
                .with(new InitialContent())        // add initial content
                .with(new DefaultEditor())     // automatically set default types
                .with(new NameValidatorProvider()) // allow only valid JCR names
                .with(new SecurityProviderImpl())  // use the default security    
                .with(new PropertyIndexProvider()) // search support for the indexes                
                .createContentRepository();
        return repository;
    }
    
    
    @Bean
    public JRepository repository(){
        return new  RepositoryImpl();
    }
    
    @Bean JRootService root(){
        JRootService root = new JRootServiceImpl();
        return root;
    }
    
    @Bean 
    public JTreeService treeService(){
        JTreeService service = new JTreeServiceImpl();
        return service;
    }
    
    @Bean
    public JNodeTypeManager nodeTypeManager(){
        JNodeTypeManager service = new JNodeTypeManagerImpl();
        return service;
    }
    
    @Bean
    public JNodeTypeService nodeTypeService(){
        JNodeTypeService service = new JNodeTypeServiceImpl();
        return service;
    }

   
   public TRootService.Processor rootProcessor(){
       TRootService.Processor processor = new TRootService.Processor(root());
       return processor;
   }
   
   
   
   
   public TTreeService.Processor treeProcessor(){
       TTreeService.Processor processor = new TTreeService.Processor<>(treeService());
       return processor;
   }
   

   public TNodeTypeManager.Processor nodeTypeManagerProcessor(){
       TNodeTypeManager.Processor processor = new TNodeTypeManager.Processor<>(nodeTypeManager());
       return processor;
   }
   
   
   
   @Bean
   @Primary
   public TProcessor mainMultiplexerProcessor(){
         TMultiplexedProcessor processor = new TMultiplexedProcessor();        
        processor.registerProcessor("TRootService", rootProcessor());
        processor.registerProcessor("TTreeService", treeProcessor());
        processor.registerProcessor("TNodeTypeManager", nodeTypeManagerProcessor());
        processor.registerProcessor("TNodeTypeService", new TNodeTypeService.Processor<>(nodeTypeService()));
        return processor;
   }
}
