package com.jamin.java.designpatterns.iterator;

public class MyIterator implements Iterator {

	
	private Collection mCollection;
	private int pos = -1;

	
	public MyIterator(Collection collection) {
		this.mCollection = collection;
	}

	@Override
	public Object previous() {
		if (pos > 0) {
			pos--;
		}
		return mCollection.get(pos);
	}

	@Override
	public Object next() {
		if (pos < mCollection.size() - 1) {
			pos++;
		}
		return mCollection.get(pos);
	}

	@Override
	public boolean hasNext() {
		if (pos < mCollection.size() - 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Object first() {
		pos = 0;
		return mCollection.get(pos);
	}

}
