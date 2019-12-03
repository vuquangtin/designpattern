package com.designpatterns.others.twin;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class BallThread extends Thread {
	BallItem twin;

	public void run() {
		while (true) {
			twin.draw(); /* erase */
			twin.move();
			twin.draw();
		}
	}
}
