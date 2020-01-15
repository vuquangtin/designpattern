package mediators.app.INGSW;

import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 * <h1>Mediator</h1> Định nghĩa 1 đối tượng đóng gói cách 1 tập hợp các đối
 * tượng tương tác. Mediator thúc đẩy sự khớp nối lỏng lẻo bằng cách ngăn không
 * cho các đối tượng đề cập đến nhau 1 cách rõ ràng và nó cho phép bạn thay đổi
 * sự tương tác của chúng 1 cách độc lập.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/designpattern">https://github.com
 *      /vuquangtin/designpattern</a>
 *
 */
@SuppressWarnings("unchecked")
public class List extends JList implements Component {
	private Mediator mediator;
	private final DefaultListModel LIST_MODEL;

	public List(DefaultListModel listModel) {
		super(listModel);
		this.LIST_MODEL = listModel;
		setModel(listModel);
		this.setLayoutOrientation(JList.VERTICAL);
		Thread thread = new Thread(new Hide(this));
		thread.start();
	}

	@Override
	public void setMediator(Mediator mediator) {
		this.mediator = mediator;
	}

	public void addElement(Note note) {
		LIST_MODEL.addElement(note);
		int index = LIST_MODEL.size() - 1;
		setSelectedIndex(index);
		ensureIndexIsVisible(index);
		mediator.sendToFilter(LIST_MODEL);
	}

	public void deleteElement() {
		int index = this.getSelectedIndex();
		try {
			LIST_MODEL.remove(index);
			mediator.sendToFilter(LIST_MODEL);
		} catch (ArrayIndexOutOfBoundsException ignored) {
		}
	}

	public Note getCurrentElement() {
		return (Note) getSelectedValue();
	}

	@Override
	public String getName() {
		return "List";
	}

	private class Hide implements Runnable {
		private List list;

		Hide(List list) {
			this.list = list;
		}

		@Override
		public void run() {
			while (true) {
				try {
					Thread.sleep(300);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				if (list.isSelectionEmpty()) {
					mediator.hideElements(true);
				} else {
					mediator.hideElements(false);
				}
			}
		}
	}
}