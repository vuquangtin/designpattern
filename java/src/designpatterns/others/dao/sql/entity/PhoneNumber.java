package dao.sql.entity;

import java.util.List;

import dao.sql.persistence.SettingsManager;

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
public interface PhoneNumber extends AbstractEntity {

    public static int DEFAULT_COST = SettingsManager.getSettings().getTariff();

    /**
     * Gets cost of calls on this phone number.
     *
     * @return cost of call.
     */
    public int getCost();

    /**
     * Gets list of calls from this phone number.
     *
     * @return List of in calls.
     */
    public List<Call> getInCalls();

    /**
     * Gets phone number.
     *
     * @return Phone number.
     */
    public String getNumber();

    /**
     * Gets list of calls to this phone number.
     *
     * @return List of out calls.
     */
    public List<Call> getOutCalls();

    /**
     * Gets owner of the phone number.
     *
     * @return Owner of the phone number.
     */
    public Subscriber getOwner();

    /**
     * Sets owner of the phone number.
     *
     * @param owner Owner of the phone number.
     */
    public void setOwner(Subscriber owner);

    /**
     * Sets phone number.
     *
     * @param Phone number.
     */
    public void setNumber(String number);

    /**
     * Adds incoming call.
     *
     * @param inCall Incoming call.
     */
    public void addInCall(Call inCall);

    /**
     * Adds outcoming call.
     *
     * @param outCall Outcoming call.
     */
    public void addOutCall(Call outCall);
}
