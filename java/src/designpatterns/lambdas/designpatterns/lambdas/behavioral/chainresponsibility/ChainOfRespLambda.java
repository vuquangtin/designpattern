package designpatterns.lambdas.behavioral.chainresponsibility;

import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

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
public class ChainOfRespLambda {

	public static Optional<String> parseText(File file) {
		return Optional.ofNullable(file)
				.filter(f -> f.getType() == File.Type.TEXT)
				.map(f -> "Text file: " + f.getContent());
	}

	public static Optional<String> parsePresentation(File file) {
		return Optional.ofNullable(file)
				.filter(f -> f.getType() == File.Type.PRESENTATION)
				.map(f -> "Presentation file: " + f.getContent());
	}

	public static Optional<String> parseAudio(File file) {
		return Optional.ofNullable(file)
				.filter(f -> f.getType() == File.Type.AUDIO)
				.map(f -> "Audio file: " + f.getContent());
	}

	public static Optional<String> parseVideo(File file) {
		return Optional.ofNullable(file)
				.filter(f -> f.getType() == File.Type.VIDEO)
				.map(f -> "Video file: " + f.getContent());
	}

	public static void main(String[] args) {
		File file = new File(File.Type.AUDIO,
				"Dream Theater  - The Astonishing");

		System.out.println(Stream
				.<Function<File, Optional<String>>> of(
						ChainOfRespLambda::parseText,
						ChainOfRespLambda::parsePresentation,
						ChainOfRespLambda::parseAudio,
						ChainOfRespLambda::parseVideo)
				.map(f -> f.apply(file))
				.filter(Optional::isPresent)
				.map(Optional::get)
				.findFirst()
				.orElseThrow(
						() -> new RuntimeException("Unknown file: " + file)));
	}
}