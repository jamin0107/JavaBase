package com.jamin.java.designpatterns.visitor;

public class TestVisistor {

	
	public static void main(String[] args) {
		DoorKeeper doorKeeper = new DoorKeeper();
		doorKeeper.accecpt(new MyVisitor());
	}
}
