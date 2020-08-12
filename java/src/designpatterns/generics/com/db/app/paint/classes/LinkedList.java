package com.db.app.paint.classes;

/**
 *
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */

public class LinkedList {

	static class Node {
		int item;
		Node next;

		public Node(int item, Node next) {
			this.item = item;
			this.next = next;
		}
	}

	static int sumWhile(Node data) {
		int result = 0;
		while (data != null) {
			result = result + data.item;
			data = data.next;
		}
		return result;
	}

	static int sumFor(Node data) {
		int result = 0;
		for (; data != null; data = data.next) {
			result += data.item;
		}
		return result;
	}

	static int sumRecursive(Node data) {
		if (data == null) {
			return 0;
		} else {
			return data.item + sumRecursive(data.next);
		}
	}

	public static void main(String[] args) {
		Node data = null;
		for (int i = args.length - 1; i >= 0; i--) {
			data = new Node(Integer.parseInt(args[i]), data);
		}

		System.out.printf("sumWhile     = %d%n", sumWhile(data));
		System.out.printf("sumFor       = %d%n", sumFor(data));
		System.out.printf("sumRecursive = %d%n", sumRecursive(data));
	}
}