package factorymethods.products;

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
// Empty vocabulary of actual object
interface IPerson {
	String GetName();
}

class Villager implements IPerson {
	public String GetName() {
		return "Village Person";
	}
}

class CityPerson implements IPerson {
	public String GetName() {
		return "City Person";
	}
}

enum PersonType {
	Rural, Urban
}

// / <summary>
// / Implementation of Factory - Used to create objects
// / </summary>
public class FactoryMethod {
	public IPerson GetPerson(PersonType type) throws NotSupportedException {
		switch (type) {
		case Rural:
			return new Villager();
		case Urban:
			return new CityPerson();
		default:
			throw new NotSupportedException();
		}
	}
}

/*
 * Almost same as Factory, just an additional exposure to do something with the
 * created method
 */
abstract class PersonAbstractFactory {
	protected abstract IPerson makePerson();

	public IPerson getObject() // Implementation of Factory Method.
	{
		return this.makePerson();
	}
}

class CityPersonConcreteFactory extends PersonAbstractFactory {
	protected IPerson makePerson() {
		CityPerson item = new CityPerson();
		// Do something with the object after you get the object.
		// product.SetPrice(20.30);
		return item;
	}
}