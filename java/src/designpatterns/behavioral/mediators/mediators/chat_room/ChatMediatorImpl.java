package mediators.chat_room;

import java.util.ArrayList;
import java.util.List;

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
public class ChatMediatorImpl implements ChatMediator {
    
    public ChatMediatorImpl(String groupName) {
        System.out.println(groupName + " group already created");
    }
 
    private List<User> users = new ArrayList<>();
 
    @Override
    public void addUser(User user) {
        System.out.println(user.name + " joined this group");
        this.users.add(user);
    }
 
    @Override
    public void sendMessage(String msg, User user) {
        for (User u : this.users) {
            if (!u.equals(user)) {
                u.receive(msg);
            }
        }
    }
}