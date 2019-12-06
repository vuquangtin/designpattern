package lambda;

import java.util.ArrayList;
import java.util.List;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class BookDescriptionMainWithLambda {

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
			private static final long serialVersionUID = 1L;

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