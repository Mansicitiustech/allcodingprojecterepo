package com.springcore.entity;

public class Address {
private int addid;
private String city;
public Address() {
	super();
}
public void setAddid(int addid) {
	this.addid = addid;
}
public void setCity(String city) {
	this.city = city;
}
@Override
public String toString() {
	return "Address [addid=" + addid + ", city=" + city + "]";
}
//for constructor di in constructor autowiring xml
public Address(int addid, String city) {
	super();
	this.addid = addid;
	this.city = city;
}

}
