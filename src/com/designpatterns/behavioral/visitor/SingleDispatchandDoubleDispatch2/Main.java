package com.designpatterns.behavioral.visitor.SingleDispatchandDoubleDispatch2;
/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class Main {
	public static void main(final String[] args) {
	    Lady lady = new AmericanLady();
	    lady.accept(new SayLoveVisitor());
	}
}
