#  Jackrabbit Oak Thrift RPC API #



### What is this repository for? ###

 Implementation of RPC API for JackRabbit Oak based on [Apache thrift](https://thrift.apache.org).


### Prerrequisites ###
* JDK 8
* Maven
* MongoDB  (For Jackrabbit)


### Installation
* Clone the repository, **git clone git@github.com:ottogiron/jcr-oak-rpc.git**
* CD to jcr-oak-rpc and run **mvn clean install**

### Running RPC Service
The service on port 9090 by default.
Go  into the ***jcr-oak-rpc/jcr-oak-rpc-proxy-server*** folder an run  **mvn spring-boot:run** that will start the thrift server.

### Example of client for NodeJS

***Please Check [jcr-oak-rpc-nodejs](https://github.com/ottogiron/jcr-oak-rpc-nodejs)***
```

  TRoot = require('./TRootService'),
  jcrOakAPI = require('jcr-oak-api');

  var connection = jcrOakAPI.getConnection({
    host: 'localhost',
    port: 9090
  });

  var multiplexer = new  thrift.Multiplexer(),
  var rootService =  multiplexer.createClient("TTreeService",TRoot,conn);

  rootService.getTree('/', function(err, tree) {
   connection.end();
       if(err) { return handleError(res, err); }
       console.log(tree);
    });

```
***Note:*** Example based in Node's apache thrift 1.x master branch module, 0.9.x branch doesn't support multiplexer.

###Implemented API
Check Thrift services definition
* [root.thrift](https://github.com/ottogiron/jcr-oak-rpc/blob/development/jcr-oak-rpc-services/src/main/resources/thrift/root.thrift)
* [tree.thrift](https://github.com/ottogiron/jcr-oak-rpc/blob/development/jcr-oak-rpc-services/src/main/resources/thrift/tree.thrift)
