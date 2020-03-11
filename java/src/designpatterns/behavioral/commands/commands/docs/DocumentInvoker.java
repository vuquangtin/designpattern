package commands.docs;

import java.util.Stack;

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
public class DocumentInvoker {
    private Stack<Command> undoCommands = new Stack<>();
    private Stack<Command> redoCommands = new Stack<>();
    private Document document = new Document();
 
    public void undo() {
        if (!undoCommands.isEmpty()) {
            Command cmd = undoCommands.pop();
            cmd.undo();
            redoCommands.push(cmd);
        } else {
            System.out.println("Nothing to undo");
        }
    }
 
    public void redo() {
        if (!redoCommands.isEmpty()) {
            Command cmd = redoCommands.pop();
            cmd.redo();
            undoCommands.push(cmd);
        } else {
            System.out.println("Nothing to reodo");
        }
    }
 
    public void write(String text) {
        Command cmd = new DocumentEditorCommand(document, text);
        undoCommands.push(cmd);
        redoCommands.clear();
    }
 
    public void read() {
        document.readDocument();
    }
}