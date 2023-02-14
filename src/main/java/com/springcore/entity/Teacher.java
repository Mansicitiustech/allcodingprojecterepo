package com.springcore.entity;

public class Teacher {
private int tid;
private String tname;
private String tsubject;
public Teacher() {
	super();
}
public void setTid(int tid) {
	this.tid = tid;
}
public void setTname(String tname) {
	this.tname = tname;
}
public void setTsubject(String tsubject) {
	this.tsubject = tsubject;
}
@Override
public String toString() {
	return "Teacher [tid=" + tid + ", tname=" + tname + ", tsubject=" + tsubject + "]";
}

}
