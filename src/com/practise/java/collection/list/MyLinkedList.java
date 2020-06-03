package com.practise.java.collection.list;

public class MyLinkedList<E> {

	// ��Ա����
	/** ��һ���ڵ� */
	private Node first;
	/** ���һ���ڵ� */
	private Node last;
	/** ��С */
	private int size;

	// ���췽��
	public MyLinkedList() {
		super();
	}

	// �ṩ���ⲿ���õķ���
	/**
	 * ���Ԫ��
	 * 
	 * @param element
	 */
	public void add(E element) {
		Node node = new Node(null, element, null);
		if (null == this.first) { // �����ǰ����Ϊ��
			this.first = node;
			this.last = node;
		} else { // ����Ϊ�յ����
			this.last.next = node;
			node.previous = this.last;
			node.next = null;
			this.last = node;
		}
		size++; // ��С+1
	}

	/**
	 * ָ���±����Ԫ��
	 * 
	 * @param index
	 * @param element
	 */
	public void add(int index, E element) {
		Node node = new Node(null, element, null);
		Node temp = getNode(index);
		if (temp != null) {
			// ��ǰ��ͷ�ڵ��β�ڵ����ᱨ��
			Node up = temp.previous;
			node.previous = up;
			up.next = node;
			node.next = temp;
			temp.previous = node;
			size++;
		}
	}

	/**
	 * ��ȡ��Ӧ�±��Ԫ��
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
	 * �Ƴ���Ӧ�±�Ľڵ�
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
			/* ɾ����һ���ڵ� */
			if (index == 0) {
				first = down;
			}
			/* ɾ�����һ���ڵ� */
			if (index == this.size - 1) {
				last = up;
			}
			size--;
		}
	}

	/**
	 * �������������С
	 * 
	 * @return
	 */
	public int size() {
		return this.size;
	}

	// ˽�з���������ʹ��
	/**
	 * ��������±�
	 * 
	 * @param index
	 * @return
	 */
	private boolean checkIndex(int index) {
		if (index < 0 || index > this.size - 1) {
			throw new RuntimeException("���Ϸ����±�:" + index);
		}
		return true;
	}

	/**
	 * ���������±��ѯ��Ӧ�ڵ�
	 * 
	 * @param index
	 * @return
	 */
	private Node getNode(int index) {
		Node node = null;
		// ����������ƿ���������
		/* �Ż���ѯ */
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
