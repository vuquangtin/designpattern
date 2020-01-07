package iterators.tests;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>Iterator</h1> Cung cấp một cách để truy xuất các thành phần của một đối
 * tượng tập hợp một cách tuần tự mà không cho thấy sự biểu diễn representation
 * bên dưới của nó. <br/>
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/designpattern">https://github.com
 *      /vuquangtin/designpattern</a>
 *
 */
public class IteratorImp<T> implements Iterator<T> {

	private List<T> mTList = new ArrayList<>();

	private int cursor = 0;

	public IteratorImp(List<T> mTList) {
		this.mTList = mTList;
	}

	@Override
	public boolean hasNext() {
		return !(cursor > mTList.size() - 1 || mTList.get(cursor) != null);
	}

	@Override
	public T next() {
		T obj = null;
		if (this.hasNext()) {
			obj = this.mTList.get(cursor++);
		}
		return obj;
	}
}