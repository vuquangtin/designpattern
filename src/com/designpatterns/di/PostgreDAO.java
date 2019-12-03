package com.designpatterns.di;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class PostgreDAO implements AbstractDAO {
	@Override
	public void insert() {
		System.out.println("Postgre insert");
	}

	@Override
	public void delete() {
		System.out.println("Postgre delete");
	}

	@Override
	public void update() {
		System.out.println("Postgre update");
	}
}