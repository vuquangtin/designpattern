package observers.app.demo;
/**
 * <h1>Observer</h1> Định nghĩa một sự phụ thuộc 1-nhiều giữa các đối tượng để
 * khi một đối tượng thay đổi trạng thái, tất cả phụ thuộc của nó được thông báo
 * và cập nhật một cách tự động.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com

 *      /vuquangtin/designpattern</a>
 *
 */
public class ObserverDemo {
	public static void main(String args[]){
		
		// create the shared string object
		SharedString sharedString = new SharedString();
		sharedString.setTheString("Shared Value");
		
		// create the GUI objects, passing the shared string as a parameter
		DemoGUI gui1 = new DemoGUI(sharedString);
		DemoGUI gui2 = new DemoGUI(sharedString);
		DemoGUI gui3 = new DemoGUI(sharedString);

		// create the threads to contain the GUIs
		Thread t1 = new Thread(gui1);
		Thread t2 = new Thread(gui2);
		Thread t3 = new Thread(gui3);

		// start the threads
		t1.start();
		t2.start();
		t3.start();
	}
}