package com.designpatterns.creational.factorymethod.bank;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class BankFactory {

	private BankFactory() {
	}

	public static final Bank getBank(BankType bankType) {
		switch (bankType) {

		case TPBANK:
			return new TPBank();

		case VIETCOMBANK:
			return new VietcomBank();

		default:
			throw new IllegalArgumentException("This bank type is unsupported");
		}
	}

}
