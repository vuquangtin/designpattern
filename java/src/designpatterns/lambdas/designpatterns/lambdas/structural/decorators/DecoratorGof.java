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
public class DecoratorGof {

	interface SalaryCalculator {
		double calculate(double grossAnnual);
	}

	public static class DefaultSalaryCalculator implements SalaryCalculator {

		@Override
		public double calculate(double grossAnnual) {
			return grossAnnual / 12;
		}
	}

	public static abstract class AbstractTaxDecorator implements
			SalaryCalculator {
		private final SalaryCalculator salaryCalculator;

		public AbstractTaxDecorator(SalaryCalculator salaryCalculator) {
			this.salaryCalculator = salaryCalculator;
		}

		protected abstract double applyTax(double salary);

		@Override
		public final double calculate(double grossAnnual) {
			double salary = salaryCalculator.calculate(grossAnnual);
			return applyTax(salary);
		}
	}

	public static class GeneralTaxDecorator extends AbstractTaxDecorator {
		public GeneralTaxDecorator(SalaryCalculator salaryCalculator) {
			super(salaryCalculator);
		}

		@Override
		protected double applyTax(double salary) {
			return Taxes.generalTax(salary);
		}
	}

	public static class RegionalTaxDecorator extends AbstractTaxDecorator {
		public RegionalTaxDecorator(SalaryCalculator salaryCalculator) {
			super(salaryCalculator);
		}

		@Override
		protected double applyTax(double salary) {
			return Taxes.regionalTax(salary);
		}
	}

	public static class HealthInsuranceDecorator extends AbstractTaxDecorator {
		public HealthInsuranceDecorator(SalaryCalculator salaryCalculator) {
			super(salaryCalculator);
		}

		@Override
		protected double applyTax(double salary) {
			return Taxes.healthInsurance(salary);
		}
	}

	public static void main(String[] args) {
		System.out.println(new HealthInsuranceDecorator(
				new RegionalTaxDecorator(new GeneralTaxDecorator(
						new DefaultSalaryCalculator()))).calculate(30000.00));
	}
}