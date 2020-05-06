package designpatterns.gof.behavioral.iterator.pattern;

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
public class ConcreteAggregate implements Aggregate {
	private String[] strings;

	public ConcreteAggregate(String[] strings) {
		this.strings = strings;
	}

	@Override
	public int size() {
		return strings.length;
	}

	@Override
	public String get(int index) {
		if (index < 0 || index >= strings.length) {
			return null;
		}
		return strings[index];
	}

	@Override
	public Iterator createIterator() {
		return new ConcreteIterator(this);
	}
}