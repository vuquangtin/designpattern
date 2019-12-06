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
public class TruckShipper implements Shipper
{
	public void deliver( PackageInfor item )
	{
		System.out.println("<p>Package ("+item.getCode()+") deliver by truck.</p>");
	}
}