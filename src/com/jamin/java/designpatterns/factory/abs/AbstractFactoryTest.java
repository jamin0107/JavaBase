package com.jamin.java.designpatterns.factory.abs;

public class AbstractFactoryTest {

	
	public static void main(String[] args) {
		
		UserModel usermodel = new UserModel();
		usermodel.id = 1;
		usermodel.username = "abc";
		usermodel.password = "123456";
		UserModelDao dao = new UserModelDao();
		
		dao.insert(usermodel);
		
	}


}

