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
public class Adapter implements PhoneTarget {
	CheckNumberAdaptee checkNumberAdapptee = new CheckNumberAdaptee();

	@Override
	public boolean checkPhoneNumber(String input) {
		if (!checkNumberAdapptee.checkNumber(input)) {
			return false;
		}
		if (input.length() > 11 || input.length() < 10) {
			return false;
		}
		return true;
	}
}