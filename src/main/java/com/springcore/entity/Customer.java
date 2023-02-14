package com.springcore.entity;

public class Customer {
public Customer(int id, String name, String city,Product product) {
		// TODO Auto-generated constructor stub
	this.name=name;
	this.city=city;
	this.id=id;
	this.product=product;
	
	}
private int id;
private String name;
private String city;
private Product product;
@Override
public String toString() {
	return "Customer [id=" + id + ", name=" + name + ", city=" + city + ",product="+product+"]";
}


}
