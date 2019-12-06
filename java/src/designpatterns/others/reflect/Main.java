package reflect;

import producerconsumer.ProducerConsumerTest;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
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
