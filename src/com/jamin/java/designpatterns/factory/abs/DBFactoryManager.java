package com.jamin.java.designpatterns.factory.abs;

public class DBFactoryManager {

	
	public <T extends BaseModel> void insert(Class<UserModel> class1 , UserModel model){
		DBFactory factory = new AbsDBFactory();
		factory.insert(class1 , model);
	}
	
	
}
