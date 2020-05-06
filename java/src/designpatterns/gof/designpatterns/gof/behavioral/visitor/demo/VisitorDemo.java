package designpatterns.gof.behavioral.visitor.demo;

import java.util.Scanner;

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
public class VisitorDemo {
	private static Scanner scanner;

	public VisitorDemo() {
		scanner = new Scanner(System.in);
	}

	public static void main(String[] args) {
		VisitorDemo demo = new VisitorDemo();

		System.out.println("=============================================");
		System.out.println(" Visitor Pattern Exercise Program");
		System.out.println("=============================================");
		System.out.println("\tMenu Options:");
		System.out.println("\t1. Read File Operation");
		System.out.println("\t2. Print Name Operation");
		System.out.println("\t3. Rename Operation");
		System.out.println("\t4. Reverse Operation");
		System.out.println("\t5. File Save Operation");
		System.out.println("\t6. Exit the program");

		Car car = new Car();

		while (true) {
			System.out.println("=============================================");
			System.out.print("Please select an option from 1-6: ");

			switch (demo.getOption()) {
			case 1:
				System.out.println("[DBG] Executing MyFileReadVisitor...");
				MyFileReadVisitor fileReadVisitor = new MyFileReadVisitor();
				car.accept(fileReadVisitor);
				break;
			case 2:
				System.out.println("[DBG] Executing MyAccessVisitor...");
				MyAccessVisitor accessVisitor = new MyAccessVisitor();
				car.accept(accessVisitor);
				break;
			case 3:
				System.out.println("[DBG] Executing MyRenameVisitor...");
				MyRenameVisitor renameVisitor = new MyRenameVisitor();
				car.accept(renameVisitor);
				break;
			case 4:
				System.out.println("[DBG] Executing MyReverseVisitor...");
				MyReverseVisitor reverseVisitor = new MyReverseVisitor();
				car.accept(reverseVisitor);
				break;
			case 5:
				System.out.println("[DBG] Executing MyFileSaveVisitor...");
				MyFileSaveVisitor saveVisitor = new MyFileSaveVisitor();
				car.accept(saveVisitor);
				break;
			default:
				break;
			}
		}
	}

	int getOption() {
		int input = scanner.nextInt();
		if (input < 0 || input > 6) {
			System.out.println("You have entered an invalid selection, please try again\n");
		} else if (input == 6) {
			System.out.println("You have quit the program\n");
			System.exit(1);
		} else {
			System.out.println("You have entered " + input + "\n");
			return input;
		}
		return 0;
	}
}