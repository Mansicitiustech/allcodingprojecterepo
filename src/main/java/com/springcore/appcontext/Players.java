package com.springcore.appcontext;

public class Players {
private int id;
private String name;
public Players() {
	super();
}
public void setId(int id) {
	this.id = id;
}
public void setName(String name) {
	this.name = name;
}
public int getId() {
	return id;
}
public String getName() {
	return name;
}
@Override
public String toString() {
	return "Players [id=" + id + ", name=" + name + "]";
}

}
