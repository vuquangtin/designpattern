package com.designpatterns.creational.af_and_singleton;
/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class MiniStatement implements StatementType {
	@Override
	public String print() {
		System.out.println("Mini Statement Created");
		return "miniStmt";
	}
}