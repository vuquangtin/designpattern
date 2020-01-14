package abstractfactories.app.factory;


import app.abstractclass.Church;
import app.abstractclass.House;
import app.abstractclass.Monument;
import app.abstractclass.School;
import app.abstractclass.Theatre;



public abstract class VillageFactory {

	  public abstract Church createChurch();
	  
	  public abstract House createHouse();
	  
	  public abstract School createSchool();
	  
	  public abstract Theatre createTheatre();
	  
	  public abstract Monument createMonument();
	  
	  
	  
	 
	  
	  
	   
	  
}
