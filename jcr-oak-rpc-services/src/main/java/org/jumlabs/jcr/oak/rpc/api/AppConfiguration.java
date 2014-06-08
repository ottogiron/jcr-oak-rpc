/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.jumlabs.jcr.oak.rpc.api;

import com.mongodb.MongoClientURI;
import java.net.UnknownHostException;
import javax.jcr.Credentials;
import javax.jcr.SimpleCredentials;
import org.apache.jackrabbit.oak.Oak;
import org.apache.jackrabbit.oak.api.ContentRepository;
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
import org.jumlabs.jcr.oak.rpc.api.impl.RootImpl;
import org.jumlabs.jcr.oak.rpc.api.impl.SessionImpl;
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
    public NodeStore nodeStore(){
        NodeStore store;
        store = new DocumentMK.Builder().
                 setMongoDB(mongoConnection().getDB())
                 .getNodeStore();  
        return store;
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
    public Session session(){
        Session session = new SessionImpl();
        return session;
    }
    
    
    @Bean
    public Repository repository(){
        return new  RepositoryImpl();
    }
    
    @Bean Root root(){
        Root root = new RootImpl();
        return root;
    }
    
    @Bean(name = "testService")
    public TestService testService(){
        return new TestServiceImpl();
    }
    
   @Bean
   public TSession.Processor sessionProcessor(){
       TSession.Processor processor = new TSession.Processor(session());
       return processor;
   }
   
   @Bean 
   public TRoot.Processor rootProcessor(){
       TRoot.Processor processor = new TRoot.Processor(root());
       return processor;
   }
}
