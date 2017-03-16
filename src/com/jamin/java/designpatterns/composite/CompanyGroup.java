package com.jamin.java.designpatterns.composite;

import java.util.ArrayList;
import java.util.List;

public class CompanyGroup  extends Company {
	
	
	    private List<Company> mList;  
	  
	    public CompanyGroup() {  
	    	mList = new ArrayList<Company>();  
	    }  
	  
	    public CompanyGroup(String name) {  
	        super(name);   
	        mList = new ArrayList<Company>() ;   
	    }  
	  
	    @Override  
	    protected void add(Company company) {  
	    	mList.add(company);  
	    }  
	  
	    @Override  
	    protected void display(int depth) {  
	        // TODO Auto-generated method stub  
	        StringBuilder sb = new StringBuilder("");  
	        for (int i = 0; i < depth; i++) {  
	            sb.append("-");   
	        }  
	        System.out.println(new String(sb) + this.getName());  
	        for (Company c : mList) {  
	            c.display(depth + 2);  
	        }  
	    }  
	  
	    @Override  
	    protected void romove(Company company) {  
	    	mList.remove(company);  
	    }  
	}  
	  