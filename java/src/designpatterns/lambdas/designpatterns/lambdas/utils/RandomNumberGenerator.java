package designpatterns.lambdas.utils;

import java.util.Random;

public class RandomNumberGenerator {
	/**
	 * Generates a pseudo-random integer in the range [min, max]
	 * 
	 * @param min
	 *            : the starting value of the range (inclusive)
	 * @param max
	 *            : the ending value of the range (inclusive)
	 */
	public static int rand(int min, int max) {
		if (min > max || (max - min + 1 > Integer.MAX_VALUE)) {
			throw new IllegalArgumentException("Invalid range");
		}

		return new Random().nextInt(max - min + 1) + min;
	}

	public static int nextInt(int min, int max) {
		return rand(min, max);
	}

	public static void main(String[] args) {
		int min = 1, max = 10;

		for (int i = 0; i < 10; i++)
			System.out.println(rand(min, max));
	}
}