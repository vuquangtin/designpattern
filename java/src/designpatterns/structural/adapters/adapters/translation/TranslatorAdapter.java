package adapters.translation;

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
public class TranslatorAdapter implements VietnameseTarget {

	private JapaneseAdaptee adaptee;

	public TranslatorAdapter(JapaneseAdaptee adaptee) {
		this.adaptee = adaptee;
	}

	@Override
	public void send(String words) {
		System.out.println("Reading Words ...");
		System.out.println(words);
		String vietnameseWords = this.translate(words);
		System.out.println("Sending Words ...");
		adaptee.receive(vietnameseWords);
	}

	private String translate(String vietnameseWords) {
		System.out.println("Translated!");
		return "こんにちは";
	}
}