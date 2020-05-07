package designpatterns.gof.creational.simplefactory.demo;

/**
 * 乘法类，继承运算类
 */
public class OperationMul extends Operation {

	@Override
	public double getResult() {
		double result = getNumberA() * getNumberB();
		return result;
	}
}