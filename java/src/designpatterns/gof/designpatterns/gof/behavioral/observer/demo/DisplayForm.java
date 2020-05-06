package designpatterns.gof.behavioral.observer.demo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
public class DisplayForm extends JFrame {
	InputFormObserver input = new InputFormObserver();
	InputForm inputForm;
	Observable obsInput;
	JTextField display;

	// ...
	public DisplayForm() {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		inputForm = new InputForm();
		obsInput = inputForm.getInputInfo();
		obsInput.addObserver(input);

		display = new JTextField(10);
		display.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		getContentPane().add(display);
		setTitle("Observer form");
		setSize(200, 100);
		setLocation(200, 100);
		setVisible(true);

	}

	private class InputFormObserver implements Observer {
		public void update(Observable ob, Object o) {
			doSomeUpdate();
			if (obsInput.countObservers() > 0)
				obsInput.deleteObservers();
			obsInput = inputForm.getInputInfo();
			obsInput.addObserver(input);
		}

	}

	public void doSomeUpdate() {
		display.setText(inputForm.getText());
		JOptionPane.showMessageDialog(DisplayForm.this,
				"This form has been updated");
	}

	public static void main(String args[]) {
		DisplayForm df = new DisplayForm();
	}
}

class InputForm extends JFrame {
	public InformDisplay inform = new InformDisplay();
	// ...
	JTextField input = new JTextField(10);

	public InputForm() {
		JPanel panel = new JPanel();
		input.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inform.notifyObservers();
			}
		});
		panel.add(new JLabel("Enter: "));
		panel.add(input);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		getContentPane().add(panel);
		setTitle("Observable form");
		setSize(200, 100);
		setVisible(true);
	}

	public Observable getInputInfo() {
		return inform;
	}

	public String getText() {
		return input.getText();
	}

	private class InformDisplay extends Observable {
		public void notifyObservers() {
			setChanged();
			super.notifyObservers();
		}

		public String getChange() {
			return input.getText();
		}
	}
	// ...
}