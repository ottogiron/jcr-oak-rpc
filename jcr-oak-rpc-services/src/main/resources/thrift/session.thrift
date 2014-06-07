include "tree.thrift"

namespace java org.jumlabs.jcr.oak.rpc.api

service Session {
    tree.Tree getTree(1:string path)
}
