package javacodegeeks.com.gkatzioura.design.structural.facade1;

import java.util.Date;
import java.util.List;

public interface TimeSeriesReport {

    List<TimeInformation> generate(Date start, Date end);

}
