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
//Next, lets define the abstract class BookDecorator which will act as the Decorator:
public abstract class BookDecorator implements Book {
	 
    protected Book book;
 
    BookDecorator(Book book) {
        this.book = book;
    }
 
    @Override
    public String describe() {
        return book.describe();
    }
}