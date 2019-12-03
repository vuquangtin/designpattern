package com.designpatterns.others.methodchaining;

import java.util.ArrayList;
import java.util.List;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class Storage {
	private List<Item> items;

	public Storage() {
		this.items = new ArrayList<Item>();
	}

	public Storage put(String name) {
		items.clear();
		return and(name);
	}

	public Storage and(String name) {
		items.add(new Item(name.hashCode(), name));
		return this;
	}

	public Item get(int index) {
		return items.get(index);
	}

	public List<Item> getAll() {
		return items;
	}
}
