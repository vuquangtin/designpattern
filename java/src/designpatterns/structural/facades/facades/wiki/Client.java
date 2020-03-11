package facades.wiki;

/**
 * <h1>Facade</h1> Cung cấp một interface thống nhất cho một tập các interface
 * trong một hệ thống con (subsystem). Façade định nghĩa một interface mức cao
 * làm cho hệ thống con dễ dàng sử dụng hơn. <br/>
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/designpattern">https://github.com
 *      /vuquangtin/designpattern</a>
 *
 */
/* Complex parts */

class CPU {
	public void freeze() {
		System.out.println("freeze");
	}

	public void jump(long position) {
		System.out.println("jump");
	}

	public void execute() {
		System.out.println("execute");
	}
}

class HardDrive {
	public byte[] read(long lba, int size) {
		System.out.println("read");
		return new byte[size];
	}
}

class Memory {
	public void load(long position, byte[] data) {
		System.out.println("load");
	}
}

/* Facade */

class ComputerFacade {
	private static final long BOOT_ADDRESS = 0;
	private static final long BOOT_SECTOR = 0;
	private static final int SECTOR_SIZE = 0;
	private final CPU processor;
	private final Memory ram;
	private final HardDrive hd;

	public ComputerFacade() {
		this.processor = new CPU();
		this.ram = new Memory();
		this.hd = new HardDrive();
	}

	public void start() {
		processor.freeze();
		ram.load(BOOT_ADDRESS, hd.read(BOOT_SECTOR, SECTOR_SIZE));
		processor.jump(BOOT_ADDRESS);
		processor.execute();
	}
}

/* Client */

public class Client {
	public static void main(String[] args) {
		ComputerFacade computer = new ComputerFacade();
		computer.start();
	}
}