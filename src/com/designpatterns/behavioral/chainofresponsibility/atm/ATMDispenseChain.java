package com.designpatterns.behavioral.chainofresponsibility.atm;

import java.util.Scanner;

import com.designpattern.base.main.Main;

public class ATMDispenseChain extends Main {

	private DispenseChain c1;

	public ATMDispenseChain() {
		super();
		// initialize the chain
		this.c1 = new Dollar50Dispenser();
		DispenseChain c2 = new Dollar20Dispenser();
		DispenseChain c3 = new Dollar10Dispenser();

		// set the chain of responsibility
		c1.setNextChain(c2);
		c2.setNextChain(c3);
	}

	public static void main(String[] args) {

		ATMDispenseChain atmDispenser = new ATMDispenseChain();
		while (true) {
			int amount = 5000;
			logger.debug("Enter amount to dispense");
			Scanner input = new Scanner(System.in);
			amount = input.nextInt();
			if (amount % 10 != 0) {
				System.out.println("Amount should be in multiple of 10s.");
				input.close();
				return;
			}
			input.close();
			// process the request
			atmDispenser.c1.dispense(new Currency(amount));
		}

	}

}