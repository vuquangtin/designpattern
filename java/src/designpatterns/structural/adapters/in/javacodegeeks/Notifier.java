package in.javacodegeeks;

import java.util.List;

public interface Notifier {

    void notify(List<String> recipients, String message);

}
