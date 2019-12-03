package com.designpattern.base.main;

import org.apache.log4j.Logger;

import com.designpattern.utilities.Log4jUtils;
import com.designpatterns.creational.abstractfactory.Client;

public class Main {
	protected static Logger logger = Logger.getLogger(Client.class.getName());

	public Main() {
		init();
	}

	private void init() {
		logger = Log4jUtils.initLog4j();
	}
}
