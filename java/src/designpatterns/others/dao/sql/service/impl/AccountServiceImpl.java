package dao.sql.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import dao.sql.entity.Account;
import dao.sql.entity.Organization;
import dao.sql.entity.Period;
import dao.sql.entity.Person;
import dao.sql.entity.Subscriber;
import dao.sql.entity.impl.AccountImpl;
import dao.sql.entity.impl.PeriodImpl;
import dao.sql.exception.DatabaseException;
import dao.sql.impl.AccountDAO;
import dao.sql.impl.OrganizationDAO;
import dao.sql.impl.PeriodDAO;
import dao.sql.impl.PersonDAO;
import dao.sql.persistence.Transaction;
import dao.sql.service.AccountService;

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
public class AccountServiceImpl extends ServiceImpl<Account> implements
		AccountService {

	public AccountServiceImpl(Transaction transaction) {
		super(transaction);
	}

	@Override
	public void addMonthlyAccounts() throws DatabaseException {
		AccountDAO accountDAO = getTransaction().createDao(AccountDAO.class);
		PeriodDAO periodDAO = getTransaction().createDao(PeriodDAO.class);
		PersonDAO personDAO = getTransaction().createDao(PersonDAO.class);
		OrganizationDAO organizationDAO = getTransaction().createDao(
				OrganizationDAO.class);

		// Creating period from 1st number of previous month to 1st number of
		// current month
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR, -12);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);

		Date end = calendar.getTime();
		calendar.add(Calendar.MONTH, -1);
		Date start = calendar.getTime();

		Period period;

		try {
			period = periodDAO.readByStartAndEndDates(start, end);
		} catch (EntityNotFoundException e) {
			period = new PeriodImpl(start, end);
			periodDAO.create(period);
		}

		for (Person per : personDAO.findAll()) {
			Account account = new AccountImpl(per, period);
			account.calculate();
			accountDAO.create(account);
		}

		for (Organization org : organizationDAO.findAll()) {
			Account account = new AccountImpl(org, period);
			account.calculate();
			accountDAO.create(account);
		}

	}

	@Override
	public List<Account> findAll() throws DatabaseException {
		return getTransaction().createDao(AccountDAO.class).findAll();
	}

	@Override
	public void remove(int id) {
		getTransaction().createDao(AccountDAO.class)
				.delete(new AccountImpl(id));
	}

	@Override
	public void remove(Account account) {
		getTransaction().createDao(AccountDAO.class).delete(account);
	}

	@Override
	public void create(Account entity) {
		getTransaction().createDao(AccountDAO.class).create(entity);
	}

	@Override
	public Account read(Integer id) {
		return getTransaction().createDao(AccountDAO.class).read(id);
	}

	@Override
	public void update(Account entity) {
		getTransaction().createDao(AccountDAO.class).update(entity);
	}

	@Override
	public List<Account> findBySubscriber(String parameter) {
		return getTransaction().createDao(AccountDAO.class).findBySubscriber(
				parameter);
	}

	@Override
	public List<Account> readBySubscriber(Integer id) {
		return getTransaction().createDao(AccountDAO.class)
				.readBySubscriber(id);
	}

	@Override
	public Account findBySubscriberAndPeriod(Subscriber subscriber,
			Period period) {
		return getTransaction().createDao(AccountDAO.class)
				.findBySubscriberAndPeriod(subscriber, period);
	}

	@Override
	public void payAccount(Integer id) {
		getTransaction().createDao(AccountDAO.class).payAccount(id);
	}
}