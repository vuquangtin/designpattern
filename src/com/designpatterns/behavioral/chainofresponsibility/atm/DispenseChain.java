package com.designpatterns.behavioral.chainofresponsibility.atm;

public interface DispenseChain {
	void setNextChain(DispenseChain nextChain);

	void dispense(Currency cur);
}