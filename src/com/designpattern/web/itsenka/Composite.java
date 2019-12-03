package com.designpattern.web.itsenka;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

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