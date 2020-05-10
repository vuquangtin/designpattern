package designpatterns.gof.behavioral.templatemethod.inline;

/**
 * <h1>Template Method</h1> Định nghĩa 1 bộ khung của 1 thuật toán trong 1 chức
 * năng (thao tác) chuyển giao việc thực hiện nó cho lớp con. Mẫu Template
 * Method cho phép lớp con định nghĩa lại cách thực hiện của 1 thuật toán mà
 * không phải thay đổi cấu trúc thuật toán. <br/>
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/designpattern">https://github.com
 *      /vuquangtin/designpattern</a>
 *
 */
public class TemplateMethodPatternExample {

	// 客户端
	public static void main(String[] args) {
		PageTemplate homePage = new HomePage();
		homePage.showPage();

		System.out.println();
		PageTemplate detailPage = new DetailPage();
		detailPage.showPage();

		System.out.println();
		PageTemplate contactPage = new ContactPage();
		contactPage.showPage();
	}

	static abstract class PageTemplate {

		protected void showHeader() {
			System.out.println("<header />");
		}

		protected void showNavigation() {
			System.out.println("<nav />");
		}

		protected void showFooter() {
			System.out.println("<footer />");
		}

		protected abstract void showBody();

		public final void showPage() {
			showHeader();
			showNavigation();
			showBody();
			showFooter();
		}
	}

	static class ContactPage extends PageTemplate {

		@Override
		protected void showNavigation() {
			// Just do nothing
			// Because we don't want to show navigation bar on contact page
		}

		@Override
		protected void showBody() {
			System.out.println("Content of contact page");
		}
	}

	static class DetailPage extends PageTemplate {

		@Override
		protected void showBody() {
			System.out.println("Content of detail");
		}
	}

	static class HomePage extends PageTemplate {

		@Override
		protected void showBody() {
			System.out.println("Content of home page page");
		}
	}
}