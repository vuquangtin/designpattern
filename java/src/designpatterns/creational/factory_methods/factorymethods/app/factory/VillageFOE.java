package factorymethods.app.factory;

import app.abstractclass.Building;
import app.models.ChurchFOE;
import app.models.HouseFOE;
import app.models.MonumentFOE;
import app.models.SchoolFOE;
import app.models.TheatreFOE;

public class VillageFOE implements VillageFactory {

	@Override
	public Building createBuilding(String t) {
		
		if(t=="Church") {
			return new ChurchFOE();
		}
		if(t=="House") {
			return new HouseFOE();
		}
		if(t=="Monument") {
			return new MonumentFOE();
		}
		if(t=="School") {
			return new SchoolFOE();
		}
		if(t=="Theatre") {
			return new TheatreFOE();
		}

		return null;
		
	}

}
