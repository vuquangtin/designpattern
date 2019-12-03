package com.designpatterns.behavioral.command;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class SellStock implements Order {

	private Stock abcStock;

	public SellStock(Stock abcStock) {

		this.abcStock = abcStock;

	}

	public void execute() {

		abcStock.sell();

	}

}