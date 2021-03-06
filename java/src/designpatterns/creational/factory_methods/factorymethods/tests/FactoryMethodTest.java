package factorymethods.tests;

/* interface PaymentMethod {
    public void makePayment();
}

class CreditCard implements PaymentMethod {
    public void makePayment() {
        System.out.println("Payment through credit card...");
    }
}

class NetBanking implements PaymentMethod {
    public void makePayment() {
        System.out.println("Payment through net banking...");
    }
}*/
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
interface IPaymentMethodFactory {
	public PaymentMethod getPaymentMethod();
}

class CreditCardFactory implements IPaymentMethodFactory {
	public PaymentMethod getPaymentMethod() {
		return new CreditCard();
	}
}

class NetBankingFactory implements IPaymentMethodFactory {
	public PaymentMethod getPaymentMethod() {
		return new NetBanking();
	}
}

/***
 * Factory Method:
 * 
 * Definition:
 * 
 * Defines an interface for creating objects, but let subclasses to decide which
 * class to instantiate Refers the newly created object through a common
 * interface.
 * 
 * @author admin
 * @see https://stackoverflow.com/questions/20848082/motivation-for-simple-factory-and-factory-method-pattern/20859513#20859513
 *
 */
public class FactoryMethodTest {

	public static void main(String[] args) {
		IPaymentMethodFactory factory = new CreditCardFactory();
		PaymentMethod paymentMethod = factory.getPaymentMethod();
		paymentMethod.makePayment();
	}

}