package com.jamin.java.designpatterns.flyweight;

public class TestFlyWeight {

	
	public static void main(String[] args) {
		FlyweightFactory  flyweightFactory = new FlyweightFactory();
		FlyWeight flyWeight0 = flyweightFactory.getFlyWeight("Facebook");
		FlyWeight flyWeight1 = flyweightFactory.getFlyWeight("Google");
		FlyWeight flyWeight2 = flyweightFactory.getFlyWeight("Google");
		FlyWeight flyWeight3 = flyweightFactory.getFlyWeight("Google");
		FlyWeight flyWeight4 = flyweightFactory.getFlyWeight("Google");
		FlyWeight flyWeight5 = flyweightFactory.getFlyWeight("Google");
		FlyWeight flyWeight6 = flyweightFactory.getFlyWeight("Facebook");
		FlyWeight flyWeight7 = flyweightFactory.getFlyWeight("Facebook");
	
		flyWeight0.operation();
		flyWeight1.operation();
		flyWeight2.operation();
		flyWeight3.operation();
		flyWeight4.operation();
		flyWeight5.operation();
		flyWeight6.operation();
		flyWeight7.operation();
		
		
		System.out.println("getFlyWeightSize = " + flyweightFactory.getFlyWeightSize());
		
	}
}
