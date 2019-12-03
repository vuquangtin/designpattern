package com.designpattern.utilities;

import java.util.Random;

import org.apache.log4j.Logger;

public class RandomUtils {
	static Logger logger = Logger.getLogger(RandomUtils.class.getName());

	public static int GenerateRandomNumber(int intLength) {
		int sufix = 0;
		switch (intLength) {
		case 1:
			break;
		case 2:
			sufix = 10;
			break;
		case 3:
			sufix = 100;
			break;
		case 4:
			sufix = 1000;
			break;
		case 5:
			sufix = 10000;
			break;
		case 6:
			sufix = 100000;
			break;
		case 7:
			sufix = 1000000;
			break;
		case 8:
			sufix = 10000000;
			break;
		case 9:
			sufix = 100000000;
			break;
		case 10:
			sufix = 1000000000;
			break;
		default:
			break;
		}

		int n = sufix + (int) (new Random().nextFloat() * 9 * sufix);
		return n;

	}

	/**
	 * Returns a pseudo-random number between min and max, inclusive. The
	 * difference between min and max can be at most
	 * <code>Integer.MAX_VALUE - 1</code>.
	 *
	 * @param min
	 *            Minimum value
	 * @param max
	 *            Maximum value. Must be greater than min.
	 * @return Integer between min and max, inclusive.
	 * @see java.util.Random#nextInt(int)
	 */
	public static int randInt(int min, int max) {

		// NOTE: This will (intentionally) not run as written so that folks
		// copy-pasting have to think about how to initialize their
		// Random instance. Initialization of the Random instance is outside
		// the main scope of the question, but some decent options are to have
		// a field that is initialized once and then re-used as needed or to
		// use ThreadLocalRandom (if using at least Java 1.7).

		// nextInt is normally exclusive of the top value,
		// so add 1 to make it inclusive
		int randomNum = new Random().nextInt((max - min) + 1) + min;
		return randomNum;
	}

	public static void main(String[] args) {
		if(logger.isDebugEnabled())
					logger.debug(RandomUtils.randInt(5, 8) + "");
	}

}
