package decorators.books;

import java.util.ArrayList;
import java.util.List;

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
public class BookDescriptionMain {

	public static void main(String[] args) {

		BasicBook book = new BasicBook();

		// Specify book as Fiction category
		FictionBookDecorator fictionBook = new FictionBookDecorator(book);

		// Specify that the book has a hard cover
		HardCoverDecorator hardCoverBook = new HardCoverDecorator(book);

		// What if we want to specify both the category and cover type together
		HardCoverDecorator hardCoverFictionBook = new HardCoverDecorator(
				fictionBook);

		// Specify book as Science category
		ScienceBookDecorator scienceBook = new ScienceBookDecorator(book);

		// What if we want to specify both the category and cover type together
		HardCoverDecorator hardCoverScienceBook = new HardCoverDecorator(
				scienceBook);

		// Add all the decorated book items in a list
		List<Book> bookList = new ArrayList<Book>() {
			{
				add(book);
				add(fictionBook);
				add(hardCoverBook);
				add(hardCoverFictionBook);
				add(scienceBook);
				add(hardCoverScienceBook);
			}
		};

		// Traverse the list to access all the book items
		for (Book b : bookList) {
			System.out.println(b.describe());
		}
	}
}
