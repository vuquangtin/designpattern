package dao.sql.service.impl;


import java.util.List;

import dao.sql.entity.Person;
import dao.sql.exception.DatabaseException;
import dao.sql.impl.PersonDAO;
import dao.sql.impl.UserDAO;
import dao.sql.persistence.Transaction;
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
public class PersonServiceImpl extends ServiceImpl<Person> implements PersonService{

    public PersonServiceImpl(Transaction transaction) {
        super(transaction);
    }

    @Override
    public void create(Person entity) throws DatabaseException {
        getTransaction().createDao(PersonDAO.class).create(entity);
        getTransaction().createDao(UserDAO.class).addUserToSubscriber(entity);
    }

    @Override
    public Person read(Integer id) throws DatabaseException {
        return getTransaction().createDao(PersonDAO.class).read(id);
    }

    @Override
    public void update(Person entity) throws DatabaseException {
        getTransaction().createDao(PersonDAO.class).update(entity);
    }

    @Override
    public void remove(Person entity) throws DatabaseException {
        getTransaction().createDao(PersonDAO.class).delete(entity);
        getTransaction().createDao(UserDAO.class).removeUser(entity);
    }

    @Override
    public List<Person> findAll() throws DatabaseException {
        return getTransaction().createDao(PersonDAO.class).findAll();
    }

    @Override
    public List<Person> readByName(String name) {
        return getTransaction().createDao(PersonDAO.class).readByName(name);
    }
    
}
