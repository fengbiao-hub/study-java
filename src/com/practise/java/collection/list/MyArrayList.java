package com.practise.java.collection.list;

/**
 * 自定义实现ArrayList
 * 
 * @author fengb
 * @data 2020年6月2日
 */
public class MyArrayList<E> {

	// 成员变量和静态变量
	/** 存放数组 */
	private Object[] obj;
	/** 当前List大小 */
	private int size;
	/** 默认容量 */
	public static final int DEFAULT_CAPACITY = 10;

	// 构造方法
	public MyArrayList() {
		this.obj = new Object[DEFAULT_CAPACITY];
	}

	public MyArrayList(int capacity) {
		this.obj = new Object[capacity];
	}

	//方法
	/**
	 * 增加元素
	 * @param element
	 * @return
	 */
	public boolean add(E element) {
		this.obj[size++] = element;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i = 0; i < size; i++) {
			sb.append(this.obj[i] + ",");
		}
		sb.setCharAt(sb.length() - 1, ']');
		return sb.toString();
	}
}
