'use strict';

var jcrOakRpcApiNodejs = require('../lib/jcr-oak-rpc-api-nodejs.js'),
        thrift = require('thrift'),
        TSession = require('../node_modules/jcr-oak-api/TSession'),
        sessiontypes = require('../node_modules/jcr-oak-api/session_types'),
        treetypes = require('../node_modules/jcr-oak-api/tree_types');


/*
 ======== A Handy Little Nodeunit Reference ========
 https://github.com/caolan/nodeunit
 
 Test methods:
 test.expect(numAssertions)
 test.done()
 Test assertions:
 test.ok(value, [message])
 test.equal(actual, expected, [message])
 test.notEqual(actual, expected, [message])
 test.deepEqual(actual, expected, [message])
 test.notDeepEqual(actual, expected, [message])
 test.strictEqual(actual, expected, [message])
 test.notStrictEqual(actual, expected, [message])
 test.throws(block, [error], [message])
 test.doesNotThrow(block, [error], [message])
 test.ifError(value)
 */

exports.jcrOakRpcApiNodejs = {
    setUp: function(done) {
        // setup here
        done();
    },
    testJcrOakClient: function(test) {

        var connection = thrift.createConnection('localhost', 9090, {transport: thrift.TFramedTransport}),
        multiplexer = new  thrift.Multiplexer(),
        session =  multiplexer.createClient('TSession',TSession,connection);
        
        
        connection.on('error', function(err) {
            console.error(err);
            test.done();
        });

        session.getTree('/', function(error, tree) {
            if (error) {
                console.log(error);
            } else {
                test.ok(tree, 'Session has not returned a result');
                test.equal(tree.path, '/', 'The path of the tree should be equal the required path /');
                console.log(tree);
                connection.end();
            }

            test.done();
        });

    }
};
