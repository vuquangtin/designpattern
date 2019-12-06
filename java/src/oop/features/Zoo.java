package features;

import java.util.ArrayList;
import java.util.List;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class Zoo {
	 
    private List<Animal> animals = new ArrayList<Animal>();
     
    public void add(Animal animal) {
        animals.add(animal);
    }
     
    public void remove(Animal animal) {
        animals.remove(animal);
    }
     
    public void showListAnimal() {
        for (Animal animal : animals) {
            animal.sayHello();
        }
    }
     
}
