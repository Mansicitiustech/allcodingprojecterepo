package com.designpattern.strategy;

public class Product {
private String name;
private String upcCode;
private int price;


public Product(String name, String upcCode, int price) {
	super();
	this.name = name;
	this.upcCode = upcCode;
	this.price = price;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getUpcCode() {
	return upcCode;
}
public void setUpcCode(String upcCode) {
	this.upcCode = upcCode;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}


}
