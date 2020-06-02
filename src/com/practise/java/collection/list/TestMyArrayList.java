package com.practise.java.collection.list;

/**
 * �����Զ����ArrayList
 * @author fengb
 * @data 2020��6��2��
 */
public class TestMyArrayList {

	public static void main(String[] args) {
		MyArrayList<String> list = new MyArrayList<>(0);
		list.add("aaa");
		list.add("bbb");
		for (int i = 0; i < 10; i++) {
			list.add("item" + i);
		}
		System.out.println(list);
		System.out.println(list.get(8));
		list.set(5, "ccc");
		System.out.println(list);
		list.remove(10);
		System.out.println(list);
		list.remove("bbb");
		System.out.println(list);
		System.out.println(list.size());
	}
}
