package com.jamin.java.designpatterns.memento;

public class MemoryData {

	private String value;

	public MemoryData(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
