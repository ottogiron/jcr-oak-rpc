#!/bin/bash
echo "Begining to compile" 

SRC_PATH="../../java/"
NODE_SRC_PATH="../../../../../jcr-oak-rpc-api-nodejs/node_modules/jcr-oak-api"

thrift -r --gen java -out $SRC_PATH  session.thrift
thrift -r --gen  js:node -out $NODE_SRC_PATH  session.thrift

echo "Finishing compilation"
