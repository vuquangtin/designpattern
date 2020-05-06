package designpatterns.gof.structural.composite.inline;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>Composite</h1> Các đối tượng cấu thành các cấu trúc cây để mô tả bán toàn
 * bộ hệ thống phần cấp. Composite để cho các client tác động các đối tượng
 * riêng biệt và các thành phần của đối tượng một cách thống nhất.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/designpattern">https://github.com
 *      /vuquangtin/designpattern</a>
 *
 */
public class Main {

	public static void main(String[] args) {
		Leaf l1 = new Leaf();
		Leaf l2 = new Leaf();
		Leaf l3 = new Leaf();

		Composite composite1 = new Composite();
		Composite composite2 = new Composite();

		composite1.add(l1);
		composite2.add(l2);
		composite2.add(l3);
		composite1.add(composite2);

		composite1.operation();
	}

}

interface Component {
	void operation();
}

class Leaf implements Component {

	public void operation() {
		System.out.println("Perfoming operation on leaf");
	}

}

class Composite implements Component {

	private List<Component> children = new ArrayList<>();

	public void add(Component child) {
		children.add(child);
	}

	public void remove(Component child) {
		children.remove(child);
	}

	public void operation() {
		if (!children.isEmpty()) {
			System.out.println("Inside composite");
			for (Component child : children) {
				child.operation();
			}
		}
	}
}