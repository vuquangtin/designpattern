package designpatterns.gof.behavioral.visitor.inline;

/**
 * <h1>Visitor</h1>Diễn tả 1 hoạt động (thao tác, thuật toán) được thực hiện
 * trên các phần tử của 1 cấu trúc đối tượng. Visitor cho phép bạn định nghĩa 1
 * phép toán mới mà không thay đổi các lớp của các phần tử mà nó thao tác
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/designpattern">https://github.com
 *      /vuquangtin/designpattern</a>
 *
 */
public class VisitorPatternExample {

	public static void main(String[] args) throws Exception {
		Book book1 = new BusinessBook();
		Book book2 = new JavaCoreBook();
		Book book3 = new DesignPatternBook();

		Visitor v = new VisitorImpl();
		book1.accept(v);
		book2.accept(v);
		book3.accept(v);
	}

	static interface Visitor {

		void visit(BusinessBook book);

		void visit(DesignPatternBook book);

		void visit(JavaCoreBook book);
	}

	static class VisitorImpl implements Visitor {

		@Override
		public void visit(BusinessBook a) {
			System.out.println(a.getPublisher());
		}

		@Override
		public void visit(DesignPatternBook w) {
			System.out.println(w.getBestSeller());
		}

		@Override
		public void visit(JavaCoreBook g) {
			System.out.println(g.getFavouriteBook());
		}
	}

	static interface Book {
		void accept(Visitor v);
	}

	static class BusinessBook implements Book {
		public void accept(Visitor v) {
			v.visit(this);
		}

		public String getPublisher() {
			return "The publisher of business book";
		}
	}

	static interface ProgramingBook extends Book {

		String getResource();
	}

	static class DesignPatternBook implements ProgramingBook {

		@Override
		public void accept(Visitor v) {
			v.visit(this);
		}

		@Override
		public String getResource() {
			return "https://github.com/gpcodervn/Design-Pattern-Tutorial/";
		}

		public String getBestSeller() {
			return "The best Seller of design pattern book";
		}
	}

	static class JavaCoreBook implements ProgramingBook {

		@Override
		public void accept(Visitor v) {
			v.visit(this);
		}

		@Override
		public String getResource() {
			return "https://github.com/gpcodervn/Java-Tutorial/";
		}

		public String getFavouriteBook() {
			return "The most favourite book of java core";
		}
	}
}