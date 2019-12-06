package lazyloading.value_holder;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class ValueHolder {
	private Object value;
	private ValueLoader loader;

	public ValueHolder(ValueLoader loader) {
		this.loader = loader;
	}

	public Object getValue() {
		if (value == null)
			value = loader.load();
		return value;
	}
}