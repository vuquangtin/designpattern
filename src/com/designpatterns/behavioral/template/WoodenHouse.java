package com.designpatterns.behavioral.template;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class WoodenHouse extends HouseTemplate {

	@Override
	public void buildWalls() {

		System.out.println("Building Wooden Walls");

	}

	@Override
	public void buildPillars() {

		System.out.println("Building Pillars with Wood coating");

	}

}