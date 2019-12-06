package lazyloading.virtual_proxy;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
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