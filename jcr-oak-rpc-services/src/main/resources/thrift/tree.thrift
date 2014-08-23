namespace java org.jumlabs.jcr.oak.rpc.api


enum TType{
  BINARIES, BINARY, BOOLEAN, BOOLEANS, DATE, DATES, 
  DOUBLE, DOUBLES, LONG, LONGS, STRING, STRINGS
}
struct TPropertyState {
  1:i32 count,
  2:string name,
  3:i32 size,
  4:bool isArray,
  5:TType type,
  6:binary binaryValue,
  7:list<binary> binaryValues,
  8:list<i64> longValues,
  9:i64 longValue,
  10:list<bool> booleanValues,
  11:bool booleanValue,
  12:list<i64> dateValues,
  13:i64 dateValue,
  14:list<double> doubleValues,
  15:double doubleValue,
  16:list<string> stringValues,
  17:string stringValue
}

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
  map<string,TPropertyState> getPropertiesValue(1:list<string> propertyNames,2:TTree ttree),
  void setPropertiesValue(1:map<string,TPropertyState> values,2:TTree ttree),
  bool remove(1:TTree tree)
}



