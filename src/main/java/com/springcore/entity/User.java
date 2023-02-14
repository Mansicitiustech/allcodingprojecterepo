package com.springcore.entity;

public class User {
private int id;
private String firstName;
private String lastName;
private String email;
private Product product;
public User() {
	super();
}
/*public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getfirstName() {
	return firstName;
}
public void setfirstName(String firstName) {
	this.firstName = firstName;
}
public String getlName() {
	return lastName;
}
public void setlName(String lastName) {
	this.lastName = lastName;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}*/
@Override
public String toString() {
	return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email+", product=" + product ;
}
public User(int id, String firstName, String lastName, String email,Product product) {
	super();
	this.id = id;
	this.firstName = firstName;
	this.lastName = lastName;
	this.email = email;
	this.product=product;
}

}
