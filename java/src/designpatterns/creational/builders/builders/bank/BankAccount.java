package builders.bank;

/**
 * <h1>Builder</h1> Tách rời việc xây dựng (khởi tạo) của một đối tượng phức tạp
 * khỏi phần biểu diễn của nó sao cho cùng 1 tiến trình xây dựng (khởi tạo) có
 * thể tạo ra các biểu diễn khác nhau.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class BankAccount {
	private long accountNumber;
	private String owner;
	private String branch;
	private double balance;
	private double interestRate;

	public BankAccount(long accountNumber, String owner, String branch,
			double balance, double interestRate) {
		this.setAccountNumber(accountNumber);
		this.setOwner(owner);
		this.setBranch(branch);
		this.setBalance(balance);
		this.setInterestRate(interestRate);
	}

	public static class Builder {
		private long accountNumber; // This is important, so we'll pass it to
									// the constructor.
		private String owner;
		private String branch;
		private double balance;
		private double interestRate;

		public Builder(long accountNumber) {
			this.accountNumber = accountNumber;
		}

		public Builder withOwner(String owner) {
			this.owner = owner;
			return this; // By returning the builder each time, we can create a
							// fluent interface.
		}

		public Builder atBranch(String branch) {
			this.branch = branch;
			return this;
		}

		public Builder openingBalance(double balance) {
			this.balance = balance;
			return this;
		}

		public Builder atRate(double interestRate) {
			this.interestRate = interestRate;
			return this;
		}

		public BankAccount build() {
			// Here we create the actual bank account object, which is always in
			// a fully initialised state when it's returned.
			BankAccount account = new BankAccount(); // Since the builder is in
														// the BankAccount
														// class, we can invoke
														// its private
														// constructor.
			account.setAccountNumber(this.accountNumber);
			account.setOwner(this.owner);
			account.setBranch(this.branch);
			account.setBalance(this.balance);
			account.setInterestRate(this.interestRate);
			return account;
		}
	}

	// Fields omitted for brevity.
	private BankAccount() {
		// Constructor is now private.
	}

	// Getters and setters omitted for brevity.
	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
}
