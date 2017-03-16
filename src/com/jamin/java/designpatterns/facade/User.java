package com.jamin.java.designpatterns.facade;

public class User {

	
	public static void main(String[] args) {
		Computer computer = new Computer();
		computer.startup();
		System.out.println("------------");
		computer.shutdown();
	}
}
