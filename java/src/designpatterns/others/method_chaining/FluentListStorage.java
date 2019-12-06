package method_chaining;

import java.util.ArrayList;
import java.util.List;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class FluentListStorage implements FluentStorage
{
	private List<Item> items;

	public FluentListStorage()
	{
		items = new ArrayList<Item>();
	}

	@Override
	public FluentStorage add(String name)
	{
		items.add(new Item(name.hashCode(), name));
		return this;
	}

	@Override
	public List<Item> toList()
	{
		return items;
	}

}
