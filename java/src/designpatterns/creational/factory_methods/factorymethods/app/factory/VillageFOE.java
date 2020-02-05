package factorymethods.app.factory;

import app.abstractclass.Building;
import app.models.ChurchFOE;
import app.models.HouseFOE;
import app.models.MonumentFOE;
import app.models.SchoolFOE;
import app.models.TheatreFOE;
/**
 * <h1>Factory Method</h1>Cung cấp 1 giao diện để tạo ra đối tượng nhưng để lớp
 * con quyết định kiểu đối tượng nào sẽ dc tạo.
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com

 *      /vuquangtin/designpattern</a>
 *
 */
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
