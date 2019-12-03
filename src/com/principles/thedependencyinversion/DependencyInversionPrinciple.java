package com.principles.thedependencyinversion;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class DependencyInversionPrinciple {
	public void copy() {
		Keyboard keyboard = new Keyboard();
		Printer printer = new Printer();
		char c;
		while ((c = keyboard.read()) != 'q')
			printer.write(c);
	}

	public void copy(OutputType type) {
		Keyboard keyboard = new Keyboard();
		Printer printer = new Printer();
		File file = new File("");
		char c;
		while ((c = keyboard.read()) != 'q')
			if (type == OutputType.PRINTER)
				printer.write(c);
			else if (type == OutputType.FILE) {
				FileOutputStream fos;
				try {
					fos = new FileOutputStream(file, false);
					BufferedWriter bw = new BufferedWriter(
							new OutputStreamWriter(fos));
					bw.write(c + "");
					bw.close();
				} catch (IOException e) {

					e.printStackTrace();
				}
			}
	}
	public void copy(Reader reader, Writer writer)
	{
		int c;
		try {
			while ((c = reader.read()) != 'q')
				writer.write(c);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
