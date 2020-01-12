package prototypes.gof;

import java.util.HashMap;
import java.util.Map;
/**
 * <h1>Prototype</h1> Xác định các kiểu của các object (đối tượng) muốn tạo ra
 * bằng cách sử dụng một prototype (khuôn mẫu,nguyên mẫu), và tạo ra những
 * object (đối tượng) mới bằng cách sao chép prototype này.
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/designpattern">https://github.com
 *      /vuquangtin/designpattern</a>
 *
 */
class Client {
	private Map<String, Prototype> hashmap = new HashMap<String, Prototype>();

	public void regist(String key, Prototype prototype) {
		hashmap.put(key, prototype);
	}

	public Prototype create(String key) {
		Prototype prototype = hashmap.get(key);
		return prototype.createClone();
	}
}

/**
 * cloneメソッドを使用したい場合は、そのスーパークラス・インタフェースのどこかでCloneableインタフェースを実装していないといけません。 ※
 * Cloneableインタフェースには抽象メソッドが1つも定義されていません。単にそのクラスが、cloneできるか否かのマーク付けをしているだけです。
 */
abstract class Prototype implements Cloneable {
	public abstract Prototype createClone();
}

class ConcretePrototype extends Prototype {
	private int id;

	public ConcretePrototype(int id) {
		this.id = id;
	}

	public Prototype createClone() {
		ConcretePrototype concretePrototype = null;
		try {
			concretePrototype = (ConcretePrototype) this.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return concretePrototype;
	}

	public int getId() {
		return id;
	}
}

/**
 * Design Patterns
 * @see http://www.itsenka.com/contents/development/designpattern/prototype.html
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class GOF {
	// /public class PrototypeUser {
	public static void main(String[] args) {
		Client client = new Client();
		ConcretePrototype cp1 = new ConcretePrototype(0);
		ConcretePrototype cp2 = new ConcretePrototype(1);
		ConcretePrototype cp3 = new ConcretePrototype(2);
		client.regist("0", cp1);
		client.regist("1", cp2);
		client.regist("2", cp3);
		Prototype prototype1 = client.create("0");
		Prototype prototype2 = client.create("1");
		Prototype prototype3 = client.create("2");
		System.out.println(((ConcretePrototype) prototype1).getId());
		System.out.println(((ConcretePrototype) prototype2).getId());
		System.out.println(((ConcretePrototype) prototype3).getId());
	}
}
