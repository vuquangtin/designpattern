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
public class CuteDogie implements Monster {
    public void damaged(int hp) {
        System.out.println("Woof! I lost " + hp + "hp (❍ᴥ❍ʋ)");
    }
}