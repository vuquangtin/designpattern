package designpatterns.gof.book.inline;

import java.util.List;

import com.google.common.collect.Lists;

import designpatterns.gof.book.inline.DesignPatternContants.Pattern;
import designpatterns.gof.book.inline.RandomUtils.IdPattern;

/**
 * <h1>Memento</h1> Không vi phạm tính đóng gói, nó nắm bắt và hiệu chỉnh trạng
 * thái bên trong của đối tượng để đối tượng có thể được khôi phục về trạng thái
 * này sau đó.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com

 *      /vuquangtin/designpattern</a>
 *
 */
@DesignPattern(value = Pattern.Mediator, description = "中介者")
public class MediatorPattern implements DesignPatternClient {

	/** 依托中介进行协同的领域类抽象 */
	private abstract class Widget {
		/** 中介对象引用 */
		private DialogDirector director;

		/** 触发中介对象的动作，诱发其他协同对象上的动作 */
		public void changed() {
			director.widgetChanged();
		}

		/** 设置协调用的中介 */
		public void setDirector(DialogDirector director) {
			this.director = director;
		}

		public abstract void show();
	}

	/** 具体的协同者1 */
	private class ListBox extends Widget {
		public String getSelection() {
			String result = RandomUtils.nextId(IdPattern.UpperCase);
			System.out.println("获取下拉框内容：" + result);
			return result;
		}

		@Override
		public void show() {
			System.out.println("展示ListBox");
		}
	}

	/** 具体的协同者2 */
	private class EntryField extends Widget {
		public void setText(String text) {
			System.out.println("设置输入项内容：" + text);
		}

		@Override
		public void show() {
			System.out.println("展示EntryField");
		}
	}

	/** 中介 */
	private abstract class DialogDirector {
		protected List<Widget> widgetList;

		public DialogDirector(Widget... widgets) {
			widgetList = Lists.newArrayList(widgets);
		}

		public void showDialog() {
			System.out.println("显示对话框：");
			for (Widget widget : widgetList) {
				widget.show();
			}
		}

		public abstract void createWidgets();

		public abstract void widgetChanged();
	}

	/** 具体中介 */
	private class FontDialogDirector extends DialogDirector {
		/** 中介知悉各组件，协调这些组件之间的交互 */
		protected ListBox listBox;
		protected EntryField entryField;

		public FontDialogDirector(ListBox listBox, EntryField entryField) {
			super(listBox, entryField);

			this.listBox = listBox;
			this.entryField = entryField;

			// 设置协同者与中介的关系
			this.listBox.setDirector(this);
			this.entryField.setDirector(this);
		}

		@Override
		public void createWidgets() {
			listBox.show();
			entryField.show();
		}

		@Override
		public void widgetChanged() {
			// 协调组件之间的交互：根据下拉框中选项更新输入字段中的值
			String listBoxSelection = listBox.getSelection();
			entryField.setText(listBoxSelection);
		}
	}

	@Override
	public void usage() {
		ListBox listBox = new ListBox();
		EntryField entryField = new EntryField();

		// 中介与协同对象之间关系的建立
		DialogDirector dialogDirector = new FontDialogDirector(listBox,
				entryField);
		dialogDirector.showDialog();

		// 模拟触发某个协同者上的事件
		listBox.changed();

	}

	public static void main(String[] args) {
		new MediatorPattern().usage();
	}
}