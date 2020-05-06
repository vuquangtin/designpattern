package designpatterns.gof.structural.flyweight.pattern;

import java.util.Arrays;

/**
 * <h1>Flyweight</h1> Sử dụng việc chia sẻ để hỗ trợ số lượng lớn các đối tượng
 * fine-graied cỡ nhỏ 1 cách hiệu quả
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/designpattern">https://github.com
 * 
 *      /vuquangtin/designpattern</a>
 *
 */
public class Client {
	public static void main(String[] args) {
		FlyweightFactory factory = new FlyweightFactory();
		Flyweight flyweight1 = factory.getFlyweight("share1");
		Flyweight flyweight2 = factory.getFlyweight("share1");
		System.out.println(flyweight1 == flyweight2);

		Flyweight flyweight3 = factory.getFlyweight("share2");
		flyweight1.operation("extrinsic state 1");
		flyweight2.operation("extrinsic state 2");
		flyweight3.operation("extrinsic state 3");

		System.out.println("unshared flyweight:");
		Flyweight flyweight4 = factory.getFlyweight(Arrays.asList("share1", "share2"));
		flyweight4.operation("extrinsic state 4");

	}
}