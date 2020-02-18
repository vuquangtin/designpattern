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
public class BookDescriptionMainWithLambda {
	// It clearly demonstrates how different properties can be added to any
	// pre-defined class / object. Also, multiple properties can be combined. I
	// have tried to combine all the decorated book items in a list and then
	// access them by iterating over the list.

	// What we have seen till now is just the standard decorator pattern and
	// it’s been around for a long time now. In these times when functional
	// programming is the new buzzword one may ponder whether the support of
	// lambda expressions in Java, can things be done differently. Indeed, since
	// the decorated interface is like a function interface, we can rehash using
	// lambda expressions in Java. Lets see how the code looks like:
	public static void main(String[] args) {

		BasicBook book = new BasicBook();

		// Specify book as Fiction category using Lambda expression
		Book fictionBook = () -> "Fiction " + book.describe();

		// Specify that the book has a hard cover using Lambda expression
		Book hardCoverBook = () -> book.describe() + " with Hard Cover";

		// What if we want to specify both the category and cover type together
		Book hardCoverFictionBook = () -> fictionBook.describe()
				+ " with Hard Cover";

		// Specify book as Science category using Lambda expression
		Book scienceBook = () -> "Science " + book.describe();

		// What if we want to specify both the category and cover type together
		Book hardCoverScienceBook = () -> fictionBook.describe()
				+ " with Hard Cover";

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

		bookList.forEach(b -> System.out.println(b.describe()));
	}
}