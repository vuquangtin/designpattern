package designpatterns.gof.behavioral.observer.demo2;

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
public class Teleplay extends Show {

	private String channel;
	private String time;

	public Teleplay(String name) {
		super(name);
	}

	@Override
	public String changeShowInfo(String channel, String time) {
		this.channel = channel;
		this.time = time;
		return notifySpectators();
	}

	@Override
	public String getChannel() {
		return channel;
	}

	@Override
	public String getTime() {
		return time;
	}
}