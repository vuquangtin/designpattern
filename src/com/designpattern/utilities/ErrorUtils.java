package com.designpattern.utilities;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */

public class ErrorUtils {

	private ErrorUtils() {
	}

	public static String getStackTrace(Exception e) {
		StringWriter sw = new StringWriter(1000);
		PrintWriter pw = new PrintWriter(sw);
		e.printStackTrace(pw);
		pw.close();
		return sw.toString();
	}
}