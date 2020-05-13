package designpatterns.lambdas.structural.decorators;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

import org.junit.Test;

import designpatterns.lambdas.abs.AbstractTest;
import designpatterns.lambdas.structural.decorators.WebFilterOfSocialNetworks;

import static org.junit.Assert.assertEquals;


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
public class WebFilterDecoratorTest extends AbstractTest {

	private final List<String> URLs = Arrays.asList("https://www.facebook.com/", "https://twitter.com/",
			"https://mail.google.com", "http://www.bbc.com/news", "http://www.a.site/");

	@Test
	public void non_lambda_filters_of_social_media() {
		WebFilter firstFilter = new WebFilterOfSocialNetworks();
		assertEquals(firstFilter.filter(URLs).size(), 3);
	}

	@Test
	public void non_lambda_filters_of_all() {
		WebFilter firstFilter = new WebFilterOfSocialNetworks();
		WebFilter decorator = new WebFilterOfNewsSites(new WebFilterOfWebMails(firstFilter));
		assertEquals(decorator.filter(URLs).size(), 1);
	}

	@Test
	public void lambda_filters_of_social_media() {
		Function<List<String>, List<String>> filter = WebFilterAlgorithms::removeSocialNetworks;
		assertEquals(filter.apply(URLs).size(), 3);
	}

	@Test
	public void lambda_filters_of_all() {
		// put class type after of, otherwise cannot be recognize
		Function<List<String>, List<String>> filterDecorator = Stream
				.<Function<List<String>, List<String>>> of(WebFilterAlgorithms::removeSocialNetworks,
						WebFilterAlgorithms::removeWebMails, WebFilterAlgorithms::removeNewsSites)
				.reduce((f, n) -> n.compose(f)) // here is binding. compose is
												// FUNCTION, put next before
												// first to execution
				.get();
		assertEquals(filterDecorator.apply(URLs).size(), 1);
	}
}