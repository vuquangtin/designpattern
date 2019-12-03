package javacodegeeks.com.gkatzioura.design.structural.facade1;

import java.util.List;

public interface GeolocationReport {

     List<LocationInformation> generate(Double lat, Double lng, Double distance);

}
