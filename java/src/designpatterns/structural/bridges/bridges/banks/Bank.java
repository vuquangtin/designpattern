package bridges.banks;
/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public abstract class Bank {
	 
    protected Account account;
 
    public Bank(Account account) {
        this.account = account;
    }
 
    public abstract void openAccount();
}