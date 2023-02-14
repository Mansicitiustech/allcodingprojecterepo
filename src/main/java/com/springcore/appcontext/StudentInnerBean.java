package com.springcore.appcontext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springcore.entity.Student;

public class StudentInnerBean {
public static void main(String[] args) {
	ApplicationContext appContext=new ClassPathXmlApplicationContext("innerBeanConfig.xml");
Student student1=(Student) appContext.getBean("student");
System.out.println(student1);
}
}
