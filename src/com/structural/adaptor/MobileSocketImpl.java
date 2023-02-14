package com.structural.adaptor;

public class MobileSocketImpl implements MobileSocket{
WallSocketAdaptor wallSocket;//adaptor 
	@Override
	public Volt get3Volts() {
		// TODO Auto-generated method stub
		Volt volts = wallSocket.getVolts();
		int v3=(volts.getVolt()/80) ;
		return new Volt(v3);
	}
public MobileSocketImpl(WallSocketAdaptor wallSocket) {
	this.wallSocket=wallSocket;
}
@Override
public String toString() {
	return "MobileSocketImpl [wallSocket=" + wallSocket + ", get3Volts()=" + get3Volts() + "]";
}

}
