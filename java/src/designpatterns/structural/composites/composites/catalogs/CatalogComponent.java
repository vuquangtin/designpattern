package composites.catalogs;

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
public abstract class CatalogComponent {

	public void add(CatalogComponent catalogComponent) {
		throw new UnsupportedOperationException("Cannot add item to catalog.");
	}

	public void remove(CatalogComponent catalogComponent) {
		throw new UnsupportedOperationException(
				"Cannot remove item from catalog.");
	}

	public String getName() {
		throw new UnsupportedOperationException("Cannot return name.");
	}

	public double getPrice() {
		throw new UnsupportedOperationException("Cannot return price.");
	}

	public void print() {
		throw new UnsupportedOperationException("Cannot print.");
	}

}