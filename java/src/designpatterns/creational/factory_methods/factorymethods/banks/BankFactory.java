package factorymethods.banks;

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
public class BankFactory {

	private BankFactory() {
	}

	public static final Bank getBank(BankType bankType) {
		switch (bankType) {

		case TPBANK:
			return new TPBank();

		case VIETCOMBANK:
			return new VietcomBank();

		default:
			throw new IllegalArgumentException("This bank type is unsupported");
		}
	}

}
