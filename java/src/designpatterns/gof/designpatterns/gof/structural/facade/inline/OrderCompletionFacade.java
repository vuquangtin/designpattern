package designpatterns.gof.structural.facade.inline;

/**
 * <h1>Facade</h1> Cung cấp một interface thống nhất cho một tập các interface
 * trong một hệ thống con (subsystem). Façade định nghĩa một interface mức cao
 * làm cho hệ thống con dễ dàng sử dụng hơn.
 * 
 * <br/>
 * facade encapsulates a complex subsystem behind a simple interface. It hides
 * much of the complexity and makes the subsystem easy to use. Also, if we need
 * to use the complex subsystem directly, we still can do that; we aren't forced
 * to use the facade all the time.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com

 *      /vuquangtin/designpattern</a>
 *
 */
public class OrderCompletionFacade {
	/**
	 * facade method takes in Order details and does the following 1. Process
	 * the order completion by calling the order module 2. Updates shipping
	 * information 3. Bills the order and Updates billing information
	 */
	public void completeOrder(String orderId, String paymentId) {
		new OrderProcessing().completeOrder(); // might fetch and pass Order
												// object to this method

		new BillingImpl().processBilling(); // might pass billing object to this
											// method

		new Shipping().initiateShippingForOrder(); // might create a new
													// shipping object and pass
	}
}

class BillingImpl {
	public void processBilling() {
		// contains logic for processing the billing given the credit card
		// details
	}
}

class OrderProcessing {
	public void completeOrder() {
		// Updates the order records and completes the order
	}
}

class Shipping {
	public void initiateShippingForOrder() {
		// initiates the shipping request
	}

	public void captureShippingDetails() {
		// captures the address and does basic verification for zip code etc.
	}
}