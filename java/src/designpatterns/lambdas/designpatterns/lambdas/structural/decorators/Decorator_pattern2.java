package designpatterns.lambdas.structural.decorators;

import java.awt.Color;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * <h1>Decorator</h1> Gán bổ sung các “trách nhiệm” (responsibility) cho một đối
 * tượng một cách linh hoạt. Các decorator cung cấp một sự lựa chọn linh động
 * cho lớp con để mở rộng tính năng.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/designpattern">https://github.com
 * 
 *      /vuquangtin/designpattern</a>
 *
 */
@SuppressWarnings("unchecked") // this removes warnings
class Camera {
	private static Function<Color, Color> filter;

	public Camera(Function<Color, Color>... filters) {
		setFilters(filters);
	}

	public void setFilters(Function<Color, Color>... filters) {
		filter = Stream.of(filters).reduce(Function.identity(), Function::andThen);
		// this is worth effective & concise
		// color-> color, // or this
		// (theFilters, aFilter)->
		// theFilters.andThen(aFilter));

	}

	public static Color snap(Color input) {
		return filter.apply(input);
	}
}

@SuppressWarnings("unchecked")
public class Decorator_pattern2 {
	public static void printSnap(Camera camera) {
		System.out.println(Camera.snap(new Color(125, 125, 125)));
	}

	public static void main(String[] args) {
		printSnap((new Camera())); // 125

		printSnap((new Camera(Color::brighter))); // 178

		printSnap((new Camera(Color::darker))); // 87

		printSnap((new Camera(Color::brighter, Color::darker))); // 124

	}

}