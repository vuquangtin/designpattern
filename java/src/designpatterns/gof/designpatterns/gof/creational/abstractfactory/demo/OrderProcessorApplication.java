package designpatterns.gof.creational.abstractfactory.demo;


/**
 * <h1>Abstract Factory</h1> Cung cấp một interface để tạo ra 1 họ các object
 * (đối tượng) có liên quan hoặc phụ thuộc lẫn nhau mà không chỉ rõ các lớp cụ
 * thể của chúng (concrete classes)
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com

 *      /vuquangtin/designpattern</a>
 *
 */
abstract class FinancialToolsFactory {
	public abstract TaxProcessor createTaxProcessor();

	public abstract ShipFeeProcessor createShipFeeProcessor();
}

class CanadaFinancialToolsFactory extends FinancialToolsFactory {
	public TaxProcessor createTaxProcessor() {
		return new CanadaTaxProcessor();
	}

	public ShipFeeProcessor createShipFeeProcessor() {
		return new CanadaShipFeeProcessor();
	}
}

class EuropeFinancialToolsFactory extends FinancialToolsFactory {
	public TaxProcessor createTaxProcessor() {
		return new EuropeTaxProcessor();
	}

	public ShipFeeProcessor createShipFeeProcessor() {
		return new EuropeShipFeeProcessor();
	}
}

// Products
abstract class ShipFeeProcessor {
	abstract void calculateShipFee(Order order);
}

abstract class TaxProcessor {
	abstract void calculateTaxes(Order order);
}

class EuropeShipFeeProcessor extends ShipFeeProcessor {
	public void calculateShipFee(Order order) {
		// insert here Europe specific ship fee calculation
	}
}

class CanadaShipFeeProcessor extends ShipFeeProcessor {
	public void calculateShipFee(Order order) {
		// insert here Canada specific ship fee calculation
	}
}

class EuropeTaxProcessor extends TaxProcessor {
	public void calculateTaxes(Order order) {
		// insert here Europe specific taxt calculation
	}
}

class CanadaTaxProcessor extends TaxProcessor {
	public void calculateTaxes(Order order) {
		// insert here Canada specific taxt calculation
	}
}

// Client
class OrderProcessor {
	private TaxProcessor taxProcessor;
	private ShipFeeProcessor shipFeeProcessor;

	public OrderProcessor(FinancialToolsFactory factory) {
		taxProcessor = factory.createTaxProcessor();
		shipFeeProcessor = factory.createShipFeeProcessor();
	}

	public void processOrder(Order order) {
		// ....
		taxProcessor.calculateTaxes(order);
		shipFeeProcessor.calculateShipFee(order);
		// ....
	}
}

// Integration with the overall application
public class OrderProcessorApplication {
	public static void main(String[] args) {
		// .....
		String countryCode = "EU";
		Customer customer = new Customer();
		Order order = new Order();
		OrderProcessor orderProcessor = null;
		FinancialToolsFactory factory = null;

		if (countryCode == "EU") {
			factory = new EuropeFinancialToolsFactory();
		} else if (countryCode == "CA") {
			factory = new CanadaFinancialToolsFactory();
		}
		orderProcessor = new OrderProcessor(factory);
		orderProcessor.processOrder(order);
	}
}

class Customer {
}

class Order {
}
