package decoratorpattern;
/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class Disk extends ComponentDecorator {

    Computer computer;
    
    public Disk(Computer c) {
        this.computer = c;
    }
    
    @Override
    public String description() {
        return computer.description() + " and a disk"; 
    }
}