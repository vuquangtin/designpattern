package com.designpatterns.behavioral.command;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class BuyStock implements Order {

	private Stock abcStock;

	public BuyStock(Stock abcStock) {

		this.abcStock = abcStock;

	}

	public void execute() {

		abcStock.buy();

	}

}
