package bridges.share;
/**
 * <h1>Bridge</h1> Tách một abstraction khỏi implementation của nó để cả hai có
 * thể thay đổi độc lập nhau.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com

 *      /vuquangtin/designpattern</a>
 *
 */
public class YellowCircle implements DrawAPI {

  @Override
  public void drawCircle(int radius, int x, int y) {
    System.out.println("Drawing Circle[ color: yellow, radius: " + radius + ", x: " + x + ", " + y
        + "]");
  }

}
