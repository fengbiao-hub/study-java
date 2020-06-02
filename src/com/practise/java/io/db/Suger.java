package com.practise.java.io.db;

/**
 * װ����ģʽ֮����װ����
 * 
 * @author fengb
 * @data 2020��6��3�� ����1:28:21
 */
public class Suger extends Decorate {

	public Suger(Drink drink) {
		super(drink);
	}

	@Override
	public int price() {
		return super.price() + 5;
	}

	@Override
	public String info() {
		return super.info() + "����";
	}
}
