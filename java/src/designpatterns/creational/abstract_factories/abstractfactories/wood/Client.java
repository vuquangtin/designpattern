package abstractfactories.wood;
/**
 * <h1>Abstract Factory</h1> Cung cấp một interface để tạo ra 1 họ các object
 * (đối tượng) có liên quan hoặc phụ thuộc lẫn nhau mà không chỉ rõ các lớp cụ
 * thể của chúng (concrete classes)
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com

 *      /vuquangtin/designpattern</a>
 *
 */
public class Client {

   public static void main(String[] args) {

       FurnitureAbstractFactory factory = FurnitureFactory.getFactory(MaterialType.FLASTIC);

       Chair chair = factory.createChair();
       chair.create(); // Create plastic chair

       Table table = factory.createTable();
       table.create(); // Create plastic table
   }
}