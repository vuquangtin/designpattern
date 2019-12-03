package com.designpatterns.creational.af_and_singleton;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class StatementFactory extends Factory {
	private static StatementFactory uniqueInstance;

	private StatementFactory() {
	}

	public static StatementFactory getUniqueInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new StatementFactory();
			System.out.println("Creating a new StatementFactory instance");
		}
		return uniqueInstance;

	}

	public StatementType createStatements(String selection) {
		if (selection.equalsIgnoreCase("detailedStmt")) {
			return new DetailedStatement();
		} else if (selection.equalsIgnoreCase("miniStmt")) {
			return new MiniStatement();
		}
		throw new IllegalArgumentException("Selection doesnot exist");
	}
}