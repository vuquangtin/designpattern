package com.designpatterns.others.lazyloading.virtualproxy;

import java.util.List;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class LazyLoading {
	public static void main(String[] args) {
		ContactList contactList = new ContactListProxyImpl();
		Company company = new Company("Geeksforgeeks", "India",
				"+91-011-28458965", contactList);

		System.out.println("Company Name: " + company.getCompanyName());
		System.out.println("Company Address: " + company.getCompanyAddress());
		System.out.println("Company Contact No.: "
				+ company.getCompanyContactNo());
		System.out.println("Requesting for contact list");

		contactList = company.getContactList();
		List<Employee> empList = contactList.getEmployeeList();
		for (Employee emp : empList) {
			System.out.println(emp);
		}
	}
}