package dao.sql.entity.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Objects;

import dao.sql.entity.Call;
import dao.sql.entity.PhoneNumber;

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
public class CallImpl extends AbstractEntityImpl implements Call {

    /**
     * Number of the calling telephone number.
     */
    private PhoneNumber numberFrom;
    /**
     * Number of the called telephone number.
     */
    private PhoneNumber numberTo;
    /**
     * Duration of call.
     */
    private int duration;
    /**
     * Beginning of the call
     */
    private Date dateOfCall;

    public CallImpl(int id) {
        super(id);
    }

    /**
     * Initializes a newly created {@code Call} object with an indication of two
     * number.
     *
     * @param numberFrom calling number.
     * @param numberTo called number.
     */
    public CallImpl(PhoneNumber numberFrom, PhoneNumber numberTo) {
        this.numberFrom = numberFrom;
        this.numberTo = numberTo;
    }

    public CallImpl() {
    }

    public CallImpl(PhoneNumber numberFrom, PhoneNumber numberTo, Date dateOfCall) {
        this.numberFrom = numberFrom;
        this.numberTo = numberTo;
        this.dateOfCall = dateOfCall;
    }

    public CallImpl(PhoneNumber numberFrom, PhoneNumber numberTo, int duration, Date dateOfCall) {
        this.numberFrom = numberFrom;
        this.numberTo = numberTo;
        this.duration = duration;
        this.dateOfCall = dateOfCall;
    }

    public CallImpl(PhoneNumber numberFrom, PhoneNumber numberTo, int duration, String dateOfCall) throws ParseException {
        this.numberFrom = numberFrom;
        this.numberTo = numberTo;
        this.duration = duration;
        DateFormat df = DateFormat.getDateInstance();
        this.dateOfCall = df.parse(dateOfCall);
    }

    @Override
    public Date getDateOfCall() {
        return dateOfCall;
    }

    @Override
    public int getDuration() {
        return duration;
    }

    @Override
    public PhoneNumber getNumberFrom() {
        return numberFrom;
    }

    @Override
    public PhoneNumber getNumberTo() {
        return numberTo;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CallImpl other = (CallImpl) obj;
        if (!Objects.equals(this.numberFrom, other.numberFrom)) {
            return false;
        }
        if (!Objects.equals(this.numberTo, other.numberTo)) {
            return false;
        }
        if (!Objects.equals(this.dateOfCall, other.dateOfCall)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Call from " + numberFrom + " to " + numberTo + ". Date of call: " + dateOfCall;
    }
}
