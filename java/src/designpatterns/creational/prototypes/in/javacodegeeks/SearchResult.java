package in.javacodegeeks;

public interface SearchResult {

    SearchResult clone();

    int totalEntries();

    String getPage(int page);
}
