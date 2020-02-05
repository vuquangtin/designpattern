package in.javacodegeeks;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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
public class UserUsageFacadeImpl implements UserUsageFacade {

	private final GeolocationReport geolocationReport;
	private final TimeSeriesReport timeSeriesReport;
	private final UsageReport usageReport;

	private final double DEFAULT_DISTANCE = 20d;
	private final int DEFAULT_TIME_RANGE = 20;

	public UserUsageFacadeImpl(GeolocationReport geolocationReport,
			TimeSeriesReport timeSeriesReport, UsageReport usageReport) {
		this.geolocationReport = geolocationReport;
		this.timeSeriesReport = timeSeriesReport;
		this.usageReport = usageReport;
	}

	@Override
	public List<UserUsage> usageOn(UUID user, Date from, Double lat, Double lng) {

		List<LocationInformation> locationInformationData = geolocationReport
				.generate(lat, lng, DEFAULT_DISTANCE);
		Date to = Date.from(from.toInstant().plusSeconds(DEFAULT_TIME_RANGE));
		List<TimeInformation> timeSetiesData = timeSeriesReport.generate(from,
				to);
		List<Usage> usageData = usageReport.report(user);
		System.out.println(locationInformationData);
		System.out.println(timeSetiesData);
		System.out.println(usageData);
		/**
		 * Generate the report based on the data retrieved
		 */

		return new ArrayList<>();
	}
}
