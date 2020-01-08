package designpatternsproject.io.exporter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

import designpatternsproject.util.DialogsHelper;
import designpatternsproject.util.Logger;

public class SaveLogToFile implements Exporter {

	/**
	 * Will create new empty file to save log to, save line by line into it
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void exportData(ArrayList<Object> objects, String path) {
		if (path == null)
			return;
		File logFile = new File(path);
		if(logFile.exists()) {
			logFile.delete();
			logFile = new File(path);
		}
		try {
			logFile.createNewFile();
		} catch (IOException e1) {
			e1.printStackTrace();
			return;
		}
		Path pathObj = Paths.get(path);
		try {
			for (String logLine : (ArrayList<String>) objects.get(0)) {
				logLine += "\n";
				byte[] strToBytes = logLine.getBytes();
				try {
					Files.write(pathObj, strToBytes, StandardOpenOption.APPEND);
				} catch (IOException e) {
					String msg = "Error while exporting log file, error message: " + e.getMessage();
					DialogsHelper.showErrorMessage(msg);
					Logger.getInstance().log(msg, true, true);
					e.printStackTrace();
				}
			}
			Logger.getInstance().log("Log has been exported to " + path, true, true);
		} catch (Exception e) {
			String msg = "Error while exporting log file, error message: " + e.getMessage();
			DialogsHelper.showErrorMessage(msg);
			Logger.getInstance().log(msg, true, true);
			e.printStackTrace();
		}

	}

}
