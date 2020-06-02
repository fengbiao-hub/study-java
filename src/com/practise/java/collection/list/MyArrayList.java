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
		if (checkCapacity(capacity)) {
			this.objs = new Object[capacity];
		} else {
			this.objs = new Object[DEFAULT_CAPACITY];
		}
	}

	// 提供外部调用方法
	/**
	 * 增加元素
	 * 
	 * @param element
	 * @return
	 */
	public boolean add(E element) {
		if (size == this.objs.length) {
			expand(); // 扩容
		}
		this.objs[size++] = element;
		return true;
	}

	/**
	 * 根据下标获取元素
	 * 
	 * @param index
	 * @return
	 */
	public E get(int index) {
		checkIndex(index); // 检查索引
		return (E) this.objs[index];
	}

	/**
	 * 设置对应下标元素
	 * 
	 * @param index
	 * @param element
	 */
	public void set(int index, E element) {
		checkIndex(index);
		this.objs[index] = element;
	}

	/**
	 * 移除对应元素
	 * 
	 * @param element
	 */
	public int remove(E element) {
		for (int i = 0; i < this.size; i++) {
			if (this.objs[i].equals(element)) {
				remove(i);
				return i;
			}
		}
		return -1;
	}

	/**
	 * 移除对应下标元素
	 * 
	 * @param index
	 * @return
	 */
	public E remove(int index) {
		checkIndex(index); // 检查下标合法性
		E element = get(index);
		int moveCount = this.size - 1 - index;
		if (moveCount > 0) {
			System.arraycopy(objs, index + 1, objs, index, moveCount); // 利用数组拷贝实现数组移动
		}
		this.objs[size - 1] = null;
		size--;
		return element;
	}

	/**
	 * 返回集合的大小
	 * 
	 * @return
	 */
	public int size() {
		return this.size;
	}

	// 内部方法
	/**
	 * 检查容量合法性
	 * 
	 * @return
	 */
	private boolean checkCapacity(int capacity) {
		if (capacity < 0) {
			throw new RuntimeException("容量不合法:" + capacity);
		}
		if (capacity == 0) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 检查索引合法性
	 * 
	 * @param index
	 * @return
	 */
	private boolean checkIndex(int index) {
		if (index < 0 || index > size - 1) {
			throw new RuntimeException("不合法的索引:" + index);
		} else {
			return true;
		}
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
