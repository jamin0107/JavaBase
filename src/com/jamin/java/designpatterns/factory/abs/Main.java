package com.jamin.java.designpatterns.factory.abs;

public class Main {

	
	public static void main(String[] args) {
		
		UserModel usermodel = new UserModel();
		usermodel.id = 1;
		usermodel.setUsername("abc");
		usermodel.setPassword("123456");
		UserModelDao dao = new UserModelDao();
		
		dao.insert(usermodel);
		
	}


}

