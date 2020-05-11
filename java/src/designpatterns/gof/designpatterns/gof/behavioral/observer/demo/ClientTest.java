package designpatterns.gof.behavioral.observer.demo;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

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
public class ClientTest {

	private Show show;
	private Spectator spectator;

	@Before
	public void setUp() throws Exception {
		show = new Teleplay("北京青年");
		spectator = new YoungSpectator("张三");
		show.addSpectator(spectator);
	}

	@Test
	public void should_show_add_spectator_correct() {
		assertThat(show.getSpectatorsCount(), is(1));
	}

	@Test
	public void should_show_remove_spectator_correct() {
		show.removeSpectator(spectator);
		assertThat(show.getSpectatorsCount(), is(0));
	}

	@Test
	public void should_notify_one_spectator_correct() {
		String message = show.notifySpectators();
		assertThat(message, is("张三收看的节目:北京青年,节目的频道变更为null,时间变更为null\n"));
	}

	@Test
	public void should_notify_spectators_when_show_info_change() {
		String message = show.changeShowInfo("02", "8:00 pm");
		assertThat(message, is("张三收看的节目:北京青年,节目的频道变更为02,时间变更为8:00 pm\n"));
	}

	@Test
	public void should_notify_all_spectators_when_show_info_change() {
		Spectator otherSpectator = new YoungSpectator("李四");
		show.addSpectator(otherSpectator);
		String message = show.changeShowInfo("02", "8:00 pm");
		assertThat(message, is("张三收看的节目:北京青年,节目的频道变更为02,时间变更为8:00 pm\n"
				+ "李四收看的节目:北京青年,节目的频道变更为02,时间变更为8:00 pm\n"));
	}

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

	public interface Spectator {
		String update(Show show);
	}

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
}