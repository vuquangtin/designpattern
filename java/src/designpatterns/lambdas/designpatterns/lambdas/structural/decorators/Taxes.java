package designpatterns.lambdas.structural.decorators;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

import org.junit.Test;

import designpatterns.lambdas.abs.AbstractTest;
import designpatterns.lambdas.structural.decorators.WebFilterOfSocialNetworks;

import static org.junit.Assert.assertEquals;

/**
 * <h1>Decorator</h1> Gán bổ sung các “trách nhiệm” (responsibility) cho một đối
 * tượng một cách linh hoạt. Các decorator cung cấp một sự lựa chọn linh động
 * cho lớp con để mở rộng tính năng.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com

 *      /vuquangtin/designpattern</a>
 *
 */
public class Taxes {
	public static double generalTax(double salary) {
		return salary * 0.8;
	}

	public static double regionalTax(double salary) {
		return salary * 0.95;
	}

	public static double healthInsurance(double salary) {
		return salary - 200.0;
	}
}