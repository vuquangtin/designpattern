package com.designpatterns.others.twin.games;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class App {

	/**
	 * Program entry point
	 * 
	 * @param args
	 *            command line args
	 */
	public static void main(String[] args) throws Exception {

		BallItem ballItem = new BallItem();
		BallThread ballThread = new BallThread();

		ballItem.setTwin(ballThread);
		ballThread.setTwin(ballItem);

		ballThread.start();

		waiting();

		ballItem.click();

		waiting();

		ballItem.click();

		waiting();

		// exit
		ballThread.stopMe();
	}

	private static void waiting() throws Exception {
		Thread.sleep(750);
	}
}