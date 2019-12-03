package com.designpatterns.others.filter;

import java.util.List;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public interface Criteria {
	public List<Person> meetCriteria(List<Person> persons);
}
