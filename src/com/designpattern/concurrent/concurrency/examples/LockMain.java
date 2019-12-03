package com.designpattern.concurrent.concurrency.examples;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */

public class LockMain {

  private Lock myLock = new ReentrantLock();

  public void updateResource() {

    try {
      // Acquire the lock
      myLock.lock();
    } finally {
      // Release the lock
      myLock.unlock();
    }
  }
}