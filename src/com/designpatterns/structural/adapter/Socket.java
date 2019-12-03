package com.designpatterns.structural.adapter;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class Socket {

	public Volt getVolt() {
		return new Volt(120);
	}
}