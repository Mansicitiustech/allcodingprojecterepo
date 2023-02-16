package com.structural.adaptor;

public class WallSocketImpl  implements WallSocketAdaptor {

	@Override
	public Volt getVolts() {
		// TODO Auto-generated method stub
		return new Volt(240);
	}

	@Override
	public String toString() {
		return "WallSocketImpl [getVolts()=" + getVolts() + "]";
	}

}
