package utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.log4j.Logger;

public class MongoDBCopyUtils {
	static Logger logger = Logger.getLogger(MongoDBCopyUtils.class.getName());
	public static final String FOLDER = "conf";
	public static final String PREFIX_FILE = "page";

	public static boolean checkFile(String fileName) {
		// TODO Auto-generated method stub
		File folder = new File(FOLDER);
		if (!folder.exists()) {
			folder.mkdir();
		}
		// String pathFile = fileName;
		// if(logger.isDebugEnabled())
					logger.debug("pathFile:"+fileName);
		File fileRequest = new File(fileName);
		if (!fileRequest.exists()) {

			// FileWriter fileWriter = new FileWriter(fileName);
			// BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			// if(logger.isDebugEnabled())
					logger.debug("write:"+0);
			// bufferedWriter.write("0");
			// bufferedWriter.close();
			writeFile(0);
			// RandomAccessFile file = new RandomAccessFile(pathFile, "rw");
			// file.writeBytes("0");
			return true;

		}
		return true;
	}

	public static int readingFile() {
		return readingFile(FOLDER + "/" + PREFIX_FILE);
	}

	public static int readingFile(int i) {
		return readingFile(FOLDER + "/" + PREFIX_FILE + i);
	}

	public static int readingFile(String fileName) {
		if (checkFile(fileName)) {
			try {
				FileReader reader = new FileReader(fileName);
				BufferedReader bufferedReader = new BufferedReader(reader);
				String line;
				while ((line = bufferedReader.readLine()) != null) {
					if(logger.isDebugEnabled())
					logger.debug("line:" + line);
					bufferedReader.close();
					return Integer.parseInt(line);
				}
				reader.close();
				return 0;
			} catch (IOException e) {
				e.printStackTrace();
				return 0;
			}
		} else {
			return 0;
		}
	}

	public static void writeFile(int current) {
		writeFile(FOLDER + "/" + PREFIX_FILE, current);
	}

	public static void writeFile(int index, int current) {
		writeFile(FOLDER + "/" + PREFIX_FILE + index, current);
	}

	public static void writeFile(String fileName, int current) {
		try {
			FileWriter writer = new FileWriter(fileName, false);
			if(logger.isDebugEnabled())
					logger.debug("current:" + current);
			writer.write(current + "");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		// if(logger.isDebugEnabled())
					logger.debug("current:" + readingFile());
		// writeFile(10);
		if(logger.isDebugEnabled())
					logger.debug("current:" + readingFile());
	}

}
