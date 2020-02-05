package bridges.logger;

/**
 * <h1>Bridge</h1> Tách một abstraction khỏi implementation của nó để cả hai có
 * thể thay đổi độc lập nhau.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com

 *      /vuquangtin/designpattern</a>
 *
 */
public class TextMessage extends Message {
	public TextMessage() {
	}

	public TextMessage(MessageLogger messageLogger) {
		super(messageLogger);
	}

	public MessageLogger getMessageLogger() {
		return messageLogger;
	}

	public void setMessageLogger(MessageLogger messageLogger) {
		this.messageLogger = messageLogger;
	}

	public String preProcess(String str) {
		return str;
	}

	@Override
	public void log(String msg) {
		this.messageLogger.log(preProcess(msg));
	}
}
