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
public class OperationSystem implements Cloneable {

	private String type;
	private int diskCount;
	private List<String> drives;
	private OperationSystem systemBackup;

	public OperationSystem(String type, int diskCount, List<String> drives) {
		this.type = type;
		this.diskCount = diskCount;
		this.drives = drives;
	}

	public String getSystemInfo() {
		return String.format("系统类型是:%s, 磁盘分区数:%d, 硬件驱动信息:%s", type, diskCount, drives.toString());
	}

	public void createSystemMemento() {
		try {
			this.systemBackup = clone();
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException("备份系统失败");
		}
	}

	public void changeSystemInfo(String type, int diskCount, List<String> drives) {
		this.type = type;
		this.diskCount = diskCount;
		this.drives = drives;
	}

	public void restore() {
		this.type = systemBackup.type;
		this.diskCount = systemBackup.diskCount;
		this.drives = systemBackup.drives;
	}

	@Override
	protected OperationSystem clone() throws CloneNotSupportedException {
		return (OperationSystem) super.clone();
	}
}