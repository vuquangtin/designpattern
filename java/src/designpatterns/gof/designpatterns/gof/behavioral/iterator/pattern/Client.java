package designpatterns.gof.behavioral.iterator.pattern;

/**
 * <h1>Iterator</h1> Cung cấp một cách để truy xuất các thành phần của một đối
 * tượng hợp nhất một cách tuần tự mà không cho thấy sự biểu diễn representation
 * bên dưới của nó. <br/>
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/designpattern">https://github.com
 *      /vuquangtin/designpattern</a>
 *
 */
public class Client {
    public static void main(String[] args) {
        String[] strings = {"a", "b", "c", "d"};
        Aggregate aggregate = new ConcreteAggregate(strings);
        Iterator iterator = aggregate.createIterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + ",");
        }
    }
}