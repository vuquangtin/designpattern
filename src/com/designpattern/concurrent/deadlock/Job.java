package com.designpattern.concurrent.deadlock;

import java.util.List;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class Job {
	private boolean running = false;
	private final String filename;

	public Job(String filename) {
		this.filename = filename;
	}

	public synchronized void start() {
		
		if(running) {
			throw new IllegalStateException("..."+filename);
		}
		//...
	}

	public synchronized List<String> getResults() {
		if(!running) {
			throw new IllegalStateException("...");
		}
		//...
		return null;
	}
}