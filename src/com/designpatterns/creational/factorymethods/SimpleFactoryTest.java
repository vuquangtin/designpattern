package com.designpatterns.creational.factorymethods;

interface PaymentMethod {
	public void makePayment();
}

class CreditCard implements PaymentMethod {
	public void makePayment() {
		System.out.println("Payment through credit card...");
	}
}

class NetBanking implements PaymentMethod {
	public void makePayment() {
		System.out.println("Payment through net banking...");
	}
}

class PaymentMethodFactory {
	// static
	public PaymentMethod getPaymentMethod(String method) {
		if ("creditcard".equalsIgnoreCase(method)) {
			return new CreditCard();
		} else if ("netbanking".equalsIgnoreCase(method)) {
			return new NetBanking();
		} else {
			throw new IllegalArgumentException("Payment method not supported!");
		}
	}
}

/***
 * 
 * 
 * Simple Factory is a factory in the form of a class. Because of that it
 * doesn't solve the problem with elegance, since for every new subclass of
 * Product you will have to edit the switch statement in the create() method.
 * This is a violation of the Open/Close Principle. A potential way to make a
 * Simple Factory useful would be to use class registration as sawn here:
 * http://www.oodesign.com/factory-pattern.html
 * 
 * Factory Method is a factory in the form of a method (hence the name). This
 * doesn't violate the Open/Close Principle since you deal with change by
 * extending and not by modifying code.
 * 
 * Your understanding is correct. Client and Creator/Factory in FMP are the same
 * since the Factory (method) is part of the Client.
 * 
 * It is true that the create method in FMP is not reusable. That is ok though,
 * because this is not an attempt to create an application-wide Factory of the
 * Product, but a way for the Client to create his depended objects without
 * using new.
 * 
 * I cannot answer you third question since I believe it is based on preference.
 * 
 * Simple Factory:
 * 
 * Definition:
 * 
 * Creates objects without exposing the instantiation logic to the client.
 * Refers to the newly created object through a common interface
 * 
 * @author admin
 *
 */
public class SimpleFactoryTest {

	public static void main(String[] args) {
		PaymentMethodFactory factory = new PaymentMethodFactory();
		PaymentMethod paymentMethod = factory.getPaymentMethod("creditcard");
		paymentMethod.makePayment();
	}

}
