package javacodegeeks.com.gkatzioura.design.behavioural.cor1;

public interface RoadIncidentHandler {

    void handle(RoadIncident roadIncident);

    boolean withinBounds(double lat, double lng);

}
