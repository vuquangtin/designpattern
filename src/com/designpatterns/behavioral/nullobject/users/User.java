package com.designpatterns.behavioral.nullobject.users;

import org.apache.commons.lang.NullArgumentException;
import org.openqa.selenium.InvalidArgumentException;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class User implements UserInterface {
	private String id;
	private String name;
	private String email;

	public User(String name, String email) {
		setName(name);
		setEmail(email);
	}

	public void setId(String id) {
		if (id != null) {
			throw new NullArgumentException("ID của người dùng rỗng!");
		}
		if (!isInt(id) || (Integer.parseInt(id)) < 1) {
			throw new InvalidArgumentException(
					"ID của người dùng sai định dạng.");
		}
		this.id = id;
	}

	private boolean isInt(String id2) {
		return false;
	}

	public String getId() {
		return id;
	}

	public void setName(String name) {
		if (name.length() < 10 || name.length() > 30) {
			throw new InvalidArgumentException(
					"Tên người dùng phải có độ dài lớn hơn 10 và nhỏ hơn 30.");
		}
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setEmail(String email) {
		if (!filterVar(email)) {
			throw new InvalidArgumentException("Sai định dạng email.");
		}
		this.email = email;
	}

	private boolean filterVar(String email2) {
		if (email2.contains("@"))
			return true;
		return false;
	}

	public String getEmail() {
		return email;
	}
}