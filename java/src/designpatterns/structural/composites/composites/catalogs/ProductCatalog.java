package composites.catalogs;

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
public class ProductCatalog extends CatalogComponent {
	private ArrayList<CatalogComponent> items = new ArrayList<>();
	private String name;

	public ProductCatalog(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void print() {

		for (CatalogComponent comp : items) {
			comp.print();
		}
	}

	@Override
	public void add(CatalogComponent catalogComponent) {
		items.add(catalogComponent);
	}

	@Override
	public void remove(CatalogComponent catalogComponent) {
		items.remove(catalogComponent);
	}

}