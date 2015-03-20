package com.jamin.java.designpatterns.factory;

public class FactoryTest {

	
	private static int a = 10;
	private static int b = 5;
	
	public static void main(String[] args) {
		Operation operation1 = OperationFactory.factory(OperationFactory.TYPE_ADD);
		operation1.setA(a);
		operation1.setB(b);
		int result1 = operation1.operation();
		System.out.println("result1 = " + result1);
		Operation operation2 = OperationFactory.factory(OperationFactory.TYPE_MUL);
		operation2.setA(a);
		operation2.setB(b);
		int result2 = operation2.operation();
		System.out.println("resulut2 = " + result2);
	}



}
