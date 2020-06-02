package com.practise.java.io.db;

/**
 * װ����ģʽ֮����װ����
 * 
 * @author fengb
 * @data 2020��6��3�� ����1:26:17
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
		return super.info() + "��ţ��";
	}

}
