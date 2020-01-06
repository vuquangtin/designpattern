package templatemethods.refactoring;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <h1>Template Method</h1> Định nghĩa 1 bộ khung của 1 thuật toán trong 1 chức
 * năng (thao tác) chuyển giao việc thực hiện nó cho lớp con. Mẫu Template
 * Method cho phép lớp con định nghĩa lại cách thực hiện của 1 thuật toán mà
 * không phải thay đổi cấu trúc thuật toán. <br/>
 * Everything comes together here.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class Demo {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		Network network = null;
		System.out.print("Input user name: ");
		String userName = reader.readLine();
		System.out.print("Input password: ");
		String password = reader.readLine();

		// Enter the message.
		System.out.print("Input message: ");
		String message = reader.readLine();

		System.out.println("\nChoose social network for posting message.\n"
				+ "1 - Facebook\n" + "2 - Twitter");
		int choice = Integer.parseInt(reader.readLine());

		// Create proper network object and send the message.
		if (choice == 1) {
			network = new Facebook(userName, password);
		} else if (choice == 2) {
			network = new Twitter(userName, password);
		}
		network.post(message);
	}
}