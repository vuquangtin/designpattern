package designpatterns.gof.structural.decorator.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/designpattern">https://github.com
 *      /vuquangtin/designpattern</a>
 *
 */
public class UpperReader extends BufferedReader {
	public UpperReader(Reader in) {
		super(in);
	}

	@Override
	public String readLine() throws IOException {
		String line = super.readLine();
		return line.toUpperCase();
	}
}