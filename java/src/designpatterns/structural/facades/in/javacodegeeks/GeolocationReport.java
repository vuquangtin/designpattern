package in.javacodegeeks;

import java.util.List;

public interface GeolocationReport {

     List<LocationInformation> generate(Double lat, Double lng, Double distance);

}
