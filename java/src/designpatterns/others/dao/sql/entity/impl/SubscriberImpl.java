package dao.sql.entity.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import dao.sql.entity.PhoneNumber;
import dao.sql.entity.Subscriber;

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
public abstract class SubscriberImpl extends AbstractEntityImpl implements Subscriber {

    /**
     * Subscriber name.
     */
    private String name;
    /**
     * Subscriber address.
     */
    private String address;
    /**
     * List of subscriber phone numbers.
     */
    private List<PhoneNumber> phoneNumbers = new ArrayList<>();

    /**
     * Gets subscriber address.
     *
     * @return Subscriber address.
     */
    @Override
    public String getAddress() {
        return address;
    }

    /**
     * Sets subscriber address.
     *
     * @param address address.
     */
    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets subscriber name.
     *
     * @return subscriber name.
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Sets subscriber name.
     *
     * @param name Subscriber name.
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets a list of subscriber phone numbers.
     *
     * @return List of subscriber phone numbers.
     */
    @Override
    public List<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    /**
     * Sets a list of phone numbers.
     *
     * @param phoneNumbers list of phone numbers.
     */
    @Override
    public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    @Override
    public void addPhoneNumber(PhoneNumber number) {
        phoneNumbers.add(number);
    }

    /**
     * Default constructor.
     */
    public SubscriberImpl() {
    }

    public SubscriberImpl(int id) {
        super(id);
    }

    /**
     * Initializes a newly created {@code Subscriber} object with an indication
     * of name.
     *
     * @param name Name or title of subscriber
     */
    public SubscriberImpl(String name) {
        this.name = name;
    }

    /**
     * Initializes a newly created {@code Subscriber} object with an indication
     * of his name, address and list of phone numbers.
     *
     * @param name Subscriber name
     * @param address Subscriber address
     * @param phoneNumbers List of subscriber phone numbers
     */
    public SubscriberImpl(String name, String address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SubscriberImpl other = (SubscriberImpl) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        return true;
    }

    @Override
    public abstract String getSubscriberType();
}
