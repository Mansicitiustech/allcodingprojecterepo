package com.designpattern.state;

public class AcContext implements State{
private State state;

public State getState() {
	return state;
}

public void setState(State state) {
	this.state = state;
}

@Override
public void doAction() {
	// TODO Auto-generated method stub
	state.doAction();
}

}
