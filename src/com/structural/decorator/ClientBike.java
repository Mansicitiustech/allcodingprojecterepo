package com.structural.decorator;

public class ClientBike {
public static void main(String[] args) {
	Bike basicBike=new BasicBike();
basicBike.assembledBike();
	System.out.println("________________________________________________________");
	Bike sportsBike=new SportsBike(basicBike);
sportsBike.assembledBike();
	System.out.println("______________________________________________");
	Bike luxzuryBike=new LuxzuryBike(basicBike);	luxzuryBike.assembledBike();
System.out.println("_______________________________________________");
	Bike sportsLuxzuryBasicBikes=new SportsBike(new LuxzuryBike(new BasicBike()));//decorator design pattern
	sportsLuxzuryBasicBikes.assembledBike();
}
}
