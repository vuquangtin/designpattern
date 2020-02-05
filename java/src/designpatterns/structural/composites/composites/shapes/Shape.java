package composites.shapes;


import java.awt.Graphics;
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
public interface Shape {
	int getX();

	int getY();

	int getWidth();

	int getHeight();

	void move(int x, int y);

	boolean isInsideBounds(int x, int y);

	void select();

	void unSelect();

	boolean isSelected();

	void paint(Graphics graphics);
}