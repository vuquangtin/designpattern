package abstractfactories.app.factory;


import app.abstractClass.Church;
import app.abstractClass.House;
import app.abstractClass.Monument;
import app.abstractClass.School;
import app.abstractClass.Theatre;



public abstract class VillageFactory {

	  public abstract Church createChurch();
	  
	  public abstract House createHouse();
	  
	  public abstract School createSchool();
	  
	  public abstract Theatre createTheatre();
	  
	  public abstract Monument createMonument();
	  
	  
	  
	 
	  
	  
	   
	  
}
