package builders.phones;

public class MailSender implements Sender {

	@Override
	public void sendMessage() {
		System.out.println("this is MailSender");
	}

}
