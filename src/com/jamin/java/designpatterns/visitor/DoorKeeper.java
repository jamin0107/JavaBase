package com.jamin.java.designpatterns.visitor;

public class DoorKeeper {

	public void accecpt(Visitor visitor){
		if(visitor != null){
			System.out.println("Door keep accept");
			visitor.visit();
		}
	}
}
