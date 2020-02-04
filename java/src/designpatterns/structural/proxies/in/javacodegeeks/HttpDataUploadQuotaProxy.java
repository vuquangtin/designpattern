package in.javacodegeeks;

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
public class HttpDataUploadQuotaProxy implements DataUploadService {

	private final HttpDataUploadImpl httpDataUpload;

	public HttpDataUploadQuotaProxy(HttpDataUploadImpl httpDataUpload) {
		this.httpDataUpload = httpDataUpload;
	}

	@Override
	public void upload(String payload) {

		if (quotaExceeded()) {
			throw new IllegalStateException(
					"Quota exceeded cannot upload payload");
		}

		httpDataUpload.upload(payload);
	}

	private boolean quotaExceeded() {

		/**
		 * Code that should check whether we exceeded our quota or not
		 */

		return false;
	}

}
