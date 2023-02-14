package com.springcore.appcontext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.springcore.entity.Department;
import com.springcore.entity.Employee;

public class FileSystemContext {
public static void main(String[] args) {
	ApplicationContext appContext=new FileSystemXmlApplicationContext("C:\\Users\\MansiC\\Documents\\Junit-Mokito ,Hibernate Practice\\/spring-core-practice/src/main/resources/appContext1.xml","C:\\Users\\MansiC\\Documents\\Junit-Mokito ,Hibernate Practice\\/spring-core-practice/src/main/resources/appDepartmentContext.xml");
Employee emp1=(Employee) appContext.getBean("employee1");
System.out.println(emp1);
Department department1=(Department) appContext.getBean("department");
System.out.println(department1);
}
}
