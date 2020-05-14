package designpatterns.lambdas.behavioral.strategies;

/**
 * <h1>Observer</h1> Định nghĩa một sự phụ thuộc 1-nhiều giữa các đối tượng để
 * khi một đối tượng thay đổi trạng thái, tất cả phụ thuộc của nó được thông báo
 * và cập nhật một cách tự động.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class JobInfo {

	private JobCategory jobCategory;
	private String description;

	public JobInfo(JobCategory jobCategory, String description) {
		this.jobCategory = jobCategory;
		this.description = description;
	}

	public enum JobCategory {
		ENGINEERING, SALES, LOGISTICS
	}

}