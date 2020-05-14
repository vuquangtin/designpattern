package designpatterns.lambdas.structural.decorators;

import java.util.function.DoubleUnaryOperator;
import java.util.stream.Stream;

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
public class DecoratorLambda {

	public static class DefaultSalaryCalculator implements DoubleUnaryOperator {
		@Override
		public double applyAsDouble(double grossAnnual) {
			return grossAnnual / 12;
		}
	}

	public static void main(String[] args) {
		new DefaultSalaryCalculator().andThen(Taxes::generalTax)
				.andThen(Taxes::regionalTax).andThen(Taxes::healthInsurance)
				.applyAsDouble(80000.00);

		System.out.println(calculateSalary(80000.00,
				new DefaultSalaryCalculator(), Taxes::generalTax,
				Taxes::regionalTax, Taxes::healthInsurance));
	}

	public static double calculateSalary(double annualGross,
			DoubleUnaryOperator... taxes) {
		return Stream
				.of(taxes)
				.reduce(DoubleUnaryOperator.identity(),
						DoubleUnaryOperator::andThen)
				.applyAsDouble(annualGross);
	}
}