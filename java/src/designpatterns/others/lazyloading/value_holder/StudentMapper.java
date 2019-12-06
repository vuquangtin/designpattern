package lazyloading.value_holder;

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
public class StudentMapper {

	protected DomainObject doLoad(Long id) {
		Student student = new Student(id);
		student.setCourses(new ValueHolder(new CourseLoader(id)));
		return student;
	}

	public static class CourseLoader implements ValueLoader {
		private Long id;

		public CourseLoader(Long id) {
			this.setId(id);
		}

		public Object load() {
			// Return dummy empty list
			return new ArrayList<Object>(2);
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}
	}
}
