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
public class SoftCoverDecorator extends BookDecorator {
	// ScienceBookDecorator also adds the category of book in the original
	// operation. There can also be another set of Decorators which indicate
	// what type of cover the book has. We can have SoftCoverDecorator
	// describing that the book has a soft cover.
	SoftCoverDecorator(Book book) {
		super(book);
	}

	@Override
	public String describe() {
		return (super.describe() + " with Soft Cover");
	}
}