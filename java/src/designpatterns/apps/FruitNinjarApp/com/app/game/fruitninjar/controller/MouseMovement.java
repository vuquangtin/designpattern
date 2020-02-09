package com.app.game.fruitninjar.controller;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 * <h1>Desktop-Fruit-Ninja-App</h1>This is Desktop Fruit Ninjar App using Java
 * programming language. Used MVC architecture pattern, singleton, strategy and
 * factory design pattern. Stored user data in Amazon SimpleDB and showed user
 * information by update HTML file stored in Amazon S3
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/designpattern">https://github.com
 *      /vuquangtin/designpattern</a>
 *
 */
public class MouseMovement implements MouseMotionListener {
	private Point center;
	private Controller controller;

	public MouseMovement(Controller controller) {
		center = new Point();
		center.x = -100;
		center.y = -100;
		this.controller = controller;
	}

	public Point getCenter() {
		return center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}

	@Override
	public void mouseDragged(MouseEvent event) {

	}

	@Override
	// set position of mouse and check mouse hit fruit
	public void mouseMoved(MouseEvent event) {
		center.x = event.getX();
		center.y = event.getY();
		controller.hitFruit();
	}

}