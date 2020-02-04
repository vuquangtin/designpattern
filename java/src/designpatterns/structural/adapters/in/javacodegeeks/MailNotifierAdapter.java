package in.javacodegeeks;

import java.util.List;

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
public class MailNotifierAdapter implements Notifier {

	private static final String NOTIFICATION_TITLE = "System notification";

	public void notify(List<String> recipients, String message) {

		MailSender mailSender = new MailSender(NOTIFICATION_TITLE, message,
				recipients);
		mailSender.sendMessage();
	}

}
