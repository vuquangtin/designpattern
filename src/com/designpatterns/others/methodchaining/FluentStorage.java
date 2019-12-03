package com.designpatterns.others.methodchaining;

import java.util.List;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public interface FluentStorage
{
	FluentStorage add(String name);
	
	List<Item> toList();
}
