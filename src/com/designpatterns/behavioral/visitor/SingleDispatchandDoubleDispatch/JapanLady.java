package com.designpatterns.behavioral.visitor.SingleDispatchandDoubleDispatch;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class JapanLady implements Lady {

	public void sayAishiteImasu() {
		System.out.println("aishite imasu");
	}

	@Override
	public void sayLove() {
		sayAishiteImasu();
	}
}