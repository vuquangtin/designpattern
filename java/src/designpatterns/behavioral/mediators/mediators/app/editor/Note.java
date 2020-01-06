package mediators.app.editor;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class Note {
	private String _name;
	private String _text;

	public Note() {
		_name = "New note";
	}

	public Note(String name, String text) {
		_name = name;
		_text = text;
	}

	public void setName(String name) {
		_name = name;
	}

	public void setText(String text) {
		_text = text;
	}

	public String getName() {
		return _name;
	}

	public String getText() {
		return _text;
	}

	@Override
	public String toString() {
		return _name;
	}
}