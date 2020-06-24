package dao.sql.entity.impl;

import dao.sql.entity.Person;

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
public class PersonImpl extends SubscriberImpl implements Person {

    /** Number of the passport. */
    private String passportNumber;
    
    /**
     * Default constructor.
     */
    public PersonImpl() {
    }
    
    /**
     * Initializes a newly created {@code RealPerson} object with an indication 
     * of name.
     * @param name RealPerson name .
     */
    public PersonImpl(String name) {
        super(name);
    }
    
    public PersonImpl(int id){
        super(id);
    }

    /**
     * Initializes a newly created {@code Organization} object with an indication 
     * of passport number, name, address and list of phone numbers.
     * @param passportNumber Passport number.
     * @param name Name of person.
     * @param address Address of person.
     * @param phoneNumbers List of phone numbers, which belong to person.
     */   
    public PersonImpl(String passportNumber, String name, String address) {
        super(name, address);
        this.passportNumber = passportNumber;
    }

    /**
     * Gets passport number.
     * @return passport number.
     */
    @Override
    public String getPassportNumber() {
        return passportNumber;
    }

    /**
     * Sets passport number.
     * @param passportNumber passport number.
     */
    @Override
    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    @Override
    public String getSubscriberType() {
        return "person";
    }
}