package designpatterns.gof.creational.factorymethod.demo;

import java.io.IOException;

/**
 * <h1>Factory Method</h1>Cung cấp 1 giao diện để tạo ra đối tượng nhưng để lớp
 * con quyết định kiểu đối tượng nào sẽ dc tạo.Factory Pattern giao việc khởi
 * tạo một đối tượng cụ thể cho lớp con.
 * 
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com

 *      /vuquangtin/designpattern</a>
 *
 */
public class LoadAndDisplayFiles{
	// This is the FACTORY METHOD Which returns the Display object based on input
	public static Display getDisplay(int argument) {
		Display display = null;
		
		if (argument == '1')
			display = new CSVFile();
		else if (argument == '2')
			display = new XMLFile();
		else if (argument == '3')
			display = new DBFile();
		else
			System.exit(1);

		
		return display;
	}

	public static void main(String[] args) throws IOException {

		System.out.println("Enter your choice 1, 2 or 3 : ");
		int inChar = System.in.read();

		while (inChar != 0) {
			Display display = LoadAndDisplayFiles.getDisplay(inChar);
			System.out.println("Return display class - "+display.getClass().getName());
			// converging code follows
			display.load("");
			display.formatConsistency();
			System.out.println("Enter your choice 1, 2 or 3 : ");
			inChar = System.in.read();
		}
	}
}

// Let's say the interface is Display
interface Display {
	// load a file
	public void load(String fileName);

	// parse the file and make a consistent data type
	public void formatConsistency();
}

// deal with plain text file
class CSVFile implements Display {
	public void load(String textfile) {
		System.out.println("load from a txt file");
	}

	public void formatConsistency() {
		System.out.println("txt file format changed");
	}
}

// deal with XML format file
class XMLFile implements Display {
	public void load(String xmlfile) {
		System.out.println("load from an xml file");
	}

	public void formatConsistency() {
		System.out.println("xml file format changed");
	}
}

// deal with binary format file
class DBFile implements Display {
	public void load(String dbfile) {
		System.out.println("load from a db file");
	}

	public void formatConsistency() {
		System.out.println("db file format changed");
	}
}