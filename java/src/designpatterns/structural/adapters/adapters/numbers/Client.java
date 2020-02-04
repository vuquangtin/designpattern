package adapters.numbers;

/**
 * <h1>Adapter</h1> Chuyển interface của một lớp thành interface khác mà các
 * client mong muốn. Adapter để cho các lớp làm việc với nhau dù có thể các
 * interface không tương thích.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class Client {
	public static void main(String[] args) {
		PhoneTarget phoneTarget = new Adapter();
		String input1 = "sdflkqweqweq";
		String input2 = "123";
		String input3 = "01234342342";
		System.out.println(input1 + " is phone number: "
				+ phoneTarget.checkPhoneNumber(input1));
		System.out.println(input2 + " is phone number: "
				+ phoneTarget.checkPhoneNumber(input2));
		System.out.println(input3 + " is phone number: "
				+ phoneTarget.checkPhoneNumber(input3));
	}
}