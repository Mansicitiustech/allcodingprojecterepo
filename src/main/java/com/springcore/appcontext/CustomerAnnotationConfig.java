package com.springcore.appcontext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springcore.config.CustomerConfig;
import com.springcore.entity.Customer;

public class CustomerAnnotationConfig {
public static void main(String[] args) {
	ApplicationContext appContext=new AnnotationConfigApplicationContext(CustomerConfig.class);
//	Customer customer1=(Customer) appContext.getBean("customer");
	Customer customer1=(Customer) appContext.getBean("customerDetail");
	System.out.println(customer1);
}
}
