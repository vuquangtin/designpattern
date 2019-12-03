package com.designpattern.concurrent.concurrency.cookbook;
/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class Result {
	
	/**
	 * Name of the Thread that finish
	 */
	private String name;
	
	/**
	 * Read the name of the Thread
	 * @return The name of the Thread
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Write the name of the Thread
	 * @param name The name of the Thread
	 */
	public void setName(String name) {
		this.name = name;
	}

}