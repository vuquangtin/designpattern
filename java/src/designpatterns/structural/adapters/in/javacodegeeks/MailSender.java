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
public class MailSender {

	private String title;
	private String message;
	private List<String> recipients;

	public MailSender(String title, String message, List<String> recipients) {
		this.title = title;
		this.message = message;
		this.recipients = recipients;
	}

	public void sendMessage() {
		System.out.println(title);
		System.out.println(message);
		System.out.println(recipients);
	}

	public void sendHtmlMessage(String htmlTemplate) {

	}

}
