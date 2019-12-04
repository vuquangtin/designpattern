package com.designpattern.base.main;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
// DMB1.javaclass


public class DMB1 {
	public static void main(String[] args) {
		SuperClass sc = new SuperClass();
		sc.method();
		sc = new SubClass();
		sc.method();
	}
}
