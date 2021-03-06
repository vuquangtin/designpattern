package composites.gof.tasks;

import java.util.ArrayList;

/**
 * <h1>Composite</h1> Các đối tượng cấu thành các cấu trúc cây để mô tả bán toàn
 * bộ hệ thống phần cấp. Composite để cho các client tác động các đối tượng
 * riêng biệt và các thành phần của đối tượng một cách thống nhất.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class MainApp {
	public static void main(String[] args) {
		Task task1 = new Task("requirement", 50);
		Task task2 = new Task("analysis", 34);
		Task task3 = new Task("design", 65);
		Task task4 = new Task("implement", 23);
		Task task5 = new Task("test", 65);
		Task task6 = new Task("maintain", 32);
		ArrayList<TaskItem> subTask = new ArrayList<>();
		subTask.add(task1);
		subTask.add(task2);
		subTask.add(task3);
		subTask.add(task4);
		subTask.add(task5);
		subTask.add(task6);
		Project project = new Project("quan li diem", subTask);
		// tinh tong thoi gian du an
		System.out.println("total time: " + project.getTime());
		// tinh tong thoi gian du an sau khi bo task: maintain
		project.removeTask(task6);
		System.out.println("total time after remove maintain task: "
				+ project.getTime());
	}
}