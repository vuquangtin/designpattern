package commands.docs;
/**
 * <h1>Command</h1> Đóng gói một yêu cầu request như một đối tượng, bằng cách đó
 * cho phép bạn tham số hóa các client với các request khác nhau, các queue và
 * log request, và hỗ trợ các hoạt động (operation) có thể “undo”.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class Client {
	 
    public static void main(String[] args) {
        DocumentInvoker instance = new DocumentInvoker();
        instance.write("The 1st text. ");
        instance.undo();
        instance.read(); // EMPTY
         
        instance.redo();
        instance.read(); // The 1st text.
 
        instance.write("The 2nd text. ");
        instance.write("The 3rd text. ");
        instance.read(); // The 1st text. The 2nd text. The 3rd text. 
        instance.undo(); // The 1st text. The 2nd text.
        instance.undo(); // The 1st text.
        instance.undo(); // EMPTY
        instance.undo(); // Nothing to undo
    }
}
