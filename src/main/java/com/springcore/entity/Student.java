package com.springcore.entity;

public class Student {
private int sid;
private String name;
private Address address;
private Teacher teacher;

public Student() {
	super();
}

public void setSid(int sid) {
	this.sid = sid;
}

public void setName(String name) {
	this.name = name;
}

public void setAddress(Address address) {
	this.address = address;
}

public void setTeacher(Teacher teacher) {
	this.teacher = teacher;
}

@Override
public String toString() {
	return "Student [sid=" + sid + ", name=" + name + ", address=" + address + ", teacher=" + teacher + "]";
}

}
