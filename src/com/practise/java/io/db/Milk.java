package com.practise.java.io.db;

/**
 * 装饰器模式之具体装饰类
 * 
 * @author fengb
 * @data 2020年6月3日 上午1:26:17
 */
public class Milk extends Decorate {

	public Milk(Drink drink) {
		super(drink);
	}

	@Override
	public int price() {
		return super.price() + 20;
	}

	@Override
	public String info() {
		return super.info() + "加牛奶";
	}

}
