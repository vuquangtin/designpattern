package utilities;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

/**
 *
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 */
public class RangeUtils {
	static Logger logger = Logger.getLogger(RangeUtils.class.getName());

	public static List<Long> range(long size, int n) {
		int diff = (int) size / n;
		return range(size, n, diff);
	}

	public static List<Long> range(long size, int n, int diff) {
		List<Long> list = new ArrayList<Long>();
		// int diff = (int)size / n;
		long value = 0;
		list.add(value);
		for (int i = 1; i <= n; i++) {
			value = value + diff;
			list.add(value);

		}
		if (value < size)
			list.add(size);
		return list;
	}

	public static void main(String[] args) {
		List<Long> list = RangeUtils.range(4503, 10, 4503 / 10);
		for (Long item : list) {
			System.out.println(item);
		}
	}
}
