package dao.sql.persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import dao.sql.entity.AbstractEntity;
import dao.sql.exception.DatabaseException;
import dao.sql.impl.AbstractDAO;
import dao.sql.impl.AccountDAO;
import dao.sql.impl.AccountDAOImpl;
import dao.sql.impl.CallDAO;
import dao.sql.impl.CallDAOImpl;
import dao.sql.impl.OrganizationDAO;
import dao.sql.impl.OrganizationDAOImpl;
import dao.sql.impl.PeriodDAO;
import dao.sql.impl.PeriodDAOImpl;
import dao.sql.impl.PersonDAO;
import dao.sql.impl.PersonDAOImpl;
import dao.sql.impl.PhoneNumberDAO;
import dao.sql.impl.PhoneNumberDAOImpl;
import dao.sql.impl.UserDAO;
import dao.sql.impl.UserDAOImpl;

/**
 * <h1>Data Access Object (DAO) Pattern</h1>
 * 
 * Data Access Object (DAO) Pattern là một trong những Pattern thuộc nhóm cấu
 * trúc (Structural Pattern). Mẫu thiết kế DAO được sử dụng để phân tách logic
 * lưu trữ dữ liệu trong một lớp riêng biệt. Theo cách này, các service được che
 * dấu về cách các hoạt động cấp thấp để truy cập cơ sở dữ liệu được thực hiện.
 * Nó còn được gọi là nguyên tắc Tách logic (Separation of Logic).
 * 
 * <br/>
 * Ý tưởng là thay vì có logic giao tiếp trực tiếp với cơ sở dữ liệu, hệ thống
 * file, dịch vụ web hoặc bất kỳ cơ chế lưu trữ nào mà ứng dụng cần sử dụng,
 * chúng ta sẽ để logic này sẽ giao tiếp với lớp trung gian DAO. Lớp DAO này sau
 * đó giao tiếp với hệ thống lưu trữ, hệ quản trị CSDL như thực hiện các công
 * việc liên quan đến lưu trữ và truy vấn dữ liệu (tìm kiếm, thêm, xóa, sửa,…).
 * 
 * <br/>
 * DAO Pattern dựa trên các nguyên tắc thiết kế abstraction và encapsulation. Nó
 * bảo vệ phần còn lại của ứng dụng khỏi mọi thay đổi trong lớp lưu trữ, ví dụ:
 * thay đổi database từ Oracle sang MySQL, thay đổi công nghệ lưu trữ từ file
 * sang database. <br/>
 * 
 * Trong Java, DAO được triển khai theo nhiều cách khác nhau như Java
 * Persistence API, Enterprise Java Bean (EJP), Object-relational mapping (ORM)
 * với các implement cụ thể như Hibernate, iBATIS, Spring JPA, … Chi tiết về các
 * phần này chúng ta sẽ cùng thảo luận ở một bài viết khác.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class TransactionSQL extends Transaction {

	private Connection connection;
	private static final Map<Class<? extends AbstractDAO<?>>, Class<? extends AbstractDAO<?>>> DAOS = new ConcurrentHashMap<>();

	public TransactionSQL() {
		connection = ConnectionPool.getInstance().getConnection();
	}

	static {
		DAOS.put(AccountDAO.class, AccountDAOImpl.class);
		DAOS.put(CallDAO.class, CallDAOImpl.class);
		DAOS.put(OrganizationDAO.class, OrganizationDAOImpl.class);
		DAOS.put(PeriodDAO.class, PeriodDAOImpl.class);
		DAOS.put(PersonDAO.class, PersonDAOImpl.class);
		DAOS.put(PhoneNumberDAO.class, PhoneNumberDAOImpl.class);
		DAOS.put(UserDAO.class, UserDAOImpl.class);
	}

	@Override
	public <Type extends AbstractDAO<? extends AbstractEntity>> Type createDao(
			Class<Type> key) throws DatabaseException {

		Class<? extends AbstractDAO<? extends AbstractEntity>> value = DAOS
				.get(key);
		if (value != null) {
			try {
				AbstractDAO<?> dao = value.getConstructor(Connection.class)
						.newInstance(connection);
				return (Type) dao;
			} catch (Exception e) {
				throw new DatabaseException(e);
			}
		}
		return null;
	}

	@Override
	public void commit() throws DatabaseException {
		try {
			connection.commit();
		} catch (SQLException e) {
			throw new DatabaseException(e);
		}
	}

	@Override
	public void rollback() throws DatabaseException {
		try {
			connection.rollback();
		} catch (SQLException e) {
			throw new DatabaseException(e);
		}
	}

	@Override
	public void close() throws DatabaseException {
		ConnectionPool.getInstance().releaseConnection(connection);
	}
}
