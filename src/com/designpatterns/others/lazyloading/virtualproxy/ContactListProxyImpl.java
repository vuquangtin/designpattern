package com.designpatterns.others.lazyloading.virtualproxy;

import java.util.List;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class ContactListProxyImpl implements ContactList {
	private ContactList contactList;

	public List<Employee> getEmployeeList() {
		if (contactList == null) {
			System.out.println("Fetching list of employees");
			contactList = new ContactListImpl();
		}
		return contactList.getEmployeeList();
	}
}
