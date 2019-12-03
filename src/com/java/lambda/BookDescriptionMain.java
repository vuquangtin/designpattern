package com.java.lambda;

import java.util.ArrayList;
import java.util.List;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
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

		// Traverse the list to access all the book items
		for (Book b : bookList) {
			System.out.println(b.describe());
		}
	}
}