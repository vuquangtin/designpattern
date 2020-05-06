package app.abstractclass;

import java.io.File;
import java.io.IOException;

public abstract class Resource {
	public static String PATH = null;
	public static String PATH_NINJAR = null;
	public static String PATH_INTERPRETER = null;
	static {
		try {
			PATH = new File(".").getCanonicalPath() + "/java/resources/app/";
			PATH_NINJAR = new File(".").getCanonicalPath() + "/java/resources/app_ninjar/";
			PATH_INTERPRETER= new File(".").getCanonicalPath() + "/java/resources/app_interpreter/";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	};
}
