package designpatterns.gof.behavioral.memento.demo;

import java.util.List;

/**
 * <h1>Memento</h1> Không vi phạm tính đóng gói, nó nắm bắt và hiệu chỉnh trạng
 * thái bên trong của đối tượng để đối tượng có thể được khôi phục về trạng thái
 * này sau đó.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/designpattern">https://github.com
 * 
 *      /vuquangtin/designpattern</a>
 *
 */
public class SystemMemento {
	private String type;
	private int diskCount;
	private List<String> drives;

	public SystemMemento(String type, int diskCount, List<String> drives) {
		this.type = type;
		this.diskCount = diskCount;
		this.drives = drives;
	}

	public String getType() {
		return type;
	}

	public int getDiskCount() {
		return diskCount;
	}

	public List<String> getDrives() {
		return drives;
	}
}