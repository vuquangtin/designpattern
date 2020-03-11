package features.polymorphism;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * <h1>Command</h1> Đóng gói một yêu cầu request như một đối tượng, bằng cách đó
 * cho phép bạn tham số hóa các client với các request khác nhau, các queue và
 * log request, và hỗ trợ các hoạt động (operation) có thể “undo”.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/designpattern">https://github.com
 *      /vuquangtin/designpattern</a>
 *
 */
public class Test {
	public static void main(String[] polymorphism) {
		ListAction listAction = new ListAction();
		listAction.executeListActions(null);
	}
}
// Covariant return types in method overriding
// It’s possible to change the return type of an overridden method if it is
// a
// covariant type. A covariant type is basically a subclass of the return
// type.
// Consider an example:

abstract class JavaMascot2 {
	abstract JavaMascot2 getMascot();
}

class Duke2 extends JavaMascot2 {
	@Override
	Duke2 getMascot() {
		return new Duke2();
	}
}
// Because Duke is a JavaMascot, we are able to change the return type when
// overriding.

// Polymorphism with the core Java classes
// We use polymorphism all the time in the core Java classes. One very
// simple example is when we instantiate the ArrayList class declaring the
// List interface as a type:
//
//
// List<String> list = new ArrayList<>();
// To go further, consider this code sample using the Java Collections API
// without polymorphism:

class ListActionWithoutPolymorphism {
	// Example without polymorphism
	void executeVectorActions(Vector<Object> vector) {
		/* Code repetition here */}

	void executeArrayListActions(ArrayList<Object> arrayList) {
		/* Code repetition here */}

	void executeLinkedListActions(LinkedList<Object> linkedList) {
		/* Code repetition here */}

	void executeCopyOnWriteArrayListActions(CopyOnWriteArrayList<Object> copyOnWriteArrayList) {
		/* Code repetition here */}
}

class ListActionInvokerWithoutPolymorphism {
	public static void main(String... masterPolymorphism) {
		ListActionWithoutPolymorphism listAction = new ListActionWithoutPolymorphism();
		listAction.executeVectorActions(new Vector<>());
		listAction.executeArrayListActions(new ArrayList<>());
		listAction.executeLinkedListActions(new LinkedList<>());
		listAction.executeCopyOnWriteArrayListActions(new CopyOnWriteArrayList<>());
	}
}
// Ugly code, isn’t it? Imagine trying to maintain it! Now look at the same
// example with polymorphism:

class ListAction {
	void executeListActions(List<Object> list) {
		// Execute actions with different lists
	}
}

class ListActionInvoker {
	public static void main(String... masterPolymorphism) {
		ListAction listAction = new ListAction();
		listAction.executeListActions(new Vector<>());
		listAction.executeListActions(new ArrayList<>());
		listAction.executeListActions(new LinkedList<>());
		listAction.executeListActions(new CopyOnWriteArrayList<>());
	}
}

// The benefit
// of polymorphism
// is flexibility
// and extensibility.
// Instead of
// creating several
// different methods, we
// can declare
// just one
// method that
// receives the
// generic List type.