package com.designpatterns.creational.objectpool;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class Oliphaunt {

	private static int counter = 1;

	private final int id;

	/**
	 * Constructor
	 */
	public Oliphaunt() {
		id = counter++;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return String.format("Oliphaunt id=%d", id);
	}
}