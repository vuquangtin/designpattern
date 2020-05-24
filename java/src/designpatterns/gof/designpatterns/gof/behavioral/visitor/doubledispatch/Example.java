package designpatterns.gof.behavioral.visitor.doubledispatch;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/designpattern">https://github.com
 * 
 *      /vuquangtin/designpattern</a>
 *
 */
public class Example {
	static class DD {
		void dispatch(Component com) {
			System.out.println("dispatch in Component");
			com.message();
		}

		void dispatch(ComponentA com) {
			System.out.println("dispatch in A");
			com.message();
		}

		void dispatch(ComponentB com) {
			System.out.println("dispatch in B");
			com.message();
		}
	}

	interface Component {
		void message();

		void accept(DD dd);
	}

	static class ComponentA implements Component {

		@Override
		public void message() {
			System.out.println("call in A");

		}

		@Override
		public void accept(DD dd) {
			dd.dispatch(this);

		}

	}

	static class ComponentB implements Component {

		@Override
		public void message() {
			System.out.println("call in B");

		}

		@Override
		public void accept(DD dd) {
			dd.dispatch(this);

		}

	}

	static class ObjectStruture {
		List<Component> list = new ArrayList<>();

		void add(Component com) {
			list.add(com);
		}

		void dd(DD dispatch) {
			for (Component component : list) {
				component.accept(dispatch);

			}
		}

		void callError(Component com) {
			new DD().dispatch(com);
		}

		void callError(ComponentA com) {
			new DD().dispatch(com);
		}
	}

	public static void main(String[] args) {
		ObjectStruture strut = new ObjectStruture();
		strut.add(new ComponentA());
		strut.add(new ComponentB());
		strut.add(new ComponentA());
		strut.add(new ComponentB());
		strut.dd(new DD());
		strut.callError(new ComponentA());
		strut.callError(new ComponentB());
		strut.callError(new ComponentA());
		strut.callError(new ComponentB());
		List<Component> list = new ArrayList<>();
		list.add(new ComponentA());
		list.add(new ComponentB());
		list.add(new ComponentA());
		list.add(new ComponentB());
		for (Component component : list) {
			strut.callError(component);

		}
	}
}
