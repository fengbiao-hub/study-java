package com.practise.java.collection.map;

/**
 * �Զ���ʵ��HashMap,����δʵ��
 * 
 * @author fengb
 * @data 2020��6��3�� ����3:46:02
 */
public class MyHashMap<K, V> {

	Node[] tables;
	int size;

	public MyHashMap() {
		this.tables = new Node[16];
	}

	// ���ⲿ���÷���
	/**
	 * ��K-V��ֵ�Դ�ŵ�Map������
	 * 
	 * @param key
	 * @param value
	 */
	public void put(K key, V value) {
		/* �����µĽڵ� */
		Node newNode = new Node();
		newNode.hash = myHash(key.hashCode(), tables.length); // hashֵ
		newNode.key = key; // key
		newNode.value = value; // value
		newNode.next = null; // ��һ���ڵ�
		Node lastNode = null;
		/* ��� */
		Node node = tables[newNode.hash];
		if (node == null) {
			tables[newNode.hash] = newNode;
			return;
		} else {
			while (node != null) {
				if (node.key.equals(key)) {
					node.value = newNode.value;
					return;
				} else {
					lastNode = node;
					node = node.next;

				}
			}
		}
		lastNode.next = newNode;
	}

	/**
	 * ����key��ȡ��Ӧvalue
	 * 
	 * @param key
	 * @return
	 */
	public V get(K key) {
		int hash = myHash(key.hashCode(), this.tables.length);
		Object value = null;
		if (this.tables[hash] != null) {
			Node node = this.tables[hash];
			while (node != null) {
				if (node.key.equals(key)) {
					value = node.value;
					break;
				} else {
					node = node.next;
				}
			}
		}
		return (V) value;
	}

	// ˽�з������ڲ�ʹ��
	/**
	 * �Զ����Hash��������hashCode��ɢ�ֲ�����Χ��
	 * 
	 * @param v
	 * @param length
	 * @return
	 */
	public int myHash(int v, int length) {
//		System.out.println(v + "��" + length + "&����:\t" + (v & length - 1));
//		System.out.println(v + "��" + length + "%����:\t" + (v % length));
		return v & length;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("{");
		for (int i = 0; i < tables.length; i++) {
			Node node = tables[i];
			while (node != null) {
				sb.append(node.key + "=" + node.value + ",");
				node = node.next;
			}
		}
		sb.setCharAt(sb.length() - 1, '}');
		return sb.toString();
	}
}
