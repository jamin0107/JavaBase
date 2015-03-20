package com.jamin.java.designpatterns.factory;

public class OperationFactory {

	public static final int TYPE_ADD = 1;
	public static final int TYPE_MUL = 2;
	
	public static Operation factory(int type){
		
		Operation operation = null;
		switch(type){
		case TYPE_ADD:
			operation = new OperationAdd();
			break;
		case TYPE_MUL:
			operation = new OperationMul();
			break;
		}
		return operation;
		
	}
	
}
