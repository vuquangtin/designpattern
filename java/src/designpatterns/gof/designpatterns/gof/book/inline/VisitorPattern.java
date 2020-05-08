package designpatterns.gof.book.inline;

import java.util.List;

import com.google.api.client.util.Preconditions;
import com.google.common.collect.Lists;

import designpatterns.gof.book.inline.DesignPatternContants.Pattern;

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
@DesignPattern(value = Pattern.Visitor, description = "访问者")
public class VisitorPattern implements DesignPatternClient {

	private class Program {
		private List<Node> nodes = Lists.newArrayList();

		public Program(List<Node> nodes) {
			this.nodes = nodes;
		}

		public void addNode(Node node) {
			nodes.add(node);
		}

		public void removeNode(Node node) {
			nodes.remove(node);
		}

		public void doStuff(NodeVisitor nodeVisitor) {
			Preconditions.checkNotNull(nodeVisitor);

			for (Node node : nodes) {
				node.accept(nodeVisitor);
			}
		}

	}

	/** 类层次1：接受操作的元素 */
	private abstract class Node {
		/** 接受操作并执行相应处理 */
		public abstract void accept(NodeVisitor nodeVisitor);
	}

	private class AssignmentNode extends Node {
		@Override
		public void accept(NodeVisitor nodeVisitor) {
			Preconditions.checkNotNull(nodeVisitor);

			nodeVisitor.visitAssignment();
		}
	}

	private class VariableRefNode extends Node {
		@Override
		public void accept(NodeVisitor nodeVisitor) {
			Preconditions.checkNotNull(nodeVisitor);

			nodeVisitor.visitVariableRef();
		}
	}

	/** 类层次2：定义对元素的操作的访问者 */
	private abstract class NodeVisitor {
		public abstract void visitAssignment();

		public abstract void visitVariableRef();
	}

	private class TypeCheckingVisitor extends NodeVisitor {

		@Override
		public void visitAssignment() {
			System.out.println("TypeCheckingVisitor#visitAssignment");
		}

		@Override
		public void visitVariableRef() {
			System.out.println("TypeCheckingVisitor#visitVariableRef");
		}
	}

	private class CodeGeneratingVisitor extends NodeVisitor {

		@Override
		public void visitAssignment() {
			System.out.println("CodeGeneratingVisitor#visitAssignment");
		}

		@Override
		public void visitVariableRef() {
			System.out.println("CodeGeneratingVisitor#visitVariableRef");
		}
	}

	@Override
	public void usage() {
		Node assignmentNode = new AssignmentNode();
		Node variableRefNode = new VariableRefNode();

		NodeVisitor typeCheckingVisitor = new TypeCheckingVisitor();
		NodeVisitor codeGeneratingVisitor = new CodeGeneratingVisitor();

		List<Node> nodes = Lists.newArrayList(assignmentNode, variableRefNode);
		Program program = new Program(nodes);

		program.addNode(new AssignmentNode());
		program.addNode(new VariableRefNode());

		program.removeNode(variableRefNode);

		// 类型检查
		program.doStuff(typeCheckingVisitor);

		System.out.println();

		// 代码生成
		program.doStuff(codeGeneratingVisitor);
	}

	public static void main(String[] args) {
		new VisitorPattern().usage();
	}

}