package chainofresponsibility.javacodegeeks;

public interface RoadIncidentHandler {

    void handle(RoadIncident roadIncident);

    boolean withinBounds(double lat, double lng);

}
