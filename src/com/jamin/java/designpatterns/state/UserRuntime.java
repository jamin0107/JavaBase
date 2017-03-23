package com.jamin.java.designpatterns.state;

public class UserRuntime {

	LoginState loginState;
	
	public UserRuntime(LoginState loginState){
		this.loginState = loginState;
	}
	
	
	public void comment(){
		if(loginState.state == LoginState.STATE_lOGIN){
			System.out.println("Have been login , comment.");
		}else{
			System.out.println("LOGOUT , cant comment");
		}
	}
	
	
}
