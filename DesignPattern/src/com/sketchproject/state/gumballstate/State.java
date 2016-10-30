package com.sketchproject.state.gumballstate;

public interface State {
	void insertQuarter();
	void ejectQuarter();
	void turnCrank();
	void dispense();
}
