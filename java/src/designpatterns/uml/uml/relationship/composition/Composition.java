package uml.relationship.composition;

/**
 * <h1>Composition</h1> Composition đề cập đến trường hợp khi một đối tượng (obj1)
 * tồn tại phụ thuộc vào sự tồn tại của một đối tượng khác(obj2). Có nghĩa rằng,
 * nếu đối tượng được phụ thuộc obj2 tồn tại thì đối tượng obj1 mới có thể tồn
 * tại..
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/designpattern">https://github.com
 * 
 *      /vuquangtin/designpattern</a>
 *
 */
public class Composition {
	public class Job {
		private String role;
		private long salary;
		private int id;

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}

		public long getSalary() {
			return salary;
		}

		public void setSalary(long salary) {
			this.salary = salary;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}
	}

	public class Person {
		// composition has-a relationship
		private Job job;

		public Person() {
			this.job = new Job();
			job.setSalary(1000L);
		}

		public long getSalary() {
			return job.getSalary();
		}
	}
}
