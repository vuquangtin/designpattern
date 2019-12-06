package basic;

import org.apache.log4j.Logger;

import utilities.Log4jUtils;

public class Main {
	protected static Logger logger = Logger.getLogger(Main.class.getName());

	public Main() {
		init();
	}

	private void init() {
		logger = Log4jUtils.initLog4j();
	}
}
