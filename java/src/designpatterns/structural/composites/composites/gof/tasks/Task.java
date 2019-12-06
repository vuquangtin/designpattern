package composites.gof.tasks;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class Task extends TaskItem {
	String name;
	double time;

	public Task() {
	}

	public Task(String name, double time) {
		this.name = name;
		this.time = time;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public double getTime() {
		return time;
	}

	public void setTime(double time) {
		this.time = time;
	}
}