package com.designpatterns.creational.af_and_singleton;
/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class DetailedStatement implements StatementType {
	@Override
	public String print() {
		System.out.println("Detailed Statement Created");
		return "detailedStmt";
	}
}
