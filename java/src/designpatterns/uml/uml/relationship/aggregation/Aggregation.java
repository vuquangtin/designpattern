package uml.relationship.aggregation;

/**
 * <h1>Aggregation</h1> Aggregation là mối quan hệ mà ở đó thực thể có thể tồn
 * tại độc lập với các lớp khác. Ví dụ: một người nào đó có thể thuộc một công
 * ty hoặc không thuộc một công ty, người đó vẫn có thể tồn tại độc lập, có
 * nghĩa là họ không làm cho một công ty bất kỳ..
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/designpattern">https://github.com
 * 
 *      /vuquangtin/designpattern</a>
 *
 */
public class Aggregation {
	public class Subject {
		private String name;

		public void setName(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}
	}

	public class Student {
		private Subject[] studyAreas = new Subject[10];
		// the rest of the Student class
	}
}
