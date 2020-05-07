package designpatterns.gof.creational.simplefactory.demo;

public class OperationAdd extends Operation {

	@Override
	public double getResult() {
		double result = getNumberA() + getNumberB();
		return result;
	}
}