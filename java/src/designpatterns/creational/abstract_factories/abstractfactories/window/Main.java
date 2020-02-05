package abstractfactories.window;

/**
 * <h1>Abstract Factory</h1> Cung cấp một interface để tạo ra 1 họ các object
 * (đối tượng) có liên quan hoặc phụ thuộc lẫn nhau mà không chỉ rõ các lớp cụ
 * thể của chúng (concrete classes)
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com

 *      /vuquangtin/designpattern</a>
 *
 */
public class Main {
	public static void main(String[] args) {
		GUIBuilder builder = new GUIBuilder();
		AbstractWidgetFactory widgetFactory = null;
		// check what platform we're on
		EnumOS os=getOs();
		if (os == EnumOS.macos) {
			widgetFactory = new MacOSXWidgetFactory();
		} else if (os == EnumOS.windows) {
			widgetFactory = new MsWindowsWidgetFactory();
		}else if(os==EnumOS.linux){
			widgetFactory = new LinuxWidgetFactory();
		}
		builder.buildWindow(widgetFactory);
		
	}

	public static enum EnumOS {
		linux, macos, solaris, unknown, windows;

		public boolean isLinux() {

			return this == linux || this == solaris;
		}

		public boolean isMac() {

			return this == macos;
		}

		public boolean isWindows() {

			return this == windows;
		}
	}

	public static EnumOS getOs() {

		String s = System.getProperty("os.name").toLowerCase();

		if (s.contains("win")) {
			return EnumOS.windows;
		}

		if (s.contains("mac")) {
			return EnumOS.macos;
		}

		if (s.contains("solaris")) {
			return EnumOS.solaris;
		}

		if (s.contains("sunos")) {
			return EnumOS.solaris;
		}

		if (s.contains("linux")) {
			return EnumOS.linux;
		}

		if (s.contains("unix")) {
			return EnumOS.linux;
		} else {
			return EnumOS.unknown;
		}
	}
}