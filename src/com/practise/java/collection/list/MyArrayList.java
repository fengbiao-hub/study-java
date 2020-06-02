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
	private Object[] objs;
	/** ��ǰList��С */
	private int size;
	/** Ĭ������ */
	public static final int DEFAULT_CAPACITY = 10;

	// ���췽��
	public MyArrayList() {
		this.objs = new Object[DEFAULT_CAPACITY];
	}

	public MyArrayList(int capacity) {
		this.objs = new Object[capacity];
	}

	//����
	/**
	 * ����Ԫ��
	 * @param element
	 * @return
	 */
	public boolean add(E element) {
		if(size == this.objs.length) {
			expand(); // ����
		}
		this.objs[size++] = element;
		return true;
	}
	
	/**
	 * ��������
	 */
	private void expand() {
		Object[] newObjs = new Object[this.objs.length + (this.objs.length >> 1)];
		System.out.println("���ݺ�����" + newObjs.length);
		System.arraycopy(this.objs, 0, newObjs, 0, this.objs.length); // ��������
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
