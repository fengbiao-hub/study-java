package com.practise.java.collection.list;

public class MyLinkedList<E> {

	// 成员变量
	/** 第一个节点 */
	private Node first;
	/** 最后一个节点 */
	private Node last;
	/** 大小 */
	private int size;

	// 构造方法
	public MyLinkedList() {
		super();
	}

	// 提供给外部调用的方法
	/**
	 * 添加元素
	 * 
	 * @param element
	 */
	public void add(E element) {
		Node node = new Node(null, element, null);
		if (null == this.first) { // 如果当前链表为空
			this.first = node;
			this.last = node;
		} else { // 链表不为空的情况
			this.last.next = node;
			node.previous = this.last;
			node.next = null;
			this.last = node;
		}
		size++; // 大小+1
	}

	/**
	 * 指定下标插入元素
	 * 
	 * @param index
	 * @param element
	 */
	public void add(int index, E element) {
		Node node = new Node(null, element, null);
		Node temp = getNode(index);
		if (temp != null) {
			// 当前在头节点和尾节点插入会报错
			Node up = temp.previous;
			node.previous = up;
			up.next = node;
			node.next = temp;
			temp.previous = node;
			size++;
		}
	}

	/**
	 * 获取对应下标的元素
	 * 
	 * @param index
	 * @return
	 */
	public E get(int index) {
		checkIndex(index);
		Node node = getNode(index);
		return node == null ? null : (E) node.data;
	}

	/**
	 * 移除对应下标的节点
	 * 
	 * @param element
	 */
	public void remove(int index) {
		checkIndex(index);
		Node node = getNode(index);
		if (node != null) {
			Node up = node.previous;
			Node down = node.next;
			if (up != null) {
				up.next = down;
			}
			if (down != null) {
				down.previous = up;
			}
			/* 删除第一个节点 */
			if (index == 0) {
				first = down;
			}
			/* 删除最后一个节点 */
			if (index == this.size - 1) {
				last = up;
			}
			size--;
		}
	}

	/**
	 * 返回链表数组大小
	 * 
	 * @return
	 */
	public int size() {
		return this.size;
	}

	// 私有方法供本类使用
	/**
	 * 检查索引下标
	 * 
	 * @param index
	 * @return
	 */
	private boolean checkIndex(int index) {
		if (index < 0 || index > this.size - 1) {
			throw new RuntimeException("不合法的下标:" + index);
		}
		return true;
	}

	/**
	 * 根据索引下标查询对应节点
	 * 
	 * @param index
	 * @return
	 */
	private Node getNode(int index) {
		Node node = null;
		// 如果超过限制可能有问题
		/* 优化查询 */
		if (index <= this.size >> 1) {
			node = this.first;
			for (int i = 0; i < index; i++) {
				node = node.next;
			}
		} else {
			node = this.last;
			for (int i = this.size - 1; i > index; i--) {
				node = node.previous;
			}
		}
		return node;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		Node node = this.first;
		while (node != null) {
			sb.append(node.data + ",");
			node = node.next;
		}
		sb.setCharAt(sb.length() - 1, ']');
		return sb.toString();
	}
}
