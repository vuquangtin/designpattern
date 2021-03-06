package designpatterns.gof.behavioral.visitor.demo;

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
public class MyReverseVisitor extends CartPartVisitor {
	@Override
	public void visit(Wheel part) {
		part.setName(UtilFile.reverseWords(part.getName()));
		part.setModelNumberWheel(UtilFile.reverseWords(part.getModelNumberWheel()));
		part.setModelYearWheel(UtilFile.reverseWords(part.getModelYearWheel()));
	}

	@Override
	public void visit(Engine part) {
		part.setName(UtilFile.reverseWords(part.getName()));
		part.setModelNumberEngine(UtilFile.reverseWords(part.getModelNumberEngine()));
		part.setModelYearEngine(UtilFile.reverseWords(part.getModelYearEngine()));
	}

	@Override
	public void visit(Body part) {
		part.setName(UtilFile.reverseWords(part.getName()));
		part.setModelNumberBody(UtilFile.reverseWords(part.getModelNumberBody()));
		part.setModelYearBody(UtilFile.reverseWords(part.getModelYearBody()));
	}

	@Override
	public void visit(Brake part) {
		part.setName(UtilFile.reverseWords(part.getName()));
		part.setModelNumberBrake(UtilFile.reverseWords(part.getModelNumberBrake()));
		part.setModelYearBrake(UtilFile.reverseWords(part.getModelYearBrake()));
	}
}