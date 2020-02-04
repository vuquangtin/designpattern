package decorators.sources;
/**
 * <h1>Decorator</h1> Gán bổ sung các “trách nhiệm” (responsibility) cho một đối
 * tượng một cách linh hoạt. Các decorator cung cấp một sự lựa chọn linh động
 * cho lớp con để mở rộng tính năng
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class Decorator implements Sourceable{
	private Sourceable source;
	public Decorator(Sourceable source) {
		this.source = source;
	}
	@Override
	public void method() {
		System.out.println("before decorator!");  
        source.method();  
        System.out.println("after decorator!"); 
	}

}
