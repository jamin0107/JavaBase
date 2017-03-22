package com.jamin.java.designpatterns.memento;

public class Storage {

	private MemoryData memento;

	public Storage(MemoryData memento) {
		this.memento = memento;
	}

	public MemoryData getMemento() {
		return memento;
	}

	public void setMemento(MemoryData memento) {
		this.memento = memento;
	}
}
