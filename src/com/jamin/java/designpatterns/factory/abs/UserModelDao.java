package com.jamin.java.designpatterns.factory.abs;

public class UserModelDao {

	public void insert(UserModel usermodel) {
		
		DBFactoryManager factory = new DBFactoryManager();
		factory.insert(UserModel.class, usermodel);
	}

}
