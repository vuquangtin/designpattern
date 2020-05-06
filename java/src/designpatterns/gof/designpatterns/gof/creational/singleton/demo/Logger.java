package designpatterns.gof.creational.singleton.demo;

/**
 * <h1>Singleton</h1> Đảm bảo rằng một class (lớp) chỉ có duy nhất một instance
 * (thể hiện), và cung cấp một điểm chung, toàn cục để truy cập vào lớp đó.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class Logger {

	// Initialize the private static reference of itself
	private static Logger loggerInstance = new Logger();

	// private constructor
	private Logger() {
	}

	// method to return the single instance
	public static Logger getLogger() {
		return loggerInstance;
	}

	// other methods
	public void logMsg(String priority, String message) {

	}
}
