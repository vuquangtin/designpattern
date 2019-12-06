package factorymethods.products;

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