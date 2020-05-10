package designpatterns.gof.structural.flyweight.inline;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
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

class ConcreteFlyweight implements Flyweight {

	private Character internalState = null;

	public ConcreteFlyweight(Character state) {
		this.internalState = state;
	}

	public void operation(String state) {
		System.out.println("internal state = " + internalState + ", external state = " + state);
	}

}

interface Flyweight {
	public void operation(String state);
}

class UnsharedConcreteFlyweight implements Flyweight {

	private HashMap maps = new HashMap();

	public void add(Character key, Flyweight fly) {
		maps.put(key, fly);
	}

	public void add(String key, Flyweight fly) {
		maps.put(key, fly);
	}

	public void operation(String state) {
		Flyweight fly = null;
		for (Iterator it = maps.entrySet().iterator(); it.hasNext();) {
			Map.Entry e = (Map.Entry) it.next();
			fly = (Flyweight) e.getValue();
			fly.operation(state);
		}
	}

}

class FlyweightFactory {

	private HashMap maps = new HashMap();

	public Flyweight getFlyweight(Character state) {
		if (maps.containsKey(state)) {
			return (Flyweight) maps.get(state);
		} else {
			Flyweight flyweight = new ConcreteFlyweight(state);
			maps.put(state, flyweight);
			return flyweight;
		}
	}

	public Flyweight getFlyweight(String compositeState) {
		UnsharedConcreteFlyweight compositeFly = new UnsharedConcreteFlyweight();
		int length = compositeState.length();
		Character state = null;
		for (int i = 0; i < length; i++) {
			state = new Character(compositeState.charAt(i));
			compositeFly.add(state, this.getFlyweight(state));
		}
		return compositeFly;
	}

	public Flyweight getFlyweight(List<String> keys) {
		UnsharedConcreteFlyweight unsharedConcreteFlyweight = new UnsharedConcreteFlyweight();
		for (String key : keys) {
			Flyweight flyweight = getFlyweight(key);
			unsharedConcreteFlyweight.add(key, flyweight);
		}
		return unsharedConcreteFlyweight;
	}
}

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