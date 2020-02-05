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
public class SingletonPatternDemo {
  public static void main(String[] args) {

    // illegal construct
    // Compile Time Error: The constructor SingleObject() is not visible
    // SingleObject object = new SingleObject();

    // Get the only object available
    SingleObject object = SingleObject.getInstance();

    // show the message
    object.showMessage();
    object.showMessage("Hello Everyone!");
  }
}
