package facades.names;

import java.util.Scanner;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class PersonFacade {
	Name name;
	Address address;
	PhoneNumber phoneNumber;

	public PersonFacade() {
	}

	public PersonFacade(Name name, Address address, PhoneNumber phoneNumber) {
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public PhoneNumber getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(PhoneNumber phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void display() {
		this.name.display();
		this.address.display();
		this.phoneNumber.display();
		System.out.println("-------------------------------------------");
	}

	public void setInformation() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("nhap duong: ");
		String street = scanner.nextLine();
		System.out.print("nhap thanh pho: ");
		String city = scanner.nextLine();
		System.out.print("nhap quoc gia: ");
		String country = scanner.nextLine();
		System.out.print("nhap so dien thoai: ");
		String number = scanner.nextLine();
		System.out.print("nhap ma vung: ");
		String postalCode = scanner.nextLine();
		System.out.print("nhap ho: ");
		String firstName = scanner.nextLine();
		System.out.print("nhap ten dem: ");
		String middleName = scanner.nextLine();
		System.out.print("nhap ten: ");
		String lastName = scanner.nextLine();
		this.address = new Address(city, street, country);
		this.name = new Name(firstName, middleName, lastName);
		this.phoneNumber = new PhoneNumber(number, postalCode);
		scanner.close();
	}
}
