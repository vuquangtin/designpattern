package com.designpatterns.others.twin.games;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class BallThread extends Thread {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(BallThread.class);

	private BallItem twin;

	private volatile boolean isSuspended;

	private volatile boolean isRunning = true;

	public void setTwin(BallItem twin) {
		this.twin = twin;
	}

	/**
	 * Run the thread
	 */
	public void run() {

		while (isRunning) {
			if (!isSuspended) {
				twin.draw();
				twin.move();
			}
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
	}

	public void suspendMe() {
		isSuspended = true;
		LOGGER.info("Begin to suspend BallThread");
	}

	public void resumeMe() {
		isSuspended = false;
		LOGGER.info("Begin to resume BallThread");
	}

	public void stopMe() {
		this.isRunning = false;
		this.isSuspended = true;
	}
}
