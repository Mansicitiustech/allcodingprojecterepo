package com.creationaldesign.factory;

public class Server implements Computer {
	private String rem;
	private String hdd;
	private String cpu;
	private boolean isGraphicsEnabled;
	private boolean isBluetoothEnabled;

	public Server(String rem, String hdd, String cpu, boolean isGraphicsEnabled, boolean isBluetoothEnabled) {
		super();
		this.rem = rem;
		this.hdd = hdd;
		this.cpu = cpu;
		this.isGraphicsEnabled = isGraphicsEnabled;
		this.isBluetoothEnabled = isBluetoothEnabled;
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public String rem() {
		// TODO Auto-generated method stub
		return this.rem;
	}

	@Override
	public String hdd() {
		// TODO Auto-generated method stub
		return this.hdd;
	}

	@Override
	public String cpu() {
		// TODO Auto-generated method stub
		return this.cpu;
	}

	@Override
	public boolean isGraphicsEnabled() {
		// TODO Auto-generated method stub
		return this.isGraphicsEnabled;
	}

	@Override
	public boolean isBluetoothEnabled() {
		// TODO Auto-generated method stub
		return this.isBluetoothEnabled;
	}
	@Override
	public String toString() {
		return "Server [rem=" + rem + ", hdd=" + hdd + ", cpu=" + cpu + ", isGraphicsEnabled=" + isGraphicsEnabled
				+ ", isBluetoothEnabled=" + isBluetoothEnabled + "]";
	}
}