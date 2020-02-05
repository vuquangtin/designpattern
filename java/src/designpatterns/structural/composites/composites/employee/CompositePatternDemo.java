package composites.employee;
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
public class CompositePatternDemo {
  public static void main(String[] args) {

    Employee CEO = new Employee("John", "CEO", 30000);

    Employee headSales = new Employee("Robert", "Head Sales", 20000);

    Employee headMarketing = new Employee("Michel", "Head Marketing", 20000);

    Employee clerk1 = new Employee("Laura", "Marketing", 10000);
    Employee clerk2 = new Employee("Bob", "Marketing", 10000);

    Employee salesExecutive1 = new Employee("Richard", "Sales", 10000);
    Employee salesExecutive2 = new Employee("Rob", "Sales", 10000);

    CEO.add(headSales);
    CEO.add(headMarketing);

    headSales.add(salesExecutive1);
    headSales.add(salesExecutive2);

    headMarketing.add(clerk1);
    headMarketing.add(clerk2);

    // print all employees of the organization
    System.out.println(CEO);

    for (Employee headEmployee : CEO.getSubordinates()) {
      System.out.println(headEmployee);

      for (Employee employee : headEmployee.getSubordinates()) {
        System.out.println(employee);
      }
    }
  }
}
