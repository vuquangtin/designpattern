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
public class Client {
	AbstractDAO dao;

	public Client() {
		dao = FactoryDAO.getDAO();
	}

	public AbstractDAO getDao() {
		return dao;
	}

	public void setDao(AbstractDAO dao) {
		this.dao = dao;
	}

	public void execute() {
		dao.insert();
		dao.update();
		dao.delete();
	}
}