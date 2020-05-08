package designpatterns.gof.book.inline;

import java.util.Random;
import java.util.UUID;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * <h1>Decorator</h1> Gán bổ sung các “trách nhiệm” (responsibility) cho một đối
 * tượng một cách linh hoạt. Các decorator cung cấp một sự lựa chọn linh động
 * cho lớp con để mở rộng tính năng.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public final class RandomUtils extends RandomStringUtils {

	/**
	 * 随机产生布尔值
	 * 
	 * @return
	 */
	public static boolean nextBoolean() {
		int nextInt = utilities.RandomUtils.randInt(1, 100);
		if (nextInt % 2 == 0) {
			return true;
		} else {
			return false;
		}
	}

	public enum IdPattern {
		LowerCase, UpperCase
	}

	/**
	 * 返回随机的ID串，不指定时为小写
	 * 
	 * @param idPattern
	 *            ID的格式
	 * @return
	 */
	public static String nextId(IdPattern idPattern) {
		String result = UUID.randomUUID().toString().replaceAll("\\-", "");

		if (idPattern == null) {
			idPattern = IdPattern.LowerCase;
		}

		if (IdPattern.LowerCase.equals(idPattern)) {
			return result.toLowerCase();
		} else if (IdPattern.UpperCase.equals(idPattern)) {
			return result.toUpperCase();
		}

		return result;
	}

	/**
	 * 返回随机的ID串，不指定时为小写
	 * 
	 * @param idPattern
	 * @return
	 * @see #nextId(IdPattern)
	 */
	public static String nextUUID(IdPattern idPattern) {
		return nextId(idPattern);
	}

	public static int nextInt(int i, int levels) {
		// TODO Auto-generated method stub
		return utilities.RandomUtils.randInt(i, levels);
	}
}