package in.javacodegeeks;

import java.util.List;

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
