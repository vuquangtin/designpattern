package designpatterns.lambdas.behavioral.strategies;

import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import designpatterns.lambdas.abs.AbstractTest;
import designpatterns.lambdas.behavioral.strategies.Degree.DegreeField;

/**
 * <h1>Strategy</h1> Định nghĩa tập hợp các thuật toán, đóng gói từng thuật toán
 * lại, và làm chúng hoán đổi lẫn nhau. Strategy cho phép thuật toán biến đổi
 * độc lập khi người dùng sử dụng chúng.
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com

 *      /vuquangtin/designpattern</a>
 *
 */
public class HiringStrategyTest extends AbstractTest {

	private Employer employer;
	private List<Candidate> candidates;

	@BeforeClass
	void init() {
		candidates = HiringStrategyTestDataGenerator.buildCandidates(100);
	}

	// @BeforeTest
	void before() {
		employer = new Employer();
	}

	@Test
	public void no_hiring_strategy() {
		employer.setHiringStrategy(null); /*
										 * The employer is not authorized to
										 * hire
										 */
		List<Candidate> candidates = HiringStrategyTestDataGenerator
				.buildCandidates(100);
		long hired = candidates.stream() // Find the number of hired candidates
				.filter(employer::hire) // always false, no one hired
				.count();

		assertEquals(hired, 0);
	}

	@Test
	public void no_lambda_degree_hiring_strategy() {
		DegreeField field = DegreeField.ENGINEERING;
		// expected
		long expected = candidates.stream().map(Candidate::getDegrees)
				.flatMap(Collection::stream).map(Degree::getField)
				.filter(field::equals).count();
		// actual
		employer.setHiringStrategy(new HiringStrategyOfDegree(field));
		long actual = candidates.stream().filter(employer::hire).count();

		assertEquals(actual, expected);
	}

	@Test
	public void lambda_degree_hiring_strategy() {
		DegreeField field = DegreeField.ENGINEERING;
		// expected
		long expected = candidates.stream().map(Candidate::getDegrees)
				.flatMap(Collection::stream).map(Degree::getField)
				.filter(field::equals).count();
		// actual
		employer.setHiringStrategy(c -> HiringStrategyAlgorithms.degree(c,
				field));
		long actual = candidates.stream().filter(employer::hire).count();

		assertEquals(actual, expected);
	}

	@Test
	public void no_lambda_grade_hiring_strategy() {
		final int threshold = 8;
		// expected
		long expectedHired = candidates.stream().map(Candidate::getDegrees)
				.flatMap(Collection::stream).mapToInt(Degree::getGrade)
				.filter(grade -> grade >= threshold).count();
		// actual
		employer.setHiringStrategy(new HiringStrategyOfGrade(threshold));
		long actualHired = candidates.stream().filter(employer::hire).count();

		assertEquals(actualHired, expectedHired);
	}

	@Test
	public void lambda_grade_hiring_strategy() {
		final int threshold = 8;
		// expected
		long expectedHired = candidates.stream().map(Candidate::getDegrees)
				.flatMap(Collection::stream).mapToInt(Degree::getGrade)
				.filter(grade -> grade >= threshold).count();
		// actual
		employer.setHiringStrategy(c -> HiringStrategyAlgorithms.grade(c,
				threshold));
		long actualHired = candidates.stream().filter(employer::hire).count();

		assertEquals(actualHired, expectedHired);
	}

}