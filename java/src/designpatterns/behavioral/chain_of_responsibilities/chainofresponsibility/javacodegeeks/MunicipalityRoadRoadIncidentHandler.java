package chainofresponsibility.javacodegeeks;

/**
 * <h1>Chain of Responsability</h1> Tránh sự liên kết trực tiếp giữa đối tượng
 * gửi yêu cầu và đối tượng nhận yêu cầu, khi yêu cầu có thể dc sử lý bởi hơn 1
 * đối tượng. móc nối các đối tượng nhận yêu cầu thành 1 chuỗi và gửi yêu cầu
 * theo chuỗi đó cho đến khi có đối tượng xử lý nó.
 * 
 * @see http://www.itsenka.com/contents/development/designpattern/observer.html
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class MunicipalityRoadRoadIncidentHandler implements RoadIncidentHandler {

	private final RoadIncidentHandler successor;

	public MunicipalityRoadRoadIncidentHandler(
			final RoadIncidentHandler successor) {
		this.successor = successor;
	}

	@Override
	public void handle(RoadIncident roadIncident) {
		if (!withinBounds(roadIncident.getLatitude(),
				roadIncident.getLongtitude())) {
			successor.handle(roadIncident);
		} else {
			/**
			 * Handle the incident
			 */
		}
	}

	@Override
	public boolean withinBounds(double lat, double lng) {
		/**
		 * Reverse geolocation, look up by name, radius based distance etc.
		 */
		return false;
	}
}
