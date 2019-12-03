package com.designpattern.utilities;

import java.util.UUID;

public class TextUtils {
	public static String removeEnter(String input) {
		return input.replace("\n", " ").replace("\r", " ");
	}

	public static String removeTab(String input) {
		return input.replace("\t", "	");
	}

	// public static boolean checkNameIsContainsAnphabet
	public boolean isAlpha(String name) {
		char[] chars = name.toCharArray();
		for (char c : chars) {
			if (!Character.isLetter(c)) {
				return false;
			}
		}
		return true;
	}

	public static String getUUID() {
		return UUID.randomUUID().toString();
	}

}
