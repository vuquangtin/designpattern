package proxies.sources;

import org.junit.Test;

public class ProxyTest {

	@Test
	public void testMain() {
		Sourceable source = new Proxy();  
        source.method();  
	}
}
