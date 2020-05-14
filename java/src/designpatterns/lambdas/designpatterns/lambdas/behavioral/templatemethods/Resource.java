package designpatterns.lambdas.behavioral.templatemethods;

import java.util.Random;

/**
 * <h1>Template Method</h1> Định nghĩa 1 bộ khung của 1 thuật toán trong 1 chức
 * năng (thao tác) chuyển giao việc thực hiện nó cho lớp con. Mẫu Template
 * Method cho phép lớp con định nghĩa lại cách thực hiện của 1 thuật toán mà
 * không phải thay đổi cấu trúc thuật toán. <br/>
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class Resource {
	public Resource() {
		System.out.println("Resource created");
	}

	public void useResource() {
		riskyOperation();
		System.out.println("Resource used");
	}

	public void employResource() {
		riskyOperation();
		System.out.println("Resource employed");
	}

	public void dispose() {
		System.out.println("Resource disposed");
	}

	private void riskyOperation() {
		if (new Random().nextInt(10) == 0) {
			throw new RuntimeException();
		}
	}

	public static void main(String[] args) {
		Resource resource = new Resource();
		resource.useResource();
		resource.employResource();
		resource.dispose();
	}
}
