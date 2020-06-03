package com.practise.java.collection.list;

public class TestMyLinkedList {

	public static void main(String[] args) {
		MyLinkedList<String> list = new MyLinkedList<>();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		list.add("ddd");
		list.add("eee");
		System.out.println(list);
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		System.out.println(list.get(3));
		System.out.println(list.get(4));
		list.remove(4);
		System.out.println(list);
		list.remove(0);
		System.out.println(list);
		list.remove(1);
		System.out.println(list);
		list.add(1, "ccc");
		System.out.println(list);
		list.add(3, "aaa");
		System.out.println(list);
//		System.out.println(list.get(-1));
	}
}
