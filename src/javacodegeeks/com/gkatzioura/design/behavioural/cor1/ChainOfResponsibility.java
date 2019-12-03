package javacodegeeks.com.gkatzioura.design.behavioural.cor1;

public class ChainOfResponsibility {

    public static void main(String[] args) {
        StateRoadRoadIncidentHandler state = new StateRoadRoadIncidentHandler();
        MunicipalityRoadRoadIncidentHandler municipality = new MunicipalityRoadRoadIncidentHandler(state);
        TownRoadRoadIncidentHandler firstTown = new TownRoadRoadIncidentHandler(municipality);
        TownRoadRoadIncidentHandler secondTown = new TownRoadRoadIncidentHandler(state);

        RoadIncident roadIncident = new RoadIncident(0d,0d,"Something happened");
        firstTown.handle(roadIncident);
        secondTown.handle(roadIncident);
    }

}
