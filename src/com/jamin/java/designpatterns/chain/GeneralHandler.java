package com.jamin.java.designpatterns.chain;

public class GeneralHandler extends ConsumeHandler {

	@Override
	public void doHandler() {
		System.out.println("GeneralHandler agree");
		if (getNextHandler() != null) {
			getNextHandler().doHandler();
		}
	}

}
