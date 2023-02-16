package com.springcore.entity;

public class Product {
private int id;
private String code;
private double price;
private String name;
private boolean availability;
public Product() {
	super();
}
public void setId(int id) {
	this.id = id;
}
public void setCode(String code) {
	this.code = code;
}
public void setPrice(double price) {
	this.price = price;
}
public void setName(String name) {
	this.name = name;
}
public void setAvailability(boolean availability) {
	this.availability = availability;
}
@Override
public String toString() {
	return "Product [id=" + id + ", code=" + code + ", price=" + price + ", name=" + name + ", availability="
			+ availability ;
}
//this constructor is only for composition or values in customer class
public Product(int id, String code, double price, String name, boolean availability) {
	super();
	this.id = id;
	this.code = code;
	this.price = price;
	this.name = name;
	this.availability = availability;
}


}
