package com.jamin.java.designpatterns.memento;

public class OriginData {

	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public OriginData(String value) {
		this.value = value;
	}

	public MemoryData createMemento() {
		return new MemoryData(value);
	}

	public void restoreMemento(MemoryData memoryData) {
		this.value = memoryData.getValue();
	}
}