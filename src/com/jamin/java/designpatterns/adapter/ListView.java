package com.jamin.java.designpatterns.adapter;

import java.util.ArrayList;
import java.util.List;

public class ListView {

	
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("1abc");
		list.add("2abc");
		list.add("3abc");
		list.add("4abc");
		MyAdapter myAdapter = new MyAdapter(list);
		
		int count = myAdapter.getCount();
		
		for(int i = 0 ; i < count ; i++){
			System.out.print("View Type = " + myAdapter.getItemViewType(i) + ", getView = ");
			myAdapter.getView(i, null, null);
		}
	}
	
}
