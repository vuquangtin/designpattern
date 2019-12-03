package com.designpatterns.structural.bridge.logger;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class ConsoleLogger implements MessageLogger {
	@Override
	public void log(String msg) {
		System.out.println(msg);
	}
}