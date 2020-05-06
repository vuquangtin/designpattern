package designpatterns.gof.structural.composite.demo;

import java.util.ArrayList;
import java.util.List;

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
public class Menu extends MenuComponent {
    private List<MenuComponent> menuComponents = new ArrayList<MenuComponent>();

    public Menu(String name, String operation) {
        super(name, operation);
    }

    @Override
    public void addMenuComponent(MenuComponent menuComponent) {
        menuComponents.add(menuComponent);
    }

    @Override
    public MenuComponent getMenuComponent(int index) {
        return (menuComponents.size() != 0) ?
                menuComponents.get(index) : null;
    }

    @Override
    public void removeMenuComponent(MenuComponent menuComponent) {
        menuComponents.remove(menuComponent);
    }

    @Override
    public String open() {
        StringBuilder message = new StringBuilder();
        message.append(name).append(":").append(operation).append("\n");
        for (MenuComponent menuComponent : menuComponents) {
            message.append(menuComponent.open()).append("\n");
        }
        return message.toString();
    }
}