package abstractfactories.app.factory;


import app.abstractClass.Church;
import app.abstractClass.House;
import app.abstractClass.Monument;
import app.abstractClass.School;
import app.abstractClass.Theatre;
import app.models.ChurchFOE;
import app.models.HouseFOE;
import app.models.MonumentFOE;
import app.models.SchoolFOE;
import app.models.TheatreFOE;

public class VillageFOE extends VillageFactory {

	@Override
	public Church createChurch() {
		// TODO Auto-generated method stub
		return new ChurchFOE();
	}

	@Override
	public House createHouse() {
		// TODO Auto-generated method stub
		return new HouseFOE();
	}

	@Override
	public School createSchool() {
		// TODO Auto-generated method stub
		return  new SchoolFOE();
	}

	@Override
	public Theatre createTheatre() {
		// TODO Auto-generated method stub
		return new TheatreFOE();
	}

	@Override
	public Monument createMonument() {
		// TODO Auto-generated method stub
		return new MonumentFOE();
	}

	
	}


