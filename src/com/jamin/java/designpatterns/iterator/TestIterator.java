package com.jamin.java.designpatterns.iterator;

public class TestIterator {

	public static void main(String[] args) {
		MyCollection myCollection = new MyCollection();
		Iterator interator = myCollection.iterator();
		while (interator.hasNext()) {
			System.out.println(interator.next());
		}
	}

}
