package uml.relationship.aggregation;

import uml.relationship.common.BankAccount;

/**
 * <h1>Aggregation</h1>là quan hệ giữa toàn thể và bộ phận, trong đó một lớp
 * biểu diễn cái lớn hơn(tổng thể) còn lớp kia biểu diễn cái nhỏ hơn(bộ phận).
 * Aggregation biểu diễn quan hệ has-a, có nghĩa rằng một đối tượng của lớp tổng
 * thể có nhiều đối tượng của lớp thành phần. Ví dụ: Một môn học được mở (cái
 * này trong học tín chỉ) có nhiều sinh viên theo học, môn học được mở là class
 * tổng thể, còn sinh viên là class thành phần. Nếu không có môn học được mở thì
 * sinh viên vẫn tồn tại, hoặc khi hủy môn học được mở đi thì sinh viên vẫn
 * không bị hủy.<br/>
 * <br/>
 * ở dưới là cách thể hiện Aggregation, acc ko bị hủy khi Client bị hủy mà có
 * thể tồn tại độc lập:
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/designpattern">https://github.com
 * 
 *      /vuquangtin/designpattern</a>
 *
 */
public class Client {
	BankAccount acc;

	public Client(BankAccount p_acc) {
		acc = p_acc;
	}

	public void addMoneyToBankAccount(long amount) {
		acc.addMoney(amount);
	}

	public long CheckBalance() {
		return acc.checkAccountBalance();
	}
}