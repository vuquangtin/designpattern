package com.designpatterns.behavioral.nullobject.users;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class CreateUserMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static UserInterface createUser(String id, String name, String email) {
		if (id == null && name == null && email == null) {
			return new NullUser();
		}
		UserInterface user = new User(name, email);
		user.setId(id);
		if (id != null) {
		    System.out.println(name + " " +email);
		}
		return user;
	}
}
