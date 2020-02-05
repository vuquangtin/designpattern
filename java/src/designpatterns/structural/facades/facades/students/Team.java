package facades.students;

import java.util.LinkedList;

/**
 * <h1>Facade</h1> Cung cấp một interface thống nhất cho một tập các interface
 * trong một hệ thống con (subsystem). Façade định nghĩa một interface mức cao
 * làm cho hệ thống con dễ dàng sử dụng hơn.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class Team {
	private String name;
	private LinkedList<Student> students = new LinkedList<Student>();
	private Course course;

	public Team(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setCourse(Course c) {
		course = c;
	}

	public Course getCourse() {
		return course;
	}

	public void addStudent(Student s) {
		students.add(s);
	}

	public LinkedList<Student> getStudents() {
		return students;
	}
}