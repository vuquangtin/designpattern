package web.itsenka;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Composite extends Component {
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