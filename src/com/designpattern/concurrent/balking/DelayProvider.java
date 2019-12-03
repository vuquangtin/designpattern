package com.designpattern.concurrent.balking;

import java.util.concurrent.TimeUnit;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public interface DelayProvider {
	void executeAfterDelay(long interval, TimeUnit timeUnit, Runnable task);
}