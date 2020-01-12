package prototypes.objectcloning;
/**
 * <h1>Prototype</h1> Xác định các kiểu của các object (đối tượng) muốn tạo ra
 * bằng cách sử dụng một prototype (khuôn mẫu,nguyên mẫu), và tạo ra những
 * object (đối tượng) mới bằng cách sao chép prototype này.
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/designpattern">https://github.com
 *      /vuquangtin/designpattern</a>
 *
 */
public class ObjectCloningExample {
 
    public static void main(String[] args) {
 
        Student s1 = new Student(1, "GP Coder");
        Student s2 = s1;
        s1.show();
        s2.show();
 
        System.out.println("s1 and s2 are the same reference: ");
        System.out.println(s1);
        System.out.println(s2);
 
        System.out.println("After changed: ");
        s1.id = 4;
        s1.show();
        s2.show();
    }
}