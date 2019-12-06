package di;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class MySQLDAO implements AbstractDAO {
	@Override
	public void insert() {
		System.out.println("MySQL insert");
	}

	@Override
	public void delete() {
		System.out.println("MySQL delete");
	}

	@Override
	public void update() {
		System.out.println("MySQL update");
	}
}
