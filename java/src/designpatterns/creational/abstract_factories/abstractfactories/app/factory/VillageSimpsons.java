package abstractfactories.app.factory;

import app.abstractclass.Church;
import app.abstractclass.House;
import app.abstractclass.Monument;
import app.abstractclass.School;
import app.abstractclass.Theatre;
import app.models.ChurchSimpson;
import app.models.HouseSimpson;
import app.models.MonumentSimpson;
import app.models.SchoolSimpson;
import app.models.TheatreSimpson;


public class VillageSimpsons extends VillageFactory {

	@Override
	public Church createChurch() {
		// TODO Auto-generated method stub
		return new ChurchSimpson();
	}

	@Override
	public House createHouse() {
		// TODO Auto-generated method stub
		return new HouseSimpson();
	}

	@Override
	public Theatre createTheatre() {
		// TODO Auto-generated method stub
		return new TheatreSimpson();
	}

	@Override
	public Monument createMonument() {
		// TODO Auto-generated method stub
		return new MonumentSimpson();
	}

	@Override
	public School createSchool() {
		// TODO Auto-generated method stub
		return new SchoolSimpson();
	}	


}
