package com.designpattern.base.main;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class Templ {
	public static void main2(String[] args) {
		int amount = 1000;
		Customer customer = new Customer();
		// thanh toán tiền
		customer.payMoney(amount);
		// thanh toán tiền
		customer.getWallet().substractMoney(amount);

	}

	public static void main(String[] args) {
		Dog dog = new Dog();
		dog.hienThiTiengKeu();

		Cat cat = new Cat();
		cat.hienThiTiengKeu();
	}
}

// Chúng ta thay đổi quá trình xử lý việc chuyển tiền về cho Customer:
class Customer {
	private Wallet wallet;

	public Wallet getWallet() {
		return this.wallet;
	}

	public int payMoney(int amount) {
		return this.wallet.substractMoney(amount);
	}

}

class Wallet {
	public int substractMoney(int ammount) {
		// ...
		return ammount;
	}
}

abstract class Temp {
	// khai báo 1 phương thức trừu tượng có tên là khaiBaoPhuongThucTruuTuong()
	// phương thức này có phạm vi truy cập là public
	// và không có đối số truyền vào
	public abstract void khaiBaoPhuongThucTruuTuong();
}

abstract class AbstractClassDemo {
	public void hienThi() {
		System.out.println("Đây là lớp trừu tượng");
	}

	// khai báo 1 phương thức abstract có tên là hienThi()
	// phương thức này không có thân phương thức
	// và có kiểu trả về là void
	public abstract void show();
}

abstract class Animal {
	protected String tiengKeu;

	public abstract void hienThiTiengKeu();
}

class Dog extends Animal {

	@Override
	public void hienThiTiengKeu() {
		tiengKeu="";
		System.out.println("Gâu");
	}

}

class Cat extends Animal {

	@Override
	public void hienThiTiengKeu() {
		System.out.println("Meo");
	}

}

class Superclass {
	public void method() {
		System.out.println("Superclass method");
	}
}

class Subclass extends Superclass {
	public void method() {
		System.out.println("Subclass method");
	}
}

class SMB {
	public static void main(String[] args) {
		Superclass sc = new Superclass();
		sc.method();
		sc = new Subclass();
		sc.method();
	}
}