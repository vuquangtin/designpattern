package com.designpatterns.behavioral.template;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class GlassHouse extends HouseTemplate {

	@Override
	public void buildWalls() {

		System.out.println("Building Glass Walls");

	}

	@Override
	public void buildPillars() {

		System.out.println("Building Pillars with glass coating");

	}

}