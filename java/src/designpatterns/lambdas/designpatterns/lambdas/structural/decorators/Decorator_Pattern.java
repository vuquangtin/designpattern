package designpatterns.lambdas.structural.decorators;

import java.util.function.Function;

/**
 * <h1>Decorator</h1> Gán bổ sung các “trách nhiệm” (responsibility) cho một đối
 * tượng một cách linh hoạt. Các decorator cung cấp một sự lựa chọn linh động
 * cho lớp con để mở rộng tính năng.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com

 *      /vuquangtin/designpattern</a>
 *
 */
public class Decorator_Pattern 
{
	// here Function is an interface.
	public static void doWork(int value, Function<Integer, Integer> func)
	{
		System.out.println(func.apply(value));
	}

	public static void main(String[] args) 
	{
		Function<Integer, Integer> inc = e->e+1;
		Function<Integer, Integer> doubleIt= e-> e*2;
		
		doWork(5, inc);
		doWork(5, doubleIt);
//		//increment & double using temp variable don't do like this
//		int temp =inc.apply(5);
//		System.out.println(doubleIt.apply(temp));		
		doWork(5, inc.andThen(doubleIt));
		
		
		

	}

}