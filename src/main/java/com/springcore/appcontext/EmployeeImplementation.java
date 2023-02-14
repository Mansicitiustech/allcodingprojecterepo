package com.springcore.appcontext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springcore.entity.Employee;
import com.springcore.entity.Product;
import com.springcore.entity.User;

public class EmployeeImplementation {
public static void main(String[] args) {
	ApplicationContext appContext=new ClassPathXmlApplicationContext("appContext1.xml");
	//Employee beanemp = (Employee) appContext.getBean("employee");
	Employee beanemp1= (Employee) appContext.getBean("employee1",Employee.class);
	Employee beanemp11= (Employee) appContext.getBean("employee1",Employee.class);
	Employee beanemp2= (Employee) appContext.getBean("employee2",Employee.class);
	//User user1=(User) appContext.getBean("user1");
	User user1=(User) appContext.getBean("user3");
	User users4=(User) appContext.getBean("user4");
	Product product1=(Product) appContext.getBean("product1");

	
	System.out.println(beanemp1);
	System.out.println(beanemp2);
	System.out.println(user1);
	System.out.println(product1);
	System.out.println(users4);
	
	System.out.println(beanemp1.hashCode());
	System.out.println(beanemp11.hashCode());
	
}
}
