
package org.jumlabs.jcr.oak.rpc.api;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 *
 * @author otto
 */
@Component
@ConfigurationProperties(prefix = "connection")
public class ConnectionSettings {
    private String mongoHost = "localhost";
    private String mongoDB = "MongoJCRSmartAdmin";
    private String oakUser = "admin";
    private String oakPassword = "admin";
    private int proxyPort =  9090;

    public String getMongoHost() {
        return mongoHost;
    }

    public void setMongoHost(String mongoHost) {
        this.mongoHost = mongoHost;
    }

    public String getMongoDB() {
        return mongoDB;
    }

    public void setMongoDB(String mongoDB) {
        this.mongoDB = mongoDB;
    }

    public String getOakUser() {
        return oakUser;
    }

    public void setOakUser(String oakUser) {
        this.oakUser = oakUser;
    }

    public String getOakPassword() {
        return oakPassword;
    }

    public void setOakPassword(String oakPassword) {
        this.oakPassword = oakPassword;
    }

    public int getProxyPort() {
        return proxyPort;
    }

    public void setProxyPort(int thriftProxyPort) {
        this.proxyPort = thriftProxyPort;
    }
    
    
    
}
