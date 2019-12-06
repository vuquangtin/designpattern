package delegation.shipper;

import java.util.ArrayList;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class Client {
	public static void main(String[] args) {
		ArrayList<PackageInfor> packages = new ArrayList<PackageInfor>() {
			private static final long serialVersionUID = 1L;

			{
				add(new PackageInfor("00001", 500));
				add(new PackageInfor("00002", 25));
				add(new PackageInfor("00003", 23));
				add(new PackageInfor("009A3", 400));
			}
		};
		ShippingDelegate shipper = new ShippingDelegate();
		for (PackageInfor packageInfor : packages) {
			shipper.deliver(packageInfor);
		}

	}
}
