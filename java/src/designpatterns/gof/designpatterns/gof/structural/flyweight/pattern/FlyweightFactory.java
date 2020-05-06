package designpatterns.gof.structural.flyweight.pattern;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class FlyweightFactory {
	private Map<String, Flyweight> flyweights = new HashMap<String, Flyweight>();

	public Flyweight getFlyweight(String key) {
		if (flyweights.containsKey(key)) {
			return flyweights.get(key);
		}

		Flyweight flyweight = new ConcreteFlyweight();
		flyweights.put(key, flyweight);
		return flyweight;
	}

	public Flyweight getFlyweight(List<String> keys) {
		UnsharedConcreteFlyweight unsharedConcreteFlyweight = new UnsharedConcreteFlyweight();
		for (String key : keys) {
			Flyweight flyweight = getFlyweight(key);
			unsharedConcreteFlyweight.addFlyweight(flyweight);
		}
		return unsharedConcreteFlyweight;
	}
}
