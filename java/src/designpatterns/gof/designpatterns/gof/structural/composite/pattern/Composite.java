package designpatterns.gof.structural.composite.pattern;

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
public class Composite extends Component {
	private List<Component> components = new ArrayList<Component>();

	protected Composite(String name) {
		super(name);
	}

	@Override
	public void operation() {
		for (Component component : components) {
			component.operation();
		}
	}

	public void add(Component component) {
		components.add(component);
	}

	public void remove(Component component) {
		components.remove(component);
	}

	public Component getChild(int index) {
		return components.get(index);
	}
}