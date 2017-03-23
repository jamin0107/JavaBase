package com.jamin.java.designpatterns.state;

public class TestState {

	
	public static void main(String[] args) {
		LoginState loginState = new LoginState();
		loginState.setState(LoginState.STATE_lOGIN);
		
		UserRuntime userRuntime = new UserRuntime(loginState);
		userRuntime.comment();
		
		loginState.setState(LoginState.STATE_LOGOUT);
		userRuntime.comment();
	}
	
}
