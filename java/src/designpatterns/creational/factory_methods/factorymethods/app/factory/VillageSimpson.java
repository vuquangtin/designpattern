package factorymethods.app.factory;

import app.abstractclass.Building;
import app.models.ChurchSimpson;
import app.models.HouseSimpson;
import app.models.MonumentSimpson;
import app.models.SchoolSimpson;
import app.models.TheatreSimpson;

public class VillageSimpson implements VillageFactory {

	@Override
	public Building createBuilding(String t) {
		
		if(t=="Church") {
			return new ChurchSimpson();
		}
		if(t=="House") {
			return new HouseSimpson();
		}
		if(t=="Monument") {
			return new MonumentSimpson();
		}
		if(t=="School") {
			return new SchoolSimpson();
		}
		if(t=="Theatre") {
			return new TheatreSimpson();
		}

		return null;
		
	}

}
