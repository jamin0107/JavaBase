package com.jamin.java.designpatterns.state;

public class LoginState {

	public static final int STATE_lOGIN = 1;
	public static final int STATE_LOGOUT = 2;
	
	int state = 0;

	
	
	public int getState() {
		return state;
	}

	
	
	public void setState(int state) {
		this.state = state;
	}
	
	
	
}
