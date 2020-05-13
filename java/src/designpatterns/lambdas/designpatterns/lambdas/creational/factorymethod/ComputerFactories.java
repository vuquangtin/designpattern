package designpatterns.lambdas.creational.factorymethod;

import java.util.EnumMap;
import java.util.Optional;
import java.util.function.Supplier;

import designpatterns.lambdas.creational.factorymethod.Computer.ComputerModel;
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
public class ComputerFactories {

	abstract static class ComputerFactory {

		public static Computer create(ComputerModel model) {
			Computer computer;
			switch (model) {
			case HOME:
				computer = new HomeComputer();
				break;
			case SERVER:
				computer = new ServerComputer();
				break;
			default:
				throw new IllegalStateException("Model " + model + " is not available yet!");
			}
			return computer;
		}
	}

	abstract static class LambdaComputerFactory { // use abstract class then no
													// require private
													// constructor

		private static final EnumMap<ComputerModel, Supplier<Computer>> customComputers = new EnumMap<>(
				ComputerModel.class);

		static {
			customComputers.put(ComputerModel.HOME, HomeComputer::new);
			customComputers.put(ComputerModel.SERVER, ServerComputer::new);
		}

		static Computer createLambda(ComputerModel model) {
			return customComputers.get(model) // get Supplier, it the "new"
					.get(); // Supplier.get, same as execution of method
		}
	}
}

abstract class Computer {

	private ComputerSpecs specs;

	public Computer(ComputerSpecs spec) {
		this.setSpecs(spec);
	}

	public ComputerSpecs getSpecs() {
		return specs;
	}

	public void setSpecs(ComputerSpecs specs) {
		this.specs = specs;
	}

	public enum ComputerModel {
		HOME, SERVER
	}
}

class HomeComputer extends Computer {

	public HomeComputer() {
		this(null);
	}

	public HomeComputer(ComputerSpecs spec) {
		super(Optional.ofNullable(spec).orElseGet(ComputerSpecsBuilder::buildStandardSpec));
	}

}

class ServerComputer extends Computer {

	public ServerComputer() {
		this(null);
	}

	public ServerComputer(ComputerSpecs spec) {
		super(Optional.ofNullable(spec).orElseGet(ComputerSpecsBuilder::buildExtendedSpec));
	}

}

class ComputerSpecs {

	private int cores;
	private int disks;
	private long memory;

	private ComputerSpecs(ComputerSpecsBuilder builder) {
		this.cores = builder.cores;
		this.disks = builder.disks;
		this.memory = builder.memory;
	}

	static class ComputerSpecsBuilder {

		private int cores = 1;
		private int disks = 1;
		private long memory = 2;

		static ComputerSpecs buildStandardSpec() {
			return new ComputerSpecsBuilder().withCores(4).withDisks(2).withMemory(8).build();
		}

		static ComputerSpecs buildExtendedSpec() {
			return new ComputerSpecsBuilder().withCores(8).withDisks(4).withMemory(16).build();
		}

		ComputerSpecsBuilder withCores(int cores) {
			this.cores = cores;
			return this;
		}

		ComputerSpecsBuilder withDisks(int disks) {
			this.disks = disks;
			return this;
		}

		ComputerSpecsBuilder withMemory(long memory) {
			this.memory = memory;
			return this;
		}

		ComputerSpecs build() {
			return new ComputerSpecs(this); // some validation if requires
		}
	}
}
