package com.practise.java.collection.list;

/**
 * 节点
 * @author fengb
 * @data 2020年6月2日
 */
public class Node {

	// 成员变量
	/** 上一个节点 */
	Node previous;
	/** 数据 */
	Object data;
	/** 下一个节点 */
	Node next;

	// 构造方法
	public Node(Node previous, Object data, Node next) {
		super();
		this.previous = previous;
		this.data = data;
		this.next = next;
	}
}
