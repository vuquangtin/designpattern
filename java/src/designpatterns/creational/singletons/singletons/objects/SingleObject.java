package singletons.objects;
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
public class SingleObject {

  // create an object of SingleObject
  private static SingleObject instance = new SingleObject();

  // make the constructor private so that this class cannot be
  // instantiated
  private SingleObject() {}

  // Get the only object available
  public static SingleObject getInstance() {
    return instance;
  }

  public void showMessage() {
    System.out.println("Hello World!");
  }

  public void showMessage(String message) {
    System.out.println(message);
  }
}
