package iterators.gof;

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
abstract class Visitor {

	public String visit(Figure figure) {
		return figure.getName();
	}

	abstract String visit(Square figure);

	abstract String visit(Circle figure);
}