package in.javacodegeeks;

import java.util.Collections;
/**
 * <h1>Composite</h1> Các đối tượng cấu thành các cấu trúc cây để mô tả bán toàn
 * bộ hệ thống phần cấp. Composite để cho các client tác động các đối tượng
 * riêng biệt và các thành phần của đối tượng một cách thống nhất.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class CompositeScenario {

    public static void main(String[] args) {

        Private ryan = new Private();
        Lieutenant lieutenant = new Lieutenant(Collections.singletonList(ryan));
        Major major = new Major(Collections.singletonList(lieutenant));
        General general = new General();
        general.assignOrder(major);
    }
}
