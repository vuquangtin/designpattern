package iterators.tests;

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
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/21.
 */
public class AggregateImp<T> implements Aggregate<T> {
	private List<T> mTList = new ArrayList<>();

	@Override
	public void add(T mO) {

		mTList.add(mO);
	}

	@Override
	public void delete(T mO) {
		mTList.remove(mO);
	}

	@Override
	public Iterator<T> iterator() {
		return new IteratorImp<T>(mTList);
	}
}