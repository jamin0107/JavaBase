package com.jamin.java.designpatterns.facade;

public class Computer {

	CPU cpu;
	Memory memory;
	Disk disk;
	
	
	public Computer(){
		cpu = new CPU();
		memory = new Memory();
		disk = new Disk();
	}
	
	
	public void startup() {
		System.out.println("Computer startup start");
		cpu.startup();
		memory.startup();
		disk.startup();
		System.out.println("Computer startup shutdown");
	}

	public void shutdown() {
		System.out.println("Computer shutdown start");
		cpu.shutdown();
		memory.shutdown();
		disk.shutdown();
		System.out.println("Computer shutdown end");
	}
}
