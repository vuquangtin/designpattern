package iterators.javacodegeeks;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>Iterator</h1> Cung cấp một cách để truy xuất các thành phần của một đối
 * tượng tập hợp một cách tuần tự mà không cho thấy sự biểu diễn representation
 * bên dưới của nó. <br/>
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/designpattern">https://github.com
 *      /vuquangtin/designpattern</a>
 *
 */
public class GitHubIterator implements Iterator<GitHubJob> {

	private List<GitHubJob> currentJobsPage = new ArrayList<>();
	private int page = 0;

	private final GitHubJobsRepository gitHubJobsRepository;

	public GitHubIterator(GitHubJobsRepository gitHubJobsRepository) {
		this.gitHubJobsRepository = gitHubJobsRepository;
	}

	@Override
	public boolean hasNext() {
		fetchPageIfNeeded();
		return currentJobsPage.size() > 0;
	}

	@Override
	public GitHubJob next() {
		fetchPageIfNeeded();

		if (currentJobsPage.size() == 0) {
			return null;
		}

		return currentJobsPage.remove(0);
	}

	private void fetchPageIfNeeded() {
		if (page == -1) {
			return;
		}

		if (currentJobsPage == null || currentJobsPage.size() == 0) {
			try {
				currentJobsPage = gitHubJobsRepository.fetch(page);
				if (currentJobsPage.size() == 0) {
					page = -1;
				} else {
					page++;
				}
			} catch (Exception e) {
				throw new RuntimeException();
			}
		}
	}
}
