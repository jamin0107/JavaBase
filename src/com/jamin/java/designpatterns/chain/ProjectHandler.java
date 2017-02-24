package com.jamin.java.designpatterns.chain;

public class ProjectHandler extends ConsumeHandler {

	@Override
	public void doHandler() {
		System.out.println("project agree");
		if (getNextHandler() != null) {
			getNextHandler().doHandler();
		}
	}

}
