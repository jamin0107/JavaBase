package com.jamin.java.designpatterns.iterator;

public interface Collection {  
    
    
	public Iterator iterator();  
      
    //��ȡ����Ԫ��
    public Object get(int i);  
      
    //��ȡ���ϴ�С
    public int size();  
    
    
}  