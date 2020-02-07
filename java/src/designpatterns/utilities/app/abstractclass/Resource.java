package app.abstractclass;

import java.io.File;
import java.io.IOException;

public abstract class Resource {
	public static String PATH = null;
	static {
		try {
			PATH = new File(".").getCanonicalPath() + "/java/resources/app/";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	};
}
