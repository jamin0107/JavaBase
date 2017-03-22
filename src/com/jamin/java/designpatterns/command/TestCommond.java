package com.jamin.java.designpatterns.command;

public class TestCommond {

	public static void main(String[] args) {
		OnClick onclick = new OnClick();
		Command cmd = new MyCommand(onclick);
		Invoker invoker = new Invoker(cmd);
		invoker.action();
	}
	
	
	
}
