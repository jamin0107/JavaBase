package com.jamin.java.designpatterns.bridge;

public abstract class Bridge {

	Sourceable source;
	
	
    public Sourceable getSource() {  
        return source;  
    }  
  
    public void setSource(Sourceable source) {  
        this.source = source;  
    }  
    
	public void connectDB(){
		if(source != null){
			source.connectDB();
		}
		
	}
	
	
}
