package com.designpatterns.behavioral.template;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public abstract class HouseTemplate {

	// template method, final so subclasses can't override

	public final void buildHouse() {

		buildFoundation();

		buildPillars();

		buildWalls();

		buildWindows();

		System.out.println("House is built.");

	}

	// default implementation

	private void buildWindows() {

		System.out.println("Building Glass Windows");

	}

	// methods to be implemented by subclasses

	public abstract void buildWalls();

	public abstract void buildPillars();

	private void buildFoundation() {

		System.out
				.println("Building foundation with cement,iron rods and sand");

	}

}