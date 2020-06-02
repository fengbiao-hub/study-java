package com.practise.java.collection.list;

/**
 * �Զ���ʵ��ArrayList
 * 
 * @author fengb
 * @data 2020��6��2��
 */
public class MyArrayList<E> {

	// ��Ա�����;�̬����
	/** ������� */
	private Object[] obj;
	/** ��ǰList��С */
	private int size;
	/** Ĭ������ */
	public static final int DEFAULT_CAPACITY = 10;

	// ���췽��
	public MyArrayList() {
		this.obj = new Object[DEFAULT_CAPACITY];
	}

	public MyArrayList(int capacity) {
		this.obj = new Object[capacity];
	}

	//����
	/**
	 * ����Ԫ��
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
