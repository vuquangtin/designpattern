package designpatterns.lambdas.structural.decorators;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;

/**
 * <h1>Decorator</h1> Gán bổ sung các “trách nhiệm” (responsibility) cho một đối
 * tượng một cách linh hoạt. Các decorator cung cấp một sự lựa chọn linh động
 * cho lớp con để mở rộng tính năng.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/designpattern">https://github.com
 *      /vuquangtin/designpattern</a>
 *
 */

public class WebFilterOfSocialNetworks extends WebFilterDecorator {

	WebFilterOfSocialNetworks() {
		super(null);
	}

	@Override
	List<String> remove(List<String> urls) {
		log.info("Removing of social media... ...");
		return urls.stream().filter(url -> !(url.contains("facebook") || url.contains("twitter")))
				.collect(Collectors.toList());
	}

	@Override
	public List<String> filter(List<String> urls) {
		log.info("Filtering of social media... ...");
		return remove(super.filter(urls));
	}

}

@FunctionalInterface
interface WebFilter {
	Logger log = Logger.getLogger(WebFilterAlgorithms.class);

	List<String> filter(List<String> urls);

}

interface WebFilterAlgorithms {

	Logger log = Logger.getLogger(WebFilterAlgorithms.class);

	static List<String> removeSocialNetworks(List<String> urls) {
		log.info("Removing of social media... ...");
		return urls.stream().filter(url -> !(url.contains("facebook") || url.contains("twitter")))
				.collect(Collectors.toList());
	}

	static List<String> removeWebMails(List<String> urls) {
		log.info("Removing of web mails... ...");
		return urls.stream().filter(url -> !url.contains("mail")).collect(Collectors.toList());
	}

	static List<String> removeNewsSites(List<String> urls) {
		log.info("Removing of news... ...");
		return urls.stream().filter(url -> !url.contains("news")).collect(Collectors.toList());
	}

}

abstract class WebFilterDecorator implements WebFilter {

	abstract List<String> remove(List<String> urls);

	private WebFilter webFilter;

	WebFilterDecorator(WebFilter webFilter) {
		this.webFilter = webFilter;
	}

	@Override
	public List<String> filter(List<String> urls) {
		if (webFilter != null) {
			return webFilter.filter(urls);
		}
		return urls;
	}
}

class WebFilterOfNewsSites extends WebFilterDecorator {

	WebFilterOfNewsSites(WebFilter webFilter) {
		super(webFilter);
	}

	@Override
	List<String> remove(List<String> urls) {
		log.info("Removing of news... ...");
		return urls.stream().filter(url -> !url.contains("news")) // no news
				.collect(Collectors.toList());
	}

	@Override
	public List<String> filter(List<String> urls) {
		log.info("Filtering of news... ...");
		return remove(super.filter(urls));
	}

}

class WebFilterOfWebMails extends WebFilterDecorator {

	WebFilterOfWebMails(WebFilter webFilter) {
		super(webFilter);
	}

	@Override
	List<String> remove(List<String> urls) {
		log.info("Removing of web mails... ...");
		return urls.stream().filter(url -> !url.contains("mail")).collect(Collectors.toList());
	}

	@Override
	public List<String> filter(List<String> urls) {
		log.info("Filtering of web mails... ...");
		return remove(super.filter(urls));
	}

}