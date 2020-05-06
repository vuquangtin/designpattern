package designpatterns.gof.structural.flyweight.pattern;

import java.util.ArrayList;
import java.util.List;

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
public class UnsharedConcreteFlyweight implements Flyweight {
	private List<Flyweight> flyweights = new ArrayList<Flyweight>();

	@Override
	public void operation(String extrinsicState) {
		for (Flyweight flyweight : flyweights) {
			flyweight.operation(extrinsicState);
		}
	}

	public void addFlyweight(Flyweight flyweight) {
		flyweights.add(flyweight);
	}
}