package com.springcore.appcontext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springcore.entity.Details;
import com.springcore.entity.FirstBean;
import com.springcore.entity.SecondBean;

public class MergeCollectionImpl {
public static void main(String[] args) {
	ApplicationContext appContext=new ClassPathXmlApplicationContext("appMergeCollections.xml","appDepndsOnBean.xml");
	Details detail = (Details) appContext.getBean("detail1");
	//System.out.println(detail);
	
	//ApplicationContext appContext1=new ClassPathXmlApplicationContext("appDepndsOnBean.xml");
	//appContext1.getBean(SecondBean.class).print();
	appContext.getBean(SecondBean.class).print();
}
}
