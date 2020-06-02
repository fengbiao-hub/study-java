package com.practise.java.io.db;

/**
 * 装饰器模式之具体组件
 * 
 * @author fengb
 * @data 2020年6月3日 上午1:17:23
 */
public class Coffee implements Drink {

	@Override
	public int price() {
		return 20;
	}

	@Override
	public String info() {
		return "卡布奇诺";
	}

}
