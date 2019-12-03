package com.designpattern.dao;

import java.util.ArrayList;

public interface EmployeeDao {
	public ArrayList<Employee> getAllEmployees();

	public Employee getEmployee(int id);

	public void updateEmployee(Employee emp);

	public void deleteEmployee(Employee emp);
}