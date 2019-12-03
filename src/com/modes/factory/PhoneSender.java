package com.modes.factory;

public class PhoneSender implements Sender {

	@Override
	public void sendMessage() {
		System.out.println("this is PhoneSender!");
	}

}
