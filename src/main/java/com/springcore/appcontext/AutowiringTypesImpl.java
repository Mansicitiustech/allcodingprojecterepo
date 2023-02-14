package com.springcore.appcontext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springcore.entity.Person;

public class AutowiringTypesImpl {
public static void main(String[] args) {
	ApplicationContext appContext=new ClassPathXmlApplicationContext("appByNamesAutiwiring.xml");
	ApplicationContext appContext1=new ClassPathXmlApplicationContext("appByTypeAutowire.xml");
	Person person1=(Person) appContext.getBean("person");
	Person person2=(Person) appContext1.getBean("person");
	System.out.println(person1);
	System.out.println(person2);
	ApplicationContext appContext2=new ClassPathXmlApplicationContext("appConstructorAutowire.xml");
	Person person3=(Person) appContext2.getBean("person");
	System.out.println(person3);
	
}
}
