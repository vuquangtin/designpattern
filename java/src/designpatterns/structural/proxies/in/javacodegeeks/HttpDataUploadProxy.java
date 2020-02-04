package in.javacodegeeks;

import java.nio.charset.Charset;
import java.time.Duration;
import java.time.Instant;

/**
 * <h1>Proxy</h1> Cung cấp một đối tượng thay thế hoặc giữ chỗ placeholder cho
 * một đối tượng khác để truy xuất đến nó.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class HttpDataUploadProxy implements DataUploadService {

	private final HttpDataUploadImpl httpDataUpload;

	public HttpDataUploadProxy(HttpDataUploadImpl httpDataUpload) {
		this.httpDataUpload = httpDataUpload;
	}

	@Override
	public void upload(String payload) {

		Instant start = Instant.now();

		httpDataUpload.upload(payload);

		Duration duration = Duration.between(start, Instant.now());
		int byteSize = payload.getBytes(Charset.defaultCharset()).length;
		System.out.println(duration);
		System.out.println(byteSize);

		/**
		 * Log properly to splunk/cloudwatch etc
		 */

	}
}
