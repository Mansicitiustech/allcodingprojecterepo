package com.springcore.entity;

public class Person {
private int id;
private String name;
private Address address;
public void setId(int id) {
	this.id = id;
}
public void setName(String name) {
	this.name = name;
}
public void setAddress(Address address) {
	this.address = address;
}
@Override
public String toString() {
	return "Person [id=" + id + ", name=" + name + ", address=" + address + "]";
}
//for constructor autowiring
public Person(int id, String name, Address address) {
	super();
	this.id = id;
	this.name = name;
	this.address = address;
}
public Person() {
	super();
}

}
