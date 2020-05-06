package designpatterns.gof.behavioral.iterator.demo;

import static junit.framework.Assert.assertFalse;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * <h1>Iterator</h1> Cung cấp một cách để truy xuất các thành phần của một đối
 * tượng hợp nhất một cách tuần tự mà không cho thấy sự biểu diễn representation
 * bên dưới của nó. <br/>
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/designpattern">https://github.com
 *      /vuquangtin/designpattern</a>
 *
 */
public class ClientTest {
	@Test
	public void should_iterator_has_next_return_false_when_given_invalid_aggregate() {
		Achievement[] achievements = new Achievement[0];
		AchievementReport achievementReport = new NorthAchievementReport(achievements);
		Iterator iterator = achievementReport.createIterator();
		assertFalse(iterator.hasNext());
	}

	@Test
	public void should_return_achievement_when_iterator_use_next() {
		Achievement[] achievements = new Achievement[1];
		Achievement achievement = new Achievement("上半年业绩", 20000);
		achievements[0] = achievement;
		AchievementReport achievementReport = new NorthAchievementReport(achievements);
		Iterator iterator = achievementReport.createIterator();
		Achievement actualAchievement = iterator.next();
		assertThat(actualAchievement, is(achievement));
	}

	@Test
	public void should_list_all_achievement_when_use_print() {
		Achievement[] achievements = new Achievement[2];
		achievements[0] = new Achievement("上半年业绩", 20000);
		achievements[1] = new Achievement("下半年业绩", 30000);

		AchievementReport achievementReport = new NorthAchievementReport(achievements);
		String report = achievementReport.print();
		assertThat(report, is("北区业绩报告:\n" + "名称 : 上半年业绩, 金额 : 20000\n" + "名称 : 下半年业绩, 金额 : 30000\n" + "总销售额 : 50000"));
	}
}