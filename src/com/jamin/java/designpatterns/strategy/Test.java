package com.jamin.java.designpatterns.strategy;

public class Test {

	
	
	public static void main(String[] args) {
		String exp = "2+8";
		ICalculator cal = new Plus();
		int result = cal.calculate(exp);
		System.out.println(result);
		
		
		String expMuti = "2*8";
		ICalculator calMuti = new Multiply();
		int resultMuti = calMuti.calculate(expMuti);
		System.out.println(resultMuti);
	}
	
	
	

}
