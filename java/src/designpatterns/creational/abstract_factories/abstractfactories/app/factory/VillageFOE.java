package abstractfactories.app.factory;

import app.abstractclass.Church;
import app.abstractclass.House;
import app.abstractclass.Monument;
import app.abstractclass.School;
import app.abstractclass.Theatre;
import app.models.ChurchFOE;
import app.models.HouseFOE;
import app.models.MonumentFOE;
import app.models.SchoolFOE;
import app.models.TheatreFOE;

/**
 * <h1>Abstract Factory</h1> Cung cấp một interface để tạo ra 1 họ các object
 * (đối tượng) có liên quan hoặc phụ thuộc lẫn nhau mà không chỉ rõ các lớp cụ
 * thể của chúng (concrete classes)
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com

 *      /vuquangtin/designpattern</a>
 *
 */
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
		return new SchoolFOE();
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
