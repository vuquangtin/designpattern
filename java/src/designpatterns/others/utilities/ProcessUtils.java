package utilities;

import java.io.IOException;
import java.lang.reflect.Field;

import org.apache.log4j.Logger;

public class ProcessUtils {
	static Logger logger = Logger.getLogger(ProcessUtils.class.getName());

	@SuppressWarnings("rawtypes")
	public static int getUnixPID(Process process) throws Exception {
		if(logger.isDebugEnabled())
					logger.debug(process.getClass().getName());
		if (process.getClass().getName().equals("java.lang.UNIXProcess")) {
			Class cl = process.getClass();
			Field field = cl.getDeclaredField("pid");
			field.setAccessible(true);
			Object pidObject = field.get(process);
			return (Integer) pidObject;
		} else {
			throw new IllegalArgumentException("Needs to be a UNIXProcess");
		}
	}

	public static int killUnixProcess(Process process) throws Exception {
		int pid = getUnixPID(process);
		return Runtime.getRuntime().exec("kill " + pid).waitFor();
	}

	public static int getPID() {
		String tmp = java.lang.management.ManagementFactory.getRuntimeMXBean().getName();
		tmp = tmp.split("@")[0];
		return Integer.valueOf(tmp);
	}

	public static void killChromiumBrowse() throws IOException, InterruptedException {

		Runtime.getRuntime().exec("pkill chromium-browse").waitFor();

	}

	public static void main(String[] args) {
		try {
			Runtime.getRuntime().exec("pkill chromium-browse").waitFor();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
