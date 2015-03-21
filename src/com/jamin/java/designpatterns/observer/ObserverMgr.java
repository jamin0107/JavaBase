package com.jamin.java.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

public class ObserverMgr implements IObserverManger {

	List<Observer> observerList;

	public ObserverMgr() {
		observerList = new ArrayList<Observer>();
	}

	@Override
	public void registerObserver(Observer observer) {
		if (observerList != null && observer != null) {
			observerList.add(observer);
		}
	}

	@Override
	public void unRegisterObserver(Observer observer) {
		if (observerList != null && observer != null) {
			observerList.remove(observer);
		}
	}

	@Override
	public void broadcast(int i) {
		if (observerList != null && observerList.size() > 0) {
			for (Observer o : observerList) {
				if(o != null){
					o.onReceive(i);
				}
				
			}
		}
	}

}
