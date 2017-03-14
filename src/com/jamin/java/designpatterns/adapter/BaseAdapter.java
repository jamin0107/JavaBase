package com.jamin.java.designpatterns.adapter;

public abstract class BaseAdapter implements Adapter{


	@Override
	public int getItemViewType(int position) {
		return 0;
	}

	@Override
	public int getViewTypeCount() {
		// TODO Auto-generated method stub
		return 1;
	}

}
