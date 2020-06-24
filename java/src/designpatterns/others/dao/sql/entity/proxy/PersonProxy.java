package dao.sql.entity.proxy;

import java.util.List;

import dao.sql.entity.Person;
import dao.sql.entity.PhoneNumber;
import dao.sql.service.PersonService;

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
public class PersonProxy extends AbstractProxy<Person, PersonService> implements
		Person {

	public PersonProxy() {
		super(PersonService.class);
	}

	@Override
	public String getAddress() {
		return getProxy().getAddress();
	}

	@Override
	public void setAddress(String address) {
		getProxy().setAddress(address);
	}

	@Override
	public String getName() {
		return getProxy().getName();
	}

	@Override
	public void setName(String name) {
		getProxy().setName(name);
	}

	@Override
	public List<PhoneNumber> getPhoneNumbers() {
		return getProxy().getPhoneNumbers();
	}

	@Override
	public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
		getProxy().setPhoneNumbers(phoneNumbers);
	}

	@Override
	public void addPhoneNumber(PhoneNumber number) {
		getProxy().addPhoneNumber(number);
	}

	@Override
	public String getPassportNumber() {
		return getProxy().getPassportNumber();
	}

	@Override
	public void setPassportNumber(String passportNumber) {
		getProxy().setPassportNumber(passportNumber);
	}

	@Override
	public String toString() {
		return getProxy().toString();
	}

	@Override
	public String getSubscriberType() {
		return "person";
	}
}