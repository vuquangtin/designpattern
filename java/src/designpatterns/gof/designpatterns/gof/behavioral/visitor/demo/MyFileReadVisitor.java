package designpatterns.gof.behavioral.visitor.demo;

import java.io.File;
import java.util.List;

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
public class MyFileReadVisitor extends CartPartVisitor {

	private String filePath = System.getProperty("user.dir");
	private List<String> contents;

	public MyFileReadVisitor() {
		contents = UtilFile.readFile(filePath + File.separator + "inputdata.txt");
	}

	@Override
	public void visit(Wheel part) {
		final int LINE_NUM_WHEEL = 0;
		String[] tokens = contents.get(LINE_NUM_WHEEL).split(",");
		part.setName(tokens[0].trim());
		part.setModelNumberWheel(tokens[1].trim());
		part.setModelYearWheel(tokens[2].trim());
	}

	@Override
	public void visit(Engine part) {
		final int LINE_NUM_ENGINE = 1;
		String[] tokens = contents.get(LINE_NUM_ENGINE).split(",");
		part.setName(tokens[0].trim());
		part.setModelNumberEngine(tokens[1].trim());
		part.setModelYearEngine(tokens[2].trim());
	}

	@Override
	public void visit(Body part) {
		final int LINE_NUM_BODY = 2;
		String[] tokens = contents.get(LINE_NUM_BODY).split(",");
		part.setName(tokens[0].trim());
		part.setModelNumberBody(tokens[1].trim());
		part.setModelYearBody(tokens[2].trim());
	}

	@Override
	public void visit(Brake part) {
		final int LINE_NUM_BRAKE = 3;
		String[] tokens = contents.get(LINE_NUM_BRAKE).split(",");
		part.setName(tokens[0].trim());
		part.setModelNumberBrake(tokens[1].trim());
		part.setModelYearBrake(tokens[2].trim());
	}
}