package designpatterns.lambdas.behavioral.templatemethods;

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
public class TemplateGof {

	public static abstract class AbstractResourceManipulatorTemplate {
		protected Resource resource;

		private void openResource() {
			resource = new Resource();
		}

		protected abstract void doSomethingWithResource();

		private void closeResource() {
			resource.dispose();
			resource = null;
		}

		public void execute() {
			openResource();
			try {
				doSomethingWithResource();
			} finally {
				closeResource();
			}
		}
	}

	public static class ResourceUser extends
			AbstractResourceManipulatorTemplate {
		@Override
		protected void doSomethingWithResource() {
			resource.useResource();
		}
	}

	public static class ResourceEmployer extends
			AbstractResourceManipulatorTemplate {
		@Override
		protected void doSomethingWithResource() {
			resource.employResource();
		}
	}

	public static void main(String[] args) {
		new ResourceUser().execute();
		new ResourceEmployer().execute();
	}
}
