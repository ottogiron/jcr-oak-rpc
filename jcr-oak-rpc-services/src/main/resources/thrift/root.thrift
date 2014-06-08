include "tree.thrift"

namespace java org.jumlabs.jcr.oak.rpc.api

service TRoot {
  tree.TTree getTree(1:string path)
}
