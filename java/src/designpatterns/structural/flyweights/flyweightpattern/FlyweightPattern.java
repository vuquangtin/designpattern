package flyweightpattern;

/**
 * <h1>Flyweight</h1> Sử dụng việc chia sẻ để hỗ trợ số lượng lớn các đối tượng
 * fine-graied cỡ nhỏ 1 cách hiệu quả
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com

 *      /vuquangtin/designpattern</a>
 *
 */
public class FlyweightPattern {

	public static void main(String[] args) {

		String name[] = { "qt", "vqt", "quangtin" };
		int id[] = { 1001, 1002, 1003 };
		int score[] = { 45, 76, 87 };

		double total = 0;
		for (int i = 0; i < score.length; i++) {
			total += score[i];
		}

		double averageScore = total / score.length;
		// way: 1
		// Student student = new Student(averageScore);
		// way: 2
		StudentThreaded student = StudentThreaded.getInstance();
		student.setAverageScore(averageScore);

		for (int i = 0; i < score.length; i++) {
			student.setName(name[i]);
			student.setId(id[i]);
			student.setScore(score[i]);

			System.out.println("Name: " + student.getName());
			System.out
					.println("Standing: " + Math.round(student.getStanding()));
			System.out.println("");
		}
	}
}