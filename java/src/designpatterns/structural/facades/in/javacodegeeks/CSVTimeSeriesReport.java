package in.javacodegeeks;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <h1>Facade</h1> Cung cấp một interface thống nhất cho một tập các interface
 * trong một hệ thống con (subsystem). Façade định nghĩa một interface mức cao
 * làm cho hệ thống con dễ dàng sử dụng hơn.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class CSVTimeSeriesReport implements TimeSeriesReport {

	@Override
	public List<TimeInformation> generate(Date start, Date end) {

		/**
		 * retrieve the csv and iterate line by line with the time limits
		 */

		return new ArrayList<>();
	}
}
