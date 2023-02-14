package com.creationaldesign.singleton;

public class Singleton {
	//first way using eager loading
/*private static final Singleton INSTANCE=new Singleton();

private Singleton() {}
public static Singleton getInstance() {
	return INSTANCE;
	
}*/



//using first way we cannot handle exception  ,so second way is static block
/*private static Singleton INSTANCE=null;
static {
	try {
	if(INSTANCE==null) {
		INSTANCE =	new Singleton();
	}}
	catch(Exception e) {
		e.printStackTrace();
	}
}*/
	
	//3rd way lazy loading ,object loaded at class running time
	private static Singleton INSTANCE=null;
	public static Singleton getInstance() {
		if(INSTANCE==null) {
			INSTANCE =	new Singleton();
		}
		return INSTANCE;
		
	}
}
