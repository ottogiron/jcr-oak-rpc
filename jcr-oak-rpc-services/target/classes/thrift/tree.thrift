namespace java org.jumlabs.jcr.oak.rpc.api

struct Tree {
  1: string path,
  2: bool isRoot,
  3: bool exists,
  4: optional string comment,
}