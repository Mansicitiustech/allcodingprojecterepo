package com.structural.decorator;

public class SportsBike extends DecoratorBike{

	public SportsBike(Bike bike) {
		super(bike);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void assembledBike() {
		super.assembledBike();
		// TODO Auto-generated method stub
	System.out.println("sports bike features-------------------");
	}

}
