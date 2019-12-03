package com.designpatterns.behavioral.command;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class CommandPatternDemo {

	public static void main(String[] args) {

		Stock abcStock = new Stock();

		BuyStock buyStockOrder = new BuyStock(abcStock);

		SellStock sellStockOrder = new SellStock(abcStock);

		Broker broker = new Broker();

		broker.takeOrder(buyStockOrder);

		broker.takeOrder(sellStockOrder);

		broker.placeOrders();

	}

}