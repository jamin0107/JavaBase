package com.jamin.java.designpatterns.command;

public class MyCommand implements Command {

	private OnClick mReceiver;

	public MyCommand(OnClick receiver) {
		this.mReceiver = receiver;
	}

	@Override
	public void exe() {
		mReceiver.action();
	}
}