package factorymethods.app.factory;

import app.abstractclass.Building;
import app.models.ChurchSimpson;
import app.models.HouseSimpson;
import app.models.MonumentSimpson;
import app.models.SchoolSimpson;
import app.models.TheatreSimpson;

/**
 * <h1>Factory Method</h1>Cung cấp 1 giao diện để tạo ra đối tượng nhưng để lớp
 * con quyết định kiểu đối tượng nào sẽ dc tạo.Factory Pattern giao việc khởi
 * tạo một đối tượng cụ thể cho lớp con.
 * 
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com

 *      /vuquangtin/designpattern</a>
 *
 */
public class VillageSimpson implements VillageFactory {

	@Override
	public Building createBuilding(String t) {

		if (t == "Church") {
			return new ChurchSimpson();
		}
		if (t == "House") {
			return new HouseSimpson();
		}
		if (t == "Monument") {
			return new MonumentSimpson();
		}
		if (t == "School") {
			return new SchoolSimpson();
		}
		if (t == "Theatre") {
			return new TheatreSimpson();
		}

		return null;

	}

}
