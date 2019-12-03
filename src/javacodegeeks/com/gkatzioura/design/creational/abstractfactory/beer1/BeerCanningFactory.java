package javacodegeeks.com.gkatzioura.design.creational.abstractfactory.beer1;

import javacodegeeks.com.gkatzioura.design.creational.abstractfactory.CanBody;
import javacodegeeks.com.gkatzioura.design.creational.abstractfactory.CanTop;
import javacodegeeks.com.gkatzioura.design.creational.abstractfactory.CanningFactory;

public class BeerCanningFactory extends CanningFactory {

    public CanTop createTop() {
        return new BeerCanTop();
    }

    public CanBody createBody() {
        return new BeerCanBody();
    }

}
