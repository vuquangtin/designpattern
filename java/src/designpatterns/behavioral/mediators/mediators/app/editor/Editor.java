package mediators.app.editor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;

import mediators.app.editor.components.AddButton;
import mediators.app.editor.components.Banner;
import mediators.app.editor.components.DeleteButton;
import mediators.app.editor.components.Filter;
import mediators.app.editor.components.List;
import mediators.app.editor.components.NoteComponent;
import mediators.app.editor.components.SaveButton;
import mediators.app.editor.components.TextBox;
import mediators.app.editor.components.Title;

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
// Concrete mediator: Editor implements Mediator interface to extract all
// communication between components
// Now the Editor(mediator) will handle the requests that the components send
public class Editor implements Mediator {

	private Title title;
	private TextBox textBox;
	private AddButton add;
	private DeleteButton del;
	private SaveButton save;
	private List list;
	private Filter filter;

	private static final String ADDBUTTON = "AddButton";
	private static final String DELBUTTON = "DelButton";
	private static final String SAVEBUTTON = "SaveButton";
	private static final String FILTER = "Filter";
	private static final String LIST = "List";
	private static final String TEXTBOX = "TextBox";
	private static final String TITLE = "Title";

	private static final String noteDirectory = "./notes/";

	private JLabel titleLabel = new JLabel("Title:");
	private JLabel textLabel = new JLabel("Text:");
	private JLabel label = new JLabel("Add or select existing note to proceed...");

	@Override
	public void registerComponent(NoteComponent component) {
		// receives a component that implements NoteComponent interface
		component.setMediator(this);

		// registers the particular component
		switch (component.getName()) {
		case ADDBUTTON:
			add = (AddButton) component;
			break;
		case DELBUTTON:
			del = (DeleteButton) component;
			break;
		case FILTER:
			filter = (Filter) component;
			break;
		case LIST:
			list = (List) component;
			this.list.addListSelectionListener(listSelectionEvent -> {
				Note note = (Note) list.getSelectedValue();
				if (note != null) {
					getInfoFromList(note);
				} else {
					clear();
				}
			});
			break;
		case SAVEBUTTON:
			save = (SaveButton) component;
			break;
		case TEXTBOX:
			textBox = (TextBox) component;
			break;
		case TITLE:
			title = (Title) component;
			break;
		}
	}

	// Methods to handle requests from components.

	@Override
	public void addNewNote(Note note) {
		title.setText("");
		textBox.setText("");
		list.addElement(note);
	}

	@Override
	public void deleteNote() {
		File file = new File(noteDirectory + ((Note) list.getSelectedValue()).getName());
		try {
			if (!file.toString().equals(".\\notes"))
				Files.deleteIfExists(file.toPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
		list.deleteElement();
	}

	@Override
	public void getInfoFromList(Note note) {
		title.setText(note.getName().replace('*', ' '));
		textBox.setText(note.getText());
	}

	@Override
	public void saveChanges() {
		try {
			Note note = (Note) list.getSelectedValue();
			note.setName(title.getText());
			note.setText(textBox.getText());
			list.repaint();
			writeFile(title.getText(), textBox.getText());
		} catch (NullPointerException ignored) {
		}
	}

	public void writeFile(String s, String content) {
		File file = new File("./notes/" + s);
		try {
			PrintWriter pw = new PrintWriter(file);
			pw.print(content);
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void markNote() {
		try {
			Note note = list.getCurrentElement();
			String name = note.getName();
			if (!name.endsWith("*")) {
				note.setName(note.getName() + "*");
			}
			list.repaint();
		} catch (NullPointerException ignored) {
		}
	}

	@Override
	public void clear() {
		title.setText("");
		textBox.setText("");
	}

	@Override
	public void sendToFilter(ListModel listModel) {
		filter.setList(listModel);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void setElementsList(ListModel list) {
		this.list.setModel(list);
		this.list.repaint();
	}

	@Override
	public void hideElements(boolean flag) {
		titleLabel.setVisible(!flag);
		textLabel.setVisible(!flag);
		title.setVisible(!flag);
		textBox.setVisible(!flag);
		save.setVisible(!flag);
		label.setVisible(flag);
	}

	public String readFile(File file) {
		String s = "";
		try {
			Scanner scan = new Scanner(file);
			s = scan.useDelimiter("\\A").next();
			scan.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return s;
	}

	private void loadNotes(List l) {

		File[] files = new File(noteDirectory).listFiles();

		for (File f : files)
			l.addElement(new Note(f.getName(), readFile(f)));

	}

	@Override
	public void createGUI() {

		Note ascii = new Note("classified", new Banner().generateBanner("play hard"));
		writeFile(ascii.getName(), ascii.getText());

		loadNotes(list);

		JFrame notes = new JFrame("Notes");
		notes.setSize(960, 600);
		notes.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		JPanel left = new JPanel();
		left.setBorder(new LineBorder(Color.BLACK));
		left.setSize(320, 600);
		left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));

		JPanel filterPanel = new JPanel();
		filterPanel.add(new JLabel("Filter:"));
		filter.setColumns(20);
		filterPanel.add(filter);
		filterPanel.setPreferredSize(new Dimension(280, 40));

		JPanel listPanel = new JPanel();
		list.setFixedCellWidth(260);
		listPanel.setSize(320, 470);

		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setPreferredSize(new Dimension(275, 410));

		listPanel.add(scrollPane);

		JPanel buttonPanel = new JPanel();
		add.setPreferredSize(new Dimension(85, 25));
		buttonPanel.add(add);
		del.setPreferredSize(new Dimension(85, 25));
		buttonPanel.add(del);
		buttonPanel.setLayout(new FlowLayout());

		left.add(filterPanel);
		left.add(listPanel);
		left.add(buttonPanel);

		JPanel right = new JPanel();
		right.setLayout(null);
		right.setSize(640, 600);
		right.setLocation(320, 0);
		right.setBorder(new LineBorder(Color.BLACK));

		titleLabel.setBounds(20, 4, 50, 20);
		title.setBounds(60, 5, 555, 20);
		textLabel.setBounds(20, 4, 50, 130);
		textBox.setBorder(new LineBorder(Color.DARK_GRAY));
		textBox.setBounds(20, 80, 595, 410);
		save.setBounds(270, 535, 80, 25);
		label.setFont(new Font("Verdana", Font.PLAIN, 22));
		label.setBounds(100, 240, 500, 100);

		right.add(label);
		right.add(titleLabel);
		right.add(title);
		right.add(textLabel);
		right.add(textBox);
		right.add(save);

		notes.setLayout(null);
		notes.getContentPane().add(left);
		notes.getContentPane().add(right);
		notes.setResizable(false);
		notes.setLocationRelativeTo(null);
		notes.setVisible(true);
	}

}