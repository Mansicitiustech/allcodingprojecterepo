package com.structural.decorator;

public class DecoratorBike implements Bike{
private Bike bike;

	public DecoratorBike(Bike bike) {
	super();
	this.bike = bike;
}

	@Override
	public void assembledBike() {
		// TODO Auto-generated method stub
		bike.assembledBike();
	}

}
