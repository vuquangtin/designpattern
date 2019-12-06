package abstractfactories.wood;
/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
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