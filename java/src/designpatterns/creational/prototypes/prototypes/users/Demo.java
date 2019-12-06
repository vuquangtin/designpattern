package prototypes.users;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class Demo {
	public static void main(String[] args) {
		Address address = new Address("Ha Noi", "Ha Dong", "Nguyen Trai");
		User originalUser = new User("firstName", "lastName", "stackjava",
				"abc@gmail.com", address);
		User userShallowCopy = originalUser.shallowCopy();
		User userDeepCopy = originalUser.deepCopy();

		System.out.println("Before change address:");
		System.out.println("original user: " + originalUser);
		System.out.println("shallow user: " + userShallowCopy);
		System.out.println("deep user: " + userDeepCopy);
		System.out.println("-----------------------------------");
		System.out.println("After shallow user change address:");
		userShallowCopy.getAddress().setDistrict("Thanh Xuan");
		System.out.println("original user: " + originalUser);
		System.out.println("shallow user: " + userShallowCopy);
		System.out.println("deep user: " + userDeepCopy);
		System.out.println("-----------------------------------");
		System.out.println("After deep user change address:");
		userDeepCopy.getAddress().setDistrict("Cau Giay");
		System.out.println("original user: " + originalUser);
		System.out.println("shallow user: " + userShallowCopy);
		System.out.println("deep user: " + userDeepCopy);
	}
}
