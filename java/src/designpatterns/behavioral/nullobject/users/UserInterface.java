package com.designpatterns.behavioral.nullobject.users;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public interface UserInterface {
	public void setId(String id);
	public String getId();
	public void setName(String name);
	public String getName();
	public void setEmail(String email);
	public String getEmail();
}
