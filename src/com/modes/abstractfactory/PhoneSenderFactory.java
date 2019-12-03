package com.modes.abstractfactory;

public class PhoneSenderFactory implements Provider {

	@Override
	public Sender produce() {
		return new PhoneSender();
	}

}
