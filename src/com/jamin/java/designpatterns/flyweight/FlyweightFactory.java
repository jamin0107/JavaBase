package com.jamin.java.designpatterns.flyweight;

import java.util.Hashtable;

public class FlyweightFactory {

	
	private Hashtable<String, FlyWeight> hashtable = new Hashtable<>();
	
	
	public FlyweightFactory(){
		
	}
	
	
	public FlyWeight getFlyWeight(String key){
		FlyWeight flyWeight = hashtable.get(key);
		if(flyWeight == null){
			flyWeight = new FlyWeight();
			hashtable.put(key, flyWeight);
		}
		return flyWeight;
	}
	
	
	public int getFlyWeightSize(){
		return hashtable.size();
	}
	
}
