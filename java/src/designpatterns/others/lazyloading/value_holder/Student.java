package lazyloading.value_holder;

import java.util.List;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class Student extends DomainObject {
	private Long id;
	private ValueHolder courses;

	public Student(Long id) {
		this.setId(id);
	}

	@SuppressWarnings("unchecked")
	public List<Object> getCourses() {
		return (List<Object>) courses.getValue();
	}

	public void setCourses(ValueHolder courses) {
		this.courses = courses;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
