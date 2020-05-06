package designpatterns.gof.structural.composite.demo;

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
public abstract class MenuComponent {
    protected String name;
    protected String operation;

    protected MenuComponent(String name, String operation) {
        this.name = name;
        this.operation = operation;
    }


    public void addMenuComponent(MenuComponent menuComponent) {
        throw new UnsupportedOperationException("不支持该操作");
    }

    public MenuComponent getMenuComponent(int index) {
        throw new UnsupportedOperationException("不支持该操作");
    }

    public void removeMenuComponent(MenuComponent menuComponent) {
        throw new UnsupportedOperationException("不支持该操作");
    }

    public abstract String open();
}