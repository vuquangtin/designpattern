package com.modes.abstractfactory;

public class PhoneSender implements Sender {

	@Override
	public void sendMessage() {
		System.out.println("this is PhoneSender!");
	}

}
