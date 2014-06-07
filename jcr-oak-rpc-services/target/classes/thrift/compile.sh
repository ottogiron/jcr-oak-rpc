#!/bin/bash
echo "Begining to compile" 

SRC_PATH="../../java/org/jumlabs/jcr/oak/rpc/api/"

thrift -r --gen java -out $SRC_PATH session.thrift

echo "Finishing compilation"
