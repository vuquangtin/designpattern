package designpatterns.gof.creational.builder.demo;


/**
 * <h1>Builder</h1> Tách rời việc xây dựng (khởi tạo) của một đối tượng phức tạp
 * khỏi phần biểu diễn của nó sao cho cùng 1 tiến trình xây dựng (khởi tạo) có
 * thể tạo ra các biểu diễn khác nhau.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class PersonFatBuilder extends PersonBuilder{
    @Override
    public void BuildHead() {
        System.out.println("画一个胖胖的头");
    }

    @Override
    public void BuildBody() {
        System.out.println("画一个胖胖的身体");
    }

    @Override
    public void BuildArmLeft() {
        System.out.println("画一个胖胖的左胳膊");
    }

    @Override
    public void BuildArmRight() {
        System.out.println("画一个胖胖的右胳膊");
    }

    @Override
    public void BuildLegLeft() {
        System.out.println("画一个胖胖的左腿");
    }

    @Override
    public void BuildLegRight() {
        System.out.println("画一个胖胖的右腿");
    }
}