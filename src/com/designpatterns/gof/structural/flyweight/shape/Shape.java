package com.designpatterns.gof.structural.flyweight.shape;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
import java.awt.Color;
import java.awt.Graphics;

public interface Shape {

	public void draw(Graphics g, int x, int y, int width, int height,
			Color color);
}