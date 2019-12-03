package javacodegeeks.com.gkatzioura.design.structural.proxy1;

import java.nio.charset.Charset;
import java.time.Duration;
import java.time.Instant;

public class HttpDataUploadProxy implements DataUploadService {

    private final HttpDataUploadImpl httpDataUpload;

    public HttpDataUploadProxy(HttpDataUploadImpl httpDataUpload) {
        this.httpDataUpload = httpDataUpload;
    }

    @Override
    public void upload(String payload) {

        Instant start = Instant.now();

        httpDataUpload.upload(payload);

        Duration duration = Duration.between(start,Instant.now());
        int byteSize = payload.getBytes(Charset.defaultCharset()).length;
        System.out.println(duration);
        System.out.println(byteSize);

        /**
         * Log properly to splunk/cloudwatch etc
         */

    }
}
