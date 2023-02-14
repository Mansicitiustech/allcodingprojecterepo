package com.designpattern.observable;

public class ObserverTest {
public static void main(String[] args) {
	DeliveryManagement topic=new DeliveryManagement();
	Observer obser1=new Seller();
	Observer obser2=new User();
	Observer obsser3=new DeliveryWarehouse();
	
	topic.register((java.util.Observer) obser1);
	topic.locationChanged();
}
}
