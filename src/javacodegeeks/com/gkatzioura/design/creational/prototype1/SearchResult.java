package javacodegeeks.com.gkatzioura.design.creational.prototype1;

public interface SearchResult {

    SearchResult clone();

    int totalEntries();

    String getPage(int page);
}
