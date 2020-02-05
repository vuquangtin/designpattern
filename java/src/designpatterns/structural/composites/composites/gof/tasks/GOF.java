package composites.gof.tasks;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * <h1>Composite</h1> Các đối tượng cấu thành các cấu trúc cây để mô tả bán toàn
 * bộ hệ thống phần cấp. Composite để cho các client tác động các đối tượng
 * riêng biệt và các thành phần của đối tượng một cách thống nhất.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
class Leaf extends Component {
	private String name;
	private int value;

	public Leaf(String name, int value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	protected int sumValue() {
		System.out.println(" + " + value);
		return value;
	}

	protected void printTree(String path) {
		System.out.println(path + "-" + name);
	}
}

class Composite extends Component {
	private String name;
	private List<Component> components = new ArrayList<Component>();

	public Composite(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	protected void printTree(String path) {
		System.out.println(path + "-" + name);
		Iterator<Component> it = components.iterator();
		while (it.hasNext()) {
			it.next().printTree(path + "-" + name);
		}
	}

	protected int sumValue() {
		int sum = 0;
		Iterator<Component> it = components.iterator();
		while (it.hasNext()) {
			sum += it.next().sumValue();
		}
		return sum;
	}

	public void add(Component component) throws ComponentAddException {
		components.add(component);
	}
}

abstract class Component {
	public abstract String getName();

	protected abstract int sumValue();

	public void add(Component component) throws ComponentAddException {
		/**
		 * この「add」メソッドはサブクラスで実装されない(「Leaf」)可能性があるため、
		 * デフォルトの処理としては、例外を発生させるようにしておきます。
		 */
		throw new ComponentAddException();
	}

	protected abstract void printTree(String path);
}

class ComponentAddException extends Exception {
	public ComponentAddException() {
	}

	public ComponentAddException(String msg) {
		super(msg);
	}
}

/**
 * <h1>Composite</h1> Các đối tượng cấu thành các cấu trúc cây để mô tả bán toàn
 * bộ hệ thống phần cấp. Composite để cho các client tác động các đối tượng
 * riêng biệt và các thành phần của đối tượng một cách thống nhất.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public  class GOF {
	public static void main(String[] args) {
		Composite comp1 = new Composite("A");
		Composite comp11 = new Composite("AB");
		Composite comp12 = new Composite("AC");
		Composite comp13 = new Composite("AD");
		Composite comp111 = new Composite("ABE");
		Composite comp112 = new Composite("ABF");
		try {
			comp1.add(comp11);
			comp1.add(comp12);
			comp1.add(comp13);
			comp11.add(comp111);
			comp11.add(comp112);
			comp11.add(new Leaf("a", 1));
			comp11.add(new Leaf("b", 2));
			comp11.add(new Leaf("c", 3));
			comp13.add(new Leaf("d", 4));
			comp112.add(new Leaf("e", 5));
			int sum = comp1.sumValue();
			System.out.println("----");
			System.out.println("  " + sum);
			System.out.println("");
			comp1.printTree("");
		} catch (ComponentAddException e) {
			e.printStackTrace();
		}
	}
}
