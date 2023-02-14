package com.creationaldesign.prototype;

import java.util.ArrayList;
import java.util.List;

public class StudentDAO implements Cloneable{
private static List<Student> studentList;

static {
	
	studentList=new ArrayList<>();
	Student s1=new Student();
	s1.setId(11);
	s1.setName("sweta");
	
	studentList.add(s1);
}

public List<Student> getAllStudentDetails(){
	
	return studentList;
}

public List<Student> clone() throws CloneNotSupportedException {
List<Student> dummystudentList=new ArrayList<>();
for(Student s:studentList) {
	dummystudentList.add(s);
}
	return  dummystudentList;
	
}





}
