package com.springcore.entity;

public class Department {
private int deptId;
private String name;
private Employee employee;
public void setDeptId(int deptId) {
	this.deptId = deptId;
}
public void setName(String name) {
	this.name = name;
}
public void setEmployee(Employee employee) {
	this.employee = employee;
}
public Department() {
	super();
}
@Override
public String toString() {
	return "Department [deptId=" + deptId + ", name=" + name + ", employee=" + employee + "]";
}

}
