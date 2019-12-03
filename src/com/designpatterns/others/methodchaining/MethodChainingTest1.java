package com.designpatterns.others.methodchaining;

import java.util.List;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public final class MethodChainingTest1 {
	public static void main(String[] args) {
		FluentStorage fluentStorage = new FluentListStorage().add("A").add("B")
				.add("C").add("D");
				//.add(null).add("D");

		List<Item> items = fluentStorage.toList();
		for (Item item : items) {
			System.out.println(item);
		}
		int howMany = items.size();
		System.out.println("There "
				+ (1 < howMany ? "are " + howMany + " items" : "is " + howMany
						+ " item") + " in the storage.");
		System.exit(0);
	}

}
