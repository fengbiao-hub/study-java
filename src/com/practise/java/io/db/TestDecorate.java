package com.practise.java.io.db;

/**
 * 测试装饰器模式
 * @author fengb
 * @data 2020年6月3日 上午1:29:09
 */
public class TestDecorate {

	public static void main(String[] args) {
		Drink coffee = new Coffee();
		System.out.println(coffee.info() + "->" + coffee.price());
		Drink milk = new Milk(coffee);
		System.out.println(milk.info() + "->" + milk.price());
		Drink suger = new Suger(coffee);
		System.out.println(suger.info() + "->" + suger.price());
		Drink milkAndSuger = new Suger(milk);
		System.out.println(milkAndSuger.info() + "->" + milkAndSuger.price());
	}
}
