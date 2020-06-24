package dao.sql.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import dao.sql.entity.Person;
import dao.sql.entity.PhoneNumber;
import dao.sql.entity.impl.PersonImpl;
import dao.sql.entity.proxy.PhoneNumberProxy;
import dao.sql.exception.DatabaseException;

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
public class PersonDAOImpl extends SubscriberDAOImpl<Person> implements
		PersonDAO {

	public PersonDAOImpl(Connection connection) {
		super(connection);
	}

	private static final Logger logger = Logger.getLogger(PersonDAOImpl.class
			.getName());

	@Override
	public List<Person> findAll() {
		Statement st = null;
		PreparedStatement st2 = null;
		ResultSet rs;
		ResultSet rs2;
		List<Person> subscriberList = new ArrayList<>();
		try {
			st = connection.createStatement();
			st2 = connection
					.prepareStatement("select ID_PHONE_NUMBER from PHONE_NUMBER where SUBSCRIBER_ID=?");
			rs = st.executeQuery("select * from SUBSCRIBER where SUBSCRIBER_TYPE=0");

			while (rs.next()) {
				Person subscriber;
				subscriber = new PersonImpl(rs.getString("PASSPORT_NUMBER")
						.trim(), rs.getString("SUBSCRIBER_NAME").trim(), rs
						.getString("ADDRESS").trim());

				subscriber.setId(rs.getInt("ID_SUBSCRIBER"));

				st2.setInt(1, rs.getInt("ID_SUBSCRIBER"));
				rs2 = st2.executeQuery();

				while (rs2.next()) {
					PhoneNumber pn = new PhoneNumberProxy();
					pn.setId(rs2.getInt("ID_PHONE_NUMBER"));
					subscriber.addPhoneNumber(pn);
				}
				subscriberList.add(subscriber);
			}
		} catch (SQLException ex) {
			logger.log(Level.SEVERE,
					"Exception while reading person list: {0}", ex.getMessage());
			throw new DatabaseException("Can't read person list", ex);
		} finally {
			try {
				if (st != null) {
					st.close();
				}
				if (st2 != null) {
					st2.close();
				}
			} catch (SQLException ex) {
			}
		}
		return subscriberList;
	}

	@Override
	public List<Person> readByName(String name) {
		return super.readByName(name, 0);
	}

}
