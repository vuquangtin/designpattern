package designpatterns.gof.behavioral.observer.demo2;

import java.util.ArrayList;
import java.util.List;

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
public abstract class Show {
	protected String name;
	protected List<Spectator> spectators = new ArrayList<Spectator>();

	protected Show(String name) {
		this.name = name;
	}

	public void addSpectator(Spectator spectator) {
		spectators.add(spectator);
	}

	public int getSpectatorsCount() {
		return spectators.size();
	}

	public void removeSpectator(Spectator spectator) {
		spectators.remove(spectator);
	}

	public String notifySpectators() {
		StringBuilder message = new StringBuilder();
		for (Spectator spectator : spectators) {
			message.append(spectator.update(this)).append("\n");
		}
		return message.toString();
	}

	public String getName() {
		return name;
	}

	public abstract String changeShowInfo(String channel, String time);

	public abstract String getChannel();

	public abstract String getTime();
}