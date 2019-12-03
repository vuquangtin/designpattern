package com.designpattern.reflect;

import com.designpattern.producerconsumer.ProducerConsumerTest;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class Main {
	public static void main(String[] args) {

		ProducerConsumerTest producer = Reflects.newInstance(
				"com.designpattern.producerconsumer.ProducerConsumerTest",
				new Class<?>[] { String.class,String.class }, "producer consumer","description");
		System.out.println(producer.getName());
		System.out.println(producer.getDesc());
		producer.main(args);

	}
}
