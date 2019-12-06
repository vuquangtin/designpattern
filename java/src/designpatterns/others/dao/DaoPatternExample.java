package dao;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class DaoPatternExample {
	public static void main(String[] args) {
		EmployeeDao empDao = new EmployeeDaoImpl();

		// Hiển thị tất cả
		for (Employee e : empDao.getAllEmployees()) {
			System.out.println("Nhan vien: [ID : " + e.getId() + ", Ten : "
					+ e.getName() + "]");
		}

		// Cập nhật
		Employee e = empDao.getAllEmployees().get(0);
		e.setName("Nguyễn Văn Xuân");
		empDao.updateEmployee(e);

		// Hiển thị
		e = empDao.getEmployee(0);
		System.out.println("Nhan vien: [ID : " + e.getId() + ", Ten : "
				+ e.getName() + "]");
	}
}