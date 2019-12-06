package mediators.colleagues;
/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */

public class MediatorTest {
    public static void main(String[] args) {
        MediatorImpl mediator = new MediatorImpl();

        Colleague vova = new Vova(mediator);
        Colleague stepa = new Stepa(mediator);
        Colleague pasha = new Pasha(mediator);

        mediator.addColleague(vova);
        mediator.addColleague(stepa);
        mediator.addColleague(pasha);

        vova.send("Hi Stepa! Hi Pasha!");
        System.out.println("------------");
        stepa.send("Hi all!");
        System.out.println("------------");
        pasha.send("I'm ready to talk.");
    }
}