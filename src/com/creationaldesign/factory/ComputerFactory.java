package com.creationaldesign.factory;

public class ComputerFactory {
private ComputerFactory()
{}
public static Computer getAllDetailsComputer(ComputerType computerType, String rem, String hdd, String cpu, boolean isGraphicsEnabled, boolean isBluetoothEnabled) {
	
	switch(computerType) {
	case PC:
		return new PC(rem, hdd, cpu, isGraphicsEnabled, isBluetoothEnabled);
	case Server:
		return new Server(rem, hdd, cpu, isGraphicsEnabled, isBluetoothEnabled);
	case Laptop:
		return new Laptop(rem, hdd, cpu, isGraphicsEnabled, isBluetoothEnabled);
	default:
		throw new RuntimeException("Invalid Computer Type please provide right computertype!!");
	
	}
	
}
}
