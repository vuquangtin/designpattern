package com.designpattern.concurrent.scheduling;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class EggTimer {
	private final Timer timer = new Timer();
	private final int minutes;

	public EggTimer(int minutes) {
		this.minutes = minutes;
	}

	public void start() {
		timer.schedule(new TimerTask() {
			public void run() {
				playSound();
				timer.cancel();
			}

			private void playSound() {
				System.out.println("Your egg is ready!");
				// Start a new thread to play a sound...
			}
		}, minutes * 60 * 1000);
	}

	public static void main(String[] args) {
		EggTimer eggTimer = new EggTimer(2);
		eggTimer.start();
	}

}