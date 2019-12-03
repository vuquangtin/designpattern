package com.java.lambda;
/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class SoftCoverDecorator extends BookDecorator {
	 
    SoftCoverDecorator(Book book) {
        super(book);
    }
     
    @Override
    public String describe() {  
        return (super.describe() + " with Soft Cover");
    }
}