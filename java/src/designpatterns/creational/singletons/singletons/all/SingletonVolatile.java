package singletons.all;
/**
 * <h1>Singleton</h1> Đảm bảo rằng một class (lớp) chỉ có duy nhất một instance
 * (thể hiện), và cung cấp một điểm chung, toàn cục để truy cập vào lớp đó.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class SingletonVolatile {

	private volatile static SingletonVolatile mSingletonVolatile = null;

	private SingletonVolatile() {

	}

	public static SingletonVolatile getSingletonVolatile() {

		if (mSingletonVolatile == null) {
			synchronized (SingletonVolatile.class) {
				mSingletonVolatile = new SingletonVolatile();
			}
		}
		return mSingletonVolatile;
	}
}