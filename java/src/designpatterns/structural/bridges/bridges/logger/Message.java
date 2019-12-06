package bridges.logger;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public abstract class Message {
	MessageLogger messageLogger;

	public Message() {
	}

	public Message(MessageLogger messageLogger) {
		this.messageLogger = messageLogger;
	}

	public abstract void log(String msg);
}