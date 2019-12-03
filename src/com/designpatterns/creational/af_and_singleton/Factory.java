package com.designpatterns.creational.af_and_singleton;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public abstract class Factory {
	protected abstract StatementType createStatements(String selection);
}