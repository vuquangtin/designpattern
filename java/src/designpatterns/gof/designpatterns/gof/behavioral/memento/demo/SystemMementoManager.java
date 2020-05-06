package designpatterns.gof.behavioral.memento.demo;

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
public class SystemMementoManager {
	private SystemMemento systemMemento;

	public void setSystemMemento(SystemMemento systemMemento) {
		this.systemMemento = systemMemento;
	}

	public SystemMemento getSystemMemento() {
		return systemMemento;
	}
}