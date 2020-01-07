package iterators.javacodegeeks;

import java.util.UUID;

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
public class GitHubJob {

	private final UUID id;
	private final String company;
	private final String title;

	public GitHubJob(UUID id, String company, String title) {
		this.id = id;
		this.company = company;
		this.title = title;
	}

	public UUID getId() {
		return id;
	}

	public String getCompany() {
		return company;
	}

	public String getTitle() {
		return title;
	}
}
