include "tree.thrift"

namespace java org.jumlabs.jcr.oak.rpc.api


enum TType{
  BINARIES, BINARY, BOOLEAN, BOOLEANS, DATE, DATES, 
  DOUBLE, DOUBLES, LONG, LONGS, NAME, NAMES, PATH, PATHS, 
  STRING, STRINGS, UNDEFINED, UNDEFINEDS, URI, URIS
}

//Not implemented TType refrence, weak reference

struct TPropertyState {
  1:i32 count,
  2:string name,
  3:i32 size,
  4:bool isArray,
  5:TType type
}


service TPropertyStateService {
  TType getType(1:tree.TTree tree, 2:TPropertyState property),
  list<binary> getBinaryValues(1:tree.TTree tree, 2:TPropertyState property),
  binary getBinaryValue(1:tree.TTree tree, 2:TPropertyState property),
  list<i64> getLongValues(1:tree.TTree tree, 2:TPropertyState property),
  i64 getLongValue(1:tree.TTree tree, 2:TPropertyState property),
  list<bool> getBooleanValues(1:tree.TTree tree, 2:TPropertyState property),
  bool getBooleanValue(1:tree.TTree tree, 2:TPropertyState property),
  list<i64> getDateValues(1:tree.TTree tree, 2:TPropertyState property),
  i64 getDateValue(1:tree.TTree tree, 2:TPropertyState property),
  double getDoubleValue(1:tree.TTree tree, 2:TPropertyState property),
  list<string> getNameValues(1:tree.TTree tree, 2:TPropertyState property),
  string getNameValue(1:tree.TTree tree, 2:TPropertyState property),
  list<string> getPathValues(1:tree.TTree tree, 2:TPropertyState property),
  string getPathValue(1:tree.TTree tree, 2:TPropertyState property),
  list<string> getStringValues(1:tree.TTree tree, 2:TPropertyState property),
  string getStringValue(1:tree.TTree tree, 2:TPropertyState property),
  list<string> getURIValues(1:tree.TTree tree, 2:TPropertyState property),
  string getURIValue(1:tree.TTree tree, 2:TPropertyState property)  
}

