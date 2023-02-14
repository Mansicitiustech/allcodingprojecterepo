package com.creationaldesign.prototype;

import java.util.List;

public class StudentClient {
public static void main(String[] args) throws CloneNotSupportedException {
	StudentDAO stud=new StudentDAO();
	
	List<Student> allStudentDetails = stud.getAllStudentDetails();
	allStudentDetails.forEach(System.out::println);
	
	Student student=new Student ();
	student.setId(12);
	student.setName("tomi");
	List<Student> dummyStudentList = stud.clone();
	dummyStudentList.add(student);
	
	System.out.println("updated student list");
	dummyStudentList.forEach(System.out::println);
}
}
