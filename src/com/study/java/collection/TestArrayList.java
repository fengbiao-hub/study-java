package com.study.java.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * ��ϰArrayList
 * 
 * @author fengb
 * @data 2020��6��1��
 */
public class TestArrayList {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		System.out.println(list.hashCode());
		for(int i = 0; i < 10; i++) {
			list.add("list-" + i);
//			System.out.println(list.hashCode());
		}
		System.out.println(list.hashCode());
		list.add("aaa");
		System.out.println(list.hashCode());
	}
	
	
}
