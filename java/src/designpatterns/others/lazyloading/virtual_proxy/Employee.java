package lazyloading.virtual_proxy;
/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class Employee { 
    private String employeeName; 
  
    private double employeeSalary; 
    private String employeeDesignation; 
  
    public Employee(String employeeName, 
             double employeeSalary, String employeeDesignation) 
    { 
        this.employeeName = employeeName; 
        this.employeeSalary = employeeSalary; 
        this.employeeDesignation = employeeDesignation; 
    } 
    public String getEmployeeName() 
    { 
        return employeeName; 
    } 
    public double getEmployeeSalary() 
    { 
        return employeeSalary; 
    } 
    public String getEmployeeDesignation() 
    { 
        return employeeDesignation; 
    } 
    public String toString() 
    { 
        return "Employee Name: " + employeeName + ",EmployeeDesignation : " + employeeDesignation + ",Employee Salary : " + employeeSalary; 
    } 
} 
  