#!/bin/bash
echo "Begining to compile" 

SRC_PATH="../../java/"

thrift -r --gen java -out $SRC_PATH  session.thrift

echo "Finishing compilation"
