package designpatterns.gof.behavioral.visitor.inline;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * <h1>Visitor</h1>Diễn tả 1 hoạt động (thao tác, thuật toán) được thực hiện
 * trên các phần tử của 1 cấu trúc đối tượng. Visitor cho phép bạn định nghĩa 1
 * phép toán mới mà không thay đổi các lớp của các phần tử mà nó thao tác
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class PizzaVisitorTest {
	public static void main(String[] args) {
		List pizzaList = new ArrayList();
		pizzaList.add(new PapaJohn());
		pizzaList.add(new PizzaHut());
		pizzaList.add(new CPK());
		Iterator it = pizzaList.iterator();
		System.out.println("How many pizza restaurants in this area?");
		while (it.hasNext()) {
			System.out.println(((Pizza) it.next()).order());
		}
		Dinner d = new Dinner();
		Pizza pza = d.getDinner();
		PizzaVisitor v = d.howto();
		v.visit(pza);
		System.out.println("\nWhich store for dinner?");
		System.out.println(v);
	}
}

interface PizzaVisitor {
	public void visit(Pizza p);
}

interface Pizza {
	public String order();
}

class PapaJohn implements Pizza {
	final String name = "PapaJohn";

	public String order() {
		return name;
	}
}

class PizzaHut implements Pizza {
	final String name = "PizzaHut";

	public String order() {
		return name;
	}
}

class CPK implements Pizza {
	final String name = "CPK";

	public String order() {
		return name;
	}
}

class ByPickup implements PizzaVisitor {
	private String name;
	private final String method = "By pick up";

	public void visit(Pizza p) {
		name = p.order();
	}

	public String toString() {
		return name + " " + method;
	}
}

class InTheRestaurant implements PizzaVisitor {
	private String name;
	private final String method = "By eat in";

	public void visit(Pizza p) {
		name = p.order();
	}

	public String toString() {
		return name + " " + method;
	}
}

class ByDelivery implements PizzaVisitor {
	private String name;
	private final String method = "By delivery";

	public void visit(Pizza p) {
		name = p.order();
	}

	public String toString() {
		return name + " " + method;
	}
}

class Dinner {
	public Pizza getDinner() {
		switch ((int) (Math.random() * 3)) {
		case 0:
			return new PapaJohn();
		case 1:
			return new PizzaHut();
		case 2:
			return new CPK();
		default:
			return null;
		}
	}

	public PizzaVisitor howto() {
		switch ((int) (Math.random() * 3)) {
		case 0:
			return new ByPickup();
		case 1:
			return new InTheRestaurant();
		case 2:
			return new ByDelivery();
		default:
			return null;
		}
	}
}