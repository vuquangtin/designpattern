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
public class ScienceBookDecorator extends BookDecorator {
	// You can see that FictionBookDecorator adds the category of book in the
	// original operation, i.e. describe. Similarly, if we want to specify
	// Science category we can have the corresponding ScienceBookDecorator:
	ScienceBookDecorator(Book book) {
		super(book);
	}

	@Override
	public String describe() {
		return ("Science " + super.describe());
	}
}