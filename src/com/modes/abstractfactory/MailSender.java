package com.modes.abstractfactory;

public class MailSender implements Sender {

	@Override
	public void sendMessage() {
		System.out.println("this is MailSender");
	}

}
