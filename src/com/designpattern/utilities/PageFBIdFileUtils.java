package com.designpattern.utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class PageFBIdFileUtils {
	static Logger logger = Logger.getLogger(PageFBIdFileUtils.class.getName());
	public static final String FOLDER = "conf";
	public static final String FILE = "PageFBId.txt";

	public static List<String> readingFile() {
		return readingFile(FOLDER + "/" + FILE);
	}

	public static List<String> readingFile(String fileName) {
		if (checkFile(fileName)) {
			List<String> listPageFbId = new ArrayList<String>();
			try {
				FileReader reader = new FileReader(fileName);
				BufferedReader bufferedReader = new BufferedReader(reader);
				String line;
				while ((line = bufferedReader.readLine()) != null) {
					if(logger.isDebugEnabled())
					logger.debug("line:" + line);
					listPageFbId.add(line);
				}
				reader.close();
				return listPageFbId;
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
		} else {
			return null;
		}
	}

	public static boolean checkFile(String fileName) {

		File folder = new File(FOLDER);
		if (!folder.exists()) {
			folder.mkdir();
		}

		File fileRequest = new File(fileName);
		return fileRequest.exists();
	}
}
