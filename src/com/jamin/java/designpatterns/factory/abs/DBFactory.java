package com.jamin.java.designpatterns.factory.abs;

public interface DBFactory {

	public <T extends BaseModel> void insert(Class<T> c , T t);
	
	public void update();
	
	public void delete();
	
	public void select();

	
	
}
