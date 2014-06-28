include "tree.thrift"

namespace java org.jumlabs.jcr.oak.rpc.api

service TRootService {
  tree.TTree getTree(1:string path), 
  bool move(1:string sourcePath, 2:string destPath)

}