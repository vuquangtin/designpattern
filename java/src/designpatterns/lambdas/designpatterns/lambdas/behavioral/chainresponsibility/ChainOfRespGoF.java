package designpatterns.lambdas.behavioral.chainresponsibility;

/**
 * <h1>Chain of Responsability</h1> Tránh sự liên kết trực tiếp giữa đối tượng
 * gửi yêu cầu và đối tượng nhận yêu cầu, khi yêu cầu có thể dc sử lý bởi hơn 1
 * đối tượng. móc nối các đối tượng nhận yêu cầu thành 1 chuỗi và gửi yêu cầu
 * theo chuỗi đó cho đến khi có đối tượng xử lý nó.
 * 
 * @see http://www.itsenka.com/contents/development/designpattern/observer.html
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class ChainOfRespGoF {

	interface FileParser {
		String parse(File file);

		void setNextParser(FileParser next);
	}

	public abstract static class AbstractFileParser implements FileParser {
		protected FileParser next;

		@Override
		public void setNextParser(FileParser next) {
			this.next = next;
		}
	}

	public static class TextFileParser extends AbstractFileParser {
		@Override
		public String parse(File file) {
			if (file.getType() == File.Type.TEXT) {
				return "Text file: " + file.getContent();
			} else if (next != null) {
				return next.parse(file);
			} else {
				throw new RuntimeException("Unknown file: " + file);
			}
		}
	}

	public static class PresentationFileParser extends AbstractFileParser {
		@Override
		public String parse(File file) {
			if (file.getType() == File.Type.PRESENTATION) {
				return "Presentation file: " + file.getContent();
			} else if (next != null) {
				return next.parse(file);
			} else {
				throw new RuntimeException("Unknown file: " + file);
			}
		}
	}

	public static class AudioFileParser extends AbstractFileParser {
		@Override
		public String parse(File file) {
			if (file.getType() == File.Type.AUDIO) {
				return "Audio file: " + file.getContent();
			} else if (next != null) {
				return next.parse(file);
			} else {
				throw new RuntimeException("Unknown file: " + file);
			}
		}
	}

	public static class VideoFileParser extends AbstractFileParser {
		@Override
		public String parse(File file) {
			if (file.getType() == File.Type.VIDEO) {
				return "Video file: " + file.getContent();
			} else if (next != null) {
				return next.parse(file);
			} else {
				throw new RuntimeException("Unknown file: " + file);
			}
		}
	}

	public static void main(String[] args) {
		FileParser textParser = new TextFileParser();
		FileParser presentationParser = new PresentationFileParser();
		FileParser audioParser = new AudioFileParser();
		FileParser videoParser = new VideoFileParser();

		textParser.setNextParser(presentationParser);
		presentationParser.setNextParser(audioParser);
		audioParser.setNextParser(videoParser);

		File file = new File(File.Type.AUDIO,
				"Dream Theater  - The Astonishing");

		System.out.println(textParser.parse(file));
	}
}