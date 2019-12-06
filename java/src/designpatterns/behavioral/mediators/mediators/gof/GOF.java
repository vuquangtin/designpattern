package mediators.gof;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Design Patterns
 * 
 * @see http://www.itsenka.com/contents/development/designpattern/mediator.html
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class GOF {
	public static void main(String[] args) {
		Mediator mediator = new ConcreteMediator();
		Colleague colA = new ConcreteColleagueA("A");
		Colleague colB = new ConcreteColleagueB("B");
		mediator.addColleague(colA);
		mediator.addColleague(colB);
		colA.setMediator(mediator);
		colB.setMediator(mediator);
		colA.run();
		colB.run();
	}
}

abstract class Mediator {
	public abstract void addColleague(Colleague colleague);

	public abstract void consultation(Colleague colleague);
}

class ConcreteMediator extends Mediator {
	Map<String, Colleague> colleagues = new HashMap<String, Colleague>();

	public void addColleague(Colleague colleague) {
		colleagues.put(colleague.getName(), colleague);
	}

	public void consultation(Colleague colleague) {
		String name = colleague.getName();
		System.out.println(name + "からの相談です。");
		Iterator<String> it = colleagues.keySet().iterator();
		while (it.hasNext()) {
			Colleague colleagueTmp = (Colleague) colleagues.get(it.next());
			if (!(colleagueTmp.getName().equals(colleague.getName()))) {
				colleagueTmp.advice(name + "からの相談がありましたよ。");
			}
		}
	}
}

abstract class Colleague {
	protected Mediator mediator;
	private String name;

	public Colleague(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setMediator(Mediator mediator) {
		this.mediator = mediator;
	}

	public abstract void advice(String msg);

	public abstract void run();
}

class ConcreteColleagueA extends Colleague {
	public ConcreteColleagueA(String name) {
		super(name);
	}

	public void run() {
		mediator.consultation(this);
	}

	public void advice(String msg) {
		System.out.println("ConcreteColleagueA:" + msg);
	}
}

class ConcreteColleagueB extends Colleague {
	public ConcreteColleagueB(String name) {
		super(name);
	}

	public void run() {
		mediator.consultation(this);
	}

	public void advice(String msg) {
		System.out.println("ConcreteColleagueB:" + msg);
	}
}