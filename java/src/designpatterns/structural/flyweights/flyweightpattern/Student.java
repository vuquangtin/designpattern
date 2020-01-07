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
public class Student {
	String name;
	int id;
	int score;
	double averageScore;

	public Student(double a) {
		averageScore = a;
	}

	public void setName(String n) {
		this.name = n;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public int getScore() {
		return score;
	}

	public double getStanding() {
		return (((double) score / averageScore - 1.0) * 100.0);
	}
}