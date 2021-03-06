package designpatterns.gof.structural.decorator.demo;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * <h1>Decorator</h1> Gán bổ sung các “trách nhiệm” (responsibility) cho một đối
 * tượng một cách linh hoạt. Các decorator cung cấp một sự lựa chọn linh động
 * cho lớp con để mở rộng tính năng
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/designpattern">https://github.com
 *      /vuquangtin/designpattern</a>
 *
 */
public class JavaIo {
	public static void main(String[] args) throws IOException {
		File file = new File("config/phone.properties");
		UpperReader reader = new UpperReader(new FileReader(file));

		String line = reader.readLine();
		System.out.println(line);

		reader.close();
	}
}