package com.designpatterns.others.lazyloading.virtualproxy;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class Company {
	String companyName;
	String companyAddress;
	String companyContactNo;
	ContactList contactList;

	public Company(String companyName, String companyAddress,
			String companyContactNo, ContactList contactList) {
		this.companyName = companyName;
		this.companyAddress = companyAddress;
		this.companyContactNo = companyContactNo;
		this.contactList = contactList;
	}

	public String getCompanyName() {
		return companyName;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public String getCompanyContactNo() {
		return companyContactNo;
	}

	public ContactList getContactList() {
		return contactList;
	}

}