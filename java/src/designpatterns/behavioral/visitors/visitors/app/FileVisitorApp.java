package visitors.app;

import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.EnumSet;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * <h1>Visitor</h1>Diễn tả 1 hoạt động (thao tác, thuật toán) được thực hiện
 * trên các phần tử của 1 cấu trúc đối tượng. Visitor cho phép bạn định nghĩa 1
 * phép toán mới mà không thay đổi các lớp của các phần tử mà nó thao tác
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class FileVisitorApp extends JFrame implements ItemListener {
	private JComboBox itms;
	private JTextArea txt;
	private JScrollPane scroll;

	private String[] list = new String[] { "Select type", ".java", ".cpp",
			".c", ".cs", ".html", ".pdf" };

	public FileVisitorApp() {
		itms = new JComboBox(list);
		txt = new JTextArea(70, 450);
		scroll = new JScrollPane(txt);

		setLayout(new BorderLayout());
		setSize(700, 550);
		itms.setBounds(5, 5, 105, 25);
		scroll.setBounds(5, 40, 550, 480);

		itms.addItemListener(this);

		add(itms);
		add(scroll);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void itemStateChanged(ItemEvent ie) {
		String pattern = null;
		switch ((String) ie.getItem()) {
		case ".java":
			pattern = "*.java";
			break;
		case ".cpp":
			pattern = "*.cpp";
			break;
		case ".c":
			pattern = "*.c";
			break;
		case ".cs":
			pattern = "*.cs";
			break;
		case ".html":
			pattern = "*.html";
			break;
		case ".pdf":
			pattern = "*.pdf";
			break;
		}
		Path fileTree = Paths.get(".");
		VisitDirectory walk = new VisitDirectory(pattern);
		EnumSet opts = EnumSet.of(FileVisitOption.FOLLOW_LINKS);
		try {
			Files.walkFileTree(fileTree, opts, Integer.MAX_VALUE, walk);
		} catch (IOException exp) {
			txt.setText("Problem : " + exp);
		}
		walk.sb.append("Total files found : " + walk.counter);
		txt.setText(walk.sb.toString());
	}

	public static void main(String[] args) {
		try {
			new FileVisitorApp();
		} catch (Exception exp) {
			System.out.println(exp);
		}
	}

	class VisitDirectory implements FileVisitor {
		private final PathMatcher matcher;
		private StringBuffer sb = new StringBuffer();
		int counter = 0;

		public VisitDirectory(String pattern) {
			FileSystem fs = FileSystems.getDefault();
			matcher = fs.getPathMatcher("glob:" + pattern);
		}

		public void search(Path file) throws IOException {
			Path name = file.getFileName();

			if (name != null && matcher.matches(name)) {
				sb.append("Searched file located: " + name + " in"
						+ file.getParent().toAbsolutePath() + "\r\n");
				counter++;
			}
		}

		public FileVisitResult postVisitDirectory(Object dir, IOException exp)
				throws IOException {
			return FileVisitResult.CONTINUE;
		}

		public FileVisitResult preVisitDirectory(Object dir,
				BasicFileAttributes attr) throws IOException {
			return FileVisitResult.CONTINUE;
		}

		public FileVisitResult visitFile(Object file, BasicFileAttributes attr)
				throws IOException {
			search((Path) file);
			return FileVisitResult.CONTINUE;
		}

		public FileVisitResult visitFileFailed(Object file, IOException exp)
				throws IOException {
			return FileVisitResult.CONTINUE;
		}
	}
}