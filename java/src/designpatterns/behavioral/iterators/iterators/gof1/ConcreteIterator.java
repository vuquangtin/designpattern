package iterators.gof1;

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
class ConcreteIterator extends Iterator {

	private String word;
	private int count = 0;

	public ConcreteIterator(String word) {
		this.word = word;
	}

	public String current() {
		return String.valueOf(word.charAt(count));
	}

	public boolean hasNext() {
		return (count + 1 < word.length());
	}

	public String first() {
		return String.valueOf(word.charAt(0));
	}

	public String last() {
		return String.valueOf(word.charAt(word.length() - 1));
	}

	public String next() {
		count++;

		return current();
	}
}