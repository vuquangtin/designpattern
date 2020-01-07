package singletonpattern;

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
public class Database {

	private static Database singleObject = new Database("Products");
	private int record;
	private String name;

	private Database(String n) {
		this.name = n;
		this.record = 0;
	}

	public void editRecord(String operation) {
		System.out.println("Performing a " + operation
				+ " operation on record " + record + " in " + "database "
				+ name);
	}

	public String getName() {
		return name;
	}

	public static synchronized Database getInstance(String n) {

		return singleObject;
	}
}