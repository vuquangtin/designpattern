package designpatterns.gof.structural.adapter.inline;

/**
 * <h1>Adapter</h1> Chuyển interface của một lớp thành interface khác mà các
 * client mong muốn. Adapter để cho các lớp làm việc với nhau dù có thể các
 * interface không tương thích.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class AdapterApplication {
	public static void main(String[] args) {
		Socket socketAdapter = new ConnectionAdapter();
		String output = socketAdapter.getOutput();
		System.out.println(output);
	}
}

class ConnectionAdapter implements Socket {
	Plug plug = new Plug();

	/**
	 * Method coming from the interface Socket which we have to make to fit the
	 * client plug
	 *
	 * @return Desired output of 5 AMP
	 */
	@Override
	public String getOutput() {

		String output = plug.getInput();
		return output;
	}
}

interface Socket {
	/**
	 * This method is used to match the input to be given to the Plug
	 *
	 * @return Output of the Plug (Client)
	 */
	public String getOutput();
}

class Plug {
	private String specification = "5 AMP";

	public String getInput() {
		return specification;
	}
}