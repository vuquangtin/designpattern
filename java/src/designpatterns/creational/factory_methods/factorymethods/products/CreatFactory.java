package factorymethods.products;
/**
 * <h1>Factory Method</h1>Cung cấp 1 giao diện để tạo ra đối tượng nhưng để lớp
 * con quyết định kiểu đối tượng nào sẽ dc tạo.
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com

 *      /vuquangtin/designpattern</a>
 *
 */
public class CreatFactory extends Factory {
	@SuppressWarnings("unchecked")
	@Override
	public <T extends Product> T creatProduct(Class<T> mTClass) {
		Product p = null;
		try {
			p = mTClass.newInstance();
			// p= (Product) Class.forName(mTClass.getName()).newInstance();
		} catch (InstantiationException mE) {
			mE.printStackTrace();
		} catch (IllegalAccessException mE) {
			mE.printStackTrace();
		}

		return (T) p;
	}
}