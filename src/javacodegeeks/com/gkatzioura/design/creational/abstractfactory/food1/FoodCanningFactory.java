package javacodegeeks.com.gkatzioura.design.creational.abstractfactory.food1;

import javacodegeeks.com.gkatzioura.design.creational.abstractfactory.CanBody;
import javacodegeeks.com.gkatzioura.design.creational.abstractfactory.CanTop;
import javacodegeeks.com.gkatzioura.design.creational.abstractfactory.CanningFactory;

public class FoodCanningFactory extends CanningFactory {

    public CanTop createTop() {
        return new FoodCanTop();
    }

    public CanBody createBody() {
        return new FoodCanBody();
    }

}
