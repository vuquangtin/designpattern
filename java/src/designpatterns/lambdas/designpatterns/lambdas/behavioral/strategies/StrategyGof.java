package designpatterns.lambdas.behavioral.strategies;

/**
 * <h1>Observer</h1> Định nghĩa một sự phụ thuộc 1-nhiều giữa các đối tượng để
 * khi một đối tượng thay đổi trạng thái, tất cả phụ thuộc của nó được thông báo
 * và cập nhật một cách tự động.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class StrategyGof {

	interface TextFormatter {
		boolean filter(String text);

		String format(String text);
	}

	public static class PlainTextFormatter implements TextFormatter {

		@Override
		public boolean filter(String text) {
			return true;

		}

		@Override
		public String format(String text) {
			return text;
		}
	}

	public static class ErrorTextFormatter implements TextFormatter {

		@Override
		public boolean filter(String text) {
			return text.startsWith("ERROR");

		}

		@Override
		public String format(String text) {
			return text.toUpperCase();
		}
	}

	public static class ShortTextFormatter implements TextFormatter {

		@Override
		public boolean filter(String text) {
			return text.length() < 20;

		}

		@Override
		public String format(String text) {
			return text.toLowerCase();
		}
	}

	public static class TextEditor {
		private final TextFormatter textFormatter;

		public TextEditor(TextFormatter textFormatter) {
			this.textFormatter = textFormatter;
		}

		public void publishText(String text) {
			if (textFormatter.filter(text)) {
				System.out.println(textFormatter.format(text));
			}
		}
	}

	public static void main(String[] args) {
		System.out.println("ErrorTextFormatter:");
		TextEditor textEditor = new TextEditor(new ErrorTextFormatter());
		textEditor.publishText("ERROR - something bad happened");
		textEditor.publishText("DEBUG - I'm here");

		System.out.println("\nShortTextFormatter:");
		textEditor = new TextEditor(new ShortTextFormatter());
		textEditor.publishText("ERROR - something bad happened");
		textEditor.publishText("DEBUG - I'm here");

		System.out.println("\nPlainTextFormatter:");
		textEditor = new TextEditor(new PlainTextFormatter());
		textEditor.publishText("ERROR - something bad happened");
		textEditor.publishText("DEBUG - I'm here");
	}
}