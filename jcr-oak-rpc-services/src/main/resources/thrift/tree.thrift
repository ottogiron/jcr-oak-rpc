namespace java org.jumlabs.jcr.oak.rpc.api

enum TTreeStatus {
   UNCHANGED, NEW, MODIFIED
}

struct TTree {
  1: string path,
  2: bool root,
  3: bool exists,
  4: string name, 
  5: TTreeStatus status
}



service TTreeService{
  TTree addChild(1:string name, 2:TTree tree),
  list<TTree> getChildren(1:TTree tree),
  TTree getChild(1:string name, 2:TTree tree),
  TTree getParent(1:TTree tree),  
}



