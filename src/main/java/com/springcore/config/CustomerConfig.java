package com.springcore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springcore.entity.Customer;
import com.springcore.entity.Product;

@Configuration
public class CustomerConfig {
	@Bean("customerDetail")
	//@Bean
public 	Customer customer() {
	return new Customer(1,"tomi","mumbai",new Product(222,"abclaptop",50000.09,"laptop",true));
}
}
