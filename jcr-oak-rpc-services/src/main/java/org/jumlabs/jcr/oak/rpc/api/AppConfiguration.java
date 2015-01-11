/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.jumlabs.jcr.oak.rpc.api;

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
import org.apache.jackrabbit.oak.security.SecurityProviderImpl;
import org.apache.jackrabbit.oak.spi.commit.DefaultEditor;
import org.apache.jackrabbit.oak.spi.state.NodeStore;
import org.jumlabs.jcr.oak.rpc.api.impl.RepositoryImpl;
import org.jumlabs.jcr.oak.rpc.api.impl.JRootServiceImpl;
import org.jumlabs.jcr.oak.rpc.api.impl.JTreeServiceImpl;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author otto
 */
@Configuration
public class AppConfiguration {
    private  static final Logger logger = LoggerFactory.getLogger(AppConfiguration.class);
    private NodeStore nodeStore;
    @Bean 
    public MongoConnection mongoConnection(){
        MongoClientURI uri = new MongoClientURI("mongodb://localhost/MongoMKDB");
        MongoConnection mongo = null;
        try {
            mongo = new MongoConnection(uri.getURI());
        } catch (UnknownHostException ex) {
          logger.error(ex.getMessage(),ex);
        }
        return mongo;
    }
    
    @Bean
    public Repository  jcrRepository(){
        Repository repository = new Jcr(nodeStore())
                                .createRepository();
        return repository;
    }
    
    
    @Bean
    public NodeStore nodeStore(){
        
        if(nodeStore == null)
        nodeStore = new DocumentMK.Builder().
                 setMongoDB(mongoConnection().getDB())
                 .getNodeStore();  
        return nodeStore;
    }
    
    
    @Bean
    public Credentials adminCredentials(){
        return new SimpleCredentials("admin", "admin".toCharArray());
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
   public TRootService.Processor rootProcessor(){
       TRootService.Processor processor = new TRootService.Processor(root());
       return processor;
   }
   
   @Bean 
   public TTreeService.Processor treeProcessor(){
       TTreeService.Processor processor = new TTreeService.Processor<>(treeService());
       return processor;
   }
}
