package com.practise.java.collection.list;

/**
 * �ڵ�
 * @author fengb
 * @data 2020��6��2��
 */
public class Node {

	// ��Ա����
	/** ��һ���ڵ� */
	Node previous;
	/** ���� */
	Object data;
	/** ��һ���ڵ� */
	Node next;

	// ���췽��
	public Node(Node previous, Object data, Node next) {
		super();
		this.previous = previous;
		this.data = data;
		this.next = next;
	}
}
