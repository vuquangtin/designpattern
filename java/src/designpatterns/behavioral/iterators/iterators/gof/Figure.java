package iterators.gof;

/**
 * <h1>Iterator</h1> Cung cấp một cách để truy xuất các thành phần của một đối
 * tượng hợp nhất một cách tuần tự mà không cho thấy sự biểu diễn representation
 * bên dưới của nó. <br/>
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/designpattern">https://github.com
 *      /vuquangtin/designpattern</a>
 *
 */
abstract class Figure {

	protected String name = "Figure";

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}