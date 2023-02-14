package com.springcore.appcontext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springcore.entity.Department;

public class ImportXmlFile {
public static void main(String[] args) {
	ApplicationContext appContext=new ClassPathXmlApplicationContext("appDepartmentContext.xml");
	Department dept=(Department) appContext.getBean("department");
	System.out.println(dept);
	
}
}
