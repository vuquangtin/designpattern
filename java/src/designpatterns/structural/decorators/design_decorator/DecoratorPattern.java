package design_decorator;

/**
 * <h1>Decorator</h1> Gán bổ sung các “trách nhiệm” (responsibility) cho một đối
 * tượng một cách linh hoạt. Các decorator cung cấp một sự lựa chọn linh động
 * cho lớp con để mở rộng tính năng <br/>
 * Decorator design pattern is used to modify the functionality of an object at
 * runtime. At the same time other instances of the same class will not be
 * affected by this, so individual object gets the modified behavior. <br/>
 * Suppose we want to implement different kinds of cars – we can create
 * interface Car to define the assemble method and then we can have a Basic car,
 * further more we can extend it to Sports car and Luxury Car. But if we want to
 * get a car at runtime that has both the features of sports car and luxury car,
 * then the implementation gets complex and if further more we want to specify
 * which features should be added first, it gets even more complex. Now image if
 * we have ten different kind of cars, the implementation logic using
 * inheritance and composition will be impossible to manage. To solve this kind
 * of programming situation, we apply decorator pattern. <br/>
 * Notice that client program can create different kinds of Object at runtime
 * and they can specify the order of execution too. <br/>
 * Important Points:
 * <ul>
 * <li>
 * Decorator pattern is helpful in providing runtime modification abilities and
 * hence more flexible. It’s easy to maintain and extend when the number of
 * choices are more.</li>
 * <li>
 * The disadvantage of decorator pattern is that it uses a lot of similar kind
 * of objects (decorators).</li>
 * <li>
 * Decorator pattern is used a lot in Java IO classes, such as FileReader,
 * BufferedReader etc.</li>
 * <ul/>
 * <br/>
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class DecoratorPattern {

	public static void main(String[] args) {
		Car sportsCar = new SportsCar(new BasicCar());
		sportsCar.assemble();
		System.out.println();
		Car sportsLuxuryCar = new SportsCar(new LuxuryCar(new BasicCar()));
		sportsLuxuryCar.assemble();
	}

}