package com.designpattern.utilities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

public class FileUtils {
	static Logger logger = Logger.getLogger(FileUtils.class.getName());
	public final static String JAR_FILE = "FBGraphAPI-2.0.0-SNAPSHOT-jar-with-dependencies.jar";
	public static final String NAME_FILE = "pg";
	public static final String ENTER_ROW = "\t\t\t";
	// kich thuoc theo MB
	public static final int FILE_SIZE_MAX_MB = 25;
	public static final int FILE_SIZE_MIN_MB = 5;
	public static String FOLDER_SAVE = null;
	public static String FILE_NAME = null;
	public static String FILE_NAME_NEW = null;

	public static long folderSize(String directory) {
		return folderSize(new File(directory));
	}

	public static long folderSize(File directory) {
		long length = 0;
		if (directory.listFiles() != null) {
			for (File file : directory.listFiles()) {
				if (file.isFile())
					length += file.length();
				else
					length += folderSize(file);
			}
		}
		return length;
	}

	public static String readableFileSize(long size) {
		if (size <= 0)
			return "0";
		final String[] units = new String[] { "B", "kB", "MB", "GB", "TB" };
		int digitGroups = (int) (Math.log10(size) / Math.log10(1024));
		return new DecimalFormat("#,##0.#").format(size
				/ Math.pow(1024, digitGroups))
				+ " " + units[digitGroups];
	}

	public static boolean isFilenameValid(String file) {
		File f = new File(file);
		try {
			f.getCanonicalPath();
			return true;
		} catch (IOException e) {
			return false;
		}
	}

	public static long getLastModifiedOfFacebookGraphAPIJar() {
		File file = new File("/adscloud/graph_api/" + JAR_FILE);
		if (file.exists()) {
			if (logger.isDebugEnabled())
				logger.debug("lastModified: " + file.lastModified());
			return file.lastModified();
		}
		if (logger.isDebugEnabled())
			logger.debug(JAR_FILE + " no exists in /adscloud/graph_api/");
		return 0;

	}

	public static boolean checkHsErrPidFile() {

		return checkAllFiles("hs_err_pid.*\\.log");

	}

	private static boolean checkAllFiles(String regex) {
		File curDir = new File(".");
		File[] filesList = curDir.listFiles();
		boolean isReturn = false;
		for (File f : filesList) {
			if (f.isFile()) {
				if (f.getName().matches(regex)) {
					f.delete();
					if (isReturn == false) {
						isReturn = true;
						// Logs.infoOutOfMenmory(conf, Logs.LIST_HYPHEN +
						// Logs.LIST_HYPHEN + "------\n");
					}
					if (logger.isDebugEnabled())
						logger.debug("delete:" + f.getName());
					// Logs.infoOutOfMenmory(conf, f.getName());
					// Logs.info(conf, FileUtils.class, "delete file
					// (hs_err_pid.*.log):" + f.getName());

				}
			}
		}
		return isReturn;

	}

	public static String readAllText(File file, Charset encoding) {
		return readAllText(file.toPath(), encoding);
	}

	public static String readAllText(String path, Charset encoding) {
		return readAllText(Paths.get(path), encoding);
	}

	private static String readAllText(Path path, Charset encoding) {
		byte[] encoded;
		try {
			encoded = Files.readAllBytes(path);
			return new String(encoded, encoding);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static boolean checkFileIsMaxSize(String fileName) {
		return checkFileIsMaxSize(new File(fileName), FILE_SIZE_MAX_MB);
	}

	public static boolean checkFileIsMaxSize(File file, int Max) {

		// Get length of file in bytes
		long fileSizeInBytes = file.length();
		// Convert the bytes to Kilobytes (1 KB = 1024 Bytes)
		long fileSizeInKB = fileSizeInBytes / 1024;
		// Convert the KB to MegaBytes (1 MB = 1024 KBytes)
		long fileSizeInMB = fileSizeInKB / 1024;

		if (fileSizeInMB > Max) {
			return true;
		}
		return false;
	}

	private static boolean mkdirs() {
		File file = new File(FOLDER_SAVE + "/" + TimeUtils.getNowForFile());
		if (!file.exists()) {
			file.mkdirs();
			return true;
		}
		return false;
	}

	public static String getFileName() {
		mkdirs();
		return FOLDER_SAVE + "/" + TimeUtils.getNowForFile() + "/" + NAME_FILE
				+ "-" + TimeUtils.getLongCurrentDate();
	}

	public static boolean checkProfileIsLoaded(String fileName) {

		File processCheck = new File(fileName);
		if (processCheck.exists()) {
			return false;
		} else {
			try {
				processCheck.createNewFile();
				return true;
			} catch (Exception ex) {
				ex.getMessage();
			}
		}
		return false;

	}

	public static boolean delete(String fileName) throws Exception {
		File file = new File(fileName);
		if (file.exists()) {
			if (logger.isDebugEnabled())
				logger.debug("delete profile temp: " + fileName);
			file.delete();
			return true;
		}
		return false;
	}

	public static void copyFolder(File src, File dest) throws IOException {

		if (src.isDirectory()) {

			// if directory not exists, create it
			if (!dest.exists()) {
				dest.mkdir();
				// Logs.info("Directory copied from " + src + " to "
				// + dest);
			}

			// list all the directory contents
			String files[] = src.list();

			for (String file : files) {
				// construct the src and dest file structure
				File srcFile = new File(src, file);
				File destFile = new File(dest, file);
				// recursive copy
				copyFolder(srcFile, destFile);
			}

		} else {
			// if file, then copy it
			// Use bytes stream to support all file types
			InputStream in = new FileInputStream(src);
			OutputStream out = new FileOutputStream(dest);

			byte[] buffer = new byte[1024];

			int length;
			// copy the file content in bytes
			while ((length = in.read(buffer)) > 0) {
				out.write(buffer, 0, length);
			}

			in.close();
			out.close();
			// Logs.info("File copied from " + src + " to " + dest);
		}
	}

	

	public static int writeIntLine(String txtFile, int value) {
		File file = new File(txtFile);
		if (file.exists())
			file.delete();
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(txtFile, false);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
			bw.write(value + "");
			bw.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

		return value;
	}

	public static List<String> readLineToken(String txtFile) {
		return readLineToken(txtFile, false);
	}

	public static List<String> readLineToken(String txtFile, boolean isApp) {
		List<String> list = readLine(txtFile);
		try {
			if (list != null) {
				for (Iterator<String> iterator = list.iterator(); iterator
						.hasNext();) {
					String line = iterator.next();
					if (!line.isEmpty() && !line.equals("")
							&& !line.startsWith("#")) {
						if (isApp) {
							if (line.matches("[0-9]*|.*"))
								list.add(line);
						} else
							list.add(line);
					} else {
						if (logger.isDebugEnabled())
							logger.debug("line is invalidate:" + line + "___");
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public static List<String> readLine(String txtFile) {
		BufferedReader br = null;
		String line = "";
		List<String> list = new ArrayList<String>();
		try {
			br = new BufferedReader(new FileReader(txtFile));
			while ((line = br.readLine()) != null) {
				list.add(line);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}

	public static void writeLine(String txtFile, List<String> list) {
		if (list == null)
			return;
		try {
			File fout = new File(txtFile);
			FileOutputStream fos = new FileOutputStream(fout);

			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
			int n = list.size();
			for (int i = 0; i < n; i++) {
				bw.write(list.get(i));
				if (i != n - 1)
					bw.newLine();
			}

			bw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

		}
	}

	public static void main(String[] args) {
		logger = Log4jUtils.initLog4j();
		if (logger.isDebugEnabled())
			logger.debug(FileUtils.checkHsErrPidFile() + "");
		List<String> list = readLineToken(
				"/Users/admin/Documents/workspace/FBGraphAPI/FBGraphAPI/target/crawl_groups/conf/FB_App_AccessToken.txt",
				true);
		for (String string : list) {
			if (logger.isDebugEnabled())
				logger.debug(string);
		}
	}
}
