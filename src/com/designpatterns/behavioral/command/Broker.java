package com.designpatterns.behavioral.command;

import java.util.ArrayList;
import java.util.List;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class Broker {

	private List<Order> orderList = new ArrayList<Order>();

	public void takeOrder(Order order) {

		orderList.add(order);

	}

	public void placeOrders() {

		for (Order order : orderList) {

			order.execute();

		}

		orderList.clear();

	}

}