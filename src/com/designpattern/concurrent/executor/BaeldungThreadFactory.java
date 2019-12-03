package com.designpattern.concurrent.executor;

import java.util.concurrent.ThreadFactory;

import org.apache.log4j.Logger;

import com.designpattern.base.main.Main;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class BaeldungThreadFactory extends Main implements ThreadFactory {
	private int threadId;
	private String name;
	static Logger logger = Logger.getLogger(TaskCyclicBarrier.class.getName());

	public BaeldungThreadFactory(String name) {
		super();
		threadId = 1;
		this.name = name;
	}

	@Override
	public Thread newThread(Runnable r) {
		Thread t = new Thread(r, name + "-Thread_" + threadId);
		logger.info("created new thread with id : " + threadId + " and name : "
				+ t.getName());
		threadId++;
		return t;
	}

	public static void main(String[] args) {
		BaeldungThreadFactory factory = new BaeldungThreadFactory(
				"BaeldungThreadFactory");
		for (int i = 0; i < 10; i++) {
			Thread t = factory.newThread(new Task());
			t.start();
		}
	}
}
