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
public class MyFileSaveVisitor extends CartPartVisitor {

	private static final String ENTRY_FORMAT = "%s,%s,%s%n";
	private String filePath = System.getProperty("user.dir");
	private List<String> contents;

	public MyFileSaveVisitor() {
		contents = UtilFile.readFile(filePath + File.separator + "inputdata.txt");
	}

	@Override
	public void visit(Wheel wheel) {
		final int LINE_NUM_WHEEL = 0;
		String newWheelEntry = String.format(ENTRY_FORMAT, wheel.getName(), wheel.getModelNumberWheel(),
				wheel.getModelYearWheel());
		saveLine(newWheelEntry, LINE_NUM_WHEEL);
	}

	@Override
	public void visit(Engine engine) {
		final int LINE_NUM_ENGINE = 1;
		String newEngineEntry = String.format(ENTRY_FORMAT, engine.getName(), engine.getModelNumberEngine(),
				engine.getModelYearEngine());
		saveLine(newEngineEntry, LINE_NUM_ENGINE);
	}

	@Override
	public void visit(Body body) {
		final int LINE_NUM_BODY = 2;
		String newBodyEntry = String.format(ENTRY_FORMAT, body.getName(), body.getModelNumberBody(),
				body.getModelYearBody());
		saveLine(newBodyEntry, LINE_NUM_BODY);
	}

	@Override
	public void visit(Brake brake) {
		final int LINE_NUM_BRAKE = 3;
		String newBrakeEntry = String.format(ENTRY_FORMAT, brake.getName(), brake.getModelNumberBrake(),
				brake.getModelYearBrake());
		saveLine(newBrakeEntry, LINE_NUM_BRAKE);
	}

	private void saveLine(String line, Integer lineNumber) {
		StringBuffer inputBuffer = new StringBuffer();
		for (int i = 0; i < contents.size(); i++) {
			if (i == lineNumber) {
				inputBuffer.append(line);
			} else {
				inputBuffer.append(contents.get(i) + "\n");
			}
		}
		UtilFile.saveFile(inputBuffer);
		contents = UtilFile.readFile(filePath + File.separator + "outputdata.csv");
	}

}