package in.javacodegeeks;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>Prototype</h1> Xác định các kiểu của các object (đối tượng) muốn tạo ra
 * bằng cách sử dụng một prototype (khuôn mẫu,nguyên mẫu), và tạo ra những
 * object (đối tượng) mới bằng cách sao chép prototype này.
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/designpattern">https://github.com
 *      /vuquangtin/designpattern</a>
 *
 */
public class FederatedSearchResult implements SearchResult {

	private List<String> pages = new ArrayList<String>();

	public FederatedSearchResult(List<String> pages) {
		this.pages = pages;
	}

	@Override
	public SearchResult clone() {

		final List<String> resultCopies = new ArrayList<String>();
		pages.forEach(p -> resultCopies.add(p));
		FederatedSearchResult federatedSearchResult = new FederatedSearchResult(resultCopies);
		return federatedSearchResult;
	}

	@Override
	public int totalEntries() {
		return pages.size();
	}

	@Override
	public String getPage(int page) {
		return pages.get(page);
	}

}
