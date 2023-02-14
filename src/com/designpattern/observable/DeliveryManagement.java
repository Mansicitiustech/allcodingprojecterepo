package com.designpattern.observable;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class DeliveryManagement implements Subject {
private Observable location;
private List<Observer> observer;
public DeliveryManagement() {
	this.observer=new ArrayList<>();
}
	@Override
	public void register(Observer obs) {
		// TODO Auto-generated method stub
	observer.add(obs)	;
	
	}

	@Override
	public void unregister(Observer obs) {
		// TODO Auto-generated method stub
		observer.remove(obs)	;
	}

	@Override
	public void notifyObserver() {
		// TODO Auto-generated method stub
	for(Observer ob:observer) {
		ob.update(location,"khandwa");
	}}
	public void locationChanged() {
		this.location=getLocation();
		notifyObserver();
		}
	
	

	public Observable getLocation() {
		return location;
	}

	
	
	

}
