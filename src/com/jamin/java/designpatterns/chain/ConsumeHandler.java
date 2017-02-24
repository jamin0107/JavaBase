package com.jamin.java.designpatterns.chain;

public abstract class ConsumeHandler{
	
	private ConsumeHandler consumeHandler;
	
	public ConsumeHandler getNextHandler(){
		return consumeHandler;
	}
	
	public void setNextHandler(ConsumeHandler consumeHandler){
		this.consumeHandler = consumeHandler;
	}

	public abstract void doHandler();

}
