package designpatterns.gof.behavioral.strategy.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <h1>Strategy</h1> Định nghĩa tập hợp các thuật toán, đóng gói từng thuật toán
 * lại, và làm chúng hoán đổi lẫn nhau. Strategy cho phép thuật toán biến đổi
 * độc lập khi người dùng sử dụng chúng.
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com

 *      /vuquangtin/designpattern</a>
 *
 */
public class SortingAlgorithmStrategyDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Two contexts following different strategies

		SortedList studentRecords = new SortedList();
		studentRecords.add("Vicky");
		studentRecords.add("Richie");
		studentRecords.add("Sandra");
		studentRecords.add("Vivek");
		studentRecords.add("Anna");
		studentRecords.add("Ridhi");
		studentRecords.add("Dinesh");

		studentRecords.setSortStrategy(new QuickSort());
		studentRecords.sort();

		studentRecords.setSortStrategy(new ShellSort());
		studentRecords.sort();

		studentRecords.setSortStrategy(new MergeSort());
		studentRecords.sort();
	}
}

// / The 'Strategy' abstract class
abstract class SortStrategy {
	public abstract void sort(List<String> list);
}

// / A 'ConcreteStrategy' class
class QuickSort extends SortStrategy {
	@Override
	public void sort(List<String> list) {
		Collections.sort(list); // Default is Quicksort
		System.out.println("QuickSorted list ");
	}

}

// / A 'ConcreteStrategy' class
class ShellSort extends SortStrategy {
	@Override
	public void sort(List<String> list) {
		// list.ShellSort(); not-implemented
		System.out.println("Called ShellSorted list -- NOT YET IMPLEMENTED");
	}

}

// / A 'ConcreteStrategy' class
class MergeSort extends SortStrategy {
	@Override
	public void sort(List<String> list) {
		// list.MergeSort(); not-implemented
		System.out.println("Called MergeSorted list -- NOT YET IMPLEMENTED");
	}

}

// / The 'Context' class
class SortedList {

	private ArrayList<String> list = new ArrayList<String>();
	private SortStrategy _sortstrategy;

	public void setSortStrategy(SortStrategy sortstrategy) {
		this._sortstrategy = sortstrategy;
	}

	public void add(String name) {
		list.add(name);
	}

	public void sort() {
		_sortstrategy.sort(list);

		// Iterate over list and display results
		for (String name : list) {
			System.out.println(" " + name);

		}
	}
}