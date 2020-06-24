package dao.sql.entity.impl;

import java.util.Objects;

import dao.sql.entity.Account;
import dao.sql.entity.Call;
import dao.sql.entity.Period;
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
public class AccountImpl extends AbstractEntityImpl implements Account {

    private Subscriber subscriber;
    private Period period;
    private int price;
    private boolean isPaid;

    /**
     * Default constructor.
     */
    public AccountImpl() {
    }

    public AccountImpl(int id) {
        super(id);
    }

    /**
     * Initializes a newly created {@code RealAccount} object with an indication
     * of the subscriber and the amount of time.
     *
     * @param subscriber RealSubscriber.
     * @param period RealPeriod of time.
     */
    public AccountImpl(Subscriber subscriber, Period period) {
        this.subscriber = subscriber;
        this.period = period;
        this.calculate();
    }

    /**
     * Return the period of time.
     *
     * @return The period.
     */
    @Override
    public Period getPeriod() {
        return period;
    }

    /**
     * Sets period of time.
     *
     * @param period RealPeriod of the time.
     */
    @Override
    public void setPeriod(Period period) {
        this.period = period;
    }

    /**
     * Return price of account.
     *
     * @return The price.
     */
    @Override
    public int getPrice() {
        return price;
    }

    /**
     * Sets price of account.
     *
     * @param price Price of account.
     */
    @Override
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Return the subscriber.
     *
     * @return The subscriber.
     */
    @Override
    public Subscriber getSubscriber() {
        return subscriber;
    }

    /**
     * Sets subscriber.
     *
     * @param subscriber RealSubscriber.
     */
    @Override
    public void setSubscriber(Subscriber subscriber) {
        this.subscriber = subscriber;
    }

    @Override
    public final void calculate() {
        price = 0;
        for (PhoneNumber phonenumber : getSubscriber().getPhoneNumbers()) {
            for (Call call : phonenumber.getOutCalls()) {
                if (call.getDateOfCall().after(getPeriod().getStartDate()) && call.getDateOfCall().before(getPeriod().getEndDate())) {
                    price += phonenumber.getCost() * call.getDuration();
                }
            }
        }
    }

    @Override
    public boolean isPaid() {
        return isPaid;
    }

    @Override
    public void setPay(boolean pay) {
        this.isPaid = pay;
    }

    @Override
    public String toString() {
        return "account of the " + getSubscriber() + " on the period " + getPeriod() + ". Price = " + getPrice();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AccountImpl other = (AccountImpl) obj;
        if (!Objects.equals(this.getSubscriber(), other.getSubscriber())) {
            return false;
        }
        if (!Objects.equals(this.getPeriod(), other.getPeriod())) {
            return false;
        }
        return true;
    }
}
