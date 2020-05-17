package uml.relationship.composition;

import uml.relationship.common.BankAccount;

/**
 * <h1>Composition</h1> mạnh hơn aggregation về sự phụ thuộc lẫn nhau, ví dụ cho
 * dễ hiểu nhé: Một công ty (Company) có nhiều phòng ban( Department). Như thế
 * khi công ty bị hủy đi thì phòng ban (Department) không còn tồn tại, hoặc Một
 * phòng học( Class-room) có nhiều bàn ghế (table), thực tế là tất cả các phòng
 * học đều có bàn ghế riêng cho từng phòng và bàn của phòng nào đều có mã số
 * phòng đi kèm với mã số bàn, như vậy nếu phòng học bị hủy thì bàn ghể của
 * phòng đó bị hủy theo (composition relationship). Tuy nhiên nếu ta đặt vấn đề
 * khác đi một tí là có một số bàn trong kho, có một lúc nào đó muốn mở một số
 * phòng học tăng cường thì trong trường hợp này số bàn trong kho đó không thuộc
 * về nhất định một phòng nào cả như thế khi phòng học tăng cường bị hủy thì bàn
 * trong kho này không bị hủy. <br/>
 * <br/>
 * Ở trên là cách thể hiện Composition, vì acc sẽ bị hủy khi Client bị hủy.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/designpattern">https://github.com
 * 
 *      /vuquangtin/designpattern</a>
 *
 */
public class Client {
	BankAccount acc = new BankAccount();

	public void addMoneyToBankAccount(long amount) {
		acc.addMoney(amount);
	}

	public long CheckBalance() {
		return acc.checkAccountBalance();
	}
}