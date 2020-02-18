package decorators.books;

/**
 * <h1>Decorator</h1> Gán bổ sung các “trách nhiệm” (responsibility) cho một đối
 * tượng một cách linh hoạt. Các decorator cung cấp một sự lựa chọn linh động
 * cho lớp con để mở rộng tính năng.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class FictionBookDecorator extends BookDecorator {
	// The BookDecorator class conforms to the Book interface and also stores a
	// reference to Book interface. If we want to add category as a property to
	// Book interface, we can use a concrete class which implements
	// BookDecorator interface. For Fiction category we can have the following
	// Decorator:
	FictionBookDecorator(Book book) {
		super(book);
	}

	@Override
	public String describe() {
		return ("Fiction " + super.describe());
	}
}