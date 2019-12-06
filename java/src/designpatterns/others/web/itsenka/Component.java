package web.itsenka;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public abstract class Component {
	public abstract String getName();

	protected abstract int sumValue();

	public void add(Component component) throws ComponentAddException {
		/**
		 * この「add」メソッドはサブクラスで実装されない(「Leaf」)可能性があるため、
		 * デフォルトの処理としては、例外を発生させるようにしておきます。
		 */
		throw new ComponentAddException();
	}

	protected abstract void printTree(String path);
}