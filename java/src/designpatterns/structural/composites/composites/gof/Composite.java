package composites.gof;

import java.util.ArrayList;
/**
 * <h1>Composite</h1> Các đối tượng cấu thành các cấu trúc cây để mô tả bán toàn
 * bộ hệ thống phần cấp. Composite để cho các client tác động các đối tượng
 * riêng biệt và các thành phần của đối tượng một cách thống nhất.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class Composite extends Figure {

  private ArrayList<Figure> figures = new ArrayList<Figure>();

  public String draw() {
    String s = "";

    for (Figure f : figures) {
      s += f.draw() + " ";
    }

    return s;
  }

  public void remove(Figure figure) {
    figures.remove(figure);
  }

  public void add(Figure figure) {
    figures.add(figure);
  }
}