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
	private Object[] objs;
	/** 当前List大小 */
	private int size;
	/** 默认容量 */
	public static final int DEFAULT_CAPACITY = 10;

	// 构造方法
	public MyArrayList() {
		this.objs = new Object[DEFAULT_CAPACITY];
	}

	public MyArrayList(int capacity) {
		this.objs = new Object[capacity];
	}

	//方法
	/**
	 * 增加元素
	 * @param element
	 * @return
	 */
	public boolean add(E element) {
		if(size == this.objs.length) {
			expand(); // 扩容
		}
		this.objs[size++] = element;
		return true;
	}
	
	/**
	 * 扩容数组
	 */
	private void expand() {
		Object[] newObjs = new Object[this.objs.length + (this.objs.length >> 1)];
		System.out.println("扩容后容量" + newObjs.length);
		System.arraycopy(this.objs, 0, newObjs, 0, this.objs.length); // 拷贝数组
		this.objs = newObjs;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i = 0; i < size; i++) {
			sb.append(this.objs[i] + ",");
		}
		sb.setCharAt(sb.length() - 1, ']');
		return sb.toString();
	}
}
