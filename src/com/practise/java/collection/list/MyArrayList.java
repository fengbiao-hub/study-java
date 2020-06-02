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
		if (checkCapacity(capacity)) {
			this.objs = new Object[capacity];
		} else {
			this.objs = new Object[DEFAULT_CAPACITY];
		}
	}

	// �ṩ�ⲿ���÷���
	/**
	 * ����Ԫ��
	 * 
	 * @param element
	 * @return
	 */
	public boolean add(E element) {
		if (size == this.objs.length) {
			expand(); // ����
		}
		this.objs[size++] = element;
		return true;
	}

	/**
	 * �����±��ȡԪ��
	 * 
	 * @param index
	 * @return
	 */
	public E get(int index) {
		checkIndex(index); // �������
		return (E) this.objs[index];
	}

	/**
	 * ���ö�Ӧ�±�Ԫ��
	 * 
	 * @param index
	 * @param element
	 */
	public void set(int index, E element) {
		checkIndex(index);
		this.objs[index] = element;
	}

	/**
	 * �Ƴ���ӦԪ��
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
	 * �Ƴ���Ӧ�±�Ԫ��
	 * 
	 * @param index
	 * @return
	 */
	public E remove(int index) {
		checkIndex(index); // ����±�Ϸ���
		E element = get(index);
		int moveCount = this.size - 1 - index;
		if (moveCount > 0) {
			System.arraycopy(objs, index + 1, objs, index, moveCount); // �������鿽��ʵ�������ƶ�
		}
		this.objs[size - 1] = null;
		size--;
		return element;
	}

	/**
	 * ���ؼ��ϵĴ�С
	 * 
	 * @return
	 */
	public int size() {
		return this.size;
	}

	// �ڲ�����
	/**
	 * ��������Ϸ���
	 * 
	 * @return
	 */
	private boolean checkCapacity(int capacity) {
		if (capacity < 0) {
			throw new RuntimeException("�������Ϸ�:" + capacity);
		}
		if (capacity == 0) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * ��������Ϸ���
	 * 
	 * @param index
	 * @return
	 */
	private boolean checkIndex(int index) {
		if (index < 0 || index > size - 1) {
			throw new RuntimeException("���Ϸ�������:" + index);
		} else {
			return true;
		}
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
