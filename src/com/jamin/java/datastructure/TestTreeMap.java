package com.jamin.java.datastructure;

import java.util.Iterator;
import java.util.TreeMap;

/**
 * ÓÐÐòµÄHashMap£¬ºìºÚÊ÷
 * @author Jamin
 *
 */
public class TestTreeMap {

	
	public static void main(String[] args) {
		TreeMap<Integer, String> treeMap = new TreeMap<>();
		for(int i=0; i<10; i++) {
			int key = (int) (Math.random()*1000);
	        String s = ""+key;
	        treeMap.put(key,s);
	    }
		treeMap.put(5,"5");
		treeMap.put(5,"5");
		
		Iterator<String> it = treeMap.values().iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
	
	
}
