package com.designpatterns.creational.singleton.init;
/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */

public class EagerInitialization {
	
	private static final EagerInitialization INSTANCE = new EagerInitialization();
	
	private EagerInitialization() {
		
	}
	
	public static EagerInitialization getInstance() {
		return INSTANCE;
	}
}