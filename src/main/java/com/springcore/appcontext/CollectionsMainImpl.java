package com.springcore.appcontext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CollectionsMainImpl {
public static void main(String[] args) {
	ApplicationContext appContext=new ClassPathXmlApplicationContext("appContextCollection.xml");
	CollectionSpring collectionlist=(CollectionSpring) appContext.getBean("collections");
	System.out.println(collectionlist.getMyEmployeeSet().getClass().getName());
	System.out.println(collectionlist.getMyIntSet().getClass().getName());
	System.out.println(collectionlist.getMyPlayerList().getClass().getName());
	System.out.println(collectionlist.getMyMap().getClass().toString());
	System.out.println(collectionlist);
	System.out.println(collectionlist.getProperties());
}
}
