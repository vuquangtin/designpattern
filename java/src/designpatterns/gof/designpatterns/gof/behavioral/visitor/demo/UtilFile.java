package designpatterns.gof.behavioral.visitor.demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import org.junit.Test;

/**
 * <h1>Visitor</h1>Diễn tả 1 hoạt động (thao tác, thuật toán) được thực hiện
 * trên các phần tử của 1 cấu trúc đối tượng. Visitor cho phép bạn định nghĩa 1
 * phép toán mới mà không thay đổi các lớp của các phần tử mà nó thao tác
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/designpattern">https://github.com
 *      /vuquangtin/designpattern</a>
 *
 */
public class UtilFile {

	@Test
	public void testReadFileConvertTableContents() {
		List<String> contents = UtilFile.readFile("inputdata.txt");
		List<List<String>> tableContents = UtilFile.convertTableContents(contents);

		for (List<String> iList : tableContents) {
			System.out.println("[DBG] Show the elements:");
			for (String iElem : iList) {
				System.out.println("[DBG]   Elem -> " + iElem);
			}
		}
	}

	public static List<List<String>> convertTableContents(List<String> contents) {
		List<List<String>> tableContents = new ArrayList<List<String>>();

		for (int i = 0; i < contents.size(); i++) {
			String line = contents.get(i);
			if (line == null || line.isEmpty()) {
				continue;
			}

			List<String> listElements = new ArrayList<String>();
			String[] splitedLine = line.split(",");

			for (int j = 0; j < splitedLine.length; j++) {
				String iElem = splitedLine[j].trim();
				listElements.add(iElem);
			}
			tableContents.add(listElements);
		}
		return tableContents;
	}

	public static List<String> readFile(String filePath) {
		List<String> contents = new ArrayList<String>();
		File file = new File(filePath);
		Scanner scanner = null;
		try {
			scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				contents.add(line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (scanner != null)
				scanner.close();
		}
		return contents;
	}

	public static void saveFile(StringBuffer inputBuffer) {
		try {
			// System.out.println("[DBG]");
			// System.out.println(inputBuffer.toString());
			FileOutputStream fileOut = new FileOutputStream("outputdata.csv");
			fileOut.write(inputBuffer.toString().getBytes());
			fileOut.close();

		} catch (Exception e) {
			System.out.println("Problem saving file.");
		}
	}

	public static String reverseWords(String str) {

		Pattern pattern = Pattern.compile("\\s");
		String[] temp = pattern.split(str);
		String result = "";

		for (int i = 0; i < temp.length; i++) {
			StringBuilder word = new StringBuilder();
			word.append(temp[i]);
			word = word.reverse();
			if (i == 0)
				result = word.toString() + result;
			else
				result += " " + word.toString();
		}
		return result;
	}
}