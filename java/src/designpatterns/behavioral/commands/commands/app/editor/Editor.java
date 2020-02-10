package commands.app.editor;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

/**
 * <h1>Command</h1> Đóng gói một yêu cầu request như một đối tượng, bằng cách đó
 * cho phép bạn tham số hóa các client với các request khác nhau, các queue và
 * log request, và hỗ trợ các hoạt động (operation) có thể “undo”.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class Editor {
	public JTextArea textField;
	public String clipboard;
	private CommandHistory history = new CommandHistory();

	public void init() {
		JFrame frame = new JFrame("Text editor (type & use buttons, Luke!)");
		JPanel content = new JPanel();
		frame.setContentPane(content);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
		textField = new JTextArea();
		textField.setLineWrap(true);
		content.add(textField);
		JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JButton ctrlC = new JButton("Ctrl+C");
		JButton ctrlX = new JButton("Ctrl+X");
		JButton ctrlV = new JButton("Ctrl+V");
		JButton ctrlZ = new JButton("Ctrl+Z");
		Editor editor = this;
		ctrlC.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				executeCommand(new CopyCommand(editor));
			}
		});
		ctrlX.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				executeCommand(new CutCommand(editor));
			}
		});
		ctrlV.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				executeCommand(new PasteCommand(editor));
			}
		});
		ctrlZ.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				undo();
			}
		});
		buttons.add(ctrlC);
		buttons.add(ctrlX);
		buttons.add(ctrlV);
		buttons.add(ctrlZ);
		content.add(buttons);
		frame.setSize(450, 200);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	private void executeCommand(Command command) {
		if (command.execute()) {
			history.push(command);
		}
	}

	private void undo() {
		if (history.isEmpty())
			return;

		Command command = history.pop();
		if (command != null) {
			command.undo();
		}
	}
}
