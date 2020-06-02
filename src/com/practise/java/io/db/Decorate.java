package com.practise.java.io.db;

/**
 * 装饰器模式之抽象装饰类
 * 
 * @author fengb
 * @data 2020年6月3日 上午1:23:12
 */
public abstract class Decorate implements Drink {

	private Drink drink;

	public Decorate(Drink drink) {
		this.drink = drink;
	}

	@Override
	public int price() {
		return drink.price();
	}

	@Override
	public String info() {
		return drink.info();
	}

}
