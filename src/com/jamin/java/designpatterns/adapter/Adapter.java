package com.jamin.java.designpatterns.adapter;

public interface Adapter {

	int getCount();
	
	Object getItem(int position);
	
	View getView(int position , View convertView , ViewGroup Parent);
	
	int getItemViewType(int position);
	
	int getViewTypeCount();
	
}
