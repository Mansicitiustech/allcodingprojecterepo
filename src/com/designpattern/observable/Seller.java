package com.designpattern.observable;

public class Seller implements Observer {

	@Override
	public void update(String location) {
		// TODO Auto-generated method stub
		//this.location=location;
		showLocation();
		
	}
public void showLocation() {
	System.out.println("location is updated");
}
}
