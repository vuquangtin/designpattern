package com.designpatterns.creational.objectpool;

import java.util.HashSet;
import java.util.Set;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public abstract class ObjectPool<T> {

	  private Set<T> available = new HashSet<>();
	  private Set<T> inUse = new HashSet<>();

	  protected abstract T create();

	  /**
	   * Checkout object from pool
	   */
	  public synchronized T checkOut() {
	    if (available.isEmpty()) {
	      available.add(create());
	    }
	    T instance = available.iterator().next();
	    available.remove(instance);
	    inUse.add(instance);
	    return instance;
	  }

	  public synchronized void checkIn(T instance) {
	    inUse.remove(instance);
	    available.add(instance);
	  }

	  @Override
	  public String toString() {
	    return String.format("Pool available=%d inUse=%d", available.size(), inUse.size());
	  }
	}