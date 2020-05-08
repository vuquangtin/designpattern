package designpatterns.gof.book.inline;

import com.google.api.client.util.Preconditions;

import designpatterns.gof.book.inline.DesignPatternContants.Pattern;

/**
 * <h1>State</h1> cho phép 1 đối tượng thay đổi hành vi khi trạng thái của chính
 * nó thay đổi. Đối tượng sẽ xuất hiện để thay đổi lớp của nó.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
@DesignPattern(value = Pattern.State, description = "状态")
public class StatePattern implements DesignPatternClient {

	/** 状态的上下文，负责维护状态的变迁及有效性验证 */
	private class TCPConnection {
		/** 对状态的引用 */
		private TCPState tcpState;

		public TCPConnection() {
			/** 初始状态 */
			this.tcpState = new TCPListen();
		}

		public void open() {
			/** 处于监听状态才可打开建立连接 */
			Preconditions.checkState(tcpState instanceof TCPListen);

			tcpState.open();
			/** 后继状态 */
			tcpState = new TCPEstablished();
		}

		public void close() {
			tcpState.close();
			/** 后继状态 */
			tcpState = new TCPClosed();
		}

		public void ack() {
			/** 处于连接状态才可确认 */
			Preconditions.checkState(tcpState instanceof TCPEstablished);

			tcpState.ack();
		}
	}

	/** 状态 */
	private abstract class TCPState {
		public void open() {
		}

		public void close() {
		}

		public void ack() {
		}
	}

	private class TCPListen extends TCPState {
		public void open() {
			System.out.println("TCPListen#open()");
		}
	}

	private class TCPEstablished extends TCPState {
		public void close() {
			System.out.println("TCPEstablished#close()");
		}

		public void ack() {
			System.out.println("TCPEstablished#ack()");
		}
	}

	private class TCPClosed extends TCPState {
	}

	@Override
	public void usage() {
		TCPConnection tcpConnection = new TCPConnection();

		tcpConnection.open();
		tcpConnection.ack();
		tcpConnection.close();

		// 关闭后再确认，这里会抛出运行时异常
		tcpConnection.ack();
	}

	public static void main(String[] args) {
		new StatePattern().usage();
	}
}