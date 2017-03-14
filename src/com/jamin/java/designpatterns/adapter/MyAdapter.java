package com.jamin.java.designpatterns.adapter;

import java.util.List;

public class MyAdapter extends BaseAdapter{
	
	List<String> list =null;
	
	public MyAdapter(List<String> list) {
		this.list = list;
	}
	
	
	@Override
	public int getCount() {
		return list == null ? 0:list.size();
	}

	@Override
	public Object getItem(int position) {
		return list == null ? null : list.get(position);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup Parent) {
		View view = new View();
		if(list == null){
			return view;
		}
		System.out.println(list.get(position));
		return view;
	}

	
	
}
