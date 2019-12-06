package in.javacodegeeks;

public class LAITMessenger {

	private static LAITMessenger messenger;

	private LAITMessenger() {
	}

	public synchronized static LAITMessenger getInstance() {

		if (messenger == null) {
			messenger = new LAITMessenger();
		}

		return messenger;
	}

	public void send(String message) {

	}
}
