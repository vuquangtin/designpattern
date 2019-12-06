package in.javacodegeeks;

public class DoubleCheckedLockingMessenger {

	private static final Object lock = new Object();
	private static volatile DoubleCheckedLockingMessenger messenger;

	private DoubleCheckedLockingMessenger() {
	}

	public static DoubleCheckedLockingMessenger getInstance() {

		if (messenger == null) {
			synchronized (lock) {
				if (messenger == null) {
					messenger = new DoubleCheckedLockingMessenger();
				}
			}
		}

		return messenger;
	}

	public void send(String message) {

	}

}
