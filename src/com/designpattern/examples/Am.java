package com.designpattern.examples;

import java.util.List;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class Am {
	List<User> listUser = null;

	public void printOut(User user) {
		System.out.println("first name: " + user.getFirstName());
		System.out.println("last name: " + user.getLastName());
		System.out.println("age: " + user.getAge());
		System.out.println("email: " + user.getEmail());
		System.out.println("address: " + user.getAddress());
		System.out.println("gender: " + user.getGender());
		System.out.println("exprience: " + user.getExperience());
		// do something: print user info
	}

	public void previewOut(User user) {
		System.out.println("first name: " + user.getFirstName());
		System.out.println("last name: " + user.getLastName());
		System.out.println("age: " + user.getAge());
		System.out.println("email: " + user.getEmail());
		System.out.println("address: " + user.getAddress());
		System.out.println("gender: " + user.getGender());
		System.out.println("exprience: " + user.getExperience());
		// do something: review user
	}

	public void showUser(User user) {
		System.out.println("first name: " + user.getFirstName());
		System.out.println("last name: " + user.getLastName());
		System.out.println("age: " + user.getAge());
		System.out.println("email: " + user.getEmail());
		System.out.println("address: " + user.getAddress());
		System.out.println("gender: " + user.getGender());
		System.out.println("exprience: " + user.getExperience());
	}

	public void print(User user) {
		showUser(user);
		// do something: print user info
	}

	public void preview(User user) {
		showUser(user);
		// do something: review user
	}

	public List<User> findByName(String name) {
		if (name == null) {
			return null;
		}
		String sql = "SELECT u FROM User u WHERE u.name like %" + name + "% ";
		// do something
		System.out.println(sql);
		return listUser;
	}

	public List<User> findByEmail(String email) {
		if (email == null) {
			return null;
		}
		String sql = "SELECT u FROM User u WHERE u.email like %" + email + "% ";
		// do something
		System.out.println(sql);
		return listUser;
	}

	public List<User> findByNameAndEmail(String name, String email) {
		if (name == null || email == null) {
			return null;
		}
		String sql = "SELECT u FROM User u WHERE u.name like %" + name
				+ "% AND u.email like %" + email + "%";
		// do something
		System.out.println(sql);
		return listUser;
	}

	public List<User> find(String name, String email) {
		if (name == null && email == null) {
			return null;
		}
		String sql = "SELECT u FROM User u WHERE u.name like %" + name
				+ "% AND u.email like %" + email + "%";
		if (name != null && email == null) {
			sql = "SELECT u FROM User u WHERE u.name like %" + name + "% ";
		}
		if (name == null && email != null) {
			sql = "SELECT u FROM User u WHERE u.email like %" + email + "% ";
		}
		System.out.println(sql);
		// do something
		return listUser;
	}

	public int addTwoNumber(int a, int b) {
		return a + b;
	}

	// method 1
	public static boolean isEven(int input) {
		return (input & 1) == 0;
	}

	// method 2
	public static boolean isEven2(int input) {
		return (input % 2) == 0;
	}
}
