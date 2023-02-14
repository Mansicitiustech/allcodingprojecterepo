package com.structural.decorator;

public class LuxzuryBike extends DecoratorBike{

	public LuxzuryBike(Bike bike) {
		super(bike);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void assembledBike() {
		super.assembledBike();
		// TODO Auto-generated method stub
	System.out.println("luxzury  bike features-------------------");
	}
}
