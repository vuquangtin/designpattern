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
public interface Shipper {
	/**
	 * Delivers the package
	 * 
	 * @param Package
	 *            $package
	 * @return void
	 * 
	 */
	public void deliver(PackageInfor item);
}