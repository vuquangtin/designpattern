package com.modes.abstractfactory;

public class MailSenderFactory implements Provider {

	@Override
	public Sender produce() {
		
		return new MailSender();
	}

}
