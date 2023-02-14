package com.structural.adaptor;

public class ClientAdaptor {
public static void main(String[] args) {
	WallSocketAdaptor wall=new WallSocketImpl();
	Volt voltsWall = wall.getVolts();
	System.out.println(voltsWall);
	MobileSocket mobile=new MobileSocketImpl(wall);
	Volt voltMobile = mobile.get3Volts();
	System.out.println(voltMobile);
	
}
}
