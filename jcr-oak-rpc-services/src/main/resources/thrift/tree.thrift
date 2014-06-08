namespace java org.jumlabs.jcr.oak.rpc.api

enum TStatus {
   UNCHANGED, NEW, MODIFIED
}

struct TTree {
  1: string path,
  2: bool root,
  3: bool exists,
  4: string name, 
  5: TStatus status;
}