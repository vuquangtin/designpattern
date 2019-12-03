package com.modes.abstractfactory;

import org.junit.Test;

public class TestMain {

	@Test
	public void testmain() {
		Provider provider = new MailSenderFactory();
		Sender sender = provider.produce();
		sender.sendMessage();
	}
}
