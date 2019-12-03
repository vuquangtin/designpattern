package com.designpatterns.behavioral.nullobject.users;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class NullUser implements UserInterface {
	public void setId(String id) {
	}

	public String getId() {
		return "ID của NullUser";
	}

	public void setName(String name) {
	}

	public String getName() {
		return "Name của NullUser";
	}

	public void setEmail(String email) {
	}

	public String getEmail() {
		return "Email của NullUser";
	}
}