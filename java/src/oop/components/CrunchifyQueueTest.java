package components;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class CrunchifyQueueTest {

	public static void main(String args[]) {
		CrunchifyQueueInJava crunchifyQueue = CrunchifyQueueInJava
				.getStreamInstance();

		crunchifyQueue.add("Crunchify");
		crunchifyQueue.add("Google");
		crunchifyQueue.add("Yahoo");
		crunchifyQueue.add("Facebook");
		System.out.println("Initial Queue: " + crunchifyQueue.get());

		crunchifyQueue.remove("Google");
		System.out.println("After removing Google: " + crunchifyQueue.get());

		System.out.println("totalSize: " + crunchifyQueue.getTotalSize());
		System.out.println("isEmpty(): " + crunchifyQueue.isEmpty());

		System.out.println("poll(): " + crunchifyQueue.poll());
		System.out.println("After Polling: " + crunchifyQueue.get());
	}
}