package lazyloading.virtual_proxy;

import java.util.List;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
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
