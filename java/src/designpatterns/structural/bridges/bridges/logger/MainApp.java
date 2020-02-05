package bridges.logger;

/**
 * <h1>Bridge</h1> Tách một abstraction khỏi implementation của nó để cả hai có
 * thể thay đổi độc lập nhau.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com

 *      /vuquangtin/designpattern</a>
 *
 */
public class MainApp {
	public static void main(String[] args) {
		// chọn log kiểu show ra console
		MessageLogger messageLogger = new ConsoleLogger();
		// chọn cách thức hiển thị kiểu mã hóa
		Message message1 = new EncryptedMessage(messageLogger);
		// chọn cách thức hiển thị kiểu text rõ
		Message message2 = new TextMessage(messageLogger);
		// thực thi phương thức log
		message1.log("stackjava.com");
		message2.log("stackjava.com");
	}
}