package delegation.shipper;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class PackageInfor {

	private String code;
	private int weight;

	public PackageInfor(String code, int weight) {
		this.code = code;
		this.weight = weight;
	}

	/**
	 * Returns package's code
	 * 
	 * @return string
	 * 
	 */
	public String getCode() {
		return this.code;
	}

	/**
	 * Returns package's weight
	 * 
	 * @return float
	 * 
	 */
	public int getWeight() {
		return this.weight;
	}
}
