package iterators.gof3;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>Iterator</h1> Cung cấp một cách để truy xuất các thành phần của một đối
 * tượng tập hợp một cách tuần tự mà không cho thấy sự biểu diễn representation
 * bên dưới của nó. <br/>
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/designpattern">https://github.com
 *      /vuquangtin/designpattern</a>
 *
 */
public class GOF {
	public static void main(String[] args) {
		ConcreteAggregate a = new ConcreteAggregate();
		a.addItem(new Item("A"));
		a.addItem(new Item("B"));
		a.addItem(new Item("C"));
		a.addItem(new Item("D"));
		Iterator it = a.iterator();
		while (it.hasNext()) {
			Item item = (Item) it.next();
			System.out.println(item.getName());
		}
	}
}

interface Iterator {
	public abstract boolean hasNext();

	public abstract Object next();
}

class ConcreteIterator implements Iterator {
	private ConcreteAggregate concreteAggregate;
	private int index = 0;

	public ConcreteIterator(ConcreteAggregate concreteAggregate) {
		this.concreteAggregate = concreteAggregate;
	}

	public boolean hasNext() {
		if (index < concreteAggregate.getSize()) {
			return true;
		} else {
			return false;
		}
	}

	public Object next() {
		return concreteAggregate.getItemAt(index++);
	}
}

interface Aggregate {
	public abstract Iterator iterator();
}

class ConcreteAggregate implements Aggregate {
	private List<Item> items = new ArrayList<Item>();

	public void addItem(Item item) {
		items.add(item);
	}

	public int getSize() {
		return items.size();
	}

	public Item getItemAt(int index) {
		return (Item) items.get(index);
	}

	public Iterator iterator() {
		return new ConcreteIterator(this);
	}
}

class Item {
	private String name;

	public Item(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
}