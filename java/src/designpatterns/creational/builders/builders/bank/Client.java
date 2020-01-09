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
public class Client {

	public static void main(String[] args) {
		BankAccount account = new BankAccount.Builder(1234L).withOwner("Marge")
				.atBranch("Springfield").openingBalance(100).atRate(2.5)
				.build();
		System.out.println(account.getAccountNumber());
		BankAccount anotherAccount = new BankAccount.Builder(4567L)
				.withOwner("Homer").atBranch("Springfield").openingBalance(100)
				.atRate(2.5).build();
		System.out.println(anotherAccount.getAccountNumber());

	}
}
