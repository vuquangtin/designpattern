package facades.students;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Vector;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class Facade {
	private static HashMap<String,Team> teams = new HashMap<String,Team> ();

	public static void buildCampus() {
		Campus.setCourse(1000, "Operating System");
		Campus.setCourse(2000, "Core Java");
		Campus.setStudent(100, "Bill Gates");
		Campus.setStudent(101, "James Gosling");
		Campus.setStudent(102, "Linus Tovarld");
	}

	public static void buildTeam(String tName, int courseCode) {
		Team aTeam = new Team(tName);
		aTeam.setCourse(Campus.getCourse(courseCode));
		teams.put(tName, aTeam);
	}

	public void enroll(int studentCode, String tName) {
		Student regStudent = Campus.getStudent(studentCode);
		Team aTeam = (Team) teams.get(tName);
		aTeam.addStudent(regStudent);
	}

	public Collection<String> display(String tName) {
		Vector<String> result = new Vector<String>();
		Team aTeam = (Team) teams.get(tName);

		result.addElement(aTeam.getName());
		result.addElement(aTeam.getCourse().getName());
		LinkedList<Student> students = aTeam.getStudents();
		for (int i = 0; i < students.size(); ++i) {
			result.addElement(((Student) students.get(i)).getName());
		}
		return result;
	}
}