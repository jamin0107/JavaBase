package com.jamin.java.designpatterns.single;

public class Singleton {

	private static Singleton instance;
	
	public Singleton(){
		
	}
	
	public static Singleton getInstance(){
		if(instance == null){
			synchronized(Singleton.class){
				if(instance == null){
					instance = new Singleton();
				}
			}
		}
		return instance;
	}
	
	
//    /* 获取实例 */  
//    public static Singleton getInstance() {  
//        return SingletonFactory.instance;  
//    }  
	
	 /* 此处使用一个内部类来维护单例 */  
    private static class SingletonFactory {  
        private static Singleton instance = new Singleton();  
    }  
	
	public void say(){
		System.out.println("Hello World Thread = " + Thread.currentThread().getId());
	}
	
	

}

