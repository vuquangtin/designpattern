package designpatterns.lambdas.behavioral.iterators;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * <h1>Iterator</h1> Cung cấp một cách để truy xuất các thành phần của một đối
 * tượng tập hợp một cách tuần tự mà không cho thấy sự biểu diễn representation
 * bên dưới của nó. <br/>
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com

 *      /vuquangtin/designpattern</a>
 *
 */
public class IteratorGof {
	static final List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);

	public static void main(String[] args) {
		Iterator<Integer> iterator = list.iterator();

		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

		for (Integer i : list) {
			System.out.println(i);
		}
	}
}