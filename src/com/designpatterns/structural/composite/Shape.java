package com.designpatterns.structural.composite;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
import java.awt.*;

public interface Shape {
	int getX();

	int getY();

	int getWidth();

	int getHeight();

	void move(int x, int y);

	boolean isInsideBounds(int x, int y);

	void select();

	void unSelect();

	boolean isSelected();

	void paint(Graphics graphics);
}