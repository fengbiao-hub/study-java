package com.practise.java.io.db;

/**
 * װ����ģʽ֮����װ����
 * 
 * @author fengb
 * @data 2020��6��3�� ����1:23:12
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
