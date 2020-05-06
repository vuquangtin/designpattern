package headfirst.designpatterns.decorator.io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputTest {
	public static void main(String[] args) throws IOException {
		int c;
		InputStream in = null;
		String PATH = new File(".").getCanonicalPath() + "/java/resources/com/resources/content/"
				+ "test.txt";
		;
		try {
			in = new LowerCaseInputStream(new BufferedInputStream(
					new FileInputStream(PATH)));

			while ((c = in.read()) >= 0) {
				System.out.print((char) c);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				in.close();
			}
		}
		System.out.println();
		try (InputStream in2 = new LowerCaseInputStream(
				new BufferedInputStream(new FileInputStream(PATH)))) {
			while ((c = in2.read()) >= 0) {
				System.out.print((char) c);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
