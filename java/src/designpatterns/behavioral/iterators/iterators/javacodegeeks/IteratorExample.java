package iterators.javacodegeeks;

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
public class IteratorExample {

	public static void main(String[] args) throws Exception {
		GitHubJobsRepository gitHubJobsRepository = new GitHubJobsRepository();

		Iterator<GitHubJob> gitHubJobIterator = gitHubJobsRepository.iterator();

		while (gitHubJobIterator.hasNext()) {
			GitHubJob gitHubJob = gitHubJobIterator.next();
			System.out.println(String.format(" id: %s title: %s company: %s", gitHubJob.getId(), gitHubJob.getTitle(),
					gitHubJob.getCompany()));
		}
	}

}
