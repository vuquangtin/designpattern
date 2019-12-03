package com.designpatterns.others.interceptingfilter;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class Target {
	public void execute(String request) {
		System.out.println("Executing request: " + request);
	}
}