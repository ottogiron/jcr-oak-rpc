#!/bin/bash
echo "Begining to compile" 

SRC_PATH="../../java/"
NODE_SRC_PATH="../../../../../nodejs/jcr-oak-api/node_modules/jcr-oak-api/"

thrift -r --gen java -out $SRC_PATH  all.thrift
thrift -r --gen  js:node -out $NODE_SRC_PATH  all.thrift

echo "Finishing compilation"
