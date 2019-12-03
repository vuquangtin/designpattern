/*
 * Customers Java Swing Application Demo
 *
 * Copyright(c) 2013, devsniper.com
 */
package com.designpattern.utilities;

import org.apache.log4j.Logger;

/**
 * View Helpers
 *
 * @author Cem Ikta
 */
public class ViewHelpers {
	static Logger logger = Logger.getLogger(ViewHelpers.class.getName());
	/**
	 * Default icon path.
	 */
	public static final String KEYS = "/com/org/fbgrapher/resources/keys/";

	public static String getKeyPath(Object object, String name) {
		String path = object.getClass().getResource(KEYS + name).getPath();
		if (path.startsWith("file:"))
			path = path.replace("file:", "");
		return path;
	}

	

}
