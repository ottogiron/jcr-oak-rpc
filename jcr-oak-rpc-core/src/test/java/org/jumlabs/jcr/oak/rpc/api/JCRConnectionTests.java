

package org.jumlabs.jcr.oak.rpc.api;


import javax.jcr.SimpleCredentials;
import org.apache.jackrabbit.oak.api.ContentRepository;
import org.apache.jackrabbit.oak.api.ContentSession;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.apache.jackrabbit.oak.api.Root;
import org.apache.jackrabbit.oak.api.Tree;
import org.apache.jackrabbit.oak.api.Type;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.Assert.*;
/**
 *
 * @author otto
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/META-INF/spring/spring-config.xml")
public class JCRConnectionTests {
    
    
    @Autowired
    private ContentRepository repository;
    
    
    public JCRConnectionTests() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void testJCRConnection() throws Exception{       
         
         ContentSession session = repository.login(new SimpleCredentials("admin","admin".toCharArray()),null);         
         assertNotNull(session);
         Root root = session.getLatestRoot();
         Tree tree = root.getTree("/");
         Tree childTree;
         String message = "I have a message";
         String childName = "aloo";
         if(!tree.hasChild(childName)){
              childTree = tree.addChild(childName);
              childTree.setProperty("message",message);
         }
         else{
             childTree = tree.getChild(childName);
             if(!childTree.hasProperty("message")){
                 childTree.setProperty("message",message);
             }
         }        
         
         assertTrue(tree.exists());
         assertEquals(message,childTree.getProperty("message").getValue(Type.STRING));
         root.commit();
     }
}
