package dao.sql.entity.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Objects;

import dao.sql.entity.Period;

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
public class PeriodImpl extends AbstractEntityImpl implements Period {

    /**
     * Start period of time.
     */
    private Date startDate;
    /**
     * End period of time.
     */
    private Date endDate;

    public PeriodImpl(int id) {
        super(id);
    }

    /**
     * Initializes a newly created {@code RealPeriod} object with an indication
     * of start period. Date in format like: "12.12.2012". {@code endDate}
     * initialize as today
     *
     * @param startDate - The start of period
     * @throws ParseException If the {@code startDate} argument has incorrect
     * format for parsing
     */
    public PeriodImpl(String startDate) throws ParseException {
        DateFormat df = DateFormat.getDateInstance();
        this.startDate = df.parse(startDate);
        this.endDate = new Date();
    }

    /**
     * Initializes a newly created {@code RealPeriod} object with an indication
     * of two dates. Date in format like: "12.12.2012".
     *
     * @param startDate The start of period.
     * @param endDate The end of period.
     * @throws ParseException If the {@code startDate} or {@code endDate}
     * arguments has incorrect format for parsing.
     */
    public PeriodImpl(String startDate, String endDate) throws ParseException {
        DateFormat df = DateFormat.getDateInstance();
        this.startDate = df.parse(startDate);
        this.endDate = df.parse(endDate);
    }

    public PeriodImpl(Date startDate, Date endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    /**
     * Return the date of the end of the period.
     *
     * @return The date.
     */
    @Override
    public Date getEndDate() {
        return endDate;
    }

    /**
     * Return the date of the start of the period.
     *
     * @return The date.
     */
    @Override
    public Date getStartDate() {
        return startDate;
    }

    @Override
    public String toString() {
        return "from " + startDate + " to " + endDate;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PeriodImpl other = (PeriodImpl) obj;
        if (!Objects.equals(this.startDate, other.startDate)) {
            return false;
        }
        if (!Objects.equals(this.endDate, other.endDate)) {
            return false;
        }
        return true;
    }
}
