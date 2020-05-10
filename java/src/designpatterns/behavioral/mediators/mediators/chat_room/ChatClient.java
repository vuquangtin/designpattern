package mediators.chat_room;

/**
 * <h1>Mediator</h1> Định nghĩa 1 đối tượng đóng gói cách 1 tập hợp các đối
 * tượng tương tác. Mediator thúc đẩy sự khớp nối lỏng lẻo bằng cách ngăn không
 * cho các đối tượng đề cập đến nhau 1 cách rõ ràng và nó cho phép bạn thay đổi
 * sự tương tác của chúng 1 cách độc lập.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/designpattern">https://github.com
 *      /vuquangtin/designpattern</a>
 *
 */
public class ChatClient {

	public static void main(String[] args) {
		ChatMediator mediator = new ChatMediatorImpl("Java design pattern");

		User admin = new UserImpl(mediator, "Mediator");
		User user1 = new UserImpl(mediator, "User 1");
		User user2 = new UserImpl(mediator, "User 2");
		User user3 = new UserImpl(mediator, "User 3");

		mediator.addUser(admin);
		mediator.addUser(user1);
		mediator.addUser(user2);
		mediator.addUser(user3);

		admin.send("Hi All");
		user1.send("Hi Admin");
	}
}