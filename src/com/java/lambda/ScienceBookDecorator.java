package com.java.lambda;
/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class ScienceBookDecorator extends BookDecorator {
	 
    ScienceBookDecorator(Book book) {
        super(book);
    }
 
    @Override
    public String describe() {
        return ("Science " + super.describe());
    }
}
