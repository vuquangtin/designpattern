package com.designpatterns.structural.facade.names;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class MainApp {
	public static void main(String[] args) {
		PersonFacade person = new PersonFacade();
		person.setInformation();
		person.display();
	}
}