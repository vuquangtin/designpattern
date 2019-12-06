package visitors.animals;
/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class Warrior implements Human {
    public void hit(Monster monster) {
        System.out.println("Let me introduce you: my hammer!!!");
        monster.damaged(50);
    }
}