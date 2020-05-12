package designpatterns.gof.behavioral.visitor.inline;

import java.util.Arrays;
import java.util.List;

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
public class NodeClient {
	public static void main(String[] args) {
		List<Node> nodes = Arrays.asList(new NodeA(), new NodeB(), new NodeC());
		List<NodeVisitor> visitors = Arrays.asList(new NodeVisitor1(),
				new NodeVisitor2(), new NodeVisitor3());

		for (Node node : nodes) {
			for (NodeVisitor visitor : visitors) {
				node.accept(visitor);
			}
		}
	}
}

interface Node {
	void accept(NodeVisitor visitor);
}

interface NodeVisitor {
	void visit(Node node);
}

class NodeA implements Node {

	@Override
	public void accept(NodeVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public String toString() {
		return "Node A";
	}
}

class NodeB implements Node {

	@Override
	public void accept(NodeVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public String toString() {
		return "Node B";
	}
}

class NodeC implements Node {

	@Override
	public void accept(NodeVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public String toString() {
		return "Node C";
	}
}

class NodeVisitor1 implements NodeVisitor {

	@Override
	public void visit(Node node) {
		System.out.println("Node visitor 1, node " + node);
	}
}

class NodeVisitor2 implements NodeVisitor {

	@Override
	public void visit(Node node) {
		System.out.println("Node visitor 2, node " + node);
	}
}

class NodeVisitor3 implements NodeVisitor {

	@Override
	public void visit(Node node) {
		System.out.println("Node visitor 3, node " + node);
	}
}
