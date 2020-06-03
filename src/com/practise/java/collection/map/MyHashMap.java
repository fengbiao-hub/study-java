package com.practise.java.collection.map;

/**
 * 自定义实现HashMap,扩容未实现
 * 
 * @author fengb
 * @data 2020年6月3日 下午3:46:02
 */
public class MyHashMap<K, V> {

	Node[] tables;
	int size;

	public MyHashMap() {
		this.tables = new Node[16];
	}

	// 供外部调用方法
	/**
	 * 将K-V键值对存放到Map集合中
	 * 
	 * @param key
	 * @param value
	 */
	public void put(K key, V value) {
		/* 构建新的节点 */
		Node newNode = new Node();
		newNode.hash = myHash(key.hashCode(), tables.length); // hash值
		newNode.key = key; // key
		newNode.value = value; // value
		newNode.next = null; // 下一个节点
		Node lastNode = null;
		/* 添加 */
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
	 * 根据key获取对应value
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

	// 私有方法供内部使用
	/**
	 * 自定义的Hash方法，将hashCode离散分布到范围内
	 * 
	 * @param v
	 * @param length
	 * @return
	 */
	public int myHash(int v, int length) {
//		System.out.println(v + "与" + length + "&运算:\t" + (v & length - 1));
//		System.out.println(v + "与" + length + "%运算:\t" + (v % length));
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
