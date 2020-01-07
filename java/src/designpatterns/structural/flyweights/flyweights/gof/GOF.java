package flyweights.gof;

import java.util.HashMap;
import java.util.Map;

/**
 * <h1>Flyweight</h1> Sử dụng việc chia sẻ để hỗ trợ số lượng lớn các đối tượng
 * fine-graied cỡ nhỏ 1 cách hiệu quả
 * 
 * @see http://www.itsenka.com/contents/development/designpattern/flyweight.html
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class GOF {
	public static void main(String[] args) {
		FlyweightFactory factory = FlyweightFactory.getInstance();
		int[] number = new int[] { 0, 1, 2, 1, 3, 4, 2, 2, 3 };
		for (int i = 0; i < number.length; i++) {
			Flyweight flyweight = factory.getFlyweight(number[i]);
			flyweight.flyweightMethod2();
		}
	}
}

class Flyweight {
	private int id;
	private int counter;

	public Flyweight(int id) {
		this.id = id;
		System.out.println("Flyweightオブジェクト生成:id=[" + id + "]");
	}

	private int flyweightMethod1() {
		return ++counter;
	}

	public void flyweightMethod2() {
		System.out.println("Flyweight-fM2():id=[" + id + "]/counter=["
				+ flyweightMethod1() + "]");
	}
}

class FlyweightFactory {
	private static FlyweightFactory singleton = new FlyweightFactory();
	private Map<Integer, Flyweight> pool = new HashMap<Integer, Flyweight>();

	private FlyweightFactory() {
	}

	public static FlyweightFactory getInstance() {
		return singleton;
	}

	/**
	 * マルチスレッドを考慮し、「Synchronized」修飾子を付け、同期化させます。
	 * 同期化させておかないと、無駄なオブジェクトを生成してしまう可能性があるためです。
	 */
	public synchronized Flyweight getFlyweight(int id) {
		Flyweight flyweight = (Flyweight) pool.get(id);
		if (flyweight == null) {
			flyweight = new Flyweight(id);
			pool.put(id, flyweight);
		}
		return flyweight;
	}
}