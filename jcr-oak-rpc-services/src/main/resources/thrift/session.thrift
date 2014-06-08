include "tree.thrift"

namespace java org.jumlabs.jcr.oak.rpc.api

service TSession {
    tree.TTree getTree(1:string path)
}
