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
	
	
//    /* ��ȡʵ�� */  
//    public static Singleton getInstance() {  
//        return SingletonFactory.instance;  
//    }  
	
	 /* �˴�ʹ��һ���ڲ�����ά������ */  
    private static class SingletonFactory {  
        private static Singleton instance = new Singleton();  
    }  
	
	public void say(){
		System.out.println("Hello World Thread = " + Thread.currentThread().getId());
	}
	
	

}

