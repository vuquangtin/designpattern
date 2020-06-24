package dao.sql.entity.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import dao.sql.entity.Call;
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
public class PhoneNumberImpl extends AbstractEntityImpl implements PhoneNumber {

    /**
     * The owner of number
     */
    private Subscriber owner;
    /**
     * Phone number in international format.
     */
    private String number;
    /**
     * List of out calls
     */
    private List<Call> outCalls = new ArrayList<>();
    /**
     * List of in calls
     */
    private List<Call> inCalls = new ArrayList<>();

    /**
     * Default constructor.
     */
    public PhoneNumberImpl() {
    }

    public PhoneNumberImpl(int id) {
        super(id);
    }

    /**
     * Initializes a newly created {@code PhoneNumber} object with an indication
     * of number.
     *
     * @param number Phone number.
     */
    public PhoneNumberImpl(String number) {
        this.number = number;
    }

    /**
     * Initializes a newly created {@code PhoneNumber} object with an indication
     * of number and owner.
     *
     * @param owner Owner of the phone number.
     * @param number Phone number.
     */
    public PhoneNumberImpl(Subscriber owner, String number) {
        this.owner = owner;
        this.number = number;
    }

    /**
     * Gets cost of calls on this phone number.
     *
     * @return cost of call.
     */
    @Override
    public int getCost() {
        return DEFAULT_COST;
    }

    /**
     * Gets list of calls from this phone number.
     *
     * @return List of in calls.
     */
    @Override
    public List<Call> getInCalls() {
        return inCalls;
    }

    /**
     * Gets phone number.
     *
     * @return Phone number.
     */
    @Override
    public String getNumber() {
        return number;
    }

    /**
     * Gets list of calls to this phone number.
     *
     * @return List of out calls.
     */
    @Override
    public List<Call> getOutCalls() {
        return outCalls;
    }

    /**
     * Gets owner of the phone number.
     *
     * @return Owner of the phone number.
     */
    @Override
    public Subscriber getOwner() {
        return owner;
    }

    /**
     * Sets owner of the phone number.
     *
     * @param owner Owner of the phone number.
     */
    @Override
    public void setOwner(Subscriber owner) {
        this.owner = owner;
    }

    @Override
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * Adds incoming call.
     *
     * @param inCall Incoming call.
     */
    @Override
    public void addInCall(Call inCall) {
        this.inCalls.add(inCall);
    }

    /**
     * Adds outcoming call.
     *
     * @param outCall Outcoming call.
     */
    @Override
    public void addOutCall(Call outCall) {
        this.outCalls.add(outCall);
    }

    @Override
    public String toString() {
        return number;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PhoneNumberImpl other = (PhoneNumberImpl) obj;
        if (!Objects.equals(this.number, other.number)) {
            return false;
        }
        return true;
    }
}
