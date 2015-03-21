package com.jamin.java.designpatterns.observer;


public interface IObserverManger {

	
	
	public void registerObserver(Observer observer);
	
	public void unRegisterObserver(Observer observer);
	
	public void broadcast(int i);
	
}
