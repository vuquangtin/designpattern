package designpatterns.gof.behavioral.visitor.pattern;

import java.util.ArrayList;
import java.util.List;

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
public class ObjectStructure {
    private List<Element> elements = new ArrayList<Element>();

    public void addElement(Element element) {
        elements.add(element);
    }

    public void visit(Visitor visitor) {
        for (Element element : elements) {
            element.accept(visitor);
        }
    }
}