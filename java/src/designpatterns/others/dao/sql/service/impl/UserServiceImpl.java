package dao.sql.service.impl;

import java.util.List;

import dao.sql.entity.Subscriber;
import dao.sql.entity.User;
import dao.sql.exception.DatabaseException;
import dao.sql.impl.UserDAO;
import dao.sql.persistence.Transaction;
import dao.sql.service.UserService;

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
public class UserServiceImpl extends ServiceImpl<User> implements UserService{

    public UserServiceImpl(Transaction transaction) {
        super(transaction);
    }

    @Override
    public void create(User entity) throws DatabaseException {
        getTransaction().createDao(UserDAO.class).create(entity);
    }

    @Override
    public User read(Integer id) throws DatabaseException {
        return getTransaction().createDao(UserDAO.class).read(id);
    }

    @Override
    public void update(User entity) throws DatabaseException {
        getTransaction().createDao(UserDAO.class).update(entity);
    }

    @Override
    public void remove(User entity) throws DatabaseException {
        getTransaction().createDao(UserDAO.class).delete(entity);
    }

    @Override
    public List<User> findAll() throws DatabaseException {
        return getTransaction().createDao(UserDAO.class).findAll();
    }

    @Override
    public void removeUser(Subscriber subscriber) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void changePassword(String login, String newPassword) {
        getTransaction().createDao(UserDAO.class).changePassword(login, newPassword);
    }

    @Override
    public int checkAuthorisation(String login, String password) {
        return getTransaction().createDao(UserDAO.class).checkAuthorisation(login, password);
    }

    @Override
    public boolean isActionAllowed(User user, String action) {
        return getTransaction().createDao(UserDAO.class).isActionAllowed(user, action);
    }

    @Override
    public String getSubscriberName(User user) {
        return getTransaction().createDao(UserDAO.class).getSubscriberName(user);
    }

    @Override
    public List<User> findAllPersonal() {
        return getTransaction().createDao(UserDAO.class).findAllPersonal();
    }

    @Override
    public User findByLogin(String login) {
        return getTransaction().createDao(UserDAO.class).findByLogin(login);
    }

    @Override
    public boolean isActionExists(String action) {
        return getTransaction().createDao(UserDAO.class).isActionExists(action);
    }
    
}
