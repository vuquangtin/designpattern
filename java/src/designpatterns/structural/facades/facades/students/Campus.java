package facades.students;

import java.util.HashMap;


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
public class Campus {
	private static HashMap<Integer, Student> students = new HashMap<Integer, Student>();
	private static HashMap<Integer, Course> courses = new HashMap<Integer, Course>();

	public Campus() {
	}

	public static void setStudent(int sCode, String sName) {
		students.put(new Integer(sCode), new Student(sCode, sName));
	}

	public static Student getStudent(int sCode) {
		return (Student) students.get(new Integer(sCode));
	}

	public static void setCourse(int cCode, String cName) {
		courses.put(new Integer(cCode), new Course(cCode, cName));
	}

	public static Course getCourse(int cCode) {
		return (Course) courses.get(new Integer(cCode));
	}
}