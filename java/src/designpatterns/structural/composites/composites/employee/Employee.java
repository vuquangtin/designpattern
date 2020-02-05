package composites.employee;

import java.util.ArrayList;
import java.util.List;
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
public class Employee {
  private String name;
  private String dept;
  private int salary;
  private List<Employee> subordinates;

  // constructor
  public Employee(String name, String dept, int sal) {
    this.name = name;
    this.dept = dept;
    this.salary = sal;
    subordinates = new ArrayList<Employee>();
  }

  public void add(Employee e) {
    subordinates.add(e);
  }

  public void remove(Employee e) {
    subordinates.remove(e);
  }

  public List<Employee> getSubordinates() {
    return subordinates;
  }

  @Override
  public String toString() {
    return "Employee :[ Name : " + name + ", dept : " + dept + ", salary :" + salary + " ]";
  }
}
