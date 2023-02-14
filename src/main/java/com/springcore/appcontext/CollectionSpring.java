package com.springcore.appcontext;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import com.springcore.entity.Employee;

public class CollectionSpring {
private List<String>myStringList;
private Set<Integer> myIntSet;
private Map<String,String> myMap;
private List<Players>myPlayerList;
private Set<Employee>myEmployeeSet;
private Properties properties;

public Properties getProperties() {
	return properties;
}
public void setProperties(Properties properties) {
	this.properties = properties;
}
public CollectionSpring() {
	super();
}
public List<String> getMyStringList() {
	return myStringList;
}
public void setMyStringList(List<String> myStringList) {
	this.myStringList = myStringList;
}
public Set<Integer> getMyIntSet() {
	return myIntSet;
}
public void setMyIntSet(Set<Integer> myIntSet) {
	this.myIntSet = myIntSet;
}
public Map<String, String> getMyMap() {
	return myMap;
}
public void setMyMap(Map<String, String> myMap) {
	this.myMap = myMap;
}
public List<Players> getMyPlayerList() {
	return myPlayerList;
}
public void setMyPlayerList(List<Players> myPlayerList) {
	this.myPlayerList = myPlayerList;
}
public Set<Employee> getMyEmployeeSet() {
	return myEmployeeSet;
}
public void setMyEmployeeSet(Set<Employee> myEmployeeSet) {
	this.myEmployeeSet = myEmployeeSet;
}
@Override
public String toString() {
	return "CollectionSpring [myStringList=" + myStringList + ", myIntSet=" + myIntSet + ", myMap=" + myMap
			+ ", myPlayerList=" + myPlayerList + ", myEmployeeSet=" + myEmployeeSet + ", properties=" + properties + "]";
}




}
