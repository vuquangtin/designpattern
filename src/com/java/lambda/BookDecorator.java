package com.java.lambda;
/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
abstract class BookDecorator implements Book {
	 
    protected Book book;
 
    BookDecorator(Book book) {
        this.book = book;
    }
 
    @Override
    public String describe() {
        return book.describe();
    }
}
