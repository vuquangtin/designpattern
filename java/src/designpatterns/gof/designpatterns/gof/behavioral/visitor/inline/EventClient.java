package designpatterns.gof.behavioral.visitor.inline;

/**
 * <h1>Visitor</h1>Diễn tả 1 hoạt động (thao tác, thuật toán) được thực hiện
 * trên các phần tử của 1 cấu trúc đối tượng. Visitor cho phép bạn định nghĩa 1
 * phép toán mới mà không thay đổi các lớp của các phần tử mà nó thao tác
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com

 *      /vuquangtin/designpattern</a>
 *
 */
public class EventClient {
	static class Event {
		/**
		 * Will do some type escalation
		 */
		void handleWith(EventHandler care) {
			care.handle(this);
		}
	}

	static class EventA extends Event {
		/**
		 * As event is EventA, this implementation is called, with its correct
		 * type forced by the cast
		 */
		void handleWith(EventHandler care) {
			care.handle(this);
		}
	}

	static class EventB extends Event {
		/**
		 * As event is EventB, this implementation is called, with its correct
		 * type forced by the cast
		 */
		void handleWith(EventHandler care) {
			care.handle(this);
		}
	}

	static class EventHandler {
		/**
		 * Finally comes here
		 */
		void handle(EventA event) {
			System.out.println("Handling EventA");
		}

		void handle(EventB event) {
			System.out.println("Handling EventB");
		}

		void handle(Event event) {
			System.out.println("Handling Event");
		}

		/**
		 * Go here first and dispatch call to Event class
		 */
		void doHandle(Event event) {
			event.handleWith(this);
		}
	}

	static class EventReceiver {
		private EventHandler handler;

		public EventReceiver(EventHandler handler) {
			this.handler = handler;
		}

		void receive(Event event) {
			handler.doHandle(event);
		}
	}

	public static void main(String[] args) {
		Event e1 = new EventA();
		new EventReceiver(new EventHandler()).receive(e1);
		e1 = new EventB();
		new EventReceiver(new EventHandler()).receive(e1);
		e1 = new Event();
		new EventReceiver(new EventHandler()).receive(e1);
	}
}
