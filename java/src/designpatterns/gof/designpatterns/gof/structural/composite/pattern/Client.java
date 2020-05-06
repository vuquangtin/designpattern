package designpatterns.gof.structural.composite.pattern;

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
public class Client {
	public static void main(String[] args) {
		Composite root = new Composite("root");

		root.add(new Leaf("leaf1"));
		root.add(new Leaf("leaf2"));
		root.add(new Leaf("leaf3"));

		root.operation();
		invoke(root);
	}

	public static void invoke(Component component) {
		if (component instanceof Composite) {
			Component child = ((Composite) component).getChild(0);
		} else if (component instanceof Leaf) {
			throw new UnsupportedOperationException("不支持该操作");
		}
	}
}