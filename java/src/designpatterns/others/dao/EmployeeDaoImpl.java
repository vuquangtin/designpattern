package dao;

import java.util.ArrayList;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class EmployeeDaoImpl implements EmployeeDao {
	ArrayList<Employee> alEmp;

	public EmployeeDaoImpl() {
		alEmp = new ArrayList<Employee>();
		Employee e1 = new Employee(1, "Xuân");
		Employee e2 = new Employee(2, "Hạ");
		alEmp.add(e1);
		alEmp.add(e2);
	}

	@Override
	public void deleteEmployee(Employee e) {
		alEmp.remove(e.getId());
		System.out.println("Nhan vien co ID " + e.getId() + "da bi xoa");
	}

	@Override
	public ArrayList<Employee> getAllEmployees() {
		return alEmp;
	}

	@Override
	public Employee getEmployee(int id) {
		return alEmp.get(id);
	}

	@Override
	public void updateEmployee(Employee e) {
		alEmp.get(e.getId()).setName(e.getName());
		System.out
				.println("Nhan vien co ID " + e.getId() + " da duoc cap nhat");
	}

}
