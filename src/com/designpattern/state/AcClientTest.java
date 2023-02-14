package com.designpattern.state;

public class AcClientTest {
public static void main(String[] args) {
	AcContext ac=new AcContext();
	State start=new AcStartState();
	ac.setState(start);
	
	
	//State stop=new AcStopState();
	//ac.setState(stop);
	
	ac.doAction();
}
}
