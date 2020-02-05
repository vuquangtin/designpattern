package factorymethods.app.gui;
/**
 * <h1>Factory Method</h1>Cung cấp 1 giao diện để tạo ra đối tượng nhưng để lớp
 * con quyết định kiểu đối tượng nào sẽ dc tạo.
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com

 *      /vuquangtin/designpattern</a>
 *
 */
public class GameConfig {
	public static int HEIGHT = 90;
	public static int WIDTH = 150;
	public static int SCALE = 6;
	public static int MAXHEIGHT = HEIGHT*SCALE;
	public static int MAXWIDTH = WIDTH*SCALE;

}
