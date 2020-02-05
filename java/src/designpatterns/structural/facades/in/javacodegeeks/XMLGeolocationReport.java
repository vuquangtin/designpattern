package in.javacodegeeks;

import java.util.ArrayList;
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
public class XMLGeolocationReport implements GeolocationReport {

    @Override
    public List<LocationInformation> generate(Double lat, Double lng, Double distance) {

        /**
         * http requests to retrieve the xml
         * iterate the xml using stax
        */

        return new ArrayList<>();
    }

}
