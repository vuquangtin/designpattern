package designpatterns.gof.behavioral.iterator.demo;

/**
 * <h1>Iterator</h1> Cung cấp một cách để truy xuất các thành phần của một đối
 * tượng tập hợp một cách tuần tự mà không cho thấy sự biểu diễn representation
 * bên dưới của nó. <br/>
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/designpattern">https://github.com
 *      /vuquangtin/designpattern</a>
 *
 */
public class NorthAchievementReport implements AchievementReport {
	private Achievement[] achievements;

	public NorthAchievementReport(Achievement[] achievements) {
		this.achievements = achievements;
	}

	@Override
	public Iterator createIterator() {
		return new AchievementReportIterator(this);
	}

	@Override
	public int size() {
		return achievements.length;
	}

	@Override
	public Achievement get(int index) {
		if (0 <= index && index < achievements.length) {
			return achievements[index];
		}
		return null;
	}

	@Override
	public String print() {
		StringBuilder report = new StringBuilder();
		report.append("北区业绩报告:\n");
		Iterator iterator = createIterator();
		int totalAmount = 0;
		while (iterator.hasNext()) {
			Achievement achievement = iterator.next();
			report.append("名称 : ").append(achievement.getName()).append(", 金额 : ").append(achievement.getAmount())
					.append("\n");
			totalAmount += achievement.getAmount();
		}
		report.append("总销售额 : ").append(totalAmount);
		return report.toString();
	}
}