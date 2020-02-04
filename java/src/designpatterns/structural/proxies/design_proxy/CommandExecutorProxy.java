package design_proxy;

/**
 * <h1>Proxy</h1> Cung cấp một đối tượng thay thế hoặc giữ chỗ placeholder cho
 * một đối tượng khác để truy xuất đến nó. <br/>
 * This class provides only admin users to have full access if the user is not
 * admin then only limited commands will be allowed.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class CommandExecutorProxy implements CommandExecutor {

	private boolean isAdmin;
	private CommandExecutor executor;

	public CommandExecutorProxy(String username, String password) {
		if ("almasud".equals(username) && "p@$$".equals(password))
			isAdmin = true;
		executor = new CommandExecute();
	}

	@Override
	public void runCommand(String cmd) throws Exception {
		if (isAdmin) {
			executor.runCommand(cmd);
		} else {
			if (cmd.trim().startsWith("rm")) {
				throw new Exception(
						"'rm' command is not allowed for non-admin users.");
			} else {
				executor.runCommand(cmd);
			}
		}
	}

}