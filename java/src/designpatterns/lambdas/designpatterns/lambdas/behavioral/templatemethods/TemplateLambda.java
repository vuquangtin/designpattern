package designpatterns.lambdas.behavioral.templatemethods;

import java.util.function.Consumer;

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

public class TemplateLambda {
	public static void withResource(Consumer<Resource> consumer) {
		Resource resource = new Resource();
		try {
			consumer.accept(resource);
		} finally {
			resource.dispose();
		}
	}

	public static void main(String[] args) {
		withResource(Resource::useResource);
		withResource(Resource::employResource);
	}
}