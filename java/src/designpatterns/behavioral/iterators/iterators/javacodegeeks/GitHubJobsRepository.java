package iterators.javacodegeeks;

import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;

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
public class GitHubJobsRepository {

	public static final String GITHUB_JOB_API = "https://jobs.github.com/positions.json?page=";

	public List<GitHubJob> fetch(int page) throws Exception {

		List<GitHubJob> gitHubJobs = new ArrayList<>();

		URL url = new URL(GITHUB_JOB_API + page);
		HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
		String response = IOUtils.toString(httpConnection.getInputStream(), Charset.defaultCharset());
		JSONArray jsonArray = new JSONArray(response);

		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject jsonObject = jsonArray.getJSONObject(i);
			GitHubJob gitHubJob = new GitHubJob(UUID.fromString(jsonObject.getString("id")),
					jsonObject.getString("company"), jsonObject.getString("title"));
			gitHubJobs.add(gitHubJob);
		}

		return gitHubJobs;
	}

	public Iterator<GitHubJob> iterator() {
		return new GitHubIterator(this);
	}
}
