package dao.sql.service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import dao.sql.exception.DatabaseException;
import dao.sql.persistence.Transaction;
import dao.sql.persistence.TransactionFactory;
import dao.sql.service.impl.AccountServiceImpl;
import dao.sql.service.impl.CallServiceImpl;
import dao.sql.service.impl.OrganizationServiceImpl;
import dao.sql.service.impl.PeriodServiceImpl;
import dao.sql.service.impl.PersonServiceImpl;
import dao.sql.service.impl.PhoneNumberServiceImpl;
import dao.sql.service.impl.ServiceImpl;
import dao.sql.service.impl.UserServiceImpl;

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
public class ServiceFactory {

	private static final Map<Class<? extends Service>, Class<? extends ServiceImpl>> SERVICES = new ConcurrentHashMap<>();

	static {
		SERVICES.put(AccountService.class, AccountServiceImpl.class);
		SERVICES.put(CallService.class, CallServiceImpl.class);
		SERVICES.put(OrganizationService.class, OrganizationServiceImpl.class);
		SERVICES.put(PeriodService.class, PeriodServiceImpl.class);
		SERVICES.put(PersonService.class, PersonServiceImpl.class);
		SERVICES.put(PhoneNumberService.class, PhoneNumberServiceImpl.class);
		SERVICES.put(UserService.class, UserServiceImpl.class);
	}

	@SuppressWarnings("unchecked")
	public static <Type extends Service> Type getService(Class<Type> key)
			throws DatabaseException {
		Class<? extends Service> value = SERVICES.get(key);
		if (value != null) {
			try {
				ClassLoader classLoader = value.getClassLoader();
				Class<?>[] interfaces = { key };
				Transaction transaction = TransactionFactory
						.createSQLTransaction();
				Service service = value.getConstructor(Transaction.class)
						.newInstance(transaction);
				InvocationHandler handler = new ServiceInvocationHandler(
						service);
				return (Type) Proxy.newProxyInstance(classLoader, interfaces,
						handler);
			} catch (DatabaseException e) {
				throw e;
			} catch (Exception e) {
			}
		}
		return null;
	}
}