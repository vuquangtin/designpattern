package com.java.lambda;
/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class FictionBookDecorator extends BookDecorator {
	 
    FictionBookDecorator(Book book) {
        super(book);
    }
 
    @Override
    public String describe() {
        return ("Fiction " + super.describe());
    }
}