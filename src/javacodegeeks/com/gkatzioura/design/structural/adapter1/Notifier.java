package javacodegeeks.com.gkatzioura.design.structural.adapter1;

import java.util.List;

public interface Notifier {

    void notify(List<String> recipients, String message);

}
