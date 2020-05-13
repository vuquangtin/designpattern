package designpatterns.lambdas.creational.factorymethod;

import org.junit.Assert;
import org.junit.Test;

import designpatterns.lambdas.abs.AbstractTest;
import designpatterns.lambdas.creational.factorymethod.Computer.ComputerModel;
import designpatterns.lambdas.creational.factorymethod.ComputerFactories.ComputerFactory;
import designpatterns.lambdas.creational.factorymethod.ComputerFactories.LambdaComputerFactory;
import designpatterns.lambdas.creational.factorymethod.ComputerSpecs.ComputerSpecsBuilder;

/**
 * <h1>Factory Method</h1>Cung cấp 1 giao diện để tạo ra đối tượng nhưng để lớp
 * con quyết định kiểu đối tượng nào sẽ dc tạo.Factory Pattern giao việc khởi
 * tạo một đối tượng cụ thể cho lớp con.
 * 
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/designpattern">https://github.com
 * 
 *      /vuquangtin/designpattern</a>
 *
 */

public class ComputerFactoriesTest extends AbstractTest {
	@Test
	public void non_lambda_factory_create_home_computer() {
		Computer computer = ComputerFactory.create(ComputerModel.HOME);
		ComputerSpecs spec = computer.getSpecs(); // inside HomeComputer, it is
													// standard specification
		ComputerSpecs sdSpec = ComputerSpecsBuilder.buildStandardSpec();
		Assert.assertEquals(spec, sdSpec);
	}

	@Test
	public void lambda_factory_create_server_computer() {
		Computer computer = LambdaComputerFactory.createLambda(ComputerModel.SERVER);
		ComputerSpecs spec = computer.getSpecs();
		ComputerSpecs exSpec = ComputerSpecsBuilder.buildExtendedSpec();
		Assert.assertEquals(spec, exSpec);
	}

	@Test
	public void compare_factories() {
		Computer computer = ComputerFactory.create(ComputerModel.SERVER);
		Computer computer2 = LambdaComputerFactory.createLambda(ComputerModel.SERVER);
		Assert.assertEquals(computer, computer2);
	}
}