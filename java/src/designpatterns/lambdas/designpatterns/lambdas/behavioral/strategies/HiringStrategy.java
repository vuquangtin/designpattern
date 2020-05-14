package designpatterns.lambdas.behavioral.strategies;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipOutputStream;

import org.apache.commons.lang3.Validate;

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
class Candidate {

	private String name;
	private int age;
	private Gender gender;
	private List<Degree> degrees;
	// The candidate may not give a contact info
	private ContactInfo contactInfo;

	private Candidate(CandidateBuilder builder) {
		this.name = builder.name;
		this.age = builder.age;
		this.gender = builder.gender;
		this.setDegrees(builder.degrees);
		this.contactInfo = builder.contactInfo;
	}

	public List<Degree> getDegrees() {
		return degrees;
	}

	public void setDegrees(List<Degree> degrees) {
		this.degrees = degrees;
	}

	public enum Gender {
		MALE, FEMALE
	}

	public static class CandidateBuilder {

		private String name;

		private int age;

		private Gender gender;

		private List<Degree> degrees = new ArrayList<>();

		private ContactInfo contactInfo;

		public CandidateBuilder withName(String name) {
			this.name = name;
			return this;
		}

		public CandidateBuilder withAge(Integer age) {
			this.age = age;
			return this;
		}

		public CandidateBuilder withGender(Gender gender) {
			this.gender = gender;
			return this;
		}

		public CandidateBuilder withDegree(Degree degree) {
			this.degrees.add(degree);
			return this;
		}

		public CandidateBuilder withDegrees(List<Degree> degrees) {
			this.degrees.addAll(degrees);
			return this;
		}

		public CandidateBuilder withContactInfo(ContactInfo contactInfo) {
			this.contactInfo = contactInfo;
			return this;
		}

		public Candidate build() {
			Validate.notEmpty(name, "Undefined candidate name!");
			Validate.notNull(gender, "Undefined candidate gender!");
			return new Candidate(this);
		}
	}
}

class ContactInfo {

	private String contact;

	private boolean email;

	public ContactInfo(String contact, boolean email) {
		Validate.notBlank("Undefined contact!");
		this.contact = contact;
		this.email = email;
	}
}

class Degree {

	private DegreeField field;
	private int grade;
	private String holderName;

	private Degree(DegreeBuilder builder) {
		this.holderName = builder.holderName;
		this.field = builder.field;
		this.grade = builder.grade;
	}

	public enum DegreeField {
		ENGINEERING, CHEMISTRY, PHYSICS, MANAGEMENT
	}

	public static class DegreeBuilder {

		private DegreeField field;

		private int grade;

		private String holderName;

		public DegreeBuilder withField(DegreeField field) {
			this.field = field;
			return this;
		}

		public DegreeBuilder withHolderName(String holderName) {
			this.holderName = holderName;
			return this;
		}

		public DegreeBuilder withGrade(int grade) {
			this.grade = grade;
			return this;
		}

		public Degree build() {
			Validate.notNull(field, "Undefined degree field!");
			Validate.notEmpty(holderName, "Undefined degree holder's name!");
			return new Degree(this);
		}
	}

	public DegreeField getField() {
		// TODO Auto-generated method stub
		return field;
	}

	public int getGrade() {
		// TODO Auto-generated method stub
		return grade;
	}
}

class Employer {

	private HiringStrategy hiringStrategy;

	public boolean hire(Candidate candidate) {
		return (boolean) Optional.ofNullable(hiringStrategy)
				.map(hs -> hs.hire(candidate)).orElse(Boolean.FALSE);
	}

	public void setHiringStrategy(HiringStrategy hiringStrategy) {
		this.hiringStrategy = hiringStrategy;

	}
}

@FunctionalInterface
interface HiringStrategy {

	boolean hire(Candidate candidate);
}

interface HiringStrategyAlgorithms {

	static boolean degree(Candidate candidate, DegreeField field) {
		return candidate.getDegrees().stream()
				.anyMatch(d -> field == d.getField()); // 实现逻辑
	}

	static boolean grade(Candidate candidate, int threshold) {
		return candidate.getDegrees().stream()
				.anyMatch(d -> threshold <= d.getGrade()); // 实现逻辑
	}

}

class HiringStrategyOfDegree implements HiringStrategy {

	private DegreeField degreeField;

	public HiringStrategyOfDegree() {
		this(DegreeField.ENGINEERING);
	}

	public HiringStrategyOfDegree(DegreeField degreeField) {
		this.degreeField = degreeField;
	}

	@Override
	public boolean hire(Candidate candidate) {
		return candidate.getDegrees().stream()
				.anyMatch(d -> degreeField == d.getField()); // implementation
	}

}

class HiringStrategyOfGrade implements HiringStrategy {

	private int threshold;

	public HiringStrategyOfGrade() {
		this(8);
	}

	public HiringStrategyOfGrade(int threshold) {
		this.threshold = threshold;
	}

	@Override
	public boolean hire(Candidate candidate) {
		return candidate.getDegrees().stream()
				.anyMatch(d -> threshold <= d.getGrade()); // implementation
	}

}