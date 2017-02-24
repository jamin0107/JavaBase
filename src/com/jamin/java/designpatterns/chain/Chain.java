package com.jamin.java.designpatterns.chain;

public class Chain {

	public static void main(String[] args) {
		ProjectHandler projectHandler = new ProjectHandler();
		DeptHandler deptHandler = new DeptHandler();
		GeneralHandler generalHandler = new GeneralHandler();
		projectHandler.setNextHandler(deptHandler);
		deptHandler.setNextHandler(generalHandler);
		projectHandler.doHandler();
	}
	
	
}
