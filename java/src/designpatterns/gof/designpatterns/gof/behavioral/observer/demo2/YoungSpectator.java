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
public class YoungSpectator implements Spectator {
	private String name;

	public YoungSpectator(String name) {
		this.name = name;
	}

	@Override
	public String update(Show show) {
		return String.format("%s收看的节目:%s,节目的频道变更为%s,时间变更为%s", name,
				show.getName(), show.getChannel(), show.getTime());
	}
}