package com.practise.java.collection.map;

public class TestMyHashMap {

	public static void main(String[] args) {
		MyHashMap<Integer, String> map = new MyHashMap<Integer, String>();
		map.put(1, "1");
		map.put(2, "2");
		System.out.println(map);
		System.out.println(map.get(1));
	}
}
